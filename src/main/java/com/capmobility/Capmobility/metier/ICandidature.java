package com.capmobility.Capmobility.metier;

import java.util.List;

import com.capmobility.Capmobility.Exception.CandidatureNotfoundException;
import com.capmobility.Capmobility.Exception.ListCandidatureVideException;
import com.capmobility.Capmobility.model.Candidature;

public interface ICandidature {
	
	public String ajouterCandidature(Candidature candidature);
	
	public List<Candidature> getListCandidature() throws ListCandidatureVideException;
	
	public Candidature getCandidatureById(Long id) throws CandidatureNotfoundException;
	
	public String updateCandidature(Candidature candidature) throws CandidatureNotfoundException;
	
	public String deleteCandidatureById(Long id) throws CandidatureNotfoundException;
	
	public List<Candidature> getListCandidatureByEtat(int etat) throws ListCandidatureVideException;
	
	// public List<Candidature> getListCandidatureValide() throws
	// ListCandidatureVideException;
	//
	// public List<Candidature> getListCandidatureRefuse() throws
	// ListCandidatureVideException;

	
}
