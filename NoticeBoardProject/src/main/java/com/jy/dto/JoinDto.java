package com.jy.dto;

public class JoinDto {
	private String memberId;
	private String password;
	private String username;
	private String email;
	private String nickname;
	private String birth; 
	private String gender;
	private String phone;
	
	public JoinDto() {}
	public JoinDto(String memberId, String password, String username, String email, String nickname, String birth,
			String gender, String phone) {
		this.memberId = memberId;
		this.password = password;
		this.username = username;
		this.email = email;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
