package com.isslng.terra.storage.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isslng.terra.storage.entities.Account;

@Transactional
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {

}
