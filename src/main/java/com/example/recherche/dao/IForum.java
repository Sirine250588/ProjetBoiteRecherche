package com.example.recherche.dao;


import com.example.recherche.model.Forum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IForum extends MongoRepository<Forum,String> {

    @Query("{'idforum':?0}")
    Forum findByIdforum (String idforum);
}
