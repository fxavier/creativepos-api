package com.xavier.creativepos.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("creativepos")
public class CreativeposProperty {
	
	private String allowedOrigin = "http://localhost:8000";
	
	private final Security security = new Security();
	
	
	
	public String getAllowedOrigin() {
		return allowedOrigin;
	}



	public void setAllowedOrigin(String allowedOrigin) {
		this.allowedOrigin = allowedOrigin;
	}



	public Security getSecurity() {
		return security;
	}

	public static class Security{
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
		
		
	}

}
