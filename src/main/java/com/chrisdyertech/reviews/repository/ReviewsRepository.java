package com.chrisdyertech.reviews.repository;

import org.springframework.data.repository.CrudRepository;

import com.chrisdyertech.reviews.domain.Review;

/**
 * {@link CrudRepository} extension <code>interface</code> for {@link Review}
 * objects.
 */
public interface ReviewsRepository extends CrudRepository<Review, Integer> {}
