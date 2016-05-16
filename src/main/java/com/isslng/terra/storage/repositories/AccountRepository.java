package com.isslng.terra.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isslng.terra.storage.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
