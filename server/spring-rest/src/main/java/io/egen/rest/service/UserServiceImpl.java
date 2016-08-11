/**
 * 
 */
package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.AppUser;
import io.egen.rest.exception.UserAlreadyExistsException;
import io.egen.rest.exception.UserNotFoundException;
import io.egen.rest.repository.UserRepository;

/**
 * @author MAHITH
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserService#findAll()
	 */
	@Override
	public List<AppUser> findAll() {
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserService#findOne(java.lang.String)
	 */
	@Override
	public AppUser findOne(String id) {
		AppUser existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return existing;
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserService#create(io.egen.rest.entity.AppUser)
	 */
	@Override
	@Transactional
	public AppUser create(AppUser user) {
		AppUser existing = userRepository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		user.setType("U");
		return userRepository.create(user);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserService#update(java.lang.String, io.egen.rest.entity.AppUser)
	 */
	@Override
	@Transactional
	public AppUser update(String id, AppUser user) {
		AppUser existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		user.setId(id);
		if("U".equalsIgnoreCase(existing.getType())){
			user.setType("U");
		}
		return userRepository.update(user);
	}

	/* (non-Javadoc)
	 * @see io.egen.rest.service.UserService#delete(java.lang.String)
	 */
	@Override
	public void delete(String id) {
		AppUser existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		userRepository.delete(existing);
	}
}
