package com.palletech;

public class StudentOne {

	private int no;
	private String name;
	private String subject;
	private String email;
	
	public StudentOne(int no, String name, String subject, String email)
	{
		super();
		this.no = no;
		this.name = name;
		this.subject = subject;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
