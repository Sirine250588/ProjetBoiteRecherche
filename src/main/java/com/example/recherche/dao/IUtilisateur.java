package com.example.recherche.dao;

import com.example.recherche.model.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilisateur extends MongoRepository<Utilisateur,String> {

    @Query("{'idutilisateur':?0}")
    Utilisateur findByIdutilisateur(String idutilisateur);
    @Query("{'nomutilisateur':?0}")
    Utilisateur findByNomutilisateur(String nomutilisateur);
    @Query("{'usernameutilisateur':?0}")
    Utilisateur findByUsernameutilisateur(String usernameutilisateur);
}
