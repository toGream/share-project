package org.share.topic.impl.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="share.url")
public class UrlConfig {
	private String home;

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
}
