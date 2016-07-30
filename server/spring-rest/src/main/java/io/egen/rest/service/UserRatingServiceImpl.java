package io.egen.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.rest.entity.UserRating;
import io.egen.rest.repository.UserRatingRepository;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	UserRatingRepository userRatingRepository;
	@Override
	public Double findRatingsForCatelog(String catelogId) {
		return userRatingRepository.findRatingsForCatelog(catelogId);
	}

	@Override
	public UserRating create(UserRating userRating) {
		return userRatingRepository.create(userRating);
	}

}
