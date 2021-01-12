package com.example.recherche.security;

import com.example.recherche.model.Utilisateur;
import com.example.recherche.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //utilisateur
        Utilisateur utilisateur=accountService.loadUserByUsername(username);
        if(utilisateur==null) throw new UsernameNotFoundException("invalid user");





        Collection<GrantedAuthority> authorities=new ArrayList<>();
        utilisateur.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRolename()));
        });


        //return
        return new User(utilisateur.getUsernameutilisateur(),utilisateur.getPasswordutilisateur(),authorities);

//                private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
//        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }



//    //return
//        return new User(utilisateur.getUsernameutilisateur(),utilisateur.getPasswordutilisateur(),authorities,user1.getUserName(),
//                user1.getPassword(),
//                        true, true, true, true,
//    getAuthorities("ROLE_USER")); }

}



