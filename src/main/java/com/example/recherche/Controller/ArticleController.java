package com.example.recherche.Controller;

import com.example.recherche.dao.IArticle;
import com.example.recherche.dao.IMembre;
import com.example.recherche.model.Article;
import com.example.recherche.model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Article")

public class ArticleController {

    @Autowired
    public IArticle iArticle;

    @Autowired
    public IMembre iMembre;

    //TODO : Ajouter article
    @PostMapping("/addarticle/{idutilisateur}")
    public Article addarticle(@RequestBody Article article,@PathVariable String idutilisateur ){
        Membre membre = iMembre.findByIdutilisateur(idutilisateur);
        article.setMembre(membre);
        return iArticle.save(article);
    }

    //TODO : Afficher les articles
    @GetMapping("/allarticle")
    public List<Article> allarticle (){
        return iArticle.findAll();
    }

    //TODO : Supprimer un article
    @DeleteMapping("/deletearticle/{idarticle}")
    HashMap deletearticle(@PathVariable String idarticle) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iArticle.deleteById(idarticle);
            hashMap.put("State","Article Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","Article Non Supprimé");
            return hashMap;

        }
    }

    //TODO : Modifier un article
    @PutMapping("/updatearticle/{idarticle}/{idutilisateur}")
    public Article updatearticle (@RequestBody Article article, @PathVariable String idarticle,@PathVariable String idutilisateur ){
        article.setIdarticle(idarticle);
        Membre membre = iMembre.findByIdutilisateur(idutilisateur);
        article.setMembre(membre);

        return iArticle.save(article);
    }



    //TODO : Chercher un article selon Id
    @GetMapping("/getarticlebyid/{idarticle}")
    public Article getarticlebyid(@PathVariable String idarticle ){
        return iArticle.findByIdarticle(idarticle);

    }

    //TODO : Valider un article selon l'Etat
    @GetMapping("/valider/{idarticle}")
    public Article valider(@PathVariable String idarticle ) {
        Article article = iArticle.findByIdarticle(idarticle);
        article.setEtatarticle(true);
        return iArticle.save(article);
    }




}
