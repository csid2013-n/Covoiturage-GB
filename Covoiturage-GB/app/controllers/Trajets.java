package controllers;

import java.util.List;

import models.Trajet;
import play.mvc.Controller;

public class Trajets extends Controller {

	public void index(){
		List<Trajet> trajetsDisponibles = Trajet.findAll();
		render(trajetsDisponibles);
	}
	
}
