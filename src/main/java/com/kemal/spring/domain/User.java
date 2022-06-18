package com.kemal.spring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Keno&Kemo on 30.09.2017..
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String bank;


    private String user_status;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(length = 60)
    private String password;

    private boolean enabled;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String name,String user_status, String bank, String username, String email, String password, boolean enabled) {
        this.name = name;
        this.bank = bank;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
//        this.user_status = user_status;
    }


    public User(String name, String user_status, String bank, String username, String email,
                String password, boolean enabled, List<Role> roles) {
        this.name = name;
        this.bank = bank;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
//        this.user_status = user_status;
    }

    public String getName() {
        return name;
    }

//    public String getUser_status() {
//        return user_status;
//    }
//
//    public void setUser_status(String user_status) {
//        this.user_status = user_status;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
