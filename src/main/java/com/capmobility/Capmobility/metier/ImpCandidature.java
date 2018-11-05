package com.capmobility.Capmobility.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capmobility.Capmobility.Repository.CandidatureRepository;
import com.capmobility.Capmobility.model.Candidature;

public class ImpCandidature implements ICandidature {
	
	@Autowired
	CandidatureRepository candidatureRepository;

	//Enregistrer une candidature
	@Override
	public Candidature addCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		candidatureRepository.save(candidature);
		return candidature;
	}

	//recuperer toutes les candidature
	@Override
	public List<Candidature> getAllCandidature() {
		// TODO Auto-generated method stub
		List candidatures = candidatureRepository.findAll();
		return candidatures;
	}

	//recuperer une candidature par id
	@Override
	public Candidature getCandidatureById(Long id) {
		// TODO Auto-generated method stub
		Candidature candidature=candidatureRepository.getOne(id);
		return candidature;
	}

	@Override
	public Candidature updateCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		
		return null;
	}

	//supprimer une candidature par id
	@Override
	public void deleteCandidatureById(Long id) {
		// TODO Auto-generated method stub
		candidatureRepository.deleteById(id);
	}

}
