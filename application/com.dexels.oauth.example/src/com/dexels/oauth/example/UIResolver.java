package com.dexels.oauth.example;

import org.ops4j.pax.web.extender.whiteboard.ResourceMapping;
import org.ops4j.pax.web.extender.whiteboard.runtime.DefaultResourceMapping;

public class UIResolver implements ResourceMapping {
	private final DefaultResourceMapping resourceMapping = new DefaultResourceMapping();

	
	
	public void activate() {
		resourceMapping.setAlias("/example");
		resourceMapping.setPath("resources");
	}

	@Override
	public String getAlias() {
		return resourceMapping.getAlias();
	}

	@Override
	public String getHttpContextId() {
		return resourceMapping.getHttpContextId();
	}

	@Override
	public String getPath() {
		return resourceMapping.getPath();
	}
}
