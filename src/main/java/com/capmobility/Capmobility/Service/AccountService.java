package com.capmobility.Capmobility.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capmobility.Capmobility.metier.IAccountService;
import com.capmobility.Capmobility.model.AppRole;
import com.capmobility.Capmobility.model.Utilisateur;

@RestController
public class AccountService {
	
	@Autowired
	private IAccountService iAccountService;

	@PostMapping("/saveUtilisateur")
	public Utilisateur saveUser(@RequestBody RegisterForm userForm) {
		// Generer Exception Password non Confirme
		if (!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("you must confirm your password");
		// Generer Exception Username existe deja
		Utilisateur user = iAccountService.findUtilisateurByUsername(userForm.getUsername());
		if (user != null)
			throw new RuntimeException("this user already exists By Username");
		// Generer Exception Date inferieru un ans
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(userForm.getDateIntegrationCap());
		String localdate = formatter.format(new Date());
		long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.parse(formattedDate), LocalDate.parse(localdate));
		if (monthsBetween < 24)
			throw new RuntimeException(
					"Vous devez avoir au moin deux ans au sein de Capgemini pour pouvoir S'inscrire");
		// Generer Exception Matricule existe deja
		Utilisateur user1 = iAccountService.findUtilisateurByMatricule(userForm.getMatricule());
		if (user1 != null)
			throw new RuntimeException("this user already exists By Matricule ");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUsername(userForm.getUsername());
		utilisateur.setPassword(userForm.getPassword());
		utilisateur.setDateIntegrationCap(userForm.getDateIntegrationCap());
		utilisateur.setMatricule(userForm.getMatricule());
		utilisateur.setAdresse(userForm.getAdresse());
		utilisateur.setGmail(userForm.getGmail());
		utilisateur.setGrade(userForm.getGrade());
		utilisateur.setNom(userForm.getNom());
		utilisateur.setPrenom(userForm.getPrenom());
		utilisateur.setTechnologie(userForm.getTechnologie());
		utilisateur.setSexe(userForm.getSexe());
		utilisateur.setVilleTravail(userForm.getVilleTravail());
		utilisateur.setProfil(userForm.getProfil());
		utilisateur.setTelephone(userForm.getTelephone());
		
		
		iAccountService.saveUser(utilisateur);
		iAccountService.addRoleToUser(userForm.getUsername(), "USER");
		return utilisateur;

	}

	@PostMapping("/saveRole")
	public AppRole saveRole(@RequestBody AppRole role) {
		return iAccountService.saveRole(role);
	}

	@PostMapping("/addRoleToUser")
	public void addRoleToUser(@RequestBody String username, @RequestBody String roleName) {
		iAccountService.addRoleToUser(username, roleName);
	}

	@GetMapping("/findUserByUsername/{username}")
	public Utilisateur findUtilisateurByLogin(@PathVariable String username) {
		return iAccountService.findUtilisateurByUsername(username);
	}

}
