package com.chrisdyertech.reviews.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisdyertech.reviews.domain.Review;

/**
 * Main controller <code>class</code> for retrieving 
 * {@link com.chrisdyertech.reviews.domain.Review} objects.
 */
@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

	@GetMapping
	public List<Review> getAllReviews() {
		return Arrays.asList(
				new Review(1, 3.5, "Pretty ok product. Didn't last long enough."));
	}
	
}
