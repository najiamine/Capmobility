package com.capmobility.Capmobility.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capmobility.Capmobility.Repository.UtilisateurRepository;
import com.capmobility.Capmobility.model.Utilisateur;

public class ImpUtilisateur implements IUtilisateur {

	
	@Autowired 
	private UtilisateurRepository utilisateurRepository;
 	
	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
