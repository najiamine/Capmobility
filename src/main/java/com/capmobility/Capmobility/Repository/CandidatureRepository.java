package com.capmobility.Capmobility.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capmobility.Capmobility.model.Candidature;
import com.capmobility.Capmobility.model.Utilisateur;

public interface CandidatureRepository extends JpaRepository<Candidature , Long>{
	
	public Optional<Candidature> findById(Long id);
	
	@Query("select c from Candidature c where c.etatValidation=:x")
	public List<Candidature> getListCandidatureByEtat(@Param("x") int etatValidation);
}
