package com.example.recherche.Controller;

import com.example.recherche.dao.IEquipe;
import com.example.recherche.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Equipe")

public class EquipeController {


    @Autowired
    public IEquipe iEquipe;

    //TODO : Ajouter Equipe
    @PostMapping("/addequipe")
    public Equipe addequipe(@RequestBody Equipe equipe){
        return iEquipe.save(equipe);
    }

    //TODO : Afficher les Equipes
    @GetMapping("/allequipe")
    public List<Equipe> allequipe (){
        return iEquipe.findAll();
    }

    //TODO : Supprimer un Equipe
    @DeleteMapping("/deletequipe/{idequipe}")
    HashMap deletequipe(@PathVariable String idequipe) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iEquipe.deleteById(idequipe);
            hashMap.put("State","equipe Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","equipe Non Supprimé");
            return hashMap;

        }
    }

    //TODO : Modifier un equipe
    @PutMapping("/updateequipe/{idequipe}")
    public Equipe updateequipe (@RequestBody Equipe equipe, @PathVariable String idequipe){
        equipe.setIdequipe(idequipe);
        return iEquipe.save(equipe);
    }
    //TODO : Chercher un equipe selon Id
    @GetMapping("/getequipebyid/{idequipe}")
    public Equipe getequipebyid(@PathVariable String idequipe ){
        return iEquipe.findByIdequipe(idequipe);

    }

}
