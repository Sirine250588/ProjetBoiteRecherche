package com.example.recherche.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Commentaire")

public class Commentaire {

    @Id
    public String idcommentaire;
    public String messagecommentaire;

    //TODO: Association Commentaire -> Forum

    @DBRef
    private Forum forum;

    public Commentaire() {
    }

    public Commentaire(String idcommentaire, String messagecommentaire, Forum forum) {
        this.idcommentaire = idcommentaire;
        this.messagecommentaire = messagecommentaire;
        this.forum = forum;
    }

    public String getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(String idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public String getMessagecommentaire() {
        return messagecommentaire;
    }

    public void setMessagecommentaire(String messagecommentaire) {
        this.messagecommentaire = messagecommentaire;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
