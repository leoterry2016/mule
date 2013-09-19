/*
 * (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
 * law. All use of this software is subject to MuleSoft's Master Subscription Agreement
 * (or other master license agreement) separately entered into in writing between you and
 * MuleSoft. If such an agreement is not in place, you may not use the software.
 */
package org.mule.transport.quartz;

import org.mule.DefaultMuleContext;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.functional.CountdownCallback;
import org.mule.tck.functional.FunctionalTestComponent;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.PollingController;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class QuartzPollingFunctionalTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "quartz-polling-functional-test.xml";
    }

    @Test
    public void testMuleReceiverJob() throws Exception
    {
        ((DefaultMuleContext) muleContext).setPollingController(new PollingController()
        {
            @Override
            public boolean isPrimaryPollingInstance()
            {
                return false;
            }
        });

        FunctionalTestComponent component = (FunctionalTestComponent) getComponent("quartzService1");
        assertNotNull(component);
        CountdownCallback count1 = new CountdownCallback(1000);
        component.setEventCallback(count1);

        component = (FunctionalTestComponent) getComponent("quartzService2");
        assertNotNull(component);
        CountdownCallback count2 = new CountdownCallback(1000);
        component.setEventCallback(count2);
        Thread.sleep(10000);

        assertEquals(1000, count1.getCount());
        assertEquals(1000, count2.getCount());
        ((DefaultMuleContext)muleContext).setPollingController(new PollingController()
        {
            @Override
            public boolean isPrimaryPollingInstance()
            {
                return true;
            }
        });
        Thread.sleep(5000);
        assertTrue(count1.getCount() < 1000);
        assertTrue(count2.getCount() < 1000);
    }

    @Test
    public void testMuleSenderJob() throws Exception
    {
        ((DefaultMuleContext) muleContext).setPollingController(new PollingController()
        {
            @Override
            public boolean isPrimaryPollingInstance()
            {
                return false;
            }
        });

        MuleClient client = new MuleClient(muleContext);
        client.dispatch("vm://source", "Hello", null);
        Thread.sleep(10000);
        int numMessages = -1;
        MuleMessage message;
        do
        {
            numMessages++;
            message = client.request("vm://sink", 1);
            if (message != null)
            {
                assertEquals("Hello", message.getPayload());
            }
        }
        while (message != null);
        assertTrue(numMessages > 0);
    }

}