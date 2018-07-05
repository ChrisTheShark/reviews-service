package com.chrisdyertech.reviews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.chrisdyertech.reviews.domain.Review;
import com.chrisdyertech.reviews.repository.ReviewsRepository;
import com.chrisdyertech.reviews.util.CollectionUtils;

/**
 * {@link ReviewsService} implementation uses a {@link CrudRepository}
 * to persist {@link Review}s to a data store.
 */
@Service
public class ReviewsServiceImpl implements ReviewsService {
	
	@Autowired
	private ReviewsRepository repository;

	@Override
	public List<Review> getAll() {
		return CollectionUtils.toList(repository.findAll());
	}

	@Override
	public Review getById(int id) {
		Optional<Review> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Review add(Review review) {
		return repository.save(review);
	}

	@Override
	public void delete(Review review) {
		repository.delete(review);
	}

}
