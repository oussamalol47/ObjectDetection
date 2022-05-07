package com.ensao.pfa.pieceobjectmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Object implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idObject;
    private String objectName;
    private Double prediction;
    private String upOrDown;
    private Double surfaceObject;
    private Integer orderObject;

    public Object()
    {

    }

    public Object(Long idObject, String objectName, Double prediction, String upOrDown, Double surfaceObject, Integer orderObject) {
        this.idObject = idObject;
        this.objectName = objectName;
        this.prediction = prediction;
        this.upOrDown = upOrDown;
        this.surfaceObject = surfaceObject;
        this.orderObject = orderObject;
    }

    public Long getIdObject() {
        return idObject;
    }

    public void setIdObject(Long idObject) {
        this.idObject = idObject;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Double getPrediction() {
        return prediction;
    }

    public void setPrediction(Double prediction) {
        this.prediction = prediction;
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(String upOrDown) {
        this.upOrDown = upOrDown;
    }

    public Double getSurfaceObject() {
        return surfaceObject;
    }

    public void setSurfaceObject(Double surfaceObject) {
        this.surfaceObject = surfaceObject;
    }

    public Integer getOrderObject() {
        return orderObject;
    }

    public void setOrderObject(Integer orderObject) {
        this.orderObject = orderObject;
    }

    @Override
    public String toString() {
        return "Object{" +
                "idObject=" + idObject +
                ", objectName='" + objectName + '\'' +
                ", prediction=" + prediction +
                ", upOrDown='" + upOrDown + '\'' +
                ", surfaceObject=" + surfaceObject +
                ", orderObject=" + orderObject +
                '}';
    }
}
