package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entites.Cuota;

public class dataCuota {

	private String buscaDNI = "select * from Cuota where dni LIKE %?";
	private String getOnebyDNI="select * from Cuota where dni=? ";
	private String newCuota="insert into cuota (`idCuota`, `anio`, `mes`, `precio`, `fecha_pago`) VALUES (?,?,?,?,?)";
	private String modifica= "UPDATE cuota SET `idCuota` = ?,`anio` =?,`mes` = ?,`precio` = ?,`fecha_pago` = ?";
	private String delete= "delete from cuota where dni=?";



	
	public LinkedList<Cuota> getAll() {
		return null;
	}

	public  LinkedList<Cuota>buscaDNI(int dni) {
		LinkedList<Cuota> cuotas= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscaDNI);
			ps.setInt(1, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Cuota c=new Cuota();
					c.setFecha_pago(String.valueOf(rs.getDate("fecha_pago")));
					c.setAnio(rs.getInt("anio"));
					c.setMes(rs.getInt("mes"));
					c.setPrecio(rs.getInt("precio"));
					c.setIdCuota(rs.getInt("idCuota"));
					
					cuotas.add(c);
				}}} 
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
		return cuotas;
	}
	public Cuota getOne(int dni) {
		Cuota cuotax= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNI);
			ps.setInt(1, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					cuotax=new Cuota();
					cuotax.setFecha_pago(String.valueOf(rs.getDate("fecha_pago")));
					cuotax.setAnio(rs.getInt("anio"));
					cuotax.setMes(rs.getInt("mes"));
					cuotax.setPrecio(rs.getInt("precio"));
					cuotax.setIdCuota(rs.getInt("idCuota"));
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
		return cuotax;
	}
	
	
	public void add(Cuota c) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newCuota);
			ps.setInt(1,c.getIdCuota());
			ps.setDate(2,c.getFecha_pago());
			ps.setInt(2,c.getMes());
			ps.setInt(4,c.getPrecio());
			ps.setInt(5,c.getAnio());
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
	
	public void update (Cuota c, int dni) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			ps.setInt(1,c.getIdCuota());
			ps.setDate(2,c.getFecha_pago());
			ps.setInt(2,c.getMes());
			ps.setInt(4,c.getPrecio());
			ps.setInt(5,c.getAnio());
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
}
