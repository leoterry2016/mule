/*
 * (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
 * law. All use of this software is subject to MuleSoft's Master Subscription Agreement
 * (or other master license agreement) separately entered into in writing between you and
 * MuleSoft. If such an agreement is not in place, you may not use the software.
 */
package org.mule.transport.jms.reliability;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.mule.api.context.notification.ExceptionNotificationListener;
import org.mule.context.notification.ExceptionNotification;
import org.mule.exception.DefaultSystemExceptionStrategy;
import org.mule.routing.filters.WildcardFilter;
import org.mule.transport.jms.redelivery.MessageRedeliveredException;
import org.mule.util.concurrent.Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Verify that no inbound messages are lost when exceptions occur.
 * The message must either make it all the way to the SEDA queue (in the case of
 * an asynchronous inbound endpoint), or be restored/rolled back at the source.
 *
 * In the case of JMS, this will cause the failed message to be redelivered if
 * JMSRedelivery is configured.
 */
public class InboundMessageLossTestCase extends AbstractJmsReliabilityTestCase
{
    protected Latch messageRedelivered;
    protected final int latchTimeout = 5000;

    @Override
    protected String getConfigResources()
    {
        return "reliability/activemq-config.xml, reliability/inbound-message-loss.xml";
    }

    @Override
    protected void doSetUp() throws Exception
    {
        super.doSetUp();

        // Set SystemExceptionStrategy to redeliver messages (this can only be configured programatically for now)
        ((DefaultSystemExceptionStrategy) muleContext.getExceptionListener()).setRollbackTxFilter(new WildcardFilter("*"));

        // Tell us when a MessageRedeliverdException has been handled
        messageRedelivered = new Latch();
        muleContext.registerListener(new ExceptionNotificationListener<ExceptionNotification>()
        {
            @Override
            public void onNotification(ExceptionNotification notification)
            {
                if (notification.getException() instanceof MessageRedeliveredException)
                {
                    messageRedelivered.countDown();
                }
            }
        });
    }

    @Test
    public void testNoException() throws Exception
    {
        putMessageOnQueue("noException");

        // Delivery was successful
        assertFalse("Message should not have been redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testTransformerException() throws Exception
    {
        putMessageOnQueue("transformerException");

        // Delivery failed so message should have been redelivered
        assertTrue("Message was not redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testRouterException() throws Exception
    {
        putMessageOnQueue("routerException");

        // Delivery failed so message should have been redelivered
        assertTrue("Message was not redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testComponentException() throws Exception
    {
        putMessageOnQueue("componentException");

        // Exception occurs after the SEDA queue for an asynchronous request, so from the client's
        // perspective, the message has been delivered successfully.
        assertFalse("Message should not have been redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testCatchExceptionStrategyConsumesMessage() throws Exception
    {
        putMessageOnQueue("exceptionHandled");

        // Exception occurs using catch-exception-strategy that will always consume the message
        assertFalse("Message should not have been redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testRollbackExceptionStrategyConsumesMessage() throws Exception
    {
        final CountDownLatch exceptionStrategyListener = new CountDownLatch(4);
        muleContext.registerListener(new ExceptionNotificationListener<ExceptionNotification>() {
            @Override
            public void onNotification(ExceptionNotification notification)
            {
                exceptionStrategyListener.countDown();
            }
        });
        putMessageOnQueue("rollbackOnException");
        if (!exceptionStrategyListener.await(RECEIVE_TIMEOUT,TimeUnit.MILLISECONDS))
        {
            fail("Message should have been redelivered");
        }
        assertThat(muleContext.getClient().request("jms://rollbackOnException?connector=jmsConnectorNoRedelivery", RECEIVE_TIMEOUT / 10), IsNull.<Object>nullValue());
    }

    @Test
    public void testDefaultExceptionStrategyConsumesMessage() throws Exception
    {
        putMessageOnQueue("commitOnException");

        // Exception occurs using catch-exception-strategy that will always consume the message
        assertFalse("Message should not have been redelivered",
            messageRedelivered.await(latchTimeout, TimeUnit.MILLISECONDS));
    }

}