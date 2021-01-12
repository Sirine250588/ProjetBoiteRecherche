package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "These")

public class These {


    //TODO: Association These -> Equipe

    @DBRef
    private Equipe equipe;

    @Id
    public  String idthese;
    public  String titrethese;
    public  String sujetthese;
    public  String etatthese;

    public These() {
    }

    public These(Equipe equipe, String idthese, String titrethese, String sujetthese, String etatthese) {
        this.equipe = equipe;
        this.idthese = idthese;
        this.titrethese = titrethese;
        this.sujetthese = sujetthese;
        this.etatthese = etatthese;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getIdthese() {
        return idthese;
    }

    public void setIdthese(String idthese) {
        this.idthese = idthese;
    }

    public String getTitrethese() {
        return titrethese;
    }

    public void setTitrethese(String titrethese) {
        this.titrethese = titrethese;
    }

    public String getSujetthese() {
        return sujetthese;
    }

    public void setSujetthese(String sujetthese) {
        this.sujetthese = sujetthese;
    }

    public String getEtatthese() {
        return etatthese;
    }

    public void setEtatthese(String etatthese) {
        this.etatthese = etatthese;
    }
}
