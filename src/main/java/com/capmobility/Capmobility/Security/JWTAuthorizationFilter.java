package com.capmobility.Capmobility.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String jwt = request.getHeader(SecurityConstants.HEADER_STRING );
		System.out.println(jwt);
		if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			// si la condition true  filterchain passe au filtre suivant 
			//et apres spring security qui decide se qu'il faut faire ca vx dire quitter la methode
			filterChain.doFilter(request, response); return ;
		}
		
		Claims claims=Jwts.parser()
				.setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX,""))
				.getBody();
		String username =claims.getSubject();
		ArrayList<Map<String,String>> roles =(ArrayList<Map<String,String>>)
	    claims.get("roles");
		//Spring Security pour charger le context il a besoin que les roles soient en format 
		//Collection de GrantedAuthorities
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		
		});
			//creation d'un objet username password token 
		
			UsernamePasswordAuthenticationToken authenticatedUser = 
					new UsernamePasswordAuthenticationToken(username, null ,authorities);
			  SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			 
			  filterChain.doFilter(request, response);
		
	}

}
