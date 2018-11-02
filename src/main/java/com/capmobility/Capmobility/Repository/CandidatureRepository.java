package com.capmobility.Capmobility.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capmobility.Capmobility.model.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature , Long>{
}
