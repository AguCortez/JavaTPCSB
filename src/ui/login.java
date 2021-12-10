package ui;

import data.dataSocio;
import entites.Socio;
import util.sociosUtil;

public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		Socio sa= new Socio();
		sa=s.getOne(2);
	
		
			
			System.out.println(sa.toString());
		
			
		
		
	}

}
