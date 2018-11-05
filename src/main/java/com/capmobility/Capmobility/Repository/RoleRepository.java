package com.capmobility.Capmobility.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capmobility.Capmobility.model.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName (String roleName);
}
