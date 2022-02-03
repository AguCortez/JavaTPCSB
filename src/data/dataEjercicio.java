package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entites.Ejercicio;


public class dataEjercicio {
	
	private String buscabyID = "select * from Ejercicio where idejercicio LIKE %?";
	private String getOnebyID="select * from Ejercicio where idejercicio=? ";
	private String newEjer="insert into ejercio (`repeticiones`, `peso`, `series`, `descripcion`, `nombre_maquina`, `idejercicio`, `idrutina`) VALUES (?,?,?,?,?,?,?)";
	private String deleteEjer= "delete from socio where dni=?";
	private String modifica= "UPDATE ejercicio SET `repeticiones` = ?,`peso` =?,`series` = ?,`descripcion` = ?,`nombre_maquina` = ?,`idejercicio` = ?,`idrutina` =? WHERE `idejercicio` = ?";
	
	public LinkedList<Ejercicio> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		LinkedList<Ejercicio> ejer= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Ejercicio");
			
			if(rs!=null) {
				while(rs.next()) {
					Ejercicio e=new Ejercicio();
					/*ver IDRUTINA  */
					
					e.setIdEjercicio(rs.getInt("idejercicio"));
					e.setDescripcion(rs.getString("descripcion"));
					e.setNombre_maquina(rs.getString("nombre_maquina"));
					e.setPeso(rs.getInt("peso"));
					e.setRepeticiones(rs.getInt("repeiciones"));
					e.setSeries(rs.getInt("series"));
					
					
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
					elEjer.setIdEjercicio(rs.getInt("idejercicio"));
					elEjer.setDescripcion(rs.getString("descripcion"));
					elEjer.setNombre_maquina(rs.getString("nombre_maquina"));
					elEjer.setPeso(rs.getInt("peso"));
					elEjer.setRepeticiones(rs.getInt("repeiciones"));
					elEjer.setSeries(rs.getInt("series"));
					
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
					elEjer.setRepeticiones(rs.getInt("repeiciones"));
					elEjer.setSeries(rs.getInt("series"));
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
				
			ps.setInt(1, ej.getIdEjercicio());
			ps.setString(2, ej.getDescripcion());
			ps.setString(3, ej.getNombre_maquina());
			ps.setInt(4, ej.getPeso());
			ps.setInt(5, ej.getRepeticiones());
			ps.setInt(6, ej.getSeries());
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
	
}