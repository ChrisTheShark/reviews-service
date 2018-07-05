package com.chrisdyertech.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple <code>class</code> represents a review.
 */
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "comment")
	private String comment;
	
	public Review() {}
	
	public Review(int id, int userId, double rating, String comment) {
		this.id = id;
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
