package com.davivienda.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.api.dto.APIResponseDTO;
import com.davivienda.api.entity.AccountEntity;
import com.davivienda.api.service.IAccountService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@RequestMapping(value = "/account")
@RestController
@Log4j2
public class AccountController {
	
	private String START_SERVICE = "Start service ";
	private String FINISH_SERVICE = "Finish service ";
	
	@Autowired
	IAccountService accountService;
	
	@PostMapping(value = "/create", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<APIResponseDTO<AccountEntity>> createAccount(
			 @RequestBody AccountEntity  account) {

		APIResponseDTO<AccountEntity> response;
		String operationName = "New Account";
		log.info(START_SERVICE + operationName);
		log.info(new Gson().toJson(account));
		
		response = accountService.createAccount(account);

		log.info(new Gson().toJson(response));
		log.info(FINISH_SERVICE + operationName);
		return new ResponseEntity<>(response, response.getHttpStaus());

	}
	
	
	@GetMapping(value = "/find/{idNumber}", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<APIResponseDTO<AccountEntity>> findAccount(
			 @PathVariable String  idNumber) {

		APIResponseDTO<AccountEntity> response;
		String operationName = "Find Account";
		log.info(START_SERVICE + operationName);
		log.info(new Gson().toJson(idNumber));
		
		response = accountService.findAccount(idNumber);

		log.info(new Gson().toJson(response));
		log.info(FINISH_SERVICE + operationName);
		return new ResponseEntity<>(response, response.getHttpStaus());

	}

}
