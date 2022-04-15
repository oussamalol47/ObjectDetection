package com.ensao.pfa.pieceobjectmanager.service;

import com.ensao.pfa.pieceobjectmanager.exception.PieceNotFoundException;
import com.ensao.pfa.pieceobjectmanager.model.Piece;
import com.ensao.pfa.pieceobjectmanager.repo.PieceRepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PieceService {

    private final PieceRepo pieceRepo;

    @Autowired
    public PieceService(PieceRepo pieceRepo) {
        this.pieceRepo = pieceRepo;
    }

    public Piece addPiece(Piece piece) {
        return pieceRepo.save(piece);
    }

    public List<Piece> findAllPieces() {
        return pieceRepo.findAll();
    }

    public Piece updatePiece(Piece piece) {
        return pieceRepo.save(piece);
    }

    public Piece findPieceById(Long id) {
        return pieceRepo.findPieceByIdPiece(id)
                .orElseThrow(() -> new PieceNotFoundException("Piece by id " + id + " was not found"));
    }

    public void deletePiece(Long id){
        pieceRepo.deletePieceByIdPiece(id);
    }

    //il faut ajouter une fonction qui va retourner un tableau d'objet en se basant sur le idVideo
    //on va appeler la fonction suivant : Object[] getObjectByIdVideoObject(int idObject)
}

