package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Clase;
import entites.Socio;


public class dataClase {
	
	private String buscabyNombre = "select * from Clase where nombre LIKE %?";
	private String getOnebyCodigo="select * from Clase where codigo=? ";
	
	private String newClase="insert into clase (`codigo`, `total_cupos`, `nombre`, `actual_cupos`, `dia`, `hora`,`descripcion`,`legajo`) VALUES (?,?,?,?,?,?)";
	private String deleteClase= "delete from clase where codigo=?";
    private String modifica= "UPDATE clase SET `codigo` = ?,`total_cupos` =?,`nombre` = ?,`actual_cupos` = ?,`dia` = ?,`hora` =?, `descripcion` = ?,`legajo` = ?, WHERE `codigo` = ?";
	
	public LinkedList<Clase> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Clase> clases= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Clase");
			
			if(rs!=null) {
				while(rs.next()) {
					Clase c=new Clase();
					
					c.setCodigo(rs.getString("codigo"));
					c.setTotal_cupos(rs.getInt("total cupos"));
					c.setNombre(rs.getString("nombre"));
					c.setActual_cupos(rs.getInt("actual cupos"));
					c.setDia(rs.getDate("dia"));
					c.setHora(rs.getTime("hora"));				
					c.setDescripcion(rs.getString("descripcion"));
					c.setLegajo(rs.getInt("legajo"));
					
					clases.add(c);
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
		
		
		return clases;
	}
	public Clases getOne(int codigo) {
		Clases laClase= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebycodigo);
			ps.setInt(1, cogigo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laClase=new Clase();
					laClase.setCodigo(rs.getString("codigo"));
					laClase.setTotal_cupos(rs.getInt("total cupos"));
					laClase.setNombre(rs.getString("nombre"));
					laClase.setActual_cupos(rs.getInt("actual cupos"));
					laClase.setDia(rs.getDate("dia"));
					laClase.setHora(rs.getTime("hora"));
					laClase.setDescripcion(rs.getString("descripcion"));
					laClase.setLegajo(rs.getInt("legajo"));
					
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
		return laClase;
	}
	
	public void add(Clase c) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newClase);
			ps.setString(1, c.getCodigo());
			ps.setInt(2, c.getTotal_cupos());
			ps.setString(3,c.getNombre());
			ps.setInt(4,c.getActual_cupos());
			ps.setDate(5, c.getDate());
			ps.setTime(6, c.getHora());
			ps.setString(7,c.getDescripcion());
			ps.setInt(8,c.getLegajo());
			
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
	public void delete (int codigo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteClase);
			ps.setString(1, codigo);
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
	public void update (Clase c, int codigoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setString(1, c.getCodigo());
			ps.setInt(2, c.getTotal_cupos());
			ps.setString(3,c.getNombre());
			ps.setInt(4,c.getActual_cupos());
			ps.setDate(5, c.getDate());
			ps.setTime(6, c.getHora());
			ps.setString(7,c.getDescripcion());
			ps.setInt(8,c.getLegajo());
			ps.setInt(9, codigoold);
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
	
	public  LinkedList<Clase>  buscabyCodigo(String codigo) {
		LinkedList<Clase> clases= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyCodigo);
			ps.setString(1, codigo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Clase c=new Clase();
					
					c.setCodigo(rs.getString("codigo"));
					c.setTotal_cupos(rs.getInt("total cupos"));
					c.setNombre(rs.getString("nombre"));
					c.setActual_cupos(rs.getInt("actual cupos"));
					c.setDia(rs.getDate("dia"));	
					c.setHora(rs.getTime("hora"));
					c.setDescripcion(rs.getString("descripcion"));
					c.setLegajo(rs.getInt("legajo"));
					clases.add(c);
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
		return clases;
	}

		
	
}