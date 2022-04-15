package com.ensao.pfa.pieceobjectmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensao.pfa.pieceobjectmanager.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{
    void deleteUserByIdUser(Long id);

    Optional<User> findUserByIdUser(Long id);
}
