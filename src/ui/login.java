package ui;

import data.dataSocio;
import entites.Socio;
import util.sociosUtil;

public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		
		for (Socio a : s.getAll())
		{
			
			System.out.println(a.toString());
		}
			
		
		
	}

}
