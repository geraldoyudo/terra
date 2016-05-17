package com.isslng.terra.storage.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"orgId", "entryType", "serialNo"})
public class EntryId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String orgId;
	String entryType;
	String serialNo;
}
