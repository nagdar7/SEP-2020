package com.sep.PayPal.model;

import javax.persistence.*;

public class Property {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "identifier", unique = false, nullable = false)
    private String identifier; // account number, paypal account, bitcoin account, ...

    @Column(name = "value", unique = false, nullable = false)
    private String value;
}
