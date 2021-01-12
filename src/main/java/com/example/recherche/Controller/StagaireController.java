package com.example.recherche.Controller;

import com.example.recherche.dao.*;
import com.example.recherche.model.*;
import com.example.recherche.service.AccountService;
import com.example.recherche.service.EmailService;
import com.example.recherche.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Stagaire")

public class StagaireController {


    @Autowired
    public AccountService accountService;
    @Autowired
    public IThese iThese;

    @Autowired
    public  IStagaire iStagaire;

    @Autowired
    private EmailService emailService;

    // TODO: ajouter un Stagaire avec these et mail ().

    @PostMapping("/addstagaire/{idthese}")
    public Stagaire addstagaire(Stagaire stagaire,
                                @PathVariable String idthese,
                                @PathParam("file") MultipartFile file) {

        These these = iThese.findByIdthese(idthese);
        // TODO: Send Mail
        Mail mail = new Mail();
            mail.setFrom("cyrine.benabdessalem@gmail.com");
            mail.setTo("cyrine.benabdessalem@gmail.com");
            mail.setSubject("Demande de validation inscription");
            mail.setContent(stagaire.getNomutilisateur()+stagaire.getPrenomutilisateur()+"Demandez-vous de valider l'affectation à cette thèse et ci-joint le certificat"+these.getTitrethese());
            emailService.sendSimpleMessage(mail);
            return accountService.saveStagaire(stagaire.getUsernameutilisateur(), stagaire.getPasswordutilisateur(), stagaire.getFirstnameutilisateur(), stagaire.getLastnameutilisateur(), stagaire.getNomutilisateur(), stagaire.getPrenomutilisateur(), stagaire.getDatenaissanceutilisateur(), stagaire.getEmailutilisateur(), stagaire.getSexeutilisateur(), stagaire.getTelephoneutilisateur(), stagaire.getAdresseutilisateur(), stagaire.getGradeutilisateur(), stagaire.getThese(),file);
    }

    //TODO: afficher les stagaires

    @GetMapping("/allstagaire")
    public List<Stagaire> allstagaire() {
        return iStagaire.findAll();
    }

    //TODO: modifier un Stagaire avec these

    @PutMapping("/updatestagaire/{idutilisateur}/{idthese}")
    public Stagaire updatestagaire(@RequestBody Stagaire stagaire, @PathVariable String idutilisateur,@PathVariable String idthese) {
        stagaire.setIdutilisateur(idutilisateur);
        These these = iThese.findByIdthese(idthese);
        stagaire.setThese(these);
        return iStagaire.save(stagaire);
    }

    //TODO: supprimer Stagaire

    @DeleteMapping("/deletestagaire/{idutilisateur}")
    public HashMap deletestagaire(@PathVariable String idutilisateur) {

        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iStagaire.deleteById(idutilisateur);
            hashMap.put("state", "Stagaire delete");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "Stagaire not delete");
            return hashMap;

        }


    }

}
