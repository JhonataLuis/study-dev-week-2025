package com.study.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.study.domain.model.User;
import com.study.domain.repository.UserRepository;
import com.study.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository uRepository;

    public UserServiceImpl(UserRepository uRepository) {//DESSA FORMA USANDO O CONSTRUTOR SÃO BOAS PRÁTICAS
        this.uRepository = uRepository;
    }
    @Override
    public User findById(Long id) {
        return uRepository.findById(id).orElseThrow(NoSuchElementException::new);//CASO NÃO ENCONTRE LANÇA UMA EXCEÇÃO
    }

    @Override
    public User create(User userToCreate) {
        if(uRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }

        return uRepository.save(userToCreate);
    }

}
