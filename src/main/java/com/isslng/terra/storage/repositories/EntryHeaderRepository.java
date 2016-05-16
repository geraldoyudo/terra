package com.isslng.terra.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isslng.terra.storage.entities.EntryHeader;

public interface EntryHeaderRepository extends JpaRepository<EntryHeader, String>{

}
