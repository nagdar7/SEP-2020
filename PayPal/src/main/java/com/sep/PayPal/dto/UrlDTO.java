package com.sep.PayPal.dto;

import org.springframework.http.HttpStatus;

public class UrlDTO {
	
	public String Url;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public UrlDTO(String url) {
		super();
		Url = url;
	}
	
}
