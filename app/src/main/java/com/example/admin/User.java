package com.example.admin;

public class User {
    String Name;
    String ID;
    String Email;
    String Major;


    public void User(){

    }

    public User(String Name, String ID, String Email, String Major) {
        this.Name = Name;
        this.ID = ID;
        this.Email = Email;
        this.Major=Major;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) { Major = major;
    }
}
