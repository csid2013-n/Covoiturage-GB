package controllers;

import play.cache.Cache;
import play.data.validation.*;
import play.libs.Codec;
import play.libs.Images;
import play.mvc.*;

import java.util.*;

import models.*;


public class Utilisateurs extends Controller{
	
	

	public static void index(){
		String randomID = Codec.UUID();
		render(randomID);
	}
	
	public static void Inscription(
			@Required(message = "Le Nom doit être renseigné.") String nom,
			@Required(message = "Le Prénom doit être renseigné.") String prenom,
			@Email @Required(message = "L'Email doit être renseigné.") String email,
			@Required(message = "Le mot de passe doit être renseigné.") String password,
			@Required(message = "La confirmation du mot de passe doit être renseigné.") String confirmePassword,
			@Required(message = "Veuillez entrer le code") String code,
			String randomID) {
		validation.equals(code, Cache.get(randomID)).message(
				"Code invalide. Veuillez le retapez");
		if (validation.hasErrors()) {
			render("Utilisateurs/index.html", randomID);
		}

		validation.equals(password, confirmePassword).message(
				"La confirmation du mot de passe ne correspond pas.");
		if (validation.hasErrors()) {
			render("Utilisateurs/index.html", randomID);
		}

		Utilisateur user = Utilisateur.find("byEmail", email).first();
		if (user != null) {
			validation.addError(email, "Vous êtes déja inscrit sur notre site.");
			render("Application/index.html", randomID);
		}
		
		Utilisateur newUser = new Utilisateur(nom, prenom, email, password);
		newUser.create();
		flash.success("Merci pour votre inscription ! %s", prenom);
		Cache.delete(randomID);
		index();
	}
	
	public static void captcha(String id) {
		Images.Captcha captcha = Images.captcha();
		String code = captcha.getText("#E4EAFD");
		Cache.set(id, code, "10mn");
		renderBinary(captcha);
	}
	
	public static void Connexion(
			@Email @Required(message = "L'Email doit être renseigné.") String emailConnect,
			@Required(message = "Le mot de passe doit être renseigné.") String passwordConnect) {

		Utilisateur user = Utilisateur.connect(emailConnect, passwordConnect);
		if (user != null) {
			String name = user.nom;
			render("Connecter/index.html", name);
		} else
			index();
	}

}
