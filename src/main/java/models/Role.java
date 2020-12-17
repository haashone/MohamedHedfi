package models;

import java.util.ArrayList;
import java.util.List;

import enumerations.Habilitation;

public class Role {
	
	private String nomRole;
	
	
	public Role() {
		
	}
	public Role(String nomRole) {
		this.nomRole = nomRole;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomRole == null) ? 0 : nomRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (nomRole == null) {
			if (other.nomRole != null)
				return false;
		} else if (!nomRole.equals(other.nomRole))
			return false;
		return true;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	
	/**
	 * Fonction permet de créer un Admin
	 * Admin possède tous les rôles dans tous ses serveurs de discussions
	 * 
	 */

	public void CreerRoleAdmin() {
		
		Utilisateur admin = new Utilisateur();
		Role r = new Role();
		r.setNomRole("Admin");
		List<Habilitation> tousHabilitations = new ArrayList<Habilitation>();
		
		for(Habilitation h : Habilitation.values()) {
			tousHabilitations.add(h);
		}
		
		for(ServeurDiscussion sd : admin.getServeurs()){
			
			sd.getMapping_role_habilitation().put(r, tousHabilitations);
		}
		
	}
	
	

}
