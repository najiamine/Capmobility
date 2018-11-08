package com.capmobility.Capmobility.Security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capmobility.Capmobility.model.Utilisateur;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
    // get identiant Utilisateur 
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Utilisateur user = null;
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		try {
			// prendre Objet JSON "request.getInputStream()" et le stocker dans un Objet
			// Java Déserialisation de données
			user = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("*****************************");
		System.out.println("username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
    //   Creation du Token
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User springUser =(User) authResult.getPrincipal();
		String jwt =Jwts.builder().setSubject(springUser.getUsername())
		.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))		
		.signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
		.claim("roles",springUser.getAuthorities())//Serialiser les roles au format JSON 
		.compact();//Generer le Token : Spring Security va utiliser base 64 url en code pour compacter le token 
		response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);
		
	}
}