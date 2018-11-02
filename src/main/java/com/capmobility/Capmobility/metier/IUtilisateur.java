package com.capmobility.Capmobility.metier;

import java.util.List;

import com.capmobility.Capmobility.model.Utilisateur;

public interface IUtilisateur {

	public Utilisateur addUtilisateur(Utilisateur utilisateur);

	public List<Utilisateur> getAllUtilisateur();

	public void deleteUtilisateurById(Long id);

	public Utilisateur getUtilisateurById(Long id);

	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
}
