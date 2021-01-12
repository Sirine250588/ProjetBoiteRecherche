package com.example.recherche.Controller;

import com.example.recherche.dao.*;
import com.example.recherche.model.*;
import com.example.recherche.service.AccountService;
import com.example.recherche.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Membre")

public class MembreController {

    @Autowired
    public IMembre iMembre;
    @Autowired
    public AccountService accountService;
    @Autowired
    public IForum iForum;

    @Autowired
    public IThese iThese;
    @Autowired
    public IEquipe iEquipe;
    @Autowired
    private StorageService storageService;

    // TODO: ajouter un membre avec these et equipe.

    @PostMapping("/addmembre/{idthese}/{idequipe}")
    public Membre addmembre( Membre membre,@PathVariable String idthese, @PathVariable String idequipe ,@PathParam("file") MultipartFile file) {

        // storageService.store(file);
       // membre.setPhotoutilisateur(file.getOriginalFilename());
      // Forum forum = iForum.findByIdforum(idforum);
     //  membre.setForum(forum);

        These these = iThese.findByIdthese(idthese);
        membre.setThese(these);

        Equipe equipe = iEquipe.findByIdequipe(idequipe);
        membre.setEquipe(equipe);

        return accountService.saveMembre(membre.getUsernameutilisateur(), membre.getPasswordutilisateur(), membre.getFirstnameutilisateur(), membre.getLastnameutilisateur(), membre.getNomutilisateur(), membre.getPrenomutilisateur(), membre.getDatenaissanceutilisateur(), membre.getEmailutilisateur(), membre.getSexeutilisateur(), membre.getTelephoneutilisateur(), membre.getAdresseutilisateur(), membre.getGradeutilisateur(), membre.getType(), membre.getThese(), membre.getEquipe(),file);
    }

    //TODO: afficher les membres

    @GetMapping("/allmembre")
    public List<Membre> allmembre() {
        return iMembre.findAll();
    }

    //TODO: modifier un membre

    @PutMapping("/updatemembre/{idutilisateur}/{idthese}/{idequipe}")
    public Membre updatemembre(@RequestBody Membre membre, @PathVariable String idutilisateur, @PathVariable String idthese,@PathVariable String idequipe) {
        membre.setIdutilisateur(idutilisateur);
//
//        Forum forum = iForum.findByIdforum(idforum);
//        membre.setForum(forum);

        These these = iThese.findByIdthese(idthese);
        membre.setThese(these);

        Equipe equipe = iEquipe.findByIdequipe(idequipe);
        membre.setEquipe(equipe);


        return iMembre.save(membre);
    }

    //TODO: supprimer membre

    @DeleteMapping("/deletemembre/{idutilisateur}")
    public HashMap deletemembre(@PathVariable String idutilisateur) {

        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iMembre.deleteById(idutilisateur);
            hashMap.put("state", "membre delete");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "membre not delete");
            return hashMap;

        }


    }
}
