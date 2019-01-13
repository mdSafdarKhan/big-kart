package com.example.oauthsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private boolean active;

    public UserAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
