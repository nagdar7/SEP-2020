package com.sep.NC.dto;

public class PayItemsDTO {
	public String Id;
	public String Value;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public PayItemsDTO(String id, String value) {
		super();
		Id = id;
		Value = value;
	}
	public PayItemsDTO(){
		super();
	}
	@Override
	public String toString() {
		return "PayItemsDTO [Id=" + Id + ", Value=" + Value + "]";
	}	
	
	
	
}
