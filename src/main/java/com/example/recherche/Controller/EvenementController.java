package com.example.recherche.Controller;

import com.example.recherche.dao.IAdministrateur;
import com.example.recherche.dao.IEvenement;
import com.example.recherche.model.Administrateur;
import com.example.recherche.model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/Evenement")

public class EvenementController {


    @Autowired
    public IEvenement iEvenement;
    @Autowired
    public IAdministrateur iAdministrateur;

    //TODO : Ajouter Evenement avec Administrateur
    @PostMapping("/addevenement/{idutilisateur}")
    public Evenement addevenement(@RequestBody Evenement evenement, @PathVariable String idutilisateur)
    {
        Administrateur administrateur = iAdministrateur.findByIdutilisateur(idutilisateur);
        evenement.setAdministrateur(administrateur);
        return iEvenement.save(evenement);
    }

    //TODO : Afficher les evenements
    @GetMapping("/allevenements")
    public List<Evenement> allevenements (){
        return iEvenement.findAll();
    }

    //TODO : Supprimer un evenement
    @DeleteMapping("/deleteevenement/{idevenemnt}")
    HashMap deleteevenement(@PathVariable String idevenemnt) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iEvenement.deleteById(idevenemnt);
            hashMap.put("State","evenemnt Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","evenemnt Non Supprimé");
            return hashMap;

        }
    }

    //TODO : Modifier un evenement avec administrateur
    @PutMapping("/updateevenemnt/{idevenemnt}/{idutilisateur}")
    public Evenement updateevenemnt (@RequestBody Evenement evenement, @PathVariable String idevenemnt,@PathVariable String idutilisateur  )
    {
        evenement.setIdevenemnt(idevenemnt);
        Administrateur administrateur  = iAdministrateur.findByIdutilisateur(idutilisateur);
        evenement.setAdministrateur(administrateur);
        return iEvenement.save(evenement);
    }

    //TODO : Chercher un evenement selon Id
    @GetMapping("/getevenementbyid/{idevenemnt}")
    public Evenement getevenementbyid(@PathVariable String idevenemnt ){
        return iEvenement.findByIdevenemnt(idevenemnt);

    }


}
