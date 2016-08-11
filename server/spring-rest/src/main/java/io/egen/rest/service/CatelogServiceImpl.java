/**
 * 
 */
package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Catelog;
import io.egen.rest.exception.CatelogAlreadyExistsException;
import io.egen.rest.exception.CatelogNotFoundException;
import io.egen.rest.repository.CatelogRepository;

/**
 * @author MAHITH
 *
 */
@Service
public class CatelogServiceImpl implements CatelogService {

	@Autowired
	CatelogRepository catelogRepository;
	
	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#findAll()
	 */
	@Override
	public List<Catelog> findAll() {
		return catelogRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#findAllByType(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByType(String type) {
		return catelogRepository.findAllByType(type);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#findAllByYear(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByYear(String year) {
		return catelogRepository.findAllByYear(year);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#findAllByGenre(java.lang.String)
	 */
	@Override
	public List<Catelog> findAllByGenre(String genre) {
		return catelogRepository.findAllByGenre(genre);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#findOne(java.lang.String)
	 */
	@Override
	public Catelog findOne(String id) {
		Catelog existing = catelogRepository.findOne(id);
		if (existing == null) {
			throw new CatelogNotFoundException("Movie/Series with id:" + id + " not found");
		}
		return existing;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#create(io.egen.rest.entity.Catelog)
	 */
	@Override
	@Transactional
	public Catelog create(Catelog catelog) {
		Catelog existing = catelogRepository.findByTitle(catelog.getTitle());
		if (existing != null) {
			throw new CatelogAlreadyExistsException("Movie/Series is already in use: " + catelog.getTitle());
		}
		return catelogRepository.create(catelog);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#update(java.lang.String, io.egen.rest.entity.Catelog)
	 */
	@Override
	@Transactional
	public Catelog update(String id, Catelog catelog) {
		Catelog existing = catelogRepository.findOne(id);
		if (existing == null) {
			throw new CatelogNotFoundException("Movie/Series with id:" + id + " not found");
		}
		catelog.setId(id);
		return catelogRepository.update(catelog);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.CatelogService#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public void delete(String id) {
		Catelog existing = catelogRepository.findOne(id);
		if (existing == null) {
			throw new CatelogNotFoundException("Movie/Series with id:" + id + " not found");
		}
		catelogRepository.delete(existing);
	}

	@Override
	public Catelog findByTitle(String title) {
		Catelog existing = catelogRepository.findByTitle(title);
		if (existing == null) {
			throw new CatelogNotFoundException("Movie/Series with title:" + title + " not found");
		}
		return existing;
	}

}
