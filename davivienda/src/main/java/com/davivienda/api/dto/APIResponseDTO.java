package com.davivienda.api.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "httpStaus"})
public class APIResponseDTO<T> implements Serializable {

	private boolean state;
	private String message;
	HttpStatus httpStaus;
	private T data;

	public void setSucces(T data, String message) {
		this.setMessage(message);
		this.setState(Boolean.TRUE);
		this.setHttpStaus(HttpStatus.OK);
		this.setData(data);
	}
	
	public void setFail(T data, String message) {
		this.setMessage(message);
		this.setState(Boolean.FALSE);
		this.setHttpStaus(HttpStatus.NOT_FOUND);
		this.setData(data);
	}
	
	public void setError(String message) {
		this.setMessage(message);
		this.setState(Boolean.FALSE);
		this.setHttpStaus(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private static final long serialVersionUID = -4545344227922434810L;

}
