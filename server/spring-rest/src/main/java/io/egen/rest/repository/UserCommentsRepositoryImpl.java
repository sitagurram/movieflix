package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.UserComments;

@Repository
public class UserCommentsRepositoryImpl implements UserCommentsRepository{
   
	@PersistenceContext
	private EntityManager em;
	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserCommentsReposiotry#findCommentsForCatelog(java.lang.String)
	 */
	@Override
	public List<UserComments> findCommentsForCatelog(String catelogId) {
		TypedQuery<UserComments> query = em.createNamedQuery("UserComments.findCommentsForCatelog", UserComments.class);
		query.setParameter("pCatelogId", catelogId);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserCommentsReposiotry#create(io.egen.rest.entity.UserComments)
	 */
	@Override
	public UserComments create(UserComments userComments) {
		em.persist(userComments);
		return userComments;
	}

}
