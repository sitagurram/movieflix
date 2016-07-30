package io.egen.rest.repository;

import java.util.List;
import io.egen.rest.entity.*;

public interface UserCommentsRepository {
	
	public List<UserComments> findCommentsForCatelog(String catelogId);
	
	public UserComments create(UserComments userComments);

}
