package org.ep.springioctest;

import java.util.List;

public class SysRole {
	private long id;
	private String name;

	public SysRole() {
	}

	public SysRole(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
