package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Cuota;
import entites.Socio;

public class dataCuota {

	private String buscaIDCUOTA = "select * from cuota where idcuota LIKE %?";
	private String getOnebyIDCUOTA="select * from cuota where idcuota=? ";
	private String newCuota="insert into cuota (`mes`, `precio`, `idcuota`, `dni`, `anio` , `fecha_pago`) VALUES (?,?,?,?,?,?)";
	private String modifica= "UPDATE cuota SET `mes` = ?,`precio` =?,`idcuota` = ?,`dni` = ?,`anio` = ?,`fecha_pago` = ?";
	private String deleteCuota= "delete from cuota where idcuota=?";

	
		public LinkedList<Cuota> getAll(){
			
			Statement stmt=null;
			ResultSet rs=null;
			LinkedList<Cuota> cuotas= new LinkedList<>();
			
			try {
				stmt= dbConector.getInstancia().getConn().createStatement();
				rs= stmt.executeQuery("select * from cuota");
				
				if(rs!=null) {
					while(rs.next()) {
						Cuota c=new Cuota();
						
						c.setMes(rs.getInt("mes"));
						c.setPrecio(rs.getInt("precio"));
						c.setIdCuota(rs.getInt("idcuota"));
						c.setDni(rs.getInt("dni"));
						c.setAnio(rs.getInt("anio"));				
						c.setFecha_pago(rs.getString("fecha_pago"));
						
						cuotas.add(c);
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
			
			
			return cuotas;
		}
		public Cuota getOne(int idcuota) {
			Cuota laCuota= null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyIDCUOTA);
				ps.setInt(1, idcuota);
				rs=ps.executeQuery();
				
					if(rs!=null && rs.next())
					{ 
						laCuota=new Cuota();
						laCuota.setMes(rs.getInt("mes"));
						laCuota.setPrecio(rs.getInt("precio"));
						laCuota.setIdCuota(rs.getInt("idcuota"));
						laCuota.setDni(rs.getInt("dni"));
						laCuota.setAnio(rs.getInt("anio"));
						laCuota.setFecha_pago(rs.getString("fecha_pago"));
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
			return laCuota;
		}
		
		public void add(Cuota c) {
			PreparedStatement ps=null;
			
			try {
				ps=dbConector.getInstancia().getConn().prepareStatement(newCuota);
				ps.setInt(1, c.getMes());
				ps.setInt(2, c.getPrecio());
				ps.setInt(3,c.getIdCuota());
				ps.setInt(4,c.getDni());
				ps.setInt(5, c.getAnio());
				ps.setString(6, c.getFecha_pago());
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
		public void delete (int idcuota) {
			PreparedStatement ps=null;
			try {
				ps=dbConector.getInstancia().getConn().prepareStatement(deleteCuota);
				ps.setInt(1, idcuota);
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
		public void update (Cuota c, int idcuotaold) {
			PreparedStatement ps=null;
			try {
				ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
				ps.setInt(1, c.getMes());
				ps.setInt(2, c.getPrecio());
				ps.setInt(3,c.getIdCuota());
				ps.setInt(4,c.getDni());
				ps.setInt(5, c.getAnio());
				ps.setString(6, c.getFecha_pago());
				ps.setInt(7, idcuotaold);
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
		
		public  LinkedList<Cuota>  buscaIDCUOTA(String idcuota) {
			LinkedList<Cuota> cuotas= new LinkedList<>();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=dbConector.getInstancia().getConn().prepareStatement(buscaIDCUOTA);
				ps.setString(1, "%" + idcuota + "%");
				rs=ps.executeQuery();
				
				if(rs!=null) {
					while(rs.next()) {
						Cuota c=new Cuota();
                        c.setMes(rs.getInt("mes"));
						c.setPrecio(rs.getInt("precio"));
						c.setIdCuota(rs.getInt("idcuota"));
						c.setDni(rs.getInt("dni"));
						c.setAnio(rs.getInt("anio"));
						c.setFecha_pago(rs.getString("fecha_pago"));
									
						
						cuotas.add(c);
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
			return cuotas;
		}

			
		
	}
