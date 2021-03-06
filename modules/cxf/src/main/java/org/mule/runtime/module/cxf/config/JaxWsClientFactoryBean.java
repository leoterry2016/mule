/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.module.cxf.config;

import org.mule.runtime.module.cxf.CxfOutboundMessageProcessor;
import org.mule.runtime.module.cxf.builder.JaxWsClientMessageProcessorBuilder;

import org.springframework.beans.factory.FactoryBean;

public class JaxWsClientFactoryBean extends JaxWsClientMessageProcessorBuilder implements FactoryBean {

  public Object getObject() throws Exception {
    return build();
  }

  public Class<?> getObjectType() {
    return CxfOutboundMessageProcessor.class;
  }

  public boolean isSingleton() {
    return true;
  }

}
