package com.davivienda.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
@JsonIgnoreProperties({ "id"})
public class AccountEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "identification_number", unique = true)	
	private String identificationNumber;
	
	private Double balance; 
	
	
	private static final long serialVersionUID = -1107520760169753562L;
}
