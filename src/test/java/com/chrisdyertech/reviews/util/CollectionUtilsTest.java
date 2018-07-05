package com.chrisdyertech.reviews.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.chrisdyertech.reviews.domain.Review;

public class CollectionUtilsTest {

	@Test
	public void testToList() throws Exception {
		List<Review> reviews = CollectionUtils.toList(Arrays.asList(new Review()));
		assertEquals(1, reviews.size());
	}
	
	@Test
	public void testToListEmptyIterable() throws Exception {
		List<Review> empty = CollectionUtils.toList(new ArrayList<>());
		assertEquals(0, empty.size());
	}

}
