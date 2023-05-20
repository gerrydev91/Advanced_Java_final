package com.example.demo.entities;

public class User {

    public String userName;

    public String name;

    public String lastName;

    public String email;

    public int accessLevel;

    @Override
    public String toString() {
        return "User [userName=" + userName + ", name=" + name + ", LastName=" + lastName + ", email=" + email
                + ", accessLevel=" + accessLevel + "]";
    }
}
