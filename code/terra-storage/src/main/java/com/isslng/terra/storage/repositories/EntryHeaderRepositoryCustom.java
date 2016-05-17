package com.isslng.terra.storage.repositories;

import java.util.List;
import java.util.Map;

public interface EntryHeaderRepositoryCustom {
	public void save(List<Map<String,String>> entries);
}
