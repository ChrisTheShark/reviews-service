package com.chrisdyertech.reviews.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.chrisdyertech.reviews.controller.ReviewController;
import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.service.ReviewsService;

/**
 * Testing for {@link ReviewController}.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
	
	@Autowired
	@InjectMocks
	private ReviewController reviewController;
	
	@MockBean
	private ReviewsService mockReviewsService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetReviewsHappyPath() throws Exception {
		when(mockReviewsService.getAll())
			.thenReturn(Arrays.asList(
					new Review(1, 1, 3.5, "Pretty ok product. Didn't last long enough.")
				));
		
		mockMvc.perform(get("/reviews")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
		
		verify(mockReviewsService).getAll();
	}
	
	@Test
	public void testGetReviewByIdHappyPath() throws Exception {
		when(mockReviewsService.getById(1))
			.thenReturn(new Review(1, 2, 4.3, "This is great."));
		
		mockMvc.perform(get("/reviews/1"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	public void testGetReviewByProductIdHappyPath() throws Exception {
		when(mockReviewsService.getByProductId(1))
			.thenReturn(Arrays.asList(new Review(1, 2, 4.3, "This is great.")));
		
		mockMvc.perform(get("/reviews/product/1"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	public void testPostAddReviewHappyPath() throws Exception {
		Review mockReview = new Review();
		mockReview.setId(1);
		when(mockReviewsService.add(Mockito.any(Review.class)))
			.thenReturn(mockReview);
		
		mockMvc.perform(post("/reviews")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"userId\": 2, \"productId\": 2, \"rating\": 4.3, \"comment\": \"This is great\" }"))
		.andExpect(status().isCreated());
		
		verify(mockReviewsService).add(Mockito.any(Review.class));
	}
	
	@Test
	public void testDeleteReviewHappyPath() throws Exception {
		mockMvc.perform(delete("/reviews")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"userId\": 2, \"rating\": 4.3, \"comment\": \"This is great\" }"))
		.andExpect(status().isNoContent());
		
		verify(mockReviewsService).delete(Mockito.any(Review.class));
	}

}
