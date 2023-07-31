package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Clase;
import entites.Socio;
import entites.TipoClase;


public class dataTipoClase {
	private String nombreBuscar;
	private String buscabyNombre = "select * from tipo_clase where `nombre_clase` LIKE "+"'%"+"?"+"%'" ;
	private String getOnebyCodigo="select * from tipo_clase where `idtipo_clase` =? ";
	private String newTipoClase="insert into tipo_clase (`idtipo_clase`, `nombre_clase`, `descripcion`) VALUES (?,?,?)";
	private String deleteTipoClase= "delete from tipo_clase where `idtipo_clase` =? ";
    private String modifica= "UPDATE tipo_clase SET `idtipo_clase` = ?,`nombre_clase` =?,`descripcion` = ? WHERE `idtipo_clase` = ?;";
	public LinkedList<TipoClase> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<TipoClase> tipoclases= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tipo_clase");
			
			if(rs!=null) {
				while(rs.next()) {
					TipoClase c =new TipoClase();
					
					c.setIdtipo_clase(rs.getInt("idtipo_clase"));
					c.setNombre_clase(rs.getString("nombre_clase"));
					c.setDescripcion(rs.getString("descripcion"));
					tipoclases.add(c);
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
		
		
		return tipoclases;
	}
	public TipoClase getOne(int id) {
		TipoClase laClase= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyCodigo);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laClase=new TipoClase();
					laClase.setIdtipo_clase(rs.getInt("idtipo_clase"));
					laClase.setNombre_clase(rs.getString("nombre_clase"));
					laClase.setDescripcion(rs.getString("descripcion"));
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
	
	public void add(TipoClase c) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newTipoClase);
			ps.setInt(1, c.getIdtipo_clase());
			ps.setString(2, c.getNombre_clase());
			ps.setString(3, c.getDescripcion());
			
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
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteTipoClase);
			ps.setInt(1, codigo);
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
	public void update (TipoClase c, int codigoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setInt(1, c.getIdtipo_clase());
			ps.setString(2, c.getNombre_clase());
			ps.setString(3, c.getDescripcion());
			ps.setInt(4,codigoold);
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
	
	public  LinkedList<TipoClase>  buscabyCodigo(String nombre) {
		LinkedList<TipoClase> clases= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		nombreBuscar = null;
		try {
			nombreBuscar = nombre;
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyNombre);
			ps.setString(1, nombre);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					TipoClase c =new TipoClase();
					c.setIdtipo_clase(rs.getInt("idtipo_clase"));
					c.setNombre_clase(rs.getString("nombre_clase"));
					c.setDescripcion(rs.getString("descripcion"));
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