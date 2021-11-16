package com.mattskywalker.agendamentocovid.services.servicesImpl;

import com.mattskywalker.agendamentocovid.model.User;
import com.mattskywalker.agendamentocovid.repository.Repository;
import com.mattskywalker.agendamentocovid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Repository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public User findByLogin(String login) {

        return repository.findAll().stream()
                .filter((user) -> user.getLogin().toLowerCase().equals(login))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public User findUser(User user) {
        return this.findByLogin(user.getLogin());
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }

    @Override
    public User delete(User user) {
        try{
            repository.delete(user);
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
