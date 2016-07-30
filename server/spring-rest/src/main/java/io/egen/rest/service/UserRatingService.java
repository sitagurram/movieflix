package io.egen.rest.service;

import io.egen.rest.entity.UserRating;

public interface UserRatingService {

	public Double findRatingsForCatelog(String catelogId);
	
	public UserRating create(UserRating userRating);
}
