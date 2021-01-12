package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Utilisateur")

public class Utilisateur {

    @Id
    public  String idutilisateur;
    public  String usernameutilisateur;
    public  String passwordutilisateur;
    public  String firstnameutilisateur;
    public  String lastnameutilisateur;
    public  String nomutilisateur;
    public  String prenomutilisateur;
    public  String datenaissanceutilisateur;
    public  String emailutilisateur;
    public  String sexeutilisateur;
    public  String telephoneutilisateur;
    public  String adresseutilisateur;
    public  String photoutilisateur;
    public  String gradeutilisateur;

    @DBRef
    public List<Role> roles = new ArrayList<>();


    public Utilisateur() {
    }

    public Utilisateur(String idutilisateur, String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String photoutilisateur, String gradeutilisateur, List<Role> roles) {
        this.idutilisateur = idutilisateur;
        this.usernameutilisateur = usernameutilisateur;
        this.passwordutilisateur = passwordutilisateur;
        this.firstnameutilisateur = firstnameutilisateur;
        this.lastnameutilisateur = lastnameutilisateur;
        this.nomutilisateur = nomutilisateur;
        this.prenomutilisateur = prenomutilisateur;
        this.datenaissanceutilisateur = datenaissanceutilisateur;
        this.emailutilisateur = emailutilisateur;
        this.sexeutilisateur = sexeutilisateur;
        this.telephoneutilisateur = telephoneutilisateur;
        this.adresseutilisateur = adresseutilisateur;
        this.photoutilisateur = photoutilisateur;
        this.gradeutilisateur = gradeutilisateur;
        this.roles = roles;
    }

    public String getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getUsernameutilisateur() {
        return usernameutilisateur;
    }

    public void setUsernameutilisateur(String usernameutilisateur) {
        this.usernameutilisateur = usernameutilisateur;
    }

    public String getPasswordutilisateur() {
        return passwordutilisateur;
    }

    public void setPasswordutilisateur(String passwordutilisateur) {
        this.passwordutilisateur = passwordutilisateur;
    }

    public String getFirstnameutilisateur() {
        return firstnameutilisateur;
    }

    public void setFirstnameutilisateur(String firstnameutilisateur) {
        this.firstnameutilisateur = firstnameutilisateur;
    }

    public String getLastnameutilisateur() {
        return lastnameutilisateur;
    }

    public void setLastnameutilisateur(String lastnameutilisateur) {
        this.lastnameutilisateur = lastnameutilisateur;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getPrenomutilisateur() {
        return prenomutilisateur;
    }

    public void setPrenomutilisateur(String prenomutilisateur) {
        this.prenomutilisateur = prenomutilisateur;
    }

    public String getDatenaissanceutilisateur() {
        return datenaissanceutilisateur;
    }

    public void setDatenaissanceutilisateur(String datenaissanceutilisateur) {
        this.datenaissanceutilisateur = datenaissanceutilisateur;
    }

    public String getEmailutilisateur() {
        return emailutilisateur;
    }

    public void setEmailutilisateur(String emailutilisateur) {
        this.emailutilisateur = emailutilisateur;
    }

    public String getSexeutilisateur() {
        return sexeutilisateur;
    }

    public void setSexeutilisateur(String sexeutilisateur) {
        this.sexeutilisateur = sexeutilisateur;
    }

    public String getTelephoneutilisateur() {
        return telephoneutilisateur;
    }

    public void setTelephoneutilisateur(String telephoneutilisateur) {
        this.telephoneutilisateur = telephoneutilisateur;
    }

    public String getAdresseutilisateur() {
        return adresseutilisateur;
    }

    public void setAdresseutilisateur(String adresseutilisateur) {
        this.adresseutilisateur = adresseutilisateur;
    }

    public String getPhotoutilisateur() {
        return photoutilisateur;
    }

    public void setPhotoutilisateur(String photoutilisateur) {
        this.photoutilisateur = photoutilisateur;
    }

    public String getGradeutilisateur() {
        return gradeutilisateur;
    }

    public void setGradeutilisateur(String gradeutilisateur) {
        this.gradeutilisateur = gradeutilisateur;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

