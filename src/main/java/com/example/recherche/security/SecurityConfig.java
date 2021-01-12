package com.example.recherche.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //tous permet creer login et register

        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").permitAll();
        http.authorizeRequests().antMatchers("/upload/**").permitAll();
        http.authorizeRequests().antMatchers("/sendMail").permitAll();

        //Administrateur

        http.authorizeRequests().antMatchers("/Membre/**").permitAll();
        http.authorizeRequests().antMatchers("/Stagaire/**").permitAll();
        http.authorizeRequests().antMatchers("/Evenement/**").permitAll();
        http.authorizeRequests().antMatchers("/These/**").permitAll();
        http.authorizeRequests().antMatchers("/Forum/**").permitAll();
        http.authorizeRequests().antMatchers("/Equipe/**").permitAll();
        http.authorizeRequests().antMatchers("/Article/**").permitAll();
        http.authorizeRequests().antMatchers("/Commentaire/**").permitAll();



        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);

    }


}
