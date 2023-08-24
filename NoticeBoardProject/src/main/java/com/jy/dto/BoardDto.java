package com.jy.dto;

public class BoardDto {
	private int bno;	
	private String title;	
	private String nickname;	
	private String writedate;	
	private int hitcount;	
	private String content;	
	private String photo;
	private String loginId;
	
	public BoardDto() { }	//파라미터가 0개인 생성자가 없으면 에러발생
	
	public BoardDto(int bno, String title, String nickname, String writedate, int hitcount, String content,
			String photo) {
		this.bno = bno;
		this.title = title;
		this.nickname = nickname;
		this.writedate = writedate;
		this.hitcount = hitcount;
		this.content = content;
		this.photo = photo;
	}

	public BoardDto(int bno, String title, String nickname, String writedate, int hitcount, String content,
			String photo, String loginId) {
		this(bno, title, nickname, writedate, hitcount, content, photo);
		this.loginId = loginId;
	}
	
	public BoardDto(String title, String content, String photo, String loginId) {
		this(title, content, loginId);
		this.photo = photo;
	}
	
	public BoardDto(String title, String content, String loginId) {
		this.title = title;
		this.content = content;
		this.loginId = loginId;
	}

	public BoardDto(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}


	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
}
