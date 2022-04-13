package org.ep.springioctest;

public class SysUser {
	private String username;
	private SysRole sysRole;

	public SysUser() {
	}

	public SysUser(String username, SysRole sysRole) {
		this.username = username;
		this.sysRole = sysRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
}