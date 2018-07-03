package com.chrisdyertech.reviews.domain;

/**
 * Simple <code>class</code> represents a review.
 */
public class Review {
	private Integer userId;
	private Double rating;
	private String comment;
	
	public Review() {}
	
	public Review(Integer userId, Double rating, String comment) {
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
