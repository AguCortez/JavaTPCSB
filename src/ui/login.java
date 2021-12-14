package ui;

import java.util.LinkedList;

import data.dataSocio;
import entites.Socio;
import util.sociosUtil;

public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		LinkedList<Socio> sa=s.getAll();
	
		for(Socio xcv: sa) {
			
			System.out.println(xcv.toString());
		}
			
		
		
	}

}
