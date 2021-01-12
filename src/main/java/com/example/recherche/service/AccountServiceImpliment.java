package com.example.recherche.service;

import com.example.recherche.dao.*;
import com.example.recherche.model.*;
import com.example.recherche.utils.StorageService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class AccountServiceImpliment implements AccountService {

    private StorageService storageService;
    private IUtilisateur iUtilisateur;
    private IAdministrateur iAdministrateur;
    private IStagaire iStagaire;
    private IMembre iMembre;
    private IRole iRole;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpliment(StorageService storageService, IUtilisateur iUtilisateur, IAdministrateur iAdministrateur, IStagaire iStagaire, IMembre iMembre, IRole iRole, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.storageService = storageService;
        this.iUtilisateur = iUtilisateur;
        this.iAdministrateur = iAdministrateur;
        this.iStagaire = iStagaire;
        this.iMembre = iMembre;
        this.iRole = iRole;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Administrateur saveAdministrateur(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String gradeutilisateur, MultipartFile file) {
        Administrateur user = iAdministrateur.findByUsernameutilisateur(usernameutilisateur);
        if (user != null) throw new RuntimeException("User already exists");
        //  if (!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Administrateur appUser = new Administrateur();

        appUser.setUsernameutilisateur(usernameutilisateur);
        appUser.setPasswordutilisateur(bCryptPasswordEncoder.encode(passwordutilisateur));
        appUser.setEmailutilisateur(emailutilisateur);
        appUser.setAdresseutilisateur(adresseutilisateur);
        appUser.setDatenaissanceutilisateur(datenaissanceutilisateur);
        appUser.setFirstnameutilisateur(firstnameutilisateur);
        appUser.setLastnameutilisateur(lastnameutilisateur);
        appUser.setNomutilisateur(nomutilisateur);
        storageService.store(file);
        appUser.setPhotoutilisateur(file.getOriginalFilename());

        appUser.setPrenomutilisateur(prenomutilisateur);
        appUser.setSexeutilisateur(sexeutilisateur);
        appUser.setTelephoneutilisateur(telephoneutilisateur);
        appUser.setGradeutilisateur(gradeutilisateur);
        Role role = iRole.findByRolename("Administrateur");
        appUser.getRoles().add(role);
        iAdministrateur.save(appUser);

        //addRoleToUser(nomadmin, "Administrateur");

        return appUser;

    }

    @Override
    public Membre saveMembre(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String gradeutilisateur, String type, These these, Equipe equipe, MultipartFile file) {
        Utilisateur utilisateur = iUtilisateur.findByUsernameutilisateur(usernameutilisateur);

        if (utilisateur != null) throw new RuntimeException("User already exists");
        //if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Membre membre = new Membre();

        membre.setUsernameutilisateur(usernameutilisateur);
        membre.setLastnameutilisateur(lastnameutilisateur);
        membre.setFirstnameutilisateur(firstnameutilisateur);
        membre.setEquipe(equipe);
//        membre.setForum(forum);
        membre.setThese(these);
        membre.setType(type);
        membre.setNomutilisateur(nomutilisateur);
        membre.setPrenomutilisateur(prenomutilisateur);
        membre.setDatenaissanceutilisateur(datenaissanceutilisateur);
        membre.setEmailutilisateur(emailutilisateur);
        membre.setGradeutilisateur(gradeutilisateur);
        membre.setAdresseutilisateur(adresseutilisateur);
        membre.setSexeutilisateur(sexeutilisateur);
        System.out.println(file.getOriginalFilename());
        storageService.store(file);
        membre.setPhotoutilisateur(file.getOriginalFilename());
        System.out.println(file.getOriginalFilename());
        membre.setTelephoneutilisateur(telephoneutilisateur);
        membre.setPasswordutilisateur(bCryptPasswordEncoder.encode(passwordutilisateur));
        //appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));

        Role role = iRole.findByRolename("Membre");

        membre.getRoles().add(role);
        iMembre.save(membre);

        return membre;


    }

    @Override
    public Stagaire saveStagaire(String usernameutilisateur, String passwordutilisateur, String firstnameutilisateur, String lastnameutilisateur, String nomutilisateur, String prenomutilisateur, String datenaissanceutilisateur, String emailutilisateur, String sexeutilisateur, String telephoneutilisateur, String adresseutilisateur, String gradeutilisateur, These these, MultipartFile file) {
        Utilisateur utilisateur = iUtilisateur.findByUsernameutilisateur(usernameutilisateur);

        if (utilisateur != null) throw new RuntimeException("User already exists");
        //if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Stagaire stagaire = new Stagaire();
        stagaire.setUsernameutilisateur(usernameutilisateur);
        stagaire.setLastnameutilisateur(lastnameutilisateur);
        stagaire.setFirstnameutilisateur(firstnameutilisateur);
        stagaire.setNomutilisateur(nomutilisateur);
        stagaire.setPrenomutilisateur(prenomutilisateur);
        stagaire.setAdresseutilisateur(adresseutilisateur);
        stagaire.setDatenaissanceutilisateur(datenaissanceutilisateur);
        stagaire.setGradeutilisateur(gradeutilisateur);
        stagaire.setThese(these);
        System.out.println(file.getOriginalFilename());

        storageService.store(file);
        stagaire.setPhotoutilisateur(file.getOriginalFilename());
        System.out.println(file.getOriginalFilename());
        stagaire.setSexeutilisateur(sexeutilisateur);
        stagaire.setTelephoneutilisateur(telephoneutilisateur);
        stagaire.setEmailutilisateur(emailutilisateur);
        stagaire.setPasswordutilisateur(bCryptPasswordEncoder.encode(passwordutilisateur));

        //appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));

        Role role = iRole.findByRolename("Stagaire");

        stagaire.getRoles().add(role);
        iStagaire.save(stagaire);


        //addRoleToUser(nomutilisateur, "Patient");

        return stagaire;
    }


    @Override
    //ajouter une role
    public Role save(Role role) {
        return iRole.save(role);
    }

    @Override
    //recherche de user
    public Utilisateur loadUserByUsername(String username) {
        return iUtilisateur.findByUsernameutilisateur(username);
    }


    //  @Override
////  //affectation de role d'utilisateur
//  public void addRoleToUser(String username, String rolename) {
//
//      Personne personne=iPersonne.findByUsername(username);
//    Role appRole=iRole.findByRolename(rolename);
//
//    personne.getRoles().add(appRole);
//    //iPersonne.save(personne);
//  }
    @Override
//affectation de role d'utilisateur
    public void addRoleToUser(String username, String rolename) {

        Utilisateur utilisateur = iUtilisateur.findByUsernameutilisateur(username);
        Role appRole = iRole.findByRolename(rolename);

        utilisateur.getRoles().add(appRole);

    }


}

