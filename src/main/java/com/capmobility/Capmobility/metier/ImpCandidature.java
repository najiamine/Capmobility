package com.capmobility.Capmobility.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capmobility.Capmobility.Repository.CandidatureRepository;
import com.capmobility.Capmobility.model.Candidature;
@Service
public class ImpCandidature implements ICandidature{

	@Autowired
	private CandidatureRepository candidatureRepository ;
	
	@Override
	public List<Candidature> getListUtilisateurs() {
		 
		return candidatureRepository.findAll();
	}

	@Override
	public String ajouterCandidature(Candidature candidature) {
		candidatureRepository.save(candidature) ;
	
		return "Insertion Candidature";
	}

}
