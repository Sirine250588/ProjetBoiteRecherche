package com.example.recherche.dao;

import com.example.recherche.model.Stagaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IStagaire extends MongoRepository<Stagaire,String> {

    @Query("{'usernameutilisateur':?0}")
    Stagaire findByUsernameutilisateur(String usernameutilisateur);


    @Query("{'idutilisateur':?0}")
    Stagaire findByIdutilisateur(String idutilisateur);

}
