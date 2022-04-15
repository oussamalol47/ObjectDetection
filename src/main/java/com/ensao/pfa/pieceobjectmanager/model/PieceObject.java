package com.ensao.pfa.pieceobjectmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PieceObject implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idPieceObject;
    private Long idObject;
    private Long idPiece;


    public PieceObject() {

    }

    public PieceObject(Long idObject, Long idPiece,Long idPieceObject) {
        this.idPieceObject = idPieceObject;
        this.idObject = idObject;
        this.idPiece = idPiece;
    }

    public Long getIdPieceObject() {
        return idPieceObject;
    }

    public void setIdPieceObject(Long idPieceObject) {
        this.idPieceObject = idPieceObject;
    }

    public Long getIdObject() {
        return idObject;
    }

    public void setIdObject(Long idObject) {
        this.idObject = idObject;
    }

    public Long getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(Long idPiece) {
        this.idPiece = idPiece;
    }

    @Override
    public String toString() {
        return "PieceObject{" +
                "idPieceObject=" + idPieceObject +
                ", idObject=" + idObject +
                ", idPiece=" + idPiece +
                '}';
    }
}
