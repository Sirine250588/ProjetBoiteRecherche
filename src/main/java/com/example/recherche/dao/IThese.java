package com.example.recherche.dao;

import com.example.recherche.model.These;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IThese extends MongoRepository<These,String>{
    @Query("{'titrethese' :?0}")
    These findByTitrethese(String titrethese);

    @Query("{'idthese' :?0}")
    These findByIdthese(String idthese);

    @Query("{'etatthese' :?0}")
    These findByEtatthese(String etatthese);
}



