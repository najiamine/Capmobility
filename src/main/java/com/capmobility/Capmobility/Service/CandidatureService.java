package com.capmobility.Capmobility.Service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capmobility.Capmobility.Email.SmtpMailSender;
import com.capmobility.Capmobility.Exception.CandidatureNotfoundException;
import com.capmobility.Capmobility.Exception.ListCandidatureVideException;
import com.capmobility.Capmobility.metier.ICandidature;

import com.capmobility.Capmobility.model.Candidature;

@RestController
public class CandidatureService {

	@Autowired
	private ICandidature iCandidature;
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	// ajouter une candidature;
	@RequestMapping(value = "/candidatures", method = RequestMethod.POST)
//	@PostMapping("/candidatures")
	public String addCandidature(@RequestBody Candidature candidature) {

		return iCandidature.ajouterCandidature(candidature);
	}

	// recuperer toutes les condidatures
	@RequestMapping(value = "/candidatures", method = RequestMethod.GET)
	public List<Candidature> getAllCandidature() {

		List<Candidature> candidatures = new ArrayList<Candidature>();
		try {
			candidatures = iCandidature.getListCandidature();
		} catch (ListCandidatureVideException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return candidatures;
	}

	// recuperer la candidature par id
	@RequestMapping(value = "/candidatures/{id}", method = RequestMethod.GET)
	public Candidature getCandidature(@PathVariable Long id) {

		Candidature candidature = null;
		try {
			candidature = iCandidature.getCandidatureById(id);
		} catch (CandidatureNotfoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			//return "Candidature inexistante Merci de verifier le numero de candidature";
		}
		return candidature;
	}

	// supprimer la candidature par id
	@RequestMapping(value = "/candidatures/{id}", method = RequestMethod.DELETE)
	public String supprimerCandidature(@PathVariable Long id) {

		try {
			iCandidature.deleteCandidatureById(id);
		} catch (CandidatureNotfoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			return "Candidature inexistante Merci de verifier le numero de candidature";
		}
		return "Candidature supprimé";
	}

	// modifier une candidature
	@RequestMapping(value = "/candidatures", method = RequestMethod.PUT)
	public String updateCandidature(@RequestBody Candidature candidature) throws MessagingException {
		try {
			iCandidature.updateCandidature(candidature);
		} catch (CandidatureNotfoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			return "Candidature inexistante Merci de verifier le numero de candidature";
		}
//		if(!admin)
//			return "Votre candidature est modifié";
//		else {
			smtpMailSender.send("abdou.bouchra93@gmail.com", "test mailing CapMobility", "Body");
			return "la condidature est modifié, Un Message envoyé.";
//	}
	}

	// recuperer la liste des candidatures par etat (0 = en cours, 1 = validé, 2 =
	// refusé)
	@RequestMapping(value = "/candidatures/etats/{etat}", method = RequestMethod.GET)
	public List<Candidature> getListCandidatureByEtat(@PathVariable int etat) {

		List<Candidature> candidatures = new ArrayList<Candidature>();
		try {
			candidatures = iCandidature.getListCandidatureByEtat(etat);
		} catch (ListCandidatureVideException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return candidatures;
	}

}
