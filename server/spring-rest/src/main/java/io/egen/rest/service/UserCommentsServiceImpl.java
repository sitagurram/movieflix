package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.UserComments;
import io.egen.rest.repository.UserCommentsRepository;


@Service
public class UserCommentsServiceImpl implements UserCommentsService {

	@Autowired
	UserCommentsRepository userCommentsRepository;
	
	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserCommentsService#findCommentsForCatelog(java.lang.String)
	 */
	@Override
	public List<UserComments> findCommentsForCatelog(String catelogId) {
		return userCommentsRepository.findCommentsForCatelog(catelogId);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserCommentsService#create(io.egen.rest.entity.UserComments)
	 */
	@Override
	@Transactional
	public UserComments create(UserComments userComments) {
		return userCommentsRepository.create(userComments);
	}

}