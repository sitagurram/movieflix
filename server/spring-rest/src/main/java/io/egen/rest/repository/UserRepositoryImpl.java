/**
 * 
 */
package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.AppUser;

/**
 * @author MAHITH
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#findAll()
	 */
	@Override
	public List<AppUser> findAll() {
		TypedQuery<AppUser> query = em.createNamedQuery("AppUser.findAll", AppUser.class);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#findOne(java.lang.String)
	 */
	@Override
	public AppUser findOne(String id) {
		return em.find(AppUser.class, id);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#findByEmail(java.lang.String)
	 */
	@Override
	public AppUser findByEmail(String email) {
		TypedQuery<AppUser> query = em.createNamedQuery("AppUser.findByEmail", AppUser.class);
		query.setParameter("pEmail", email);
		List<AppUser> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#create(io.egen.rest.entity.AppUser)
	 */
	@Override
	public AppUser create(AppUser user) {
		em.persist(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#update(io.egen.rest.entity.AppUser)
	 */
	@Override
	public AppUser update(AppUser user) {
		return em.merge(user);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.UserRepository#delete(io.egen.rest.entity.AppUser)
	 */
	@Override
	public void delete(AppUser user) {
		em.remove(user);
	}

}
