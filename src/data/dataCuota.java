package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class dataCuota {
	
	private String buscabyNombre = "select * from Cuota where nombre LIKE %?";
	private String getOnebyDNI="select * from Cuota where dni=? ";
	
	private String newCuota="insert into cuota (`mes`, `precio`, `idcuota`, `dni`) VALUES (?,?,?,?)";
	private String deleteCuota= "delete from cuota where dni=?";
	private String modifica= "UPDATE cuota SET `mes` = ?,`precio` =?,`idcuota` = ?,`dni` = ? WHERE `dni` = ?";
	
	public LinkedList<Cuota> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Cuota> cuotas= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Cuota");
			
			if(rs!=null) {
				while(rs.next()) {
					Cuota c=new Cuota();
					
					c.setMes(rs.getString("mes"));
					c.setPrecio(rs.getString("precio"));
					c.setIdcuota(rs.getInt("id cuota"));
					c.setDni(rs.getInt("dni"));
									
					
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
	public Cuota getOne(int dni) {
		Cuota laCuota= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNI);
			ps.setInt(1, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laCuota=new Cuota();
					laCuota.setMes(rs.getString("mes"));
					laCuota.setPrecio(rs.getString("precio"));
					laCuota.setIdcuota(rs.getInt("id cuota"));
					laCuota.setDni(rs.getInt("dni"));
					
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
	public Cuota getUsuarioxContra(int dni, String contrasenia) {
		Cuota laCuota= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyDNIyContra);
			ps.setInt(1, dni);
			ps.setString(2, contrasenia);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					
					
					laCuota=new Cuota();
					laCuota.setMes(rs.getString("mes"));
					laCuota.setPrecio(rs.getString("precio"));
					laCuota.setIdcuota(rs.getInt("id cuota"));
					laCuota.setDni(rs.getInt("dni"));
					
				
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
			
			ps.setString(1, c.getMes());
			ps.setString(2,c.getPrecio());
			ps.setInt(3, c.getIdcuota());
			ps.setInt(4, c.getDni());
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
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteCuota);
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
	public void update (Cuota c, int dniold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			
			ps.setString(1, c.getMes());
			ps.setString(2,c.getPrecio());
			ps.setInt(3, c.getIdcuota());
			ps.setInt(4, c.getDni());
			ps.setInt(5, dniold);
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
	
	public  LinkedList<Cuota>  buscabyDni(Int dni) {
		LinkedList<Cuota> cuotas= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyDni);
			ps.setString(4, dni);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Cuota c=new Cuota();
					
					c.setMes(rs.getString("mes"));
					c.setPrecio(rs.getString("precio"));
					c.setIdcuota(rs.getInt("id cuota"));
					c.setDni(rs.getInt("dni"));
					
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
