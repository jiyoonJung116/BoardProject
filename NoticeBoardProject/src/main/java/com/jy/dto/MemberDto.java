package com.jy.dto;

public class MemberDto {
	private String member_id;
	private String password;
	private String username;
	private String email;
	private String nickname;
	private String gender;
	private String phone;
	private String join_date;
	private String token;
	private String birth;
	
	public MemberDto() { }
	public MemberDto(String member_id, String password, String username, String email, String nickname, String gender,
			String phone, String join_date, String token, String birth) {
		this.member_id = member_id;
		this.password = password;
		this.username = username;
		this.email = email;
		this.nickname = nickname;
		this.gender = gender;
		this.phone = phone;
		this.join_date = join_date;
		this.token = token;
		this.birth = birth;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
