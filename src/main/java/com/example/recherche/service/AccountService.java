package com.example.recherche.service;

import com.example.recherche.model.*;
import org.springframework.web.multipart.MultipartFile;


public interface AccountService {

    Administrateur saveAdministrateur(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur,String gradeutilisateur, MultipartFile file);
    Membre saveMembre(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur,String gradeutilisateur, String type, These these, Equipe equipe, MultipartFile file);
    Stagaire saveStagaire(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur,  String gradeutilisateur,These these, MultipartFile file);

    Role save(Role role);
    Utilisateur loadUserByUsername(String username);
    void addRoleToUser(String username, String rolename);
}



