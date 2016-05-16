package com.isslng.terra.storage.web;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isslng.terra.storage.repositories.EntryHeaderRepository;

@RestController
public class TerraApi {
	@Autowired
	private EntryHeaderRepository ehRepository;
	@RequestMapping(path = "/terra/post", method = RequestMethod.POST)
	public void post(@RequestBody ArrayList<Map<String,String>> entries){
		ehRepository.save(entries);
	}
}
