package com.ensao.pfa.pieceobjectmanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ensao.pfa.pieceobjectmanager.model.Piece;
import com.ensao.pfa.pieceobjectmanager.service.PieceService;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/piece")
public class PieceResource {
    private final PieceService pieceService;

    public PieceResource(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Piece>> getAllPieces () {
        List<Piece> pieces = pieceService.findAllPieces();
        return new ResponseEntity<>(pieces, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Piece> getPieceById (@PathVariable("id") Long id) {
        Piece piece = pieceService.findPieceById(id);
        return new ResponseEntity<>(piece, HttpStatus.OK);
    }

    @PostMapping(value="/add", consumes="application/json")
    public ResponseEntity<Piece> addPiece(@RequestBody Piece piece) {
        Piece newPiece = pieceService.addPiece(piece);
        return new ResponseEntity<>(newPiece, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Piece> updatePiece(@RequestBody Piece piece) {
        Piece updatePiece = pieceService.updatePiece(piece);
        return new ResponseEntity<>(updatePiece, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePiece(@PathVariable("id") Long id) {
        pieceService.deletePiece(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
