package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")

public class Role  {
    @Id
    String idrole;
    String rolename;


    public Role(String idrole, String rolename) {
        this.idrole = idrole;
        this.rolename = rolename;
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Role() {
    }


    public String getIdrole() {

        return idrole;
    }

    public void setIdrole(String idrole) {
        this.idrole = idrole;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
