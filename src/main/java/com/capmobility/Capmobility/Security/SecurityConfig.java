package com.capmobility.Capmobility.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * Definir a spring security comment il va definir les utilisateur et les roles
	 * est ce que dans une base de donnée ou en Memoire local
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("1234").roles("ADMIN", "USER")
		.and()
		.withUser("user").password("123").roles("USER");

	}

	/*
	 * Definir les roles et les url specifique pour chaque Role ainsi que les
	 * filtres
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.formLogin();
//		loginPage("/login");
		http.authorizeRequests().anyRequest().authenticated();

	}

}
