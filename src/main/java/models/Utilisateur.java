package models;

import java.util.ArrayList;
import java.util.List;

import interfaces.Destinataire;

public class Utilisateur implements Destinataire{
	
	
	
	
	private String prenom;
	private String nom;
	private String login;
	private String motDePasse;
	private String mail;
	private List<ServeurDiscussion> serveurs = new ArrayList<ServeurDiscussion>();
	
	public Utilisateur() {
		
	}
	
	
	
	
	
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<ServeurDiscussion> getServeurs() {
		return serveurs;
	}

	public void setServeurs(List<ServeurDiscussion> serveurs) {
		this.serveurs = serveurs;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	


	
	

}
