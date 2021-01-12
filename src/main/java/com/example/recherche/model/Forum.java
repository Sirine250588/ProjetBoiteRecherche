package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Forum")

public class Forum {

    @Id
    public  String idforum;
    public  String themeforum;

// TODO: Association Forum -> Membre
    @DBRef
    private Membre membre;

    public Forum() {
    }

    public Forum(String idforum, String themeforum, Membre membre) {
        this.idforum = idforum;
        this.themeforum = themeforum;
        this.membre = membre;
    }

    public String getIdforum() {
        return idforum;
    }

    public void setIdforum(String idforum) {
        this.idforum = idforum;
    }

    public String getThemeforum() {
        return themeforum;
    }

    public void setThemeforum(String themeforum) {
        this.themeforum = themeforum;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
