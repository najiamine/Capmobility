package com.capmobility.Capmobility.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capmobility.Capmobility.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
