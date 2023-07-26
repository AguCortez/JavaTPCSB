package data;

<<<<<<< Updated upstream
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Clase;
import entites.Socio;
import entites.TipoClase;
=======
import java.sql.*;
import java.util.LinkedList;

import entites.Profesional;
import entites.Socio;
>>>>>>> Stashed changes


public class dataTipoClase {
	
<<<<<<< Updated upstream
	private String buscabyNombre = "select * from tipo_clase where `nombre_clase` LIKE %?";
	private String getOnebyCodigo="select * from tipo_clase where `idtipo_clase` =? ";
	private String newTipoClase="insert into tipo_clase (`idtipo_clase`, `nombre_clase`, `descripcion`) VALUES (?,?,?)";
	private String deleteTipoClase= "delete from tipo_clase where `idtipo_clase` =? ";
    private String modifica= "UPDATE tipo_clase SET `idtipo_clase` = ?,`nombre_clase` =?,`descripcion` = ? WHERE `idtipo_clase` = ?;";
=======

	private String buscabyNombre = "select * from tipo_clase where nombre LIKE %?";
	private String newTipoClase="insert into tipo_clase (`idtipo_clase`, `nombre_clase`, `descripcion`) VALUES (?,?,?)";
	private String deleteTipoClase= "delete from tipo_clase where idtipo_clase = ?";
	private String modifica= "UPDATE tipo_clase SET `idtipo_clase` = ?,`nombre_clase` =?,`descripcion` = ? WHERE `idtipo_clase` = ?";

	
	
	

>>>>>>> Stashed changes
	
	public LinkedList<TipoClase> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
<<<<<<< Updated upstream
		LinkedList<TipoClase> tipoclases= new LinkedList<>();
=======
		LinkedList<TipoClase> prof= new LinkedList<>();
>>>>>>> Stashed changes
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tipo_clase");
			
			if(rs!=null) {
				while(rs.next()) {
<<<<<<< Updated upstream
					TipoClase c =new TipoClase();
					
					c.setIdtipo_clase(rs.getInt("idtipo_clase"));
					c.setNombre_clase(rs.getString("nombre_clase"));
					c.setDescripcion(rs.getString("descripcion"));
					tipoclases.add(c);
=======
					Profesional p=new Profesional();
					
					p.setDni(rs.getInt("dni"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setContrasenia(rs.getString("contrasenia"));				
					
					prof.add(p);
>>>>>>> Stashed changes
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
		
		
<<<<<<< Updated upstream
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
=======
		return prof;
	}
	
	public void add(Profesional p) {
>>>>>>> Stashed changes
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newTipoClase);
<<<<<<< Updated upstream
			ps.setInt(1, c.getIdtipo_clase());
			ps.setString(2, c.getNombre_clase());
			ps.setString(3, c.getDescripcion());
=======
			ps.setInt(1,p.getDni());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido());
			ps.setString(4,p.getContrasenia());
>>>>>>> Stashed changes
			
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
<<<<<<< Updated upstream
	public void delete (int codigo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteTipoClase);
			ps.setInt(1, codigo);
=======

	public void delete (int legajo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteProfesional);
			ps.setInt(1, legajo);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	public void update (TipoClase c, int codigoold) {
=======
	public void update (Profesional p, int legajoold) {
>>>>>>> Stashed changes
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
<<<<<<< Updated upstream
			ps.setInt(1, c.getIdtipo_clase());
			ps.setString(2, c.getNombre_clase());
			ps.setString(3, c.getDescripcion());
			ps.setInt(4,codigoold);
=======
			
			ps.setInt(1, p.getDni());
			ps.setString(2, p.getNombre());
			ps.setString(3,p.getApellido());
			ps.setString(4,p.getContrasenia());
			ps.setInt(5, legajoold);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		}
	
	public  LinkedList<TipoClase>  buscabyCodigo(String nombre) {
		LinkedList<TipoClase> clases= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyNombre);
			ps.setString(1, nombre);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					TipoClase c=new TipoClase();					
	      			c.setInt(rs.getIdtipo_clase("idtipo_clase"));
					c.setString(rs.getNombre_clase("nombre_clase"));
					c.setString(rs.getDescripcion("descripcion"));
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
=======
		
		
		}
	
	
	

		
	
}
>>>>>>> Stashed changes
