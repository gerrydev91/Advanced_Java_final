package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserDBMemory;
import com.example.demo.repositories.UsersDB;


@Service
public class UsersService {
    

    UsersDB usersDB = new UserDBMemory();

    public UsersService (UsersDB usersDB){
        this.usersDB = usersDB;

    }

    protected UsersService(){}

    public ArrayList<User> listUsers(){

        return usersDB.getAllUsers();    
    }

    public User getUser (String username){
        User user = new User();
        user.userName= username;
        return usersDB.find(user);
    }


    public void createUser(User user) {
        if (usersDB.find(user) != null) {
            return;
        }

        usersDB.create(user);
    }

    public void DeleteUser(String username) {
        User user = new User();
        user.userName = username;

        usersDB.delete(user);
    }


}
