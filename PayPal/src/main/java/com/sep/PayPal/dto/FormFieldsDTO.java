package com.sep.PayPal.dto;

import java.util.List;

import com.sep.PayPal.model.FormField;

public class FormFieldsDTO {

	public List<FormField> formFields;

	public List<FormField> getFormFields() {
		return formFields;
	}

	public void setFormFields(List<FormField> formFields) {
		this.formFields = formFields;
	}

	public FormFieldsDTO(List<FormField> formFields) {
		super();
		this.formFields = formFields;
	}
}
