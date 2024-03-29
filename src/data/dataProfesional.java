package data;

import java.sql.*;
import java.util.LinkedList;

import entites.Profesional;
import entites.Socio;
import entites.TipoClase;


public class dataProfesional {
	

	private String buscabyNombre = "select * from profesional where nombre LIKE ?";
	private String getOnebyLEGAJO="select * from profesional where dni=? ";
	
	private String newProfesional="insert into profesional (`dni`, `nombre`, `apellido`, `contrasenia`) VALUES (?,?,?,?)";
	private String deleteProfesional= "delete from profesional where dni = ?";
	private String modifica= "UPDATE profesional SET `dni` = ?,`nombre` =?,`apellido` = ?,`contrasenia` = ? WHERE `dni` = ?";

	
	
	

	
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
					
					p.setDni(rs.getInt("dni"));
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
	public Profesional getOne(int dni) {
		Profesional elProfesional= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyLEGAJO);
			ps.setInt(1, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elProfesional=new Profesional();
					
					elProfesional.setDni(rs.getInt("dni"));
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
	public  LinkedList<Profesional>  buscabyNombre(String nombre) {
		LinkedList<Profesional> profesionales= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyNombre);
			ps.setString(1, "%" + nombre + "%");
			rs=ps.executeQuery();

			if(rs!=null) {
				while(rs.next()) {
					Profesional c =new Profesional();
					c.setDni(rs.getInt("dni"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setContrasenia(rs.getString("contrasenia"));
					profesionales.add(c);
				}
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
			}		}		
		return profesionales;
	}
	
	

		
	
}
