package com.example.recherche.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Utilisateur")
@TypeAlias("Membre")
public class Membre extends Utilisateur {

    public String type;

// TODO: Association Membre -> Forum
//    @DBRef
//    private Forum forum;

    //TODO: Association Membre -> These
    @DBRef
    private These these;

    ////TODO: Association Membre ->Equipe
    @DBRef
    private Equipe equipe;



    public Membre() {
    }

    public Membre(String idutilisateur, String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String photoutilisateur, String gradeutilisateur, List<Role> roles, String type, These these, Equipe equipe) {
        super(idutilisateur, usernameutilisateur, passwordutilisateur, firstnameutilisateur, lastnameutilisateur, nomutilisateur, prenomutilisateur, datenaissanceutilisateur, emailutilisateur, sexeutilisateur, telephoneutilisateur, adresseutilisateur, photoutilisateur, gradeutilisateur, roles);
        this.type = type;
        this.these = these;
        this.equipe = equipe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public These getThese() {
        return these;
    }

    public void setThese(These these) {
        this.these = these;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
