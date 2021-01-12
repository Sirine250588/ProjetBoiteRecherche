package com.example.recherche.dao;


import com.example.recherche.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IRole extends MongoRepository<Role,String> {
    @Query("{'idrole':?0}")
    Role findByIdrole(String idrole);
    @Query("{'rolename':?0}")
    Role findByRolename(String rolename);

}
