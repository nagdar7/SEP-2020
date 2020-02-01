package com.sep.PayPal.dto;

import java.util.HashMap;
import java.util.Map;

public class PaymentDTO {
    public Map<String, String> items = new HashMap<String, String>();

	public Map<String, String> getResponse() {
		return items;
	}

	public void setResponse(Map<String, String> items) {
		this.items = items;
	}

	public PaymentDTO(Map<String, String> items) {
		super();
		this.items = items;
	}

	public PaymentDTO() {
		super();
	}
}
