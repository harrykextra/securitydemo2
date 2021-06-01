package com.harryman.securitydemo2.data.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private Usersex usersex;
    private String password;
}
