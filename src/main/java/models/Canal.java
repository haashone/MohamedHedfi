package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enumerations.Habilitation;
import interfaces.Destinataire;

public class Canal implements Comparable<Canal>, Destinataire {

	private int order;
	private String nom;
	private Map<Role, List<Utilisateur>> mapping_role_utilisateurs ;
	private List<Message> historiques ;
	private Map<Role, List<Habilitation>> mapping_role_habilitation;
	private List<Webhook> webhooks;
	
	public Canal() {
		mapping_role_utilisateurs = new HashMap<Role, List<Utilisateur>>();
		mapping_role_habilitation = new HashMap<Role, List<Habilitation>>();
		historiques = new ArrayList<Message>();
		webhooks = new ArrayList<Webhook>();
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

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

	public List<Message> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Message> historiques) {
		this.historiques = historiques;
	}

	public Map<Role, List<Habilitation>> getMapping_role_habilitation() {
		return mapping_role_habilitation;
	}

	public void setMapping_role_habilitation(Map<Role, List<Habilitation>> mapping_role_habilitation) {
		this.mapping_role_habilitation = mapping_role_habilitation;
	}

	public List<Webhook> getWebhooks() {
		return webhooks;
	}

	public void setWebhooks(List<Webhook> webhooks) {
		this.webhooks = webhooks;
	}

	public void ecrireMessage(Utilisateur u, Message m) {
		
		
		
		historiques.add(m);

	}

	public int compareTo(Canal o) {
		// TODO Auto-generated method stub
		return this.order - o.getOrder();
	}

}
