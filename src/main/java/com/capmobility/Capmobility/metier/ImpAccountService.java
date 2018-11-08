package com.capmobility.Capmobility.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capmobility.Capmobility.Repository.RoleRepository;
import com.capmobility.Capmobility.Repository.UtilisateurRepository;
import com.capmobility.Capmobility.model.AppRole;
import com.capmobility.Capmobility.model.Utilisateur;

@Service
@Transactional
public class ImpAccountService implements IAccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Utilisateur saveUser(Utilisateur utilisateur) {
		String hashPW = bCryptPasswordEncoder.encode(utilisateur.getPassword());
		utilisateur.setPassword(hashPW);
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		Utilisateur Utilisateur = utilisateurRepository.findByUsername(username);
		Utilisateur.getRoles().add(role);

	}

	@Override
	public Utilisateur findUtilisateurByUsername(String username) {

		return utilisateurRepository.findByUsername(username);
	}

}
