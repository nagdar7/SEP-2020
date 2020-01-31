package com.sep.NC.dto;

import java.util.List;

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
