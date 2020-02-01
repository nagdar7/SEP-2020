package com.sep.NC.dto;

public class RedirectDTO {
	public String RedirectUrl;
	
	public String Status;

	public String getRedirectUrl() {
		return RedirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		RedirectUrl = redirectUrl;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "RedirectDTO [RedirectUrl=" + RedirectUrl + ", Status=" + Status + "]";
	}

	public RedirectDTO(String redirectUrl, String status) {
		super();
		RedirectUrl = redirectUrl;
		Status = status;
	}

	public RedirectDTO() {
		super();
	}
	
	
	
}
