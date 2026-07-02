package main;

import hechizos.*;
import personajes.Auror;
import personajes.Comandante;
import personajes.Personaje;
import testBatalla.*;

public class Main2 {

	public static void main(String[] args) {
		
		Personaje p1 = new Auror("Gian");
		Personaje p2 = new Comandante("Mauri");
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1.lanzarHechizo(new Protego(), p1));
		p2.lanzarHechizo(new AvadaKedavra(), p1);
		p2.lanzarHechizo(new AvadaKedavra(), p1);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
