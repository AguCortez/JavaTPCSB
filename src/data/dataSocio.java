package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Socio;


public class dataSocio {
	
	public LinkedList<Socio> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Socio> pers= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Socio");
			
			if(rs!=null) {
				while(rs.next()) {
					Socio p=new Socio();
				
					p.setNombre_soc(rs.getString("nombre"));
					p.setApellido_soc(rs.getString("apellido"));
					p.setCelu(rs.getString("num_celular"));
					p.setDni(rs.getInt("dni"));
					
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				dbConector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return pers;
	}
	public void add(Socio s) {
	 /*blabla sql*/
	}
}
