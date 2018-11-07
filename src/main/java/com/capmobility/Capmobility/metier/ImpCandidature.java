package com.capmobility.Capmobility.metier;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capmobility.Capmobility.Exception.CandidatureNotfoundException;
import com.capmobility.Capmobility.Exception.ListCandidatureVideException;
import com.capmobility.Capmobility.Exception.ListUtilisateurVideException;
import com.capmobility.Capmobility.Exception.UtilisateurNotfoundException;
import com.capmobility.Capmobility.Repository.CandidatureRepository;
import com.capmobility.Capmobility.model.Candidature;

@Service
public class ImpCandidature implements ICandidature {

	private static final Logger logger = LogManager.getLogger(ImpCandidature.class);
	@Autowired
	private CandidatureRepository candidatureRepository;

	@Override
	public String ajouterCandidature(Candidature candidature) {

		candidatureRepository.save(candidature);

		return "Insertion Candidature";
	}

	@Override
	public List<Candidature> getListCandidature() throws ListCandidatureVideException {

		List<Candidature> candidatures = candidatureRepository.findAll();

		if (candidatures.isEmpty()) {
			logger.info("Logger info : -La liste des Candidatures est vide");
			throw new ListCandidatureVideException("la liste des Candidatures est vide");
		} else
			return candidatures;
	}

	@Override
	public Candidature getCandidatureById(Long id) throws CandidatureNotfoundException {
		// TODO Auto-generated method stub
		Candidature candidature = candidatureRepository.findOne(id);

		if (candidature == null) {
			logger.warn("Candidature inexistante Merci de verifier le numero de candidature :" + id);
			throw new CandidatureNotfoundException("Candidature inexistante Merci de verifier la candidatiure");
		} else
			return candidature;

	}

	@Override
	public String updateCandidature(Candidature candidature) throws CandidatureNotfoundException {
		// TODO Auto-generated method stub
		Optional<Candidature> candidature1 = candidatureRepository.findById(candidature.getId());
		if (!candidature1.isPresent()) {
			logger.warn("Candidature inexistante Merci de verifier le numero de candidature :" + candidature.getId());
			throw new CandidatureNotfoundException("Candidature inexistante Merci de verifier la candidature");
		}

		else
			candidatureRepository.save(candidature);
		return "Votre candidature est modifié";
	}

	@Override
	public String deleteCandidatureById(Long id) throws CandidatureNotfoundException {
		// TODO Auto-generated method stub
		Optional<Candidature> candidature1 = candidatureRepository.findById(id);
		if (!candidature1.isPresent()) {
			logger.warn("Candidature inexistante Merci de verifier le numero de candidature :" + id);
			throw new CandidatureNotfoundException("Candidature inexistante Merci de verifier la candidature");
		} else {
			candidatureRepository.delete(id);
			return "La candidature avec Id :" + id + "est bien supprimé";
		}

	}

	@Override
	public List<Candidature> getListCandidatureByEtat(int etat) throws ListCandidatureVideException {
		// TODO Auto-generated method stub

		List<Candidature> candidatures = candidatureRepository.getListCandidatureByEtat(etat);

		if (candidatures.isEmpty()) {
			logger.info("Logger info : -La liste des Candidatures est vide");
			throw new ListCandidatureVideException("la liste des Candidatures est vide");
		} else
			return candidatures;
	}

	// @Override
	// public List<Candidature> getListCandidatureValide() throws
	// ListCandidatureVideException {
	// // TODO Auto-generated method stub
	// List<Candidature> candidatures =
	// candidatureRepository.getListCandidatureByEtat(1);
	//
	// if (candidatures.isEmpty()) {
	// logger.info("Logger info : -La liste des Candidatures avec l'etat Validé est
	// vide");
	// throw new ListCandidatureVideException("la liste des Candidatures est vide");
	// } else
	// return candidatures;
	// }
	//
	// @Override
	// public List<Candidature> getListCandidatureRefuse() throws
	// ListCandidatureVideException {
	// // TODO Auto-generated method stub
	// List<Candidature> candidatures =
	// candidatureRepository.getListCandidatureByEtat(2);
	//
	// if (candidatures.isEmpty()) {
	// logger.info("Logger info : -La liste des Candidatures avec l'etat Refusé est
	// vide");
	// throw new ListCandidatureVideException("la liste des Candidatures est vide");
	// } else
	// return candidatures;
	// }

}
