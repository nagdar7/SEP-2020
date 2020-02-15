package com.sep.PayPal.dto;

public class RedirectDTO {
	public String RedirectUrl;

	public String Status;

	public String getRedirectUrl() {
		return RedirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.RedirectUrl = redirectUrl;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

}
