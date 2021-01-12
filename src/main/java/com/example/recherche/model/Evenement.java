package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "Evenement")

public class Evenement {

    @Id
    public String idevenemnt;
    public String nomevenemnt;
    public String   dateevenemnt;
    public String lieuevenemt;

    //TODO: Association Administrateur -> Evenemnt

    @DBRef
    private Administrateur administrateur;

    public Evenement() {
    }

    public Evenement(String idevenemnt, String nomevenemnt, String dateevenemnt, String lieuevenemt, Administrateur administrateur) {
        this.idevenemnt = idevenemnt;
        this.nomevenemnt = nomevenemnt;
        this.dateevenemnt = dateevenemnt;
        this.lieuevenemt = lieuevenemt;
        this.administrateur = administrateur;
    }

    public String getIdevenemnt() {
        return idevenemnt;
    }

    public void setIdevenemnt(String idevenemnt) {
        this.idevenemnt = idevenemnt;
    }

    public String getNomevenemnt() {
        return nomevenemnt;
    }

    public void setNomevenemnt(String nomevenemnt) {
        this.nomevenemnt = nomevenemnt;
    }

    public String getDateevenemnt() {
        return dateevenemnt;
    }

    public void setDateevenemnt(String dateevenemnt) {
        this.dateevenemnt = dateevenemnt;
    }

    public String getLieuevenemt() {
        return lieuevenemt;
    }

    public void setLieuevenemt(String lieuevenemt) {
        this.lieuevenemt = lieuevenemt;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}
