package com.example.recherche.dao;

import com.example.recherche.model.Administrateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministrateur extends MongoRepository<Administrateur,String> {

    @Query("{'usernameutilisateur':?0}")
    Administrateur findByUsernameutilisateur(String usernameutilisateur);

    @Query("{'idutilisateur':?0}")
    Administrateur findByIdutilisateur(String idutilisateur);
}
