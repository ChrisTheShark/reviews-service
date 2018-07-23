package com.chrisdyertech.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * Simple <code>class</code> represents a review.
 */
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Positive
	@Column(name = "user_id")
	private int userId;
	
	@Positive
	@Column(name = "product_id")
    private int productId;
	
	@PositiveOrZero
	@Column(name = "rating")
	private double rating;
	
	@NotEmpty
	@Column(name = "comment")
	private String comment;
	
	public Review() {}

	public Review(@Positive int userId, @Positive int productId, @PositiveOrZero double rating,
			@NotEmpty String comment) {
		super();
		this.userId = userId;
		this.productId = productId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
