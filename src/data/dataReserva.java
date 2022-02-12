package data;

import java.sql.*;
import java.util.LinkedList;

import entites.Reserva;

public class dataReserva { 
	
	private String buscabyIdreserva = "select * from Reserva where idreserva LIKE %?";
	private String getOnebyDNI="select * from Reserva where dni=? ";
	
	private String newReserva="insert into reserva (`idreserva`, `fecha`, `dni`, `codigo`) VALUES (?,?,?,?)";
	private String deleteReserva= "delete from reserva where dni=?";
	private String modifica= "UPDATE reserva SET `idreserva` = ?,`fecha` =?,`dni` = ? WHERE `dni` = ?";
	
	public LinkedList<Reserva> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;	
		
		LinkedList<Reserva> res= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Reserva");
			
			if(rs!=null) {
				while(rs.next()) {
					Reserva r=new Reserva();
					
					r.setId_reserva(rs.getInt("id reserva"));
					r.setFecha(rs.getDate("fecha"));
					r.setDni(rs.getInt("dni"));								
					res.add(r);
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
		
		
		return res;
	}
	public Reserva getOne(int dni) {
		Reserva laReserva= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNI);
			ps.setInt(3, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laReserva =new Reserva();
					
					laReserva.setId_reserva(rs.getInt("id reserva"));
					laReserva.setFecha(rs.getDate("fecha"));
					laReserva.setDni(rs.getInt("dni"));
					
					
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
		return laReserva;
	}
	
	public void add(Reserva r) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newReserva);
			
			
			
			ps.setInt(1, r.getId_reserva());
			ps.setDate(2, r.getFecha());
			ps.setInt(3,r.getDni());			
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
	public void delete (int idreserva) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteReserva);
			ps.setInt(1, idreserva);
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
	public void update (Reserva r, int idreservaold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			
			ps.setInt(1, r.getId_reserva());
			ps.setDate(2, r.getFecha());
			ps.setInt(3,r.getDni());
			ps.setString(4,r.getCodigo());
			ps.setInt(5, idreservaold);
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
	
	public  LinkedList<Reserva>  buscabyId(int idreserva) {
		LinkedList<Reserva> reservas= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyIdreserva);
			ps.setInt(1, idreserva);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Reserva r=new Reserva();
					
					r.setId_reserva(rs.getInt("id reserva"));
					r.setFecha(rs.getDate("fecha"));
					r.setDni(rs.getInt("dni"));
					r.setCodigo(rs.getString("codigo"));
					
					reservas.add(r);
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
		return reservas;
	}

		
	
}