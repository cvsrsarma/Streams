package com.org.streams.first.app.model;

public class Course {
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", coursetype=" + coursetype + ", reviews=" + reviews
				+ ", numberOfStds=" + numberOfStds + "]";
	}
	public Course(String courseName, String coursetype, int reviews, int numberOfStds) {
		super();
		this.courseName = courseName;
		this.coursetype = coursetype;
		this.reviews = reviews;
		this.numberOfStds = numberOfStds;
	}
	private String courseName;
	private String coursetype;
	private int reviews;
	private int numberOfStds;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public int getNumberOfStds() {
		return numberOfStds;
	}
	public void setNumberOfStds(int numberOfStds) {
		this.numberOfStds = numberOfStds;
	}
}
