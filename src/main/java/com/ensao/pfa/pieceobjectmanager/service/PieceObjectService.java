package com.ensao.pfa.pieceobjectmanager.service;

import com.ensao.pfa.pieceobjectmanager.exception.PieceObjectNotFoundException;

import java.util.List;


import com.ensao.pfa.pieceobjectmanager.model.PieceObject;
import com.ensao.pfa.pieceobjectmanager.repo.PieceObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PieceObjectService {
    private final PieceObjectRepo pieceObjectRepo;

    @Autowired
    public PieceObjectService(PieceObjectRepo pieceObjectRepo) {
        this.pieceObjectRepo = pieceObjectRepo;
    }

    public PieceObject addPieceObject(PieceObject pieceObject) {
        return pieceObjectRepo.save(pieceObject);
    }

    public List<PieceObject> findAllPieceObjects() {
        return pieceObjectRepo.findAll();
    }

    public PieceObject updatePieceObject(PieceObject pieceObject) {
        return pieceObjectRepo.save(pieceObject);
    }

    public PieceObject findPieceObjectById(Long id) {
        return pieceObjectRepo.findPieceObjectByIdPieceObject(id)
                .orElseThrow(() -> new PieceObjectNotFoundException("PieceObject by id " + id + " was not found"));
    }

    public void deletePieceObject(Long id){
        pieceObjectRepo.deletePieceObjectByIdPieceObject(id);
    }

    public int[] getIdPieceByIdObject(Long idObject){



        return null;
    }

    //Il faut ajouter une fonction qui va prendre
    //en parametre : (String className,int positionX,int positionY)
    //et il retourne un tableau de video qui contient l'objet detecter
    //Ps : il faut passer par les tableaux suivants dans l'ordre :
    //T Object ==> IdObject ==> T VideoObject ==> Tableau de idVideo ==> T Video ==> Tableau de video
    //on va nommer la fonction : Video[] getVideoByBzaf(String className,int positionX,int positionY)
}
