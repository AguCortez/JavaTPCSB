package data;

import java.sql.*;
import java.util.LinkedList;

import entites.Profesional;
import entites.Socio;


public class dataProfesional {
	
	private String buscabyNombre = "select * from Profesional where nombre LIKE %?";
	private String getOnebyLEGAJO="select * from Profesional where legajo=? ";
	
	private String newProfesional="insert into Profesional (`legajo`, `nombre`, `apellido`, `contrase�a`) VALUES (?,?,?,?)";
	private String deleteProfesional= "delete from profesional where legajo=?";
	private String modifica= "UPDATE profesional SET `legajo` = ?,`nombre` =?,`apellido` = ?,`contrase�a` = ? WHERE `legajo` = ?";
	
	public LinkedList<Profesional> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Profesional> prof= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from profesional");
			
			if(rs!=null) {
				while(rs.next()) {
					Profesional p=new Profesional();
					
					p.setDni(rs.getInt("legajo"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setContrasenia(rs.getString("contrasenia"));				
					
					prof.add(p);
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
		
		
		return prof;
	}
	public Profesional getOne(int legajo) {
		Profesional elProfesional= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyLEGAJO);
			ps.setInt(1, legajo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elProfesional=new Profesional();
					
					elProfesional.setDni(rs.getInt("legajo"));
					elProfesional.setNombre(rs.getString("nombre"));
					elProfesional.setApellido(rs.getString("apellido"));
					elProfesional.setContrasenia(rs.getString("contrasenia"));
				}
				
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs!=null) {rs.close();}
				if(ps!=null) {ps.close();}
				dbConector.getInstancia().releaseConn();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return elProfesional;
	}
	
	public void add(Profesional p) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newProfesional);
			ps.setInt(1,p.getDni());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido());
			ps.setString(4,p.getContrasenia());
			
			ps.executeUpdate();
	 		}
		catch(SQLException e)
		{
            e.printStackTrace();
		} 
		finally {
            try {               
                if(ps!=null)ps.close();
                dbConector.getInstancia().releaseConn();
            } 
            catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	
	
	
	
	
	

	public void delete (int legajo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteProfesional);
			ps.setInt(1, legajo);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
            e.printStackTrace();
		} 
		finally {
            try {               
                if(ps!=null)ps.close();
                dbConector.getInstancia().releaseConn();
            } 
            catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		
	}
	public void update (Profesional p, int legajoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			
			ps.setInt(1, p.getDni());
			ps.setString(2, p.getNombre());
			ps.setString(3,p.getApellido());
			ps.setString(4,p.getContrasenia());
			ps.setInt(5, legajoold);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
            e.printStackTrace();
		} 
		finally {
            try {               
                if(ps!=null)ps.close();
                dbConector.getInstancia().releaseConn();
            } 
            catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		
		}
	
	
	

		
	
}
