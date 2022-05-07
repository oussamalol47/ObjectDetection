package com.ensao.pfa.pieceobjectmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Piece implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idPiece;
    private String pathPiece;
    private String titlePiece;
    private int numberOfObjecInPiece;
    private String referenceOrNot;

    public Piece() {
    }

    public Piece(Long idPiece, String pathPiece, String titlePiece, int numberOfObjecInPiece, String referenceOrNot) {
        this.idPiece = idPiece;
        this.pathPiece = pathPiece;
        this.titlePiece = titlePiece;
        this.numberOfObjecInPiece = numberOfObjecInPiece;
        this.referenceOrNot = referenceOrNot;
    }

    public Long getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(Long idPiece) {
        this.idPiece = idPiece;
    }

    public String getPathPiece() {
        return pathPiece;
    }

    public void setPathPiece(String pathPiece) {
        this.pathPiece = pathPiece;
    }

    public String getTitlePiece() {
        return titlePiece;
    }

    public void setTitlePiece(String titlePiece) {
        this.titlePiece = titlePiece;
    }

    public int getNumberOfObjecInPiece() {
        return numberOfObjecInPiece;
    }

    public void setNumberOfObjecInPiece(int numberOfObjecInPiece) {
        this.numberOfObjecInPiece = numberOfObjecInPiece;
    }

    public String getReferenceOrNot() {
        return referenceOrNot;
    }

    public void setReferenceOrNot(String referenceOrNot) {
        this.referenceOrNot = referenceOrNot;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "idPiece=" + idPiece +
                ", pathPiece='" + pathPiece + '\'' +
                ", titlePiece='" + titlePiece + '\'' +
                ", numberOfObjecInPiece=" + numberOfObjecInPiece +
                ", referenceOrNot='" + referenceOrNot + '\'' +
                '}';
    }
}
