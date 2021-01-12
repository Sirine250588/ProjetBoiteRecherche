package com.example.recherche.dao;



import com.example.recherche.model.Evenement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IEvenement extends MongoRepository<Evenement,String>{

    @Query("{'idevenemnt' :?0}")
    Evenement findByIdevenemnt(String idevenemnt);
}

