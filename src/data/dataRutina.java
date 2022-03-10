package data; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Rutina;


public class dataRutina {
	
	private String buscabyidRutina = "select * from rutina where idRutina LIKE %?";
	private String getOnebyidRutina="select * from rutina where idRutina=? ";
	private String newRutina="insert into rutina (`dia`, `idRutina`, `dni`, `dniP`, `id_ejer`) VALUES (?,?,?,?,?)";
	private String deleteRutina= "delete from rutina where idRutina=?";
	private String modifica= "UPDATE rutina SET `dia` = ?,`idRutina` =?,`dni` = ?,`dniP` = ? WHERE `idRutina` = ?";
	
	public LinkedList<Rutina> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Rutina> rut= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from rutina");
			
			if(rs!=null) {
				while(rs.next()) {
					Rutina r=new Rutina();
					
					r.setDia(rs.getString("dia"));
					r.setIdRutina(rs.getInt("idRutina"));
					r.setDni(rs.getInt("dni"));
					r.setLegajo(rs.getInt("dniP"));
									
					
					rut.add(r);
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
		
		
		return rut;
	}
	public Rutina getOne(int idRutina) {
		Rutina laRutina= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyidRutina);
			ps.setInt(2, idRutina);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laRutina=new Rutina();
					laRutina.setDia(rs.getString("dia"));
					laRutina.setIdRutina(rs.getInt("idRutina"));
					laRutina.setDni(rs.getInt("dni"));
					laRutina.setLegajo(rs.getInt("dniP"));
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
		return laRutina;
	}
	
	
	public void add(Rutina r) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newRutina);
			ps.setString(1, r.getDia());
			ps.setInt(2, r.getIdRutina());
			ps.setInt(3,r.getDni());
			ps.setInt(4,r.getLegajo());
			ps.setInt(5,r.getId_ejer());
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
	public void delete (int idRutina) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteRutina);
			ps.setInt(2, idRutina);
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
	public void update (Rutina r, int idRutinaold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setString(1, r.getDia());
			ps.setInt(2, r.getIdRutina());
			ps.setInt(3,r.getDni());
			ps.setInt(4,r.getLegajo());
			ps.setInt(5, idRutinaold); 
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
	
	public  LinkedList<Rutina>  buscabyidRutina(int idRutina) {
		LinkedList<Rutina> rutinas= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyidRutina);
			ps.setInt(2, idRutina);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Rutina r=new Rutina();
					
					r.setDia(rs.getString("dia"));
					r.setIdRutina(rs.getInt("idRutina"));
					r.setDni(rs.getInt("dni"));
					r.setLegajo(rs.getInt("dniP"));
									
					
					rutinas.add(r);
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
		return rutinas;
	}

		
	
}
