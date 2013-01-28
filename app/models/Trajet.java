package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.sf.oval.constraint.exclusion.Nullable;

import play.db.jpa.Model;

@Entity
public class Trajet extends Model{
	
	public String dateDepart;
	public String VilleDepart;
	public String VilleArrive;
	public boolean isDispo;
	
	@ManyToOne
	public Utilisateur Conducteur;
	
	@ManyToOne
	public Utilisateur Passager;
	
	public Trajet(String dateDepart, String VilleDepart, String VilleArrive, Utilisateur Conducteur, Utilisateur Passager, Boolean isDispo) {
	    this.dateDepart = dateDepart;    
		this.VilleDepart = VilleDepart;
	    this.VilleArrive = VilleArrive;
	    this.Conducteur = Conducteur;
	    this.isDispo = isDispo;
	    this.Passager = Passager;
	 }
	
}

