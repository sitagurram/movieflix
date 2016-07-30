package io.egen.rest.repository;

import io.egen.rest.entity.UserRating;


public interface UserRatingRepository {

	public Double findRatingsForCatelog(String catelogId);
	
	public UserRating create(UserRating userRating);


}
