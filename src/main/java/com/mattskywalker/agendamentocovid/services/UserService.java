package com.mattskywalker.agendamentocovid.services;

import com.mattskywalker.agendamentocovid.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public User findByLogin(String login);

    public User findUser(User user);

    public User save(User user);

    public void deleteAll();

    public User delete(User user);
}
