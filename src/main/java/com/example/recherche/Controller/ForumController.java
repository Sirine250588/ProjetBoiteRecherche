package com.example.recherche.Controller;

import com.example.recherche.dao.IForum;
import com.example.recherche.dao.IMembre;
import com.example.recherche.model.Forum;
import com.example.recherche.model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Forum")

public class ForumController {

    @Autowired
    public IForum iForum;
    @Autowired
    public IMembre iMembre;

    //TODO : Ajouter forum avec membre.
    @PostMapping("/addforum/{idutilisateur}")
    public Forum addforum(@RequestBody Forum forum,@PathVariable String idutilisateur){
        Membre membre = iMembre.findByIdutilisateur(idutilisateur);
        forum.setMembre(membre);
        return iForum.save(forum);
    }


    //TODO : Afficher les forums
    @GetMapping("/allforum")
    public List<Forum> allforum (){
        return iForum.findAll();
    }


    //TODO : Supprimer un forum
    @DeleteMapping("/deleteforum/{idforum}")
    HashMap deleteforum(@PathVariable String idforum) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iForum.deleteById(idforum);
            hashMap.put("State","Forum Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","Forum Non Supprimé");
            return hashMap;

        }
    }


    //TODO : Modifier un forum avec membre
    @PutMapping("/updateforum/{idforum}/{idutilisateur}")
    public Forum updateforum (@RequestBody Forum forum , @PathVariable String idforum , @PathVariable String idutilisateur){
        forum.setIdforum(idforum);
        Membre membre = iMembre.findByIdutilisateur(idutilisateur);
        forum.setMembre(membre);
        return iForum.save(forum);
    }

    //TODO : Chercher un forum selon Id
    @GetMapping("/getforumbyid/{idforum}")
    public Forum getforumbyid(@PathVariable String idforum ){
        return iForum.findByIdforum(idforum);

    }

}
