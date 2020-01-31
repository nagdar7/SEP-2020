package com.sep.PayPal.model;

import javax.persistence.*;

public class FormField {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "type", unique = false, nullable = false)
    private String type;

    @Column(name = "optional", unique = false, nullable = false)
    private boolean optional;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isOptional() {
		return optional;
	}

	public FormField() {
		super();
	}

	public FormField(String id, String name, String type, boolean optional) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.optional = optional;
	}
	
	public FormField(String name, String type, boolean optional) {
		super();
		this.name = name;
		this.type = type;
		this.optional = optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}
    
    
}
