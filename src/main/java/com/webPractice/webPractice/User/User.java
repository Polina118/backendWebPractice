package com.webPractice.webPractice.User;

import javax.persistence.*;

@Entity(name = "users")
@Table
public class User {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Id
    private Integer id;

    private String name;

    private String surname;

    private String role;

    private String email;

    private String password;

    private boolean is_Admin;

    public User(){}

    public User(String name, String surname, String role, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
        this.is_Admin = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_Admin() {
        return is_Admin;
    }

    public void setIs_Admin(boolean is_Admin) {
        this.is_Admin = is_Admin;
    }
}
