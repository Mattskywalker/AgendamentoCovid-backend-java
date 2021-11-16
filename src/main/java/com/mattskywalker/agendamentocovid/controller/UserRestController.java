package com.mattskywalker.agendamentocovid.controller;


import com.mattskywalker.agendamentocovid.model.User;
import com.mattskywalker.agendamentocovid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        try{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("")
    public ResponseEntity<Object> findByLogin(@RequestBody User user){
        try{
            return new ResponseEntity<Object>(userService.findByLogin(user.getLogin()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Error("Não encontrado!"),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody User user){
        try{

            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(new Error("Não foi possivel cadastrar"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
