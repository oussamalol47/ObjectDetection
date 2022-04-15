package com.ensao.pfa.pieceobjectmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensao.pfa.pieceobjectmanager.model.Object;

import java.util.Optional;

public interface ObjectRepo extends JpaRepository<Object, Long>{
    void deleteObjectByIdObject(Long id);

    Optional<Object> findObjectByIdObject(Long id);
}
