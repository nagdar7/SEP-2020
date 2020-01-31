package com.sep.PayPal.model;

import java.time.LocalDateTime;

import javax.persistence.*;

public class Transaction {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "merchant_order_id", unique = true, nullable = false)
	private Long merchantOrderId;
	
	@Column(name = "card_number", unique = true, nullable = true)
	private String cardNumber;
	
	// pin code ne bi trebalo da cuvamo
	
	@Column(name = "first_Name", unique = false, nullable = true)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = true)
	private String lastName;
	
	@Column(name = "amount", unique = false, nullable = false)
	private double amount;
    
	@Column(name = "currency", unique = false, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    
    @Column(name = "merchant_timestamp", unique = false, nullable = false)
    private LocalDateTime merchantTimestamp;
    
    @Column(name = "timestamp", unique = false, nullable = false)
    private LocalDateTime timestamp;
    
    @Column(name = "redirect_url", unique = false, nullable = false)
    private String redirectUrl;
    
    @Column(name = "callback_url", unique = false, nullable = false)
    private String callbackUrl;
    
	@Column(name = "status", unique = false, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TrasnsactionStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(Long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public LocalDateTime getMerchantTimestamp() {
		return merchantTimestamp;
	}

	public void setMerchantTimestamp(LocalDateTime merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public TrasnsactionStatus getStatus() {
		return status;
	}

	public void setStatus(TrasnsactionStatus status) {
		this.status = status;
	}

	public Transaction(Long id, Long merchantOrderId, String cardNumber, String firstName, String lastName,
			double amount, Currency currency, LocalDateTime merchantTimestamp, LocalDateTime timestamp,
			String redirectUrl, String callbackUrl, TrasnsactionStatus status) {
		super();
		this.id = id;
		this.merchantOrderId = merchantOrderId;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
		this.currency = currency;
		this.merchantTimestamp = merchantTimestamp;
		this.timestamp = timestamp;
		this.redirectUrl = redirectUrl;
		this.callbackUrl = callbackUrl;
		this.status = status;
	}

	public Transaction() {
		super();
	}
	
	
}
