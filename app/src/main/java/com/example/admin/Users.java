package com.example.admin;

public class Users {

    String name, passowrd, email, ID,major ;

    public Users() {}

    public Users(String name, String passowrd, String email, String ID, String major ) {
        this.name = name;
        this.passowrd = passowrd;
        this.email = email;
        this.ID = ID;
        this.major=major;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }







}
