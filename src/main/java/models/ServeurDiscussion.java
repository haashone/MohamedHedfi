package models;

import java.util.*;

import enumerations.Habilitation;

public class ServeurDiscussion {
	
	private String nom;
	private Map<Role, List<Utilisateur>> mapping_role_utilisateurs = new HashMap<Role, List<Utilisateur>>();
	private List<Canal> canaux = new ArrayList<Canal>();
	private Map<Role, List<Habilitation>> mapping_role_habilitation = new HashMap<Role, List<Habilitation>>();

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<Role, List<Utilisateur>> getMapping_role_utilisateurs() {
		return mapping_role_utilisateurs;
	}

	public void setMapping_role_utilisateurs(Map<Role, List<Utilisateur>> mapping_role_utilisateurs) {
		this.mapping_role_utilisateurs = mapping_role_utilisateurs;
	}

	public List<Canal> getCanaux() {
		return canaux;
	}

	public void setCanaux(List<Canal> canaux) {
		this.canaux = canaux;
	}

	public Map<Role, List<Habilitation>> getMapping_role_habilitation() {
		return mapping_role_habilitation;
	}

	public void setMapping_role_habilitation(Map<Role, List<Habilitation>> mapping_role_habilitation) {
		this.mapping_role_habilitation = mapping_role_habilitation;
	}


	
	public ServeurDiscussion() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
