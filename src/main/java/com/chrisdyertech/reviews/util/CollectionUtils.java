package com.chrisdyertech.reviews.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Simple utility <code>class</code> housing reusable functionality 
 * for {@link Collection} implementations.
 */
public class CollectionUtils {
	
	/**
	 * Return a {@link List} created from an {@link Iterable}.
	 * 
	 * @param iterable the {@link Iterable} to create from
	 * @return a created {@link List} from the provided {@link Iterable}
	 */
	public static <T> List<T> toList(Iterable<T> iterable) {
		List<T> items = new ArrayList<>();
		iterable.forEach(items::add);
		return items;
	}

}
