package com.chrisdyertech.reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chrisdyertech.reviews.domain.Review;

/**
 * {@link CrudRepository} extension <code>interface</code> for {@link Review}
 * objects.
 */
public interface ReviewsRepository extends CrudRepository<Review, Integer> {
	
	@Query("SELECT r from Review r where r.productId = ?1")
	public List<Review> findByProductId(int productId);
	
}
