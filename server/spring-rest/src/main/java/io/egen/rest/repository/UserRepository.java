/**
 * 
 */
package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.AppUser;


public interface UserRepository {

	public List<AppUser> findAll();

	public AppUser findOne(String id);

	public AppUser findByEmail(String email);

	public AppUser create(AppUser user);

	public AppUser update(AppUser user);

	public void delete(AppUser user);
}
