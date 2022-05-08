package com.ensao.pfa.pieceobjectmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String expediteur;
    private String objet;
    private String message;

    public Mail()
    {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", expediteur='" + expediteur + '\'' +
                ", objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
