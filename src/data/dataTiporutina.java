package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.*;



public class dataTiporutina {
	
	private String buscabyIdtipo = "select * from Tiporutina where idtipo LIKE %?";
	private String getOnebyIdtipo="select * from Tiporutina where idtipo=? ";
	private String newTiporutina="insert into tiporutina (`idtipo`, `descripcion`) VALUES (?,?)";
	private String deleteTiporutina= "delete from tiporutina where idtipo=?";
	private String modifica= "UPDATE tiporutina SET `idtipo` = ?,`descripcion` =? WHERE `idtipo` = ?";
	
	
	
public LinkedList<TipoRutina> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<TipoRutina> tip= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Tiporutina");
			
			if(rs!=null) {
				while(rs.next()) {
					TipoRutina t=new TipoRutina();
					
					t.setId_tipo(rs.getInt("id tipo"));
					t.setDescripcion(rs.getString("descripcion"));
					
					tip.add(t);
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
		
		
		return tip;
	}
	public TipoRutina getOne(int idtipo) {
		TipoRutina laTipoRutina= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyIdtipo);
			ps.setInt(1, idtipo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laTipoRutina = new TipoRutina();
					laTipoRutina.setId_tipo(rs.getInt("id tipo"));
					laTipoRutina.setDescripcion(rs.getString("descripcion"));
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
		return laTipoRutina;
	
	}
	public void add(TipoRutina t) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newTiporutina);
			ps.setInt(1, t.getId_tipo());
			ps.setString(2, t.getDescripcion());
			
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
	
	public void delete (int idtipo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteTiporutina);
			ps.setInt(1, idtipo);
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

	public void update (TipoRutina t, int idtipoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setInt(1, t.getId_tipo());
			ps.setString(2, t.getDescripcion());
			ps.setInt(3, idtipoold);
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
            }}
		 
		
		
		
		

		
	
