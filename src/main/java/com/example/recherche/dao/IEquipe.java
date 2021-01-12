package com.example.recherche.dao;

import com.example.recherche.model.Equipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipe extends MongoRepository<Equipe,String> {

    @Query("{'nomequipe' :?0}")
    Equipe findByNomequipe(String nomequipe);

    @Query("{'idequipe' :?0}")
    Equipe findByIdequipe(String idequipe);
}
