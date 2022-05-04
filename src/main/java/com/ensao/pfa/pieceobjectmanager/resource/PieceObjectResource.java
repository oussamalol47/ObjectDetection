package com.ensao.pfa.pieceobjectmanager.resource;

import com.ensao.pfa.pieceobjectmanager.model.Object;
import com.ensao.pfa.pieceobjectmanager.model.PieceObject;
import com.ensao.pfa.pieceobjectmanager.service.PieceObjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/pieceobject")
public class PieceObjectResource {

    private final PieceObjectService pieceObjectService;

    public PieceObjectResource(PieceObjectService pieceObjectService) {
        this.pieceObjectService = pieceObjectService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PieceObject>> getAllPieceObjects () {
        List<PieceObject> pieceObjects = pieceObjectService.findAllPieceObjects();
        return new ResponseEntity<>(pieceObjects, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PieceObject> getPieceObjectById (@PathVariable("id") Long id) {
        PieceObject pieceObject = pieceObjectService.findPieceObjectById(id);
        return new ResponseEntity<>(pieceObject, HttpStatus.OK);
    }

    @GetMapping("/findobjects/{idPiece}")
    public ResponseEntity<List<Object>> getObjectsByIdPiece (@PathVariable("idPiece") Long idPiece) {
        List<Object> objects = pieceObjectService.findObjecstByIdPiece(idPiece);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }


    @PostMapping(value="/add", consumes="application/json")
    public ResponseEntity<PieceObject> addPieceObject(@RequestBody PieceObject pieceObject) {
        PieceObject newPieceObject = pieceObjectService.addPieceObject(pieceObject);
        return new ResponseEntity<>(newPieceObject, HttpStatus.CREATED);
    }

    @PutMapping(value="/update" , consumes="application/json")
    public ResponseEntity<PieceObject> updatePieceObject(@RequestBody PieceObject pieceObject) {
        PieceObject updatePieceObject = pieceObjectService.updatePieceObject(pieceObject);
        return new ResponseEntity<>(updatePieceObject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePieceObject(@PathVariable("id") Long id) {
        pieceObjectService.deletePieceObject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
