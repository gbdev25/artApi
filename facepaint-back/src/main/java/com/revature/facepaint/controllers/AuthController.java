package com.revature.facepaint.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.facepaint.dto.UserDTO;
import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.services.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {

    private AuthService as;

    @Autowired
    public AuthController(AuthService as){
        super();
        this.as = as;
    }

    @PostMapping
    public ResponseEntity<UserDTO> getByLogin(@RequestParam(name="username") String username, @RequestParam(name="password") String password){

        try{
            User user = as.getByLogin(username, password);
            System.out.println(user);
            UserDTO userDTO = new UserDTO(user);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        }catch (UserNotFoundException | NullPointerException e){
            e.getStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
