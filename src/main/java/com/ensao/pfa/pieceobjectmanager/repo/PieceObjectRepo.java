package com.ensao.pfa.pieceobjectmanager.repo;

import com.ensao.pfa.pieceobjectmanager.model.PieceObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PieceObjectRepo extends JpaRepository<PieceObject, Long>{

    void deletePieceObjectByIdPieceObject(Long id);

    Optional<PieceObject> findPieceObjectByIdPieceObject(Long id);

}