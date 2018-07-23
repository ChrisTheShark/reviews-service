package com.chrisdyertech.reviews.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.exceptions.UserNotFoundException;
import com.chrisdyertech.reviews.service.ReviewsService;

/**
 * Main controller <code>class</code> for retrieving 
 * {@link com.chrisdyertech.reviews.domain.Review} objects.
 */
@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewsService reviewsService;

	@GetMapping
	public List<Review> getAllReviews() {
		return reviewsService.getAll();
	}
	
	@GetMapping("/{id}")
	public Review getReviewById(@PathVariable Integer id) {
		Review review = reviewsService.getById(id);
		if (review != null) {
			return review;
		}
		throw new UserNotFoundException("Unable to locate user with id: " + id);
	}
	
	@GetMapping("/product/{productId}")
	public List<Review> getReviewByProductId(@PathVariable Integer productId) {
		return reviewsService.getByProductId(productId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Review addReview(@Valid @RequestBody Review review) {
		return reviewsService.add(review);
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteReview(@RequestBody Review review) {
		reviewsService.delete(review);
	}
	
}
