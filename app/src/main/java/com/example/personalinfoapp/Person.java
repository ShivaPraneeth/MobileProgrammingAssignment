package com.example.personalinfoapp;

public class Person {

    private String email;
    private String firstname;
    private String mobilenumber;
    private String lastname;
    private String password;
    private String date;
    private String city;
    private String gender;

    public Person(String email, String firstname, String mobilenumber, String lastname, String password, String city) {
        this.email = email;
        this.firstname = firstname;
        this.mobilenumber = mobilenumber;
        this.lastname = lastname;
        this.password = password;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }



    public Person(String email, String firstname, String lastname, String password, String date, String city, String gender, String mobilenumber) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.date = date;
        this.city = city;
        this.gender = gender;
        this.mobilenumber = mobilenumber;
    }


}
