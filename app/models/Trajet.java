package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Trajet extends Model{
	
	public String dateDepart;
	public String VilleDepart;
	public String VilleArrive;
	
	@ManyToOne
	public Utilisateur Conducteur;
	
	public Trajet(String dateDepart, String VilleDepart, String VilleArrive, Utilisateur Conducteur) {
	    this.dateDepart = dateDepart;    
		this.VilleDepart = VilleDepart;
	    this.VilleArrive = VilleArrive;
	    this.Conducteur = Conducteur;
	 }
	
}

