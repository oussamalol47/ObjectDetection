package com.ensao.pfa.pieceobjectmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Object implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idObject;
    private Double prediction;
    private Boolean isUp;
    private Double surfaceObject;
    private Integer orderObject;

    public Object()
    {

    }

    public Object(Long idObject, Double prediction, Boolean isUp, Double surfaceObject, Integer orderObject) {
        this.idObject = idObject;
        this.prediction = prediction;
        this.isUp = isUp;
        this.surfaceObject = surfaceObject;
        this.orderObject = orderObject;
    }

    public Long getIdObject() {
        return idObject;
    }

    public void setIdObject(Long idObject) {
        this.idObject = idObject;
    }

    public Double getPrediction() {
        return prediction;
    }

    public void setPrediction(Double prediction) {
        this.prediction = prediction;
    }

    public Boolean getUp() {
        return isUp;
    }

    public void setUp(Boolean up) {
        isUp = up;
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
                ", prediction=" + prediction +
                ", isUp=" + isUp +
                ", surfaceObject=" + surfaceObject +
                ", orderObject=" + orderObject +
                '}';
    }
}
