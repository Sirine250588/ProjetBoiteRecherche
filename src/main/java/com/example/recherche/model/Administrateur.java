package com.example.recherche.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "Utilisateur")
@TypeAlias("Administrateur")

public class Administrateur extends Utilisateur {

    public Administrateur() {
    }

    public Administrateur(String idutilisateur, String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String photoutilisateur, String gradeutilisateur, List<Role> roles) {
        super(idutilisateur, usernameutilisateur, passwordutilisateur, firstnameutilisateur, lastnameutilisateur, nomutilisateur, prenomutilisateur, datenaissanceutilisateur, emailutilisateur, sexeutilisateur, telephoneutilisateur, adresseutilisateur, photoutilisateur, gradeutilisateur, roles);
    }


}
