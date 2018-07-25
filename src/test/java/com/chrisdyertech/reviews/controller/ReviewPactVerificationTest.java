package com.chrisdyertech.reviews.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.chrisdyertech.reviews.controller.ReviewController;
import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.service.ReviewsService;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

/**
 * Pact verification testing for reviews services.
 */
@RunWith(SpringRestPactRunner.class)
@Provider("reviewsServiceProvider")
@PactFolder("pacts")
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, 
		properties = { "server.port=8888" }
)
public class ReviewPactVerificationTest {
	
	@Autowired
	@InjectMocks
	private ReviewController reviewController;
	
	@MockBean
	private ReviewsService mockReviewsService;

	@TestTarget
	public final Target target = new HttpTarget(8888);
	
	@Before 
	public void initMocks() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@State({"a product with created reviews"})
	public void toExistingProductReviewsState() throws Exception {
		Review mockReview1 = new Review(1, 2, 3.6, "This didn't meet my expectations.");
		mockReview1.setId(2);
		Review mockReview2 = new Review(2, 2, 4.0, "Not terrible but could use improvement.");
		mockReview2.setId(3);
		
		when(mockReviewsService.getByProductId(2)).thenReturn(Arrays.asList(mockReview1, mockReview2));
	}

}
