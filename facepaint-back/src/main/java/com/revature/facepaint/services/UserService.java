package com.revature.facepaint.services;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.exceptions.UserNotCreatedException;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;


import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;



@Service  //Need this to for spring to manage
public class UserService {
	
	private UserRepository ur;
	
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	

	
	public User getUserShowcase(String imageID) {
		return ur.getUserByImageID(imageID);
	}
	public void setImageIDForUser(int id,String imageID) {
		User user = ur.getUserById(id);
		user.setImageID(imageID);
		ur.save(user);
	
	}
	public User updateUser(User u) {
		return ur.save(u);
	}
	

		
	public User removeUser(User u ) {
		 ur.delete(u);
		
		return null;
	}

	public List<User> getUsers(){
		return ur.findAll();
	}
	
	public List<User> getByRole(Role role){
		return ur.findUserByRole(role);
	}
	
	@Transactional 
	public User getUserById(int id) throws UserNotFoundException{
		
		User user = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
		
		return user;
	}
	
	@Transactional
	public User addUser(User user){

		user.setRole(Role.BASIC_USER);
		
		return ur.save(user);
	
	
	}
}
