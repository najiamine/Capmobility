package com.capmobility.Capmobility.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capmobility.Capmobility.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	public Utilisateur findUtilisateurByMatricule(Long matricule);

	public Optional<Utilisateur> findById(Long id);

	public Utilisateur findBylogin(String login);

}
