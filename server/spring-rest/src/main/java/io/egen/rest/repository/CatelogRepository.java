/**
 * 
 */
package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Catelog;


public interface CatelogRepository {

public List<Catelog> findAll();
	
	public List<Catelog> findAllByType(String type);
	
	public Catelog findByTitle(String title);
	
	public List<Catelog> findAllByYear(String year);
	
	public List<Catelog> findAllByGenre(String genre);

	public Catelog findOne(String id);

	public Catelog create(Catelog catelog);

	public Catelog update(Catelog catelog);

	public void delete(Catelog catelog);
}
