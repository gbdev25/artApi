package com.revature.facepaint.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User getUserById(int id);
	User getUserByImageID(String imageID);
	
	List<User> findUserByRole(Role role);
	
	User findUserByUsername(String username);
	

	User findUserByUsernameAndPassword(String username, String password);


}
