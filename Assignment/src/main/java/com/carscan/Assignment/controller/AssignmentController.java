package com.carscan.Assignment.controller;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carscan.Assignment.entityrepo.entityrepo;



import com.carscan.Assignment.entity.Assignment;

@RestController
@RequestMapping("")
public class AssignmentController {
//	@Autowired
//	entityrepo repo;
//	
//	@GetMapping("/")
//    public String index() {
//        return "index.html";
//    }
////	@GetMapping("/")
////    public String index() {
////        return "index.html";
////    }
	
	public static final Logger logger =
			LoggerFactory.getLogger(AssignmentController.class);
			
	       private entityrepo repo;
			
			@Autowired
			public void setRepo(entityrepo repo) {
				this.repo = repo;
			}
			
			@GetMapping("/api/user/")
			public ResponseEntity<List<Assignment>> listAllUsers() {
			List<Assignment> users = repo.findAll();
			return new ResponseEntity<List<Assignment>>(users, HttpStatus.OK);
			}

//			public entityrepo getRepo() {
//				return repo;
//			}

			@PostMapping(value = "/api/user/upload", consumes = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public ResponseEntity<Assignment> createUser(@RequestBody final Assignment user) {
				System.out.println(user.getCity());
				System.out.println(user.getFname());
				System.out.println(user.getLname());
				System.out.println(user.getMobileno());
				System.out.println(user.getDob());
				repo.save(user);
			return new ResponseEntity<Assignment>(user, HttpStatus.CREATED);
			}
			
			@GetMapping("/api/user/{id}")
			public ResponseEntity<Assignment> getUserById(@PathVariable("id") final Long id) {
			Optional	<Assignment> user = repo.findById(id);
			Assignment u=user.get();
			return new ResponseEntity<Assignment>(u, HttpStatus.OK);
			}
			
			@PostMapping(value = "/api/user/update", consumes = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public ResponseEntity<Assignment> updateUser( @RequestBody Assignment user) {
			// fetch user based on id and set it to currentUser object of type UserDTO
				Long thisId=user.getId();
				Optional	<Assignment>User = repo.findById(thisId);
				Assignment currentUser =User.get(); 
			// update currentUser object data with user object data
			currentUser.setFname(user.getFname());
			currentUser.setLname(user.getLname());
			currentUser.setDob(user.getDob());
			currentUser.setCity(user.getCity());
			currentUser.setMobileno(user.getMobileno());
//			currentUser.setEmail(user.getEmail());
			// save currentUser obejct
			repo.saveAndFlush(currentUser);
			//return ResponseEntity object
			return new ResponseEntity<Assignment>(currentUser, HttpStatus.OK);
			}
			@DeleteMapping("/api/user/{id}")
			public ResponseEntity<Assignment> deleteUser(@PathVariable("id") final Long id) {
				repo.deleteById(id);
			return new ResponseEntity<Assignment>(HttpStatus.NO_CONTENT);
			}
			

			
}

