package com.capmobility.Capmobility.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capmobility.Capmobility.metier.ICandidature;

import com.capmobility.Capmobility.model.Candidature;

@RestController
public class CandidatureService {

	@Autowired
	private ICandidature iCandidature;

	@GetMapping("/GetListCandidatures")
	public List<Candidature> getListUtilisateurs() {
		return iCandidature.getListUtilisateurs();
	}

	@PostMapping("/AjouterCandidature")
	public String ajouterCandidature(@RequestBody Candidature candidature) {
		return iCandidature.ajouterCandidature(candidature);
	}

}
