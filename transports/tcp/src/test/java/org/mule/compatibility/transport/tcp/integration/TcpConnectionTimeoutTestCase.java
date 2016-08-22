/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.compatibility.transport.tcp.integration;

import org.junit.Test;

import org.mule.compatibility.module.client.MuleClient;
import org.mule.functional.junit4.FunctionalTestCase;
import org.mule.runtime.api.message.Error;
import org.mule.runtime.core.api.FutureMessageResult;
import org.mule.runtime.core.api.MuleMessage;

public class TcpConnectionTimeoutTestCase extends FunctionalTestCase {

  @Override
  protected String getConfigFile() {
    return "tcp-connection-timeout-config.xml";
  }

  @Test
  public void usesConnectionTimeout() throws Exception {
    final MuleClient client = new MuleClient(muleContext);
    FutureMessageResult result = client.sendAsync("vm://testInput", TEST_MESSAGE, null);

    Error error = result.getResult(1000).getLeft();
    //TODO check error type

  }
}
