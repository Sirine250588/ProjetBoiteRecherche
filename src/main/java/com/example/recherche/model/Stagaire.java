package com.example.recherche.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "Utilisateur")
@TypeAlias("Stagaire")

public class Stagaire extends Utilisateur {



    //TODO: Association Stagaire -> These

    @DBRef
    private These these;

    public Stagaire() {
    }

    public Stagaire(String idutilisateur, String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String photoutilisateur, String gradeutilisateur, List<Role> roles, These these) {
        super(idutilisateur, usernameutilisateur, passwordutilisateur, firstnameutilisateur, lastnameutilisateur, nomutilisateur, prenomutilisateur, datenaissanceutilisateur, emailutilisateur, sexeutilisateur, telephoneutilisateur, adresseutilisateur, photoutilisateur, gradeutilisateur, roles);
        this.these = these;
    }

    public These getThese() {
        return these;
    }

    public void setThese(These these) {
        this.these = these;
    }
}
