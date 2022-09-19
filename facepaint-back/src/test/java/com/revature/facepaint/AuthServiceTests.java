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
import com.revature.facepaint.services.AuthService;

@SpringBootTest(classes=FacepaintApplication.class)
public class AuthServiceTests {

	@MockBean
	private UserRepository ur;
	
	// Spring Container injects our Mock UserRepository bean instead of an actual one.
	@Autowired
	private AuthService ast;
	
	@Test
	public void getbyLogin() {
		
		
	}
	
	
}