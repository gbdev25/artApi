package com.revature.facepaint.services;

import com.revature.facepaint.exceptions.UserNotFoundException;
import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthService {


    private UserRepository ur;

    @Autowired
    public AuthService(UserRepository ur){
        super();
        this.ur = ur;
    }

    @Transactional
    public User getByLogin(String username, String password) throws UserNotFoundException{
        try{
            User user = ur.findUserByUsernameAndPassword(username, password);
            return user;
        }catch(NullPointerException e){
            e.getStackTrace();
            throw new UserNotFoundException();
        }
    }

}
