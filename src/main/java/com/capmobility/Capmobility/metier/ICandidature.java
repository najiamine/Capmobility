package com.capmobility.Capmobility.metier;

import java.util.List;

import com.capmobility.Capmobility.model.Candidature;

public interface ICandidature {
	
	public Candidature addCandidature(Candidature candidature);
	
	public List<Candidature> getAllCandidature();
	
	public Candidature getCandidatureById(Long id);
	
	public Candidature updateCandidature(Candidature candidature);
	
	public void deleteCandidatureById(Long id);

	
	public List<Candidature> getListUtilisateurs();
	public String ajouterCandidature (Candidature candidature);
}
