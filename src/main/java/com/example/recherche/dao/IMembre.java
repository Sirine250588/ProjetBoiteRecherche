package com.example.recherche.dao;

import com.example.recherche.model.Membre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IMembre extends MongoRepository<Membre,String> {

    @Query("{'usernameutilisateur':?0}")
    Membre findByUsernameutilisateur(String usernameutilisateur);

    @Query("{'type' :?0}")
    Membre findByType(String type);

    @Query("{'idutilisateur' :?0}")
    Membre findByIdutilisateur(String idutilisateur);



}
