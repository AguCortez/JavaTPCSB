package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


import entites.Socio;


public class dataSocio {
	
	private String buscabyNombre = "select * from socio where nombre LIKE ?";
	private String getOnebyDNI="select * from socio where dni=? ";
	private String getOnebyDNIyContra="select * from socio where dni=? and contrasenia=?  ";
	private String newSocio="insert into socio (`dni`, `tipo`, `contrasenia`, `nombre`, `apellido`, `num_celular`) VALUES (?,?,?,?,?,?)";
	private String deleteSocio= "delete from socio where dni=?";
	private String modifica= "UPDATE socio SET `dni` = ?,`tipo` = ?,`contrasenia` = ?,`nombre` = ?,`apellido` = ?,`num_celular` =? WHERE `dni` = ?";
	
	public LinkedList<Socio> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Socio> pers= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from socio");
			
			if(rs!=null) {
				while(rs.next()) {
					Socio p=new Socio();
					
					p.setNombre_soc(rs.getString("nombre"));
					p.setApellido_soc(rs.getString("apellido"));
					p.setCelu(rs.getString("num_celular"));
					p.setDni(rs.getInt("dni"));
					p.setTipo(rs.getString("tipo"));				
					
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
	public Socio getOne(int dni) {
		Socio elSocio= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNI);
			ps.setInt(1, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elSocio=new Socio();
					elSocio.setDni(rs.getInt("dni"));
					elSocio.setTipo(rs.getString("tipo"));
					elSocio.setNombre_soc(rs.getString("nombre"));
					elSocio.setApellido_soc(rs.getString("apellido"));
					elSocio.setCelu(rs.getString("num_celular"));
					elSocio.setContrasenia(rs.getString("contrasenia"));
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
		return elSocio;
	}
	//este no sil :D
	public Socio getUsuarioxContra(int dni, String contrasenia) {
		Socio elSocio= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNIyContra);
			ps.setInt(1, dni);
			ps.setString(2, contrasenia);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elSocio=new Socio();
					elSocio.setDni(rs.getInt("dni"));
					elSocio.setTipo(rs.getString("tipo"));
					elSocio.setNombre_soc(rs.getString("nombre"));
					elSocio.setApellido_soc(rs.getString("apellido"));
					elSocio.setCelu(rs.getString("num_celular"));
					elSocio.setContrasenia(rs.getString("contrasenia"));
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
		return elSocio;
	}
	public void add(Socio s) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newSocio);
			ps.setInt(1, s.getDni());
			ps.setString(2, s.getTipo());
			ps.setString(3,s.getContrasenia());
			ps.setString(4,s.getNombre_soc());
			ps.setString(5, s.getApellido_soc());
			ps.setString(6, s.getCelu());
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
	public void delete (int dni) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteSocio);
			ps.setInt(1, dni);
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
	public void update (Socio s, int dniold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			ps.setInt(1, s.getDni());
			ps.setString(2, s.getTipo());
			ps.setString(3, s.getContrasenia());
			ps.setString(4, s.getNombre_soc());
			ps.setString(5, s.getApellido_soc());
			ps.setString(6, s.getCelu());
			ps.setInt(7, dniold);
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
	
	public  LinkedList<Socio>  buscabyNombre(String nombre) {
		LinkedList<Socio> socios= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyNombre);
			ps.setString(1, "%" + nombre + "%");
			rs=ps.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Socio s=new Socio();
					s.setNombre_soc(rs.getString("nombre"));
					s.setApellido_soc(rs.getString("apellido"));
					s.setCelu(rs.getString("num_celular"));
					s.setDni(rs.getInt("dni"));
					s.setTipo(rs.getString("tipo"));				
					
					socios.add(s);
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
		return socios;
	}

		
	
}