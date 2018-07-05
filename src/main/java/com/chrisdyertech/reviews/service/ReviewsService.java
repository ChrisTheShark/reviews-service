package com.chrisdyertech.reviews.service;

import java.util.List;

import com.chrisdyertech.reviews.domain.Review;

/**
 * <code>interface</code> representing functionality exposed
 * by an implementation of {@link ReviewsService}.
 */
public interface ReviewsService {

	/**
	 * Get all {@link Review}s.
	 * 
	 * @return a calculated {@link java.util.List} of {@link Review}s.
	 */
	public List<Review> getAll();
	
	/**
	 * Get a {@link Review} by a provided <code>int</code> identifier.
	 * 
	 * @param id the provided <code>int</code> identifier
	 * @return the located {@link Review} object
	 */
	public Review getById(int id);
	
	/**
	 * Add a {@link Review}.
	 * 
	 * @param review the provided {@link Review} to add
	 * @return the persisted {@link Review} object
	 */
	public Review add(Review review);
	
	/**
	 * Remove the provided {@link Review} object.
	 * 
	 * @param review the provided {@link Review} to remove
	 */
	public void delete(Review review);
	
}
