package com.mattskywalker.agendamentocovid.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long userId;

    @Column(nullable = false)
    private String name;

    @NotBlank
    @NotEmpty
    @Column( nullable = false,unique = true)
    private String login;

    @Column(nullable = false)
    private String password;


    public User() {
    }

    public User(long userId, String name, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
