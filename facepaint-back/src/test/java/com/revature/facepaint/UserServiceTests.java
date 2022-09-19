package com.revature.facepaint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.facepaint.FacepaintApplication;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;
import com.revature.facepaint.services.UserService;

@SpringBootTest(classes=FacepaintApplication.class)
public class UserServiceTests {

	@MockBean
	private UserRepository ur;
	

	@Autowired
	private UserService ust;
	
	@Test
	public void getUsers(){
		User u = new User();
		u.setId(1);
		u.setUsername("admin");
		u.setPassword("pass");
		u.setRole(Role.ADMIN);
		
		List<User> users = new ArrayList<>();
		users.add(u);
		
		Mockito.when(ur.findAll()).thenReturn(users);
		
		
		List<User> usersActual = ust.getUsers();
		
		assertEquals(users, usersActual);
	}
	
	@Test
	public void getUsersByRole() {
		User u = new User();
		u.setId(1);
		u.setUsername("admin");
		u.setPassword("pass");
		u.setRole(Role.ADMIN);
		
		List<User> users = new ArrayList<>();
		users.add(u);
		
		Mockito.when(ur.findUserByRole(Role.ADMIN)).thenReturn(users);
		
		
		List<User> usersActual = ust.getByRole(Role.ADMIN);
		
		assertEquals(users, usersActual);
	}
	
	@Test
	public void getUserByIdExists() throws UserNotFoundException {
		User u1 = new User();
		u1.setId(1);
		u1.setUsername("admin");
		u1.setPassword("pass");
		u1.setRole(Role.ADMIN);
		
		User u2 = new User();
		u2.setId(1);
		u2.setUsername("admin");
		u2.setPassword("pass");
		u2.setRole(Role.ADMIN);
		
		
		Mockito.when(ur.findById(1)).thenReturn(Optional.of(u1));
		
		User uservActual = ust.getUserById(1);
		
		assertEquals(u2, uservActual);
	}
	
	@Test
	public void getUserByIdDoesNotExist() throws UserNotFoundException {
		
		Mockito.when(ur.findById(3)).thenReturn(Optional.empty());
		
		assertThrows(UserNotFoundException.class, () -> ust.getUserById(10));
	}
	
	@Test
	public void addUser() {
		
	}
	
	@Test
	public void removeUser() {
		
	}
	
}