package models;

import play.db.jpa.Model;

public class Trajet extends Model{
	
	public String Ville_Depart;
	public String Ville_Arrive;
	public User Conducteur;
	
	public Trajet(String Ville_Depart, String Ville_Arrive, User Conducteur) {
	        this.Ville_Depart = Ville_Depart;
	        this.Ville_Arrive = Ville_Arrive;
	        this.Conducteur = Conducteur;
	 }
	
}

