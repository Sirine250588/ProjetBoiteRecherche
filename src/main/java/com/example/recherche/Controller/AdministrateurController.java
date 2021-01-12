package com.example.recherche.Controller;

import com.example.recherche.dao.IAdministrateur;
import com.example.recherche.model.Administrateur;
import com.example.recherche.model.Mail;
import com.example.recherche.service.AccountService;
import com.example.recherche.service.EmailService;
import com.example.recherche.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministrateurController {
    @Autowired
    public IAdministrateur iAdministrateur;
    @Autowired
    public AccountService accountService;
    @Autowired
    private StorageService storageService;

    @PostMapping("/saveadmin")
    public Administrateur saveadmin( Administrateur administrateur ,@PathParam("file") MultipartFile file) {
        return accountService.saveAdministrateur(administrateur.getUsernameutilisateur(),administrateur.getPasswordutilisateur(),administrateur.getFirstnameutilisateur(),administrateur.getLastnameutilisateur(),administrateur.getNomutilisateur(),administrateur.getPrenomutilisateur(),administrateur.getDatenaissanceutilisateur(),administrateur.getEmailutilisateur(),administrateur.getSexeutilisateur(),administrateur.getTelephoneutilisateur(),administrateur.getAdresseutilisateur(),administrateur.getGradeutilisateur(),file);


    }

    //TODO : Afficher les evenements

    @GetMapping("/alladmin")
    public List<Administrateur> alladmin (){
        return iAdministrateur.findAll();
    }

    //TODO: Association Admin -> Mail : envoyer mail

    @Autowired
    private EmailService emailService;

    @RequestMapping(value="/sendMail",method= RequestMethod.POST)
    public String sendMail(@RequestBody Mail mail){
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        mail.setFrom("cyrine.benabdessalem@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject(mail.getSubject());
        mail.setContent(mail.getContent());
        emailService.sendSimpleMessage(mail);
        return "ok";
    }
}