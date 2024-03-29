package com.org.streams.first.app.model;

public class Student {
	
	private String name;
	private int id;
	private String subject;
	private double percentage;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", subject=" + subject + ", percentage=" + percentage + "]";
	}
	public Student(String name, int id, String subject, double percentage) {
		super();
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage;
	}
	public Student(String name, int id, String subject, int percentage) {
		super();
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage*1.0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
