package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.entities.User;


public class UserDBMemory extends UsersDB{

    ArrayList<User> users = new ArrayList<>();

    @Override
    public
    ArrayList<User> getAllUsers() {
        return users;
    }

    @Override
    public User find(User user) {
        for (User currentUser : getAllUsers()) {
            if (currentUser.userName.equalsIgnoreCase(user.userName)) {
                return user;
            }
        }

        return null;

    }

    @Override
    public void create(User user) {
        for (User currentUser : users) {
            if (currentUser.userName.toLowerCase().equals(user.userName.toLowerCase())) {
                return;
            }
        }

        users.add(user);
        increaseInputs();
    }

    @Override
    public void delete(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).userName.equalsIgnoreCase(user.userName)) {
                users.remove(i);
            }
        }

        increaseDeletions();
    }
    
}
