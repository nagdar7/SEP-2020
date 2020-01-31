package com.sep.PayPal.model;

import javax.persistence.*;

public class Permission {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Permission(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Permission() {
		super();
	}
    
    

}
