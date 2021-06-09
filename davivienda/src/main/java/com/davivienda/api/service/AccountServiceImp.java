package com.davivienda.api.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davivienda.api.dto.APIResponseDTO;
import com.davivienda.api.entity.AccountEntity;
import com.davivienda.api.repository.AccountRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AccountServiceImp implements IAccountService {

	@Autowired
	private AccountRepository accountRepo;

	private AccountEntity accountData;

	private final Double MIN_BALANCE = 50000.00d;

	@Override
	public APIResponseDTO<AccountEntity> createAccount(AccountEntity account) {
		APIResponseDTO<AccountEntity> response = new APIResponseDTO<>();

		try {
			if (account.getBalance() > MIN_BALANCE) {
				findAccount(account.getIdentificationNumber());
				
				if (Objects.isNull(this.accountData)) {
					this.accountData = accountRepo.save(account);
					response.setSucces(accountData, "Account created success");
				} else {
					response.setFail(account, 
							"An account already exists with the identification number: "
									+account.getIdentificationNumber());
				}
			}else {
				response.setFail(account, "For create account the min Balance must be: " + MIN_BALANCE);
			}
		} catch (Exception e) {
			response.setError("Error to create account ");
			log.error(response.getMessage(), e);
		}
		return response;
	}

	
	@Override
	public APIResponseDTO<AccountEntity> findAccount(String idNumber) {
		APIResponseDTO<AccountEntity> response = new APIResponseDTO<>();

		try {
			this.accountData = accountRepo.findByIdentificationNumber(idNumber);
			if (!Objects.isNull(this.accountData)) {
				response.setSucces(this.accountData, "Success");
			} else {
				response.setFail(null, "Account not found");
			}
		} catch (Exception e) {
			response.setError("Error to find account ");
			log.error(response.getMessage(), e);
		}
		return response;
	}

}
