package com.ensao.pfa.pieceobjectmanager.service;

import com.ensao.pfa.pieceobjectmanager.exception.UserNotFoundException;
import com.ensao.pfa.pieceobjectmanager.model.User;
import com.ensao.pfa.pieceobjectmanager.repo.UserRepo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserByIdUser(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserByIdUser(id);
    }
}
