package com.isslng.terra.storage.repositories;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isslng.terra.storage.entities.EntryHeader;

@Transactional
public interface EntryHeaderRepository extends JpaRepository<EntryHeader, String>, EntryHeaderRepositoryCustom{
	public void save(List<Map<String,String>> entry);

}
