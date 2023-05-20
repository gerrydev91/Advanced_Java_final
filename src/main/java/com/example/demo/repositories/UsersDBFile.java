package com.example.demo.repositories;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.demo.entities.User;

public class UsersDBFile extends UsersDB {

    public String dataFile = "users.text";

    @Override
    public ArrayList<User> getAllUsers() {

        ArrayList<User> users = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(dataFile));

            while (scanner.hasNext()) {
                String currentUser = scanner.next();
                String[] parts = currentUser.split(",");

                User user = new User();
                user.userName = parts[0];
                user.name = parts[1];
                user.lastName = parts[2];
                user.email = parts[3];
                user.accessLevel = Integer.parseInt(parts[4]);

                users.add(user);
            }

            scanner.close();
        } catch (Exception e) {
        }

        return users;

    }

    @Override
    public User find(User user) {

        ArrayList<User> users = getAllUsers();

        for (User currentUser : users) {
            if (currentUser.userName.equalsIgnoreCase(user.userName)) {
                return currentUser;
            }
        }

        return null;

    }

    @Override
    public void create(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(dataFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separateUserByCommas(user));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
        }

        increaseInputs();
    }

    @Override
    public void delete(User user) {
        ArrayList<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).userName.equalsIgnoreCase(user.userName)) {
                users.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(dataFile);

            for (User currentUser : users) {
                String usuarioComas = separateUserByCommas(currentUser);
                printStream.println(usuarioComas);
            }

            printStream.close();
        } catch (Exception e) {
        }

        increaseDeletions();
    }

    private String separateUserByCommas(User user) {
        return user.userName + ","
                + user.name + ","
                + user.lastName + ","
                + user.email + ","
                + user.accessLevel;
    }

}
