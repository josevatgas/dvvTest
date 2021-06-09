package com.davivienda.api.service;

import com.davivienda.api.dto.APIResponseDTO;
import com.davivienda.api.entity.AccountEntity;

public interface IAccountService {
	
	public APIResponseDTO<AccountEntity> createAccount (AccountEntity account);
	public APIResponseDTO<AccountEntity> findAccount (String idNumber);

}
