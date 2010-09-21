/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.api.annotations.param;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.util.IOUtils;

import java.io.InputStream;

public class PayloadAnnotationTestCase extends FunctionalTestCase
{
    public PayloadAnnotationTestCase()
    {
        setDisposeManagerPerSuite(true);
    }

    @Override
    protected String getConfigResources()
    {
        return "org/mule/test/annotations/payload-annotation.xml";
    }

    public void testPayloadNoTransform() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage message = client.send("vm://payload1", "foo", null);
        assertNotNull("return message from MuleClient.send() should not be null", message);
        assertTrue("Message payload should be a String", message.getPayload() instanceof String);
        assertEquals("foo", message.getPayload());
    }

    public void testPayloadAutoTransform() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage message = client.send("vm://payload2", "foo", null);
        assertNotNull("return message from MuleClient.send() should not be null", message);
        assertTrue("Message payload should be a String", message.getPayload() instanceof InputStream);
        assertEquals("foo", IOUtils.toString((InputStream)message.getPayload()));
    }

    public void testPayloadFailedTransform() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage message = client.send("vm://payload3", null, null);
        assertNotNull("return message from MuleClient.send() should not be null", message);
        assertNotNull(message.getExceptionPayload());
        assertTrue(message.getExceptionPayload().getRootException() instanceof TransformerException);
    }
}
