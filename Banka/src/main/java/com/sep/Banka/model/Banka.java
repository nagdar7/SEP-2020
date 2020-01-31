package com.sep.Banka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Banka {

	private Long id;
	private String pin;
	private String brojKartice;
	private double iznos;
	private String ime;
	private String prezime;

	public Banka() {
		super();
	}

	public Banka(Long id, String pin, String brojKartice, double iznos, String ime, String prezime) {
		super();
		this.id = id;
		this.pin = pin;
		this.brojKartice = brojKartice;
		this.iznos = iznos;
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getBrojKartice() {
		return brojKartice;
	}

	public void setBrojKartice(String brojKartice) {
		this.brojKartice = brojKartice;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

}
