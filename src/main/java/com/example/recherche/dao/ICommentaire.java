package com.example.recherche.dao;


import com.example.recherche.model.Commentaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaire extends MongoRepository<Commentaire,String> {

    @Query("{'idcommentaire' :?0}")
    Commentaire findByIdcommentaire(String idcommentaire);



}
