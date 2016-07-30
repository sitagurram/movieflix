/**
 * 
 */
package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Catelog;


@Repository
public class CatelogRepositoryImpl implements CatelogRepository {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findAll()
	 */
	@Override
	public List<Catelog> findAll() {
		TypedQuery<Catelog> query = em.createNamedQuery("Catelog.findAll", Catelog.class);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findAllByType(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByType(String type) {
		TypedQuery<Catelog> query = em.createNamedQuery("Catelog.findByType", Catelog.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findByTitle(java.lang.String)
	 */
	@Override
	public Catelog findByTitle(String title) {
		TypedQuery<Catelog> query = em.createNamedQuery("Catelog.findByTitle", Catelog.class);
		query.setParameter("pTitle", title);
		List<Catelog> list = query.getResultList();
		if(list!=null && list.size() == 1){
			return list.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findAllByYear(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByYear(String year) {
		TypedQuery<Catelog> query = em.createNamedQuery("Catelog.findByYear", Catelog.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findAllByGenre(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByGenre(String genre) {
		TypedQuery<Catelog> query = em.createNamedQuery("Catelog.findByGenre", Catelog.class);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#findOne(java.lang.String)
	 */
	@Override
	public Catelog findOne(String id) {
		return em.find(Catelog.class, id);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#create(io.egen.rest.entity.Catelog)
	 */
	@Override
	public Catelog create(Catelog catelog) {
		em.persist(catelog);
		return catelog;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#update(io.egen.rest.entity.Catelog)
	 */
	@Override
	public Catelog update(Catelog catelog) {
		return em.merge(catelog);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.repository.CatelogRepository#delete(io.egen.rest.entity.Catelog)
	 */
	@Override
	public void delete(Catelog catelog) {
		em.remove(catelog);
	}

}
