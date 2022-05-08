package com.ensao.pfa.pieceobjectmanager.service;

import com.ensao.pfa.pieceobjectmanager.exception.PieceObjectNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.ensao.pfa.pieceobjectmanager.model.Object;
import com.ensao.pfa.pieceobjectmanager.model.Piece;
import com.ensao.pfa.pieceobjectmanager.model.PieceObject;
import com.ensao.pfa.pieceobjectmanager.repo.PieceObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PieceObjectService {
    private final PieceObjectRepo pieceObjectRepo;
    private final ObjectService objectService;
    private final PieceService pieceService;

    @Autowired
    public PieceObjectService(PieceObjectRepo pieceObjectRepo, ObjectService objectService, PieceService pieceService) {
        this.pieceObjectRepo = pieceObjectRepo;
        this.objectService = objectService;
        this.pieceService = pieceService;
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

    public List<Object> findObjecstByIdPiece(Long idPiece) {

        List<Long> idObjects = new ArrayList<>();

        for (PieceObject pieceObject : findAllPieceObjects())
        {
            if(pieceObject.getIdPiece().equals(idPiece))
            {
                idObjects.add(pieceObject.getIdObject());
            }
        }

        List<Object> objects = new ArrayList<>();

        for (Object object: objectService.findAllObjects())
        {
            for(Long idObject:idObjects)
            {
                if(idObject.equals(object.getIdObject()))
                {
                    objects.add(object);
                }
            }
        }

        return objects;
    }

    public Map<String,Double> comparePiece(Long idPiece)
    {
        Map<String,Double> map = new HashMap<String,Double>();

        List<Piece> piecesReference = new ArrayList<>();
        List<Object> listObjects = findObjecstByIdPiece(idPiece);

        for(int i = 0;i<pieceService.findAllPieces().size();i++)
        {
            if(pieceService.findAllPieces().get(i).getReferenceOrNot().equals("true") &&
                    pieceService.findAllPieces().get(i).getNumberOfObjecInPiece()==pieceService.findPieceById(idPiece).getNumberOfObjecInPiece()){
                piecesReference.add(pieceService.findAllPieces().get(i));
            }
        }

        for(Piece piece:piecesReference) {
            Double som = 0.0;
            for (Object objectRef : findObjecstByIdPiece(piece.getIdPiece())) {
                for (Object objectToCompare : listObjects) {
                    if (objectToCompare.getSurfaceObject().equals(objectRef.getSurfaceObject()) &&
                        objectToCompare.getOrderObject().equals(objectRef.getOrderObject()) &&
                        objectToCompare.getUpOrDown().equals(objectRef.getUpOrDown()) ) {
                        som = som + 1;
                    }
                    map.put(piece.getTitlePiece(), (som*100)/listObjects.size());
                }
            }
        }


        return map;
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
