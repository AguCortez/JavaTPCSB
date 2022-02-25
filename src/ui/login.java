package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
import data.dataSocio;
import entites.Clase;
import entites.Profesional;
import entites.Socio;
import entites.Usuario;
import util.UsuarioUtil;
import util.claseUtil;
import util.profesionalUtil;


public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		DataUsuario du= new DataUsuario();
		profesionalUtil pu=new profesionalUtil();
		LinkedList<Usuario> sa=du.getAll();
		String nombre="";
		int lvl=0;
		for(Usuario xcv: sa) {
			
			System.out.println(xcv.getNivel()+" "+xcv.getDni()+ " "+ xcv.getContrasenia());
		}
		Usuario su= new Usuario();
		
		
		su=du.getUsuarioxContra(111,"java");
		
		UsuarioUtil uu=new UsuarioUtil();
		// lvl=uu.nivellogin(12, "123");
		System.out.println(lvl+" "+su.getNivel());
		}
	}


