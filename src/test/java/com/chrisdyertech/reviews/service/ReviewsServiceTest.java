package com.chrisdyertech.reviews.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.repository.ReviewsRepository;
import com.chrisdyertech.reviews.service.ReviewsService;
import com.chrisdyertech.reviews.service.ReviewsServiceImpl;

/**
 * Testing for {@link ReviewsService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class ReviewsServiceTest {

	@InjectMocks
	private ReviewsService service = new ReviewsServiceImpl();

	@Mock
	private ReviewsRepository mockRepository;

	@Test
	public void testGetAll() throws Exception {
		when(mockRepository.findAll()).thenReturn(Arrays.asList(new Review()));

		List<Review> reviews = service.getAll();

		verify(mockRepository).findAll();
		assertEquals(1, reviews.size());
	}

	@Test
	public void testGetById() throws Exception {
		when(mockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new Review()));

		Review review = service.getById(1);

		verify(mockRepository).findById(Mockito.anyInt());
		assertNotNull(review);
	}
	
	@Test
	public void testGetByProductId() throws Exception {
		List<Review> reviews = Arrays.asList(new Review());
		when(mockRepository.findByProductId(Mockito.anyInt())).thenReturn(reviews);
		
		List<Review> returnedList = service.getByProductId(1);
		
		assertEquals(1, returnedList.size());
	}

	@Test
	public void testAdd() throws Exception {
		Review mockReview = new Review();
		mockReview.setId(1);
		when(mockRepository.save(Mockito.any(Review.class)))
			.thenReturn(mockReview);
		
		Review createdReview = service.add(new Review());
		
		verify(mockRepository).save(Mockito.any(Review.class));
		assertEquals(1, createdReview.getId());
	}

	@Test
	public void testDelete() throws Exception {
		service.delete(new Review());
		verify(mockRepository).deleteById(Mockito.any(Integer.class));
	}

}
