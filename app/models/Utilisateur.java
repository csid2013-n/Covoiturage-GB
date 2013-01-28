package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Utilisateur extends Model{
	
	@MaxSize(64)
	@Required
	public String nom;
	
	@MaxSize(32)
	@Required
	public String prenom;
	
	@MaxSize(128)
	@Email
	@Required
	public String email;
	
	@MinSize(6)
	@MaxSize(32)
	@Required
	public String password;
	
	
	public Utilisateur(String nom, String prenom, String email, String password){
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public static Utilisateur connect(String Email, String Password) {
	    return find("byEmailAndPassword", Email, Password).first();
	}

	
	public String toString() {
	    return email;
	}

}
