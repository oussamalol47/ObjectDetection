package com.ensao.pfa.pieceobjectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensao.pfa.pieceobjectmanager.model.Piece;

import java.util.Optional;


public interface PieceRepo extends JpaRepository<Piece, Long>{

    void deletePieceByIdPiece(Long id);

    Optional<Piece> findPieceByIdPiece(Long id);

}