package com.example.demo;

import com.example.demo.entities.User;

import com.example.demo.repositories.*;
import com.example.demo.services.UsersService;

public class App {
    public static void main(String[] args) throws Exception {
       
        User user = new User();
        user.userName = "bootcamper";
        user.name = "Open";
        user.lastName = "Bootcamp";
        user.email="firstemail@mail.com";
        user.accessLevel=1;


        User user2 = new User();
        user2.userName = "bootcamper2";
        user2.name = "Open2";
        user2.lastName = "Bootcamp2";
        user2.email="secondemail@mail.com";
        user2.accessLevel=1;

        UsersDB usersDB; 

        String type = "memory";
        if(type.equalsIgnoreCase("file")){
            usersDB = new UsersDBFile();
        }else{
            usersDB = new UserDBMemory();
        }

        UsersService users = new UsersService(usersDB);

        users.createUser(user);
        users.createUser(user2);


        User openBootcamp = users.getUser("bootcamper");
        System.out.println("This user's email is: "+ openBootcamp.email);


        users.DeleteUser("openbootcamp");

        for (User a : users.listUsers()){
            System.out.println("Current User: "+ a.userName);
            System.out.println("*******************" + "-".repeat(a.userName.length()));
            System.out.println(a);
            System.out.println();
        }

        System.out.println("Inputs total: " + usersDB.getTotalInputs());
        System.out.println("Inputs total: " + usersDB.getTotalDeletions());
        
    }
    
}
