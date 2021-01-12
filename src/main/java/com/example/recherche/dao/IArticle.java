package com.example.recherche.dao;

import com.example.recherche.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticle  extends MongoRepository<Article,String> {

    @Query("{'idarticle' :?0}")
    Article findByIdarticle(String idarticle);

    @Query("{'titrearticle' :?0}")
    Article findByTitrearticle(String titrearticle);
}
