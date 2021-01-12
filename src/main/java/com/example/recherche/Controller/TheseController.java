package com.example.recherche.Controller;

import com.example.recherche.dao.IEquipe;
import com.example.recherche.dao.IThese;
import com.example.recherche.model.Equipe;
import com.example.recherche.model.These;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/These")

public class TheseController {

    @Autowired
    public IThese iThese;
    @Autowired
    public IEquipe iEquipe;

    //TODO : Ajouter These avec equipe
    @PostMapping("/addthese/{idequipe}")
    public These addthese(@RequestBody These these , @PathVariable String idequipe ){
        Equipe equipe = iEquipe.findByIdequipe(idequipe);
        these.setEquipe(equipe);
        return iThese.save(these);
    }

    //TODO : Afficher les theses
    @GetMapping("/allthese")
    public List<These> allthese (){
        return iThese.findAll();
    }

    //TODO : Supprimer une these
    @DeleteMapping("/deletethese/{idthese}")
    HashMap deletethese(@PathVariable String idthese) {
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            iThese.deleteById(idthese);
            hashMap.put("State","these Supprimé");
            return hashMap;


        }catch (Exception e){
            hashMap.put("State","these Non Supprimé");
            return hashMap;

        }
    }

    //TODO : Modifier une these avec equipe
    @PutMapping("/updatethese/{idthese}/{idequipe}")
    public These updatethese (@RequestBody These these, @PathVariable String idthese, @PathVariable String idequipe){
        these.setIdthese(idthese);
        Equipe equipe = iEquipe.findByIdequipe(idequipe);
        these.setEquipe(equipe);
        return iThese.save(these);
    }

    //TODO : Chercher un these selon Id
    @GetMapping("/getthesebyid/{idthese}")
    public These getthesebyid(@PathVariable String idthese ){
        return iThese.findByIdthese(idthese);

    }
    //TODO : Chercher un these selon etat
    @GetMapping("/getthesebyetat/{etatthese}")
    public These getthesebyetat(@PathVariable String etatthese){
        return iThese.findByEtatthese(etatthese);
    }




}
