package com.capmobility.Capmobility.metier;

import java.util.List;
import java.util.Optional;

import com.capmobility.Capmobility.Exception.ListUtilisateurVideException;
import com.capmobility.Capmobility.Exception.UtilisateurExistantException;
import com.capmobility.Capmobility.Exception.UtilisateurNotfoundException;
import com.capmobility.Capmobility.model.Utilisateur;

public interface IUtilisateur {

	public String addUtilisateur(Utilisateur utilisateur) throws UtilisateurExistantException ;

	public List<Utilisateur> getAllUtilisateur() throws ListUtilisateurVideException ;

	public String deleteUtilisateurById(Long id) throws UtilisateurNotfoundException;

	public Utilisateur getUtilisateurById(Long id) throws UtilisateurNotfoundException;

	public String updateUtilisateur(Utilisateur utilisateur)throws UtilisateurNotfoundException;
	
	public Utilisateur getUtilisateurByMatricule(Long matricule) throws UtilisateurNotfoundException;
	

	
}
