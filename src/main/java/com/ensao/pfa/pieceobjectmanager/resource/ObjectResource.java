package com.ensao.pfa.pieceobjectmanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ensao.pfa.pieceobjectmanager.model.Object;
import com.ensao.pfa.pieceobjectmanager.service.ObjectService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/object")
public class ObjectResource {
    private final ObjectService objectService;

    public ObjectResource(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object>> getAllObjects () {
        List<Object> objects = objectService.findAllObjects();
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getObjectById (@PathVariable("id") Long id) {
        Object object = objectService.findObjectById(id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PostMapping(value="/add", consumes="application/json")
    public ResponseEntity<Object> addUser(@RequestBody Object object) {
        Object newObject = objectService.addObject(object);
        return new ResponseEntity<>(newObject, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateObject(@RequestBody Object object) {
        Object updateObject = objectService.updateObject(object);
        return new ResponseEntity<>(updateObject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteObject(@PathVariable("id") Long id) {
        objectService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
