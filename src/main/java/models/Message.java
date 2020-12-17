package models;

import interfaces.Destinataire;

public class Message {
	
	private Utilisateur auteur;
	private Destinataire destinataire;
	private String text;
	
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public Destinataire getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

	
	
	
	
}
