package com.example.recherche.Controller;

import com.example.recherche.dao.ICommentaire;
import com.example.recherche.dao.IForum;
import com.example.recherche.model.Commentaire;
import com.example.recherche.model.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Commentaire")

public class CommentaireController {

    @Autowired
    public ICommentaire iCommentaire;
    @Autowired
    public IForum iForum;

    //TODO : Ajouter commentaire avec forum
   @PostMapping("/addcommentaire/{idforum}")
    public Commentaire addcommentaire(@RequestBody Commentaire commentaire,@PathVariable String idforum)
    {
        Forum forum = iForum.findByIdforum(idforum);
        commentaire.setForum(forum);
        return iCommentaire.save(commentaire);
    }

    //TODO : Afficher les commentaires
    @GetMapping("/allcommentaire")
    public List<Commentaire> allcommentaire (){
        return iCommentaire.findAll();
    }

    //TODO : Supprimer un commentaire
    @DeleteMapping("/deletecommentaire/{idcommentaire}")
    HashMap deletecommentaire(@PathVariable String idcommentaire) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iCommentaire.deleteById(idcommentaire);
            hashMap.put("State","commentaire Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","commentaire Non Supprimé");
            return hashMap;

        }
    }

    //TODO : Modifier un commentaire avec forum
    @PutMapping("/updatecommentaire/{idcommentaire}/{idforum}")
    public Commentaire updatecommentaire (@RequestBody Commentaire commentaire, @PathVariable String idcommentaire,@PathVariable String idforum )
    {
        commentaire.setIdcommentaire(idcommentaire);
        Forum forum = iForum.findByIdforum(idforum);
        commentaire.setForum(forum);
        return iCommentaire.save(commentaire);
    }

    //TODO : Chercher un commentaire selon Id
    @GetMapping("/getcommentairebyid/{idcommentaire}")
    public Commentaire getcommentairebyid(@PathVariable String idcommentaire ){
        return iCommentaire.findByIdcommentaire(idcommentaire);

    }


}
