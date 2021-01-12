package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Article")

public class Article {


    @Id
    public String idarticle;
    public String titrearticle;
    public String descriptionarticle;
    public String sujetarticle;
    private boolean etatarticle;

    //TODO: Association  Article -> Membre

    @DBRef
    private Membre membre;

    public Article() {
    }

    public Article(String idarticle, String titrearticle, String descriptionarticle, String sujetarticle, boolean etatarticle, Membre membre) {
        this.idarticle = idarticle;
        this.titrearticle = titrearticle;
        this.descriptionarticle = descriptionarticle;
        this.sujetarticle = sujetarticle;
        this.etatarticle = etatarticle;
        this.membre = membre;
    }

    public String getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }

    public String getTitrearticle() {
        return titrearticle;
    }

    public void setTitrearticle(String titrearticle) {
        this.titrearticle = titrearticle;
    }

    public String getDescriptionarticle() {
        return descriptionarticle;
    }

    public void setDescriptionarticle(String descriptionarticle) {
        this.descriptionarticle = descriptionarticle;
    }

    public String getSujetarticle() {
        return sujetarticle;
    }

    public void setSujetarticle(String sujetarticle) {
        this.sujetarticle = sujetarticle;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public boolean isEtatarticle() {
        return etatarticle;
    }

    public void setEtatarticle(boolean etatarticle) {
        this.etatarticle = etatarticle;
    }
}
