package com.capmobility.Capmobility.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capmobility.Capmobility.Exception.ListUtilisateurVideException;
import com.capmobility.Capmobility.Exception.UtilisateurExistantException;
import com.capmobility.Capmobility.Exception.UtilisateurNotfoundException;
import com.capmobility.Capmobility.metier.IUtilisateur;
import com.capmobility.Capmobility.model.Utilisateur;

@RequestMapping("/Utilisateur")
@RestController
public class UtilisateurService {

	@Autowired
	private IUtilisateur iUtilisateur;

	// Ajouter un utilisateur
	@PostMapping("/ajouterUtilisateur")
	public String addUtilisateur(@RequestBody Utilisateur utilisateur) {

		try {
			iUtilisateur.addUtilisateur(utilisateur);
		} catch (UtilisateurExistantException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return "L'Utilisateur  -MATRICULE: " + utilisateur.getMatricule() + " -NOM: " + utilisateur.getNom()
					+ " exsite déja dans la base, veuillez inserer un autre Matricule";
		}
		return "L'Utilisateur  -MATRICULE: " + utilisateur.getMatricule() + " -NOM: " + utilisateur.getNom()
				+ " est bien enregistré";
	}

	// Recupérer la liste des utilisateurs
	@GetMapping("/GetUtilisateurs")
	public List<Utilisateur> getAllUtilisateur() {

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			utilisateurs = iUtilisateur.getAllUtilisateur();

		} catch (ListUtilisateurVideException e) {
			System.out.println(e.getMessage());

		}
		return utilisateurs;
	}

	// Rechercher un utilisateur par id
	@GetMapping("/FindUtilisateur/{id}")
	public Utilisateur getUtilisateurById(@PathVariable Long id) {

		Utilisateur utilisateur = null;
		try {
			utilisateur = iUtilisateur.getUtilisateurById(id);
		} catch (UtilisateurNotfoundException e) {
			System.out.println(e.getMessage());

		}
		return utilisateur;
	}

	// Rechercher un utilisateur par matricule
	@GetMapping("/FindUtilisateurByMatricule/{matricule}")
	public Utilisateur getUtilisateurByMatricule(@PathVariable Long matricule) {
		Utilisateur utilisateur = null;
		try {
			utilisateur = iUtilisateur.getUtilisateurByMatricule(matricule);
		} catch (UtilisateurNotfoundException e) {
			System.out.println(e.getMessage());

		}
		return utilisateur;
	}

	// Modifier un utilisateur
	@PutMapping("/UpdateUtilisateurs")
	public String updateUtilisateur(@RequestBody Utilisateur utilisateur) {

		try {
			iUtilisateur.updateUtilisateur(utilisateur);

		} catch (UtilisateurNotfoundException e) {

			System.out.println(e.getMessage());
			return "L'utilisateur -NOM: " + utilisateur.getNom() + " -MATRICULE: " + utilisateur.getMatricule()
					+ " s'aisie n'existe pas , veuillez inserer un nouveau MATRICULE";
		}
		return "L'Utilisateur  -NOM: " + utilisateur.getNom() + " -MATRICULE: " + utilisateur.getMatricule()
				+ " est bien modifié";
	}

	// Supprimer un utilisateur
	@DeleteMapping("/DeleteUtilisateur/{id}")
	public String deleteUtilisateurById(@PathVariable Long id) {
		try {
			iUtilisateur.deleteUtilisateurById(id);
		} catch (UtilisateurNotfoundException e) {

			System.out.println(e.getMessage());
			return "Echec de suppression : - Utilisateur inexistant Merci de verifier l'ID s'aisie ";
		}

		return "L'utilisateur est supprimé";

	}

}
