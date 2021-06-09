package com.davivienda.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.api.entity.AccountEntity;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long>{
	
	public AccountEntity findByIdentificationNumber(String identificationNumber);
	
}
