package com.revature.facepaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.UserService;

@SpringBootApplication
public class FacepaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacepaintApplication.class, args);
	}

	
}

