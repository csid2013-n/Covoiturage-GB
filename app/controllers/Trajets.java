package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Trajets extends Controller {

    public static void index() {
		List<Trajet> trajetsDisponibles = Trajet.find("byIsDispo",true).fetch();
		render(trajetsDisponibles);
    }
    
    public static void mesTrajets(){
    	Utilisateur u = Utilisateur.findById(2L);
    	List<Trajet> trajetsDemandes = new ArrayList<Trajet>();
    	trajetsDemandes = Trajet.find("byIsDispoAndPassager_id",false,u.id).fetch();
		render(trajetsDemandes);  	
    }
    
    public static void demander(Long id){
    	Utilisateur u = Utilisateur.findById(2L);
    	Trajet trajetReserve = Trajet.findById(id);
    	trajetReserve.Passager = u;
    	trajetReserve.isDispo = false;
    	trajetReserve.save();
    	index();
    }
    
    public static void ajouterTrajets(Trajet trajet){
    	Utilisateur u = Utilisateur.findById(1L);
    	trajet.Conducteur = u;
    	trajet.save();
    	index();
    }
    
    public static void addTrajet(){
    	render();
    }

}