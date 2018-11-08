package com.capmobility.Capmobility.metier;

import com.capmobility.Capmobility.model.AppRole;
import com.capmobility.Capmobility.model.Utilisateur;

public interface IAccountService {
public Utilisateur saveUser(Utilisateur utilisateur );
public AppRole saveRole (AppRole role);
public void addRoleToUser(String username ,String roleName);
public Utilisateur findUtilisateurByUsername(String username);
}
