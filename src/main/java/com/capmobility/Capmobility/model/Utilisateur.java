package com.capmobility.Capmobility.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Classe Utilisateur
@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long matricule;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String username;
	private String password;
	private String gmail;
	private Date dateIntegrationCap;
	private String telephone;
	private String adresse;
	private String profil;
	private String technologie;
	private String grade;
	private String sexe;
	private String villeTravail;
	// Relation Candidature
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Candidature> candidatures;
	// Relation Role
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
   
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public Date getDateIntegrationCap() {
		return dateIntegrationCap;
	}

	public void setDateIntegrationCap(Date dateIntegrationCap) {
		this.dateIntegrationCap = dateIntegrationCap;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getVilleTravail() {
		return villeTravail;
	}

	public void setVilleTravail(String villeTravail) {
		this.villeTravail = villeTravail;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

	// Constructeur par defaut
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Constructeur parametré
	public Utilisateur(Long id, Long matricule, String nom, String prenom, String username, String password,
			String gmail, Date dateIntegrationCap, String telephone, String adresse, String profil, String technologie,
			String grade, String sexe, String villeTravail, List<Candidature> candidatures, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.gmail = gmail;
		this.dateIntegrationCap = dateIntegrationCap;
		this.telephone = telephone;
		this.adresse = adresse;
		this.profil = profil;
		this.technologie = technologie;
		this.grade = grade;
		this.sexe = sexe;
		this.villeTravail = villeTravail;
		this.candidatures = candidatures;
		this.roles = roles;
	}

	
	
}
