package com.sep.PayPal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

public class Role {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private Set<Permission> permissions = new HashSet<Permission>();

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

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Role(Long id, String name, Set<Permission> permissions) {
		super();
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}

	public Role() {
		super();
	}
    
    
}
