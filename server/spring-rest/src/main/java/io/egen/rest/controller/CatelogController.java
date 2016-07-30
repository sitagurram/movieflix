package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.AppUser;
import io.egen.rest.entity.Catelog;

import io.egen.rest.entity.UserComments;
import io.egen.rest.entity.UserRating;
import io.egen.rest.service.CatelogService;

import io.egen.rest.service.UserCommentsService;
import io.egen.rest.service.UserRatingService;

@RestController
@RequestMapping(path = "catelogs")
public class CatelogController {

	@Autowired
	CatelogService catelogService;

	@Autowired
	UserCommentsService userCommentsService;
	
	@Autowired
	UserRatingService userRatingService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public List<Catelog> findAll() {

		return catelogService.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}/user-comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserComments> findAllComments(@PathVariable("id") String catelogId) {
		return userCommentsService.findCommentsForCatelog(catelogId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}/avg-rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double findCatelogRationg(@PathVariable("id") String catelogId) {
		return userRatingService.findRatingsForCatelog(catelogId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{catelogId}/users/{userId}/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating postCatelogRationg(@PathVariable("catelogId") String catelogId,@PathVariable("userId") String userId, @RequestParam Double rating) {
		UserRating userRating = new UserRating();
		if(userRating.getCatelog() == null){
			userRating.setCatelog(new Catelog());
		}
		if(userRating.getUser() == null){
			userRating.setUser(new AppUser());
		}
		userRating.getCatelog().setId(catelogId);
		userRating.getUser().setId(userId);
		userRating.setRating(rating);
		return userRatingService.create(userRating);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{catelogId}/users/{userId}/user-comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComments postUserComments(@PathVariable("catelogId") String catelogId,@PathVariable("userId") String userId, @RequestParam String comments) {
		UserComments userComments = new UserComments();
		if(userComments.getCatelog() == null){
			userComments.setCatelog(new Catelog());
		}
		if(userComments.getUser() == null){
			userComments.setUser(new AppUser());
		}
		userComments.getCatelog().setId(catelogId);
		userComments.getUser().setId(userId);
		userComments.setComments(comments);
		return userCommentsService.create(userComments);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catelog findOne(@PathVariable("id") String catelogId) {
		return catelogService.findOne(catelogId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catelog create(@RequestBody Catelog catelog) {
		return catelogService.create(catelog);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catelog update(@PathVariable("id") String catelogId, @RequestBody Catelog catelog) {
		return catelogService.update(catelogId, catelog);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String catelogId) {
		catelogService.delete(catelogId);
	}
}
