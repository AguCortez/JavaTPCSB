package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.*;

public class DataUsuario {

	private String newSocio="insert into usuario (`dni`, `contrasenia`, `nivel`) VALUES (?,?,1)";

	private String newProfe="insert into usuario (`dni`, `contrasenia`, `nivel`) VALUES (?,?,2)";
	private String delete= "delete from socio where dni=?";
	private String modifica= "UPDATE usuario SET `dni` = ?,`contrasenia` = ? WHERE `dni` = ?";
	private String unlogin="select * from usuario where dni = ? and contra= ? ";
	
public LinkedList<Usuario> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Usuario> prof= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario");
			
			if(rs!=null) {
				while(rs.next()) {
					Usuario p=new Usuario();
					
					p.setDni(rs.getInt("dni"));
					p.setContrasenia(rs.getString("contra"));				
					p.setNivel(rs.getInt("nivel"));
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
	
	public Usuario getUsuarioxContra(int dni, String contrasenia) {
		int lvl=0;
		Usuario eluser= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(unlogin);
			ps.setInt(1, dni);
			ps.setString(2, contrasenia);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					eluser=new Usuario();
					lvl=rs.getInt("nivel");								
					eluser.setDni(rs.getInt("dni"));					
					eluser.setContrasenia(rs.getString("contra"));
					eluser.setNivel(lvl);
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
		return eluser;
	}
	public void addSocio(Socio s) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newSocio);
			ps.setInt(1, s.getDni());
			ps.setString(2, s.getContrasenia());
			
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
			ps=dbConector.getInstancia().getConn().prepareStatement(delete);
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
			ps.setString(2, s.getContrasenia());		
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

}
