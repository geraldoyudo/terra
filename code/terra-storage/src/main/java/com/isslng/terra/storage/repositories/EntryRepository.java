package com.isslng.terra.storage.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.isslng.terra.storage.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, String>{

}
