package com.capmobility.Capmobility.metier;

import java.util.List;

import com.capmobility.Capmobility.model.Candidature;

public interface ICandidature {

	
	public List<Candidature> getListUtilisateurs();
	public String ajouterCandidature (Candidature candidature);
}
