package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Clase;
import entites.Socio;


public class dataClase {
	
	private String buscabyNombre = "select * from clase where `dia` LIKE ?  ORDER BY `codigo` ASC";
	private String getOnebyCodigo="select * from clase where `codigo` =? ";
	private String newClase="insert into clase (`codigo`, `total_cupos`, `nombre`, `actual_cupos`, `dia`, `hora`,`dniP`) VALUES (?,?,?,?,?,?,?)";
	private String deleteClase= "delete from clase where `codigo` =? ";
    private String modifica= "UPDATE clase SET `codigo` = ?,`total_cupos` =?,`cupos_actuales` =?,`dia` = ?,`hora` =?, `legajo` = ? , `idtipo_clase` = ? WHERE `codigo` = ?;";
	
	public LinkedList<Clase> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Clase> clases= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from clase");
			
			if(rs!=null) {
				while(rs.next()) {
					Clase c=new Clase();
					
					c.setCodigo(rs.getInt("codigo"));
					c.setTotal_cupo(rs.getInt("total_cupos"));
					/* c.setNombre(rs.getString("nombre"));*/
					c.setCupos_actuales(rs.getInt("cupos_actuales"));
					c.setDia(rs.getString("dia"));
					c.setHora(rs.getString("hora"));				
					/* c.setDescripcion(rs.getString("descripcion"));*/
					c.setLegajo_prof(rs.getInt("legajo"));
					c.setidtipo_clase(rs.getInt("idtipo_clase"));
					
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
	public Clase getOne(int codigo) {
		Clase laClase= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyCodigo);
			ps.setInt(1, codigo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laClase=new Clase();
					laClase.setCodigo(rs.getInt("codigo"));
					laClase.setCupos_actuales(rs.getInt("cupos_actuales"));
					laClase.setTotal_cupo(rs.getInt("total_cupos"));
					laClase.setDia(rs.getString("dia"));
					laClase.setHora(rs.getString("hora"));
					laClase.setLegajo_prof(rs.getInt("legajo"));	
					laClase.setidtipo_clase(rs.getInt("idtipo_clase"));
	
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
			ps.setInt(1, c.getCodigo());
			ps.setInt(2, c.getTotal_cupo());
			ps.setString(3, c.getDia());
			ps.setInt(4, c.getCupos_actuales());
			ps.setString(5, c.getHora());
			ps.setInt(6, c.getLegajo_prof());
			ps.setInt(8, c.getidtipo_clase());
			
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
	public void update (Clase c, int codigoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setInt(1, c.getCodigo());
			ps.setInt(2, c.getTotal_cupo());
			ps.setString(3, c.getDia());
			ps.setString(4, c.getHora());
			ps.setString(5, c.getHora());
			ps.setInt(6,c.getLegajo_prof());
			ps.setInt(7,c.getidtipo_clase());
			ps.setInt(8, codigoold);
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
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyNombre);
			ps.setString(1,  "%" + codigo + "%");
			rs=ps.executeQuery();
			
				if(rs!=null){
					while(rs.next()) {
						Clase c=new Clase();
						c.setCodigo(rs.getInt("codigo"));
						c.setTotal_cupo(rs.getInt("total_cupos"));
						c.setCupos_actuales(rs.getInt("cupos_actuales"));
						c.setDia(rs.getString("dia"));
						c.setHora(rs.getString("hora"));				
						c.setLegajo_prof(rs.getInt("legajo"));
						c.setidtipo_clase(rs.getInt("idtipo_clase"));
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