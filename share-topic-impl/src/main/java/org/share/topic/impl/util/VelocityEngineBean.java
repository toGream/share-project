package org.share.topic.impl.util;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class VelocityEngineBean extends VelocityEngine{
	public VelocityEngineBean() {
		this.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
		this.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	}
}
