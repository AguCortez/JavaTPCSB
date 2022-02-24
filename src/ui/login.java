package ui;

import java.util.LinkedList;

import data.dataSocio;
import entites.Profesional;
import entites.Socio;
import util.profesionalUtil;


public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		LinkedList<Socio> sa=s.getAll();
	
		for(Socio xcv: sa) {
			
			System.out.println(xcv.toString());
		}
			
		profesionalUtil pu=new profesionalUtil();
		LinkedList<Profesional> profes=pu.getAll();
		for(Profesional p:profes){System.out.println(p.getApellido());}
		
	}

}
