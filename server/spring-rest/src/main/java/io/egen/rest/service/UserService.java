/**
 * 
 */
package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.AppUser;

/**
 * @author MAHITH
 *
 */
public interface UserService {

	public List<AppUser> findAll();

	public AppUser findOne(String id);

	public AppUser create(AppUser user);

	public AppUser update(String id, AppUser user);

	public void delete(String id);
}
