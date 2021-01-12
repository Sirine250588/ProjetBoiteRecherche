package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Equipe")

public class Equipe {

    @Id
    public String idequipe;
    public String nomequipe;
    public String specialiteequipe;

    public Equipe() {
    }

    public Equipe(String idequipe, String nomequipe, String specialiteequipe) {
        this.idequipe = idequipe;
        this.nomequipe = nomequipe;
        this.specialiteequipe = specialiteequipe;
    }

    public String getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(String idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomequipe() {
        return nomequipe;
    }

    public void setNomequipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    public String getSpecialiteequipe() {
        return specialiteequipe;
    }

    public void setSpecialiteequipe(String specialiteequipe) {
        this.specialiteequipe = specialiteequipe;
    }
}
