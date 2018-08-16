package com.ssu.miso.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int authority;

	public MemberVO() {

	}

	public MemberVO(String id, String name, int authority) {
		super();
		this.id = id;
		this.name = name;
		this.authority = authority;
	}

	public MemberVO(String id, String password, String name, int authority) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.authority = authority;
	}

	public final String getId() {
		return id;
	}

	public final String getPassword() {
		return password;
	}

	public final String getName() {
		return name;
	}

	public final int getAuthority() {
		return authority;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", authority=" + authority + "]";
	}

}
