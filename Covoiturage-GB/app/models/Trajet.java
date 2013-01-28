package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Trajet extends Model{
	
	public String VilleDepart;
	public String VilleArrive;
	
	@ManyToOne
	public User Conducteur;
	
	public Trajet(String VilleDepart, String VilleArrive, User Conducteur) {
	        this.VilleDepart = VilleDepart;
	        this.VilleArrive = VilleArrive;
	        this.Conducteur = Conducteur;
	 }
	
}

