package com.Gestion_Note.Note.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    protected String firstname;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String role;
    protected String nationality;

    public User (){

    }
    public User( String firstname, String lastName, String email, String phone, String role, String nationality) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.nationality = nationality;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String Nationality) {
        this.nationality = nationality;
    }
}
