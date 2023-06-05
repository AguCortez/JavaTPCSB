package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Ejercicio;


public class dataEjercicio {
	
	private String buscabyID = "select * from ejercicio where idtipo LIKE % ? %";
	private String getOnebyID="select * from ejercicio where idtipo=?";
	private String newEjer=" INSERT INTO `gimnasiojava`.`tipo_ejercicio` (`idtipo`,`descripcion` VALUES (?,?)";
	private String deleteEjer= "delete from tipo_ejercicio where `idtipo` = ?";
	private String modifica= "UPDATE ejercicio SET `descripcion` = ?,`idtipo` = ? WHERE `idtipo` = ?";	
	public LinkedList<Ejercicio> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		LinkedList<Ejercicio> ejer= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tipo_ejercicio");
			
			if(rs!=null) {
				while(rs.next()) {
					Ejercicio e=new Ejercicio();
					
					e.setIdtipo(rs.getInt("idtipo"));
					e.setDescripcion(rs.getString("descripcion"));
					ejer.add(e);
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
		
		
		return ejer;
	}
	public Ejercicio getOne(int idejercicio) {
		Ejercicio elEjer = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyID);
			ps.setInt(1, idejercicio);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elEjer=new Ejercicio();
					elEjer.setIdtipo(rs.getInt("idtipo"));
					elEjer.setDescripcion(rs.getString("descripcion"));
					
					
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
		return elEjer;
	}
	
	public void add(Ejercicio ej) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newEjer);
				
			ps.setString(2, ej.getDescripcion());			
			ps.setInt(1, ej.getIdtipo());
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
	public void delete (int idEjercicio) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteEjer);
			ps.setInt(1, idEjercicio);
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
	public void update (Ejercicio e, int idEjercicio) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setInt(1, e.getIdtipo());
			ps.setString(2, e.getDescripcion());
			
		}		
		
		catch(SQLException ej)
		{
            ej.printStackTrace();
		} 
		finally {
            try {               
                if(ps!=null)ps.close();
                dbConector.getInstancia().releaseConn();
            } 
            catch (SQLException ej) {
            	ej.printStackTrace();
            }
		}
		
		
		}
	
		
		
}