package com.capmobility.Capmobility.metier;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capmobility.Capmobility.Exception.ListUtilisateurVideException;
import com.capmobility.Capmobility.Exception.UtilisateurExistantException;
import com.capmobility.Capmobility.Exception.UtilisateurNotfoundException;
import com.capmobility.Capmobility.Repository.UtilisateurRepository;
import com.capmobility.Capmobility.model.Utilisateur;

@Service
public class ImpUtilisateur implements IUtilisateur {

	private static final Logger logger = LogManager.getLogger(ImpUtilisateur.class);
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	// Ajouter Un Utilisateur
	@Override
	public String addUtilisateur(Utilisateur utilisateur) throws UtilisateurExistantException {

		Utilisateur utilisateur1 = utilisateurRepository
				.findUtilisateurByMatricule(utilisateur.getMatricule());

		if (utilisateur1!=null) {
			logger.warn("Utilisateur existe deja");
			throw new UtilisateurExistantException(
					"L'Utilisateur  -Matricule: " + utilisateur.getMatricule() + " -NOM: " + utilisateur.getNom()
							+ " exsite déja dans la base veuillez inserer un autre Matricule");
		} else {
			Utilisateur utilisateur2 = utilisateurRepository.save(utilisateur);

			return "L'Utilisateur  -NOM: " + utilisateur.getNom() + " -Matricule: " + utilisateur.getMatricule()
					+ " est bien enregistré";
		}
	}

	// Afficher la liste des Utilisateurs
	@Override
	public List<Utilisateur> getAllUtilisateur() throws ListUtilisateurVideException {
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		if (utilisateurs.isEmpty()) {
			logger.info("Logger info : -La liste des utilisateurs est vide");
			throw new ListUtilisateurVideException("la liste des utilisateurs est vide");
		} else
			return utilisateurs;
	}

	// Chercher un utilisateur par MATRICULE
	@Override
	public Utilisateur getUtilisateurByMatricule(Long matricule) throws UtilisateurNotfoundException {
		Utilisateur utilisateur = utilisateurRepository.findUtilisateurByMatricule(matricule);

		if (utilisateur==null) {
			logger.warn("Utilisateur inexistant Merci de verifier le matricule " + matricule);
			throw new UtilisateurNotfoundException("Utilisateur inexistant Merci de verifier le matricule s'aisie");
		}
		return utilisateur;
		
		}

	// Chercher un utilisateur par ID
	@Override
	public Utilisateur getUtilisateurById(Long id) throws UtilisateurNotfoundException {
		Utilisateur utilisateur = utilisateurRepository.findOne(id);

		if (utilisateur==null) {
			logger.warn("Utilisateur inexistant Merci de verifier  " + id);
			throw new UtilisateurNotfoundException("Utilisateur inexistant Merci de verifier l'ID s'aisie");
		} else {
			
			return utilisateur;
		}
	}

	// Modifier Un Utilisateur
	@Override
	public String updateUtilisateur(Utilisateur utilisateur) throws UtilisateurNotfoundException {

		Optional<Utilisateur> utilisateur1 = utilisateurRepository.findById(utilisateur.getId());

		if (!utilisateur1.isPresent()) {
			logger.warn("Utilisateur inexistant Merci de verifier");
			throw new UtilisateurNotfoundException("Utilisateur inexistant Merci de verifier l'ID s'aisie");
		} else {
			Utilisateur utilisateur2 = utilisateurRepository.save(utilisateur);

			return "L'Utilisateur  -NOM: " + utilisateur.getNom() + " -ID: " + utilisateur.getId()
					+ " est bien modifié";
		}

	}

	// Supprimer un Utilisateur par ID
	@Override
	public String deleteUtilisateurById(Long id) throws UtilisateurNotfoundException {

		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

		if (!utilisateur.isPresent()) {
			logger.warn("Utilisateur inexistant Merci de verifier" + id);
			throw new UtilisateurNotfoundException("Utilisateur inexistant Merci de verifier l'id s'aisie");
		} else {
			utilisateurRepository.delete(id);
			return "L'utilisateur avec Id :" + id + "est bien supprimé";
		}
	}

}