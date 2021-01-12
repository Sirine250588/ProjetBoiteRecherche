package com.example.recherche;

import com.example.recherche.dao.*;
import com.example.recherche.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RechercheApplication implements CommandLineRunner {

	@Bean
	BCryptPasswordEncoder getBCPE(){return  new BCryptPasswordEncoder();}


	@Autowired
	StorageService storageService;
	@Autowired
	IAdministrateur iAdministrateur;
	@Autowired
	IMembre iMembre;
	@Autowired
	IStagaire iStagaire;
	@Autowired
	IUtilisateur iUtilisateur;
	@Autowired
	IRole iRole;

	public static void main(String[] args) {

		SpringApplication.run(RechercheApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		storageService.deleteAll();
//		storageService.init();

	}

//	@Bean
//	CommandLineRunner start(AccountService accountService) {
//		return args -> {
//			accountService.save(new Role("Administrateur"));
//			accountService.save(new Role("Membre"));
//			accountService.save(new Role("Stagaire"));
//		};}

}
