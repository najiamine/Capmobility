package com.capmobility.Capmobility.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	/*
	 * Definir a spring security comment il va definir les utilisateur et les roles
	 * est ce que dans une base de donnée ou en Memoire local
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.inMemoryAuthentication()
//		.withUser("admin").password("1234").roles("ADMIN", "USER")
//		.and()
//		.withUser("user").password("123").roles("USER");
	   
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
		
	}
	/*
	 * Definir les roles et les url specifique pour chaque Role ainsi que les
	 * filtres
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		//Connexion statles et  désactivation d'une authetification Session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//En cas d'utilisation du filter JWT on aura pas besoin d'utiliser la page D'authentification
		//http.formLogin();
	    //	loginPage("/login"); Afin de personnaliser la page Login 
		http.authorizeRequests().antMatchers("/login/**","/register/**","/saveUtilisateur/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/utilisateurs/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
