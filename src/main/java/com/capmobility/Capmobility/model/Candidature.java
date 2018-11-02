package com.capmobility.Capmobility.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//La classe candidature 
@Entity
public class Candidature implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String projet;
	private Date dateIntegrationProjet;
	private int ced;
	private String potentielCed;
	private String motivation;
	private String ville1;
	private String ville2;
	private String ville3;
	private String situtationFamillial;
	private Boolean enfants;
	private int etatValidation;
   
	// Relation avec utilisateur
	@ManyToOne
	private Utilisateur user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public Date getDateIntegrationProjet() {
		return dateIntegrationProjet;
	}

	public void setDateIntegrationProjet(Date dateIntegrationProjet) {
		this.dateIntegrationProjet = dateIntegrationProjet;
	}

	public int getCed() {
		return ced;
	}

	public void setCed(int ced) {
		this.ced = ced;
	}

	public String getPotentielCed() {
		return potentielCed;
	}

	public void setPotentielCed(String potentielCed) {
		this.potentielCed = potentielCed;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getVille1() {
		return ville1;
	}

	public void setVille1(String ville1) {
		this.ville1 = ville1;
	}

	public String getVille2() {
		return ville2;
	}

	public void setVille2(String ville2) {
		this.ville2 = ville2;
	}

	public String getVille3() {
		return ville3;
	}

	public void setVille3(String ville3) {
		this.ville3 = ville3;
	}

	public String getSitutationFamillial() {
		return situtationFamillial;
	}

	public void setSitutationFamillial(String situtationFamillial) {
		this.situtationFamillial = situtationFamillial;
	}

	public Boolean getEnfants() {
		return enfants;
	}

	public void setEnfants(Boolean enfants) {
		this.enfants = enfants;
	}

	public int getEtatValidation() {
		return etatValidation;
	}

	public void setEtatValidation(int etatValidation) {
		this.etatValidation = etatValidation;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	// Constructeur par defaut
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructeur parametré
	public Candidature(String projet, Date dateIntegrationProjet, int ced, String potentielCed, String motivation,
			String ville1, String ville2, String ville3, String situtationFamillial, Boolean enfants,
			int etatValidation, Utilisateur user) {
		super();
		this.projet = projet;
		this.dateIntegrationProjet = dateIntegrationProjet;
		this.ced = ced;
		this.potentielCed = potentielCed;
		this.motivation = motivation;
		this.ville1 = ville1;
		this.ville2 = ville2;
		this.ville3 = ville3;
		this.situtationFamillial = situtationFamillial;
		this.enfants = enfants;
		this.etatValidation = etatValidation;
		this.user = user;
	}

}
