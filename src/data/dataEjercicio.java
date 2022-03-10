package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Ejercicio;


public class dataEjercicio {
	
	private String buscabyID = "select * from ejercicio where idejercicio LIKE %?";
	private String getOnebyID="select * from ejercicio where idejercicio=? ";
	private String newEjer=" INSERT INTO `gimnasiojava`.`ejercicio` (`repeticiones`, `peso`, `series`, `descripcion`, `nombre_maquina`, `idejercicio`, `idrutina`) VALUES (?,?, ?, ?, ?, ?, ?)";
	private String deleteEjer= "delete from socio where dni=?";
	private String modifica= "UPDATE ejercicio SET `repeticiones` = ?,`peso` =?,`series` = ?,`descripcion` = ?,`nombre_maquina` = ?,`idejercicio` = ?,`idrutina` =? WHERE `idejercicio` = ?";
	
	public LinkedList<Ejercicio> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		LinkedList<Ejercicio> ejer= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from ejercicio");
			
			if(rs!=null) {
				while(rs.next()) {
					Ejercicio e=new Ejercicio();
					
					e.setIdEjercicio(rs.getInt("idejercicio"));
					e.setDescripcion(rs.getString("descripcion"));
					e.setNombre_maquina(rs.getString("nombre_maquina"));
					e.setPeso(rs.getInt("peso"));
					e.setRepeticiones(rs.getInt("repeticiones"));
					e.setSeries(rs.getInt("series"));
					e.setIdrutina(rs.getInt("idrutina"));
					
					ejer.add(e);
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
		
		
		return ejer;
	}
	public Ejercicio getOne(int idejercicio) {
		Ejercicio elEjer = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyID);
			ps.setInt(1, idejercicio);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elEjer=new Ejercicio();
					elEjer.setIdEjercicio(rs.getInt("idejercicio"));
					elEjer.setDescripcion(rs.getString("descripcion"));
					elEjer.setNombre_maquina(rs.getString("nombre_maquina"));
					elEjer.setPeso(rs.getInt("peso"));
					elEjer.setRepeticiones(rs.getInt("repeticiones"));
					elEjer.setSeries(rs.getInt("series"));
					elEjer.setIdrutina(rs.getInt("idrutina"));
					
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
		return elEjer;
	}
	public Ejercicio getEjercicioxID(int idEjercicio) {
		Ejercicio elEjer= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyID);
			ps.setInt(1, idEjercicio);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elEjer=new Ejercicio();
					elEjer.setIdEjercicio(rs.getInt("idEjercicio"));
					elEjer.setDescripcion(rs.getString("descripcion"));
					elEjer.setNombre_maquina(rs.getString("nombre_maquina"));
					elEjer.setPeso(rs.getInt("peso"));
					elEjer.setRepeticiones(rs.getInt("repeticiones"));
					elEjer.setSeries(rs.getInt("series"));
					elEjer.setIdrutina(rs.getInt("idrutina"));
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
		return elEjer;
	}
	public void add(Ejercicio ej) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newEjer);
				
			ps.setInt(1, ej.getRepeticiones());
			ps.setInt(2, ej.getPeso());
			ps.setInt(3, ej.getSeries());
			ps.setString(4, ej.getDescripcion());
			
			ps.setString(5, ej.getNombre_maquina());
			ps.setInt(6, ej.getIdEjercicio());
	
			
			
			
			ps.setInt(7, ej.getIdrutina());
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
	public void delete (int idEjercicio) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteEjer);
			ps.setInt(1, idEjercicio);
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
	public void update (Ejercicio e, int idEjercicio) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			ps.setInt(1, e.getIdEjercicio());
			ps.setString(2, e.getDescripcion());
			ps.setString(3, e.getNombre_maquina());
			ps.setInt(4, e.getPeso());
			ps.setInt(5, e.getRepeticiones());
			ps.setInt(6, e.getSeries());
		}		
		
		catch(SQLException ej)
		{
            ej.printStackTrace();
		} 
		finally {
            try {               
                if(ps!=null)ps.close();
                dbConector.getInstancia().releaseConn();
            } 
            catch (SQLException ej) {
            	ej.printStackTrace();
            }
		}
		
		
		}
	public LinkedList<Ejercicio> buscabyID(int id) {
		LinkedList<Ejercicio> ejers= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyID);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Ejercicio e= new Ejercicio();
					
					e.setIdEjercicio(rs.getInt(id));
					e.setDescripcion(rs.getString("descripcion"));
					e.setNombre_maquina(rs.getString("nombre maquina"));
					e.setPeso(rs.getInt("peso"));
					e.setRepeticiones(rs.getInt("repeticiones"));
					e.setSeries(rs.getInt("series"));
					ejers.add(e);
					

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
		return ejers;
	}
		
		
}