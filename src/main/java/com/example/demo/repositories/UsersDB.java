package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.entities.User;

public abstract class UsersDB {

    private int totalInputs = 0;

    private int totalDeletions=0;

    public int getTotalInputs() {
        return totalInputs;
    }

    public int getTotalDeletions() {
        return totalDeletions;
    }

    protected void increaseInputs(){
        totalInputs++;
    }

    protected void increaseDeletions(){
        totalDeletions++;
    }

    
    public abstract ArrayList<User> getAllUsers();
    public abstract User find(User user);
    public abstract void create(User user);
    public abstract void delete(User user);

    
}
