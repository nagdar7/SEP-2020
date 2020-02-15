package com.sep.BitCoin.model;

import lombok.ToString;

@ToString
public class RedirectDTO {
	public String redirectUrl;

	public String status;

	public String getRedirectUrl() {
		return this.redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
