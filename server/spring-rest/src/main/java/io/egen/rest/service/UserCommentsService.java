package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.UserComments;


public interface UserCommentsService {

	public List<UserComments> findCommentsForCatelog(String catelogId);
	
	public UserComments create(UserComments userComments);
}
