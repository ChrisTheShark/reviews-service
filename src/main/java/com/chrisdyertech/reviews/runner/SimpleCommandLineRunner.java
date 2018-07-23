package com.chrisdyertech.reviews.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.service.ReviewsService;

/**
 * Simple {@link CommandLineRunner} implementation inserts starter data.
 */
@Component
public class SimpleCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private ReviewsService reviewsService;

	@Override
	public void run(String... args) throws Exception {
		Review review1 = new Review(1, 1, 4.3, "What a great product.");
		Review review2 = new Review(1, 2, 3.6, "This didn't meet my expectations.");
		Review review3 = new Review(2, 2, 4.0, "Not terrible but could use improvement.");
		Review review4 = new Review(1, 3, 5.0, "There are no improvements to be made here.");
		
		reviewsService.add(review1);
		reviewsService.add(review2);
		reviewsService.add(review3);
		reviewsService.add(review4);
	}

}
