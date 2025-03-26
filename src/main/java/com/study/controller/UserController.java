package com.study.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.study.domain.model.User;
import com.study.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService uService;

    public UserController(UserService uService){
        this.uService = uService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = uService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        var userCreated = uService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()//SERVE PARA INFORMAR A LOCALIZAÇÃO DO USUARIO CRIADO
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
            return ResponseEntity.created(location).body(userToCreate);
    }

}
