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
    
    public static void demander(Long id){
    	Trajet trajetReserve = Trajet.findById(id);
    	trajetReserve.isDispo = false;
    	trajetReserve.save();
    	index();
    }

}