package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Roles")
@EqualsAndHashCode( of = "name")
public class Role {
	@Id
	@Column(name = "Role")
	private String name;
}
