package com.ensao.pfa.pieceobjectmanager.service;

import com.ensao.pfa.pieceobjectmanager.exception.ObjectNotFoundException;
import com.ensao.pfa.pieceobjectmanager.model.Object;
import com.ensao.pfa.pieceobjectmanager.repo.ObjectRepo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ObjectService {
    private final ObjectRepo objectRepo;

    @Autowired
    public ObjectService(ObjectRepo objectRepo) {
        this.objectRepo = objectRepo;
    }

    public Object addObject(Object object) {
        return objectRepo.save(object);
    }

    public List<Object> findAllObjects() {
        return objectRepo.findAll();
    }

    public Object updateObject(Object object) {
        return objectRepo.save(object);
    }

    public Object findObjectById(Long id) {
        return objectRepo.findObjectByIdObject(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object by id " + id + " was not found"));
    }

    public void deleteObject(Long id){
        objectRepo.deleteObjectByIdObject(id);
    }

}
