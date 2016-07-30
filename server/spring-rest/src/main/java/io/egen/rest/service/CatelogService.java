/**
 * 
 */
package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Catelog;

/**
 * @author MAHITH
 *
 */
public interface CatelogService {

	public List<Catelog> findAll();
	
	public List<Catelog> findAllByType(String type);
	
	public Catelog findByTitle(String title);
	
	public List<Catelog> findAllByYear(String year);
	
	public List<Catelog> findAllByGenre(String genre);

	public Catelog findOne(String id);

	public Catelog create(Catelog catelog);

	public Catelog update(String id, Catelog catelog);

	public void delete(String id);
}
