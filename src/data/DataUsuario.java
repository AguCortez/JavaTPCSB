package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entites.Socio;

public class DataUsuario {

	private String newSocio="insert into usuario (`dni`, `contrasenia`, `nivel`) VALUES (?,?,1)";
	private String newProfe="insert into usuario (`dni`, `contrasenia`, `nivel`) VALUES (?,?,2)";
	private String delete= "delete from socio where dni=?";
	private String modifica= "UPDATE usuario SET `dni` = ?,`contrasenia` = ? WHERE `dni` = ?";
	
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
