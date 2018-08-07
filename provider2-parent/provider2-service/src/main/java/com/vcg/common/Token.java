package com.vcg.common;

public class Token {

	private String userId;
	private String userName;
	private long createDate;
	private long expires;
	private int level;

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Token(String userId, long expires) {
		super();
		this.userId = userId;
		this.createDate = System.currentTimeMillis();
		this.expires = expires * 1000;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
