package data;

import java.sql.PreparedStatement;


public class dataProfesional {
	
	private String buscabyNombre = "select * from Profesional where nombre LIKE %?";
	private String getOnebyLEGAJO="select * from Profesional where legajo=? ";
	
	private String newProfesional="insert into Profesional (`legajo`, `nombre`, `apellido`, `contraseña`) VALUES (?,?,?,?)";
	private String deleteProfesional= "delete from profesional where legajo=?";
	private String modifica= "UPDATE profesional SET `legajo` = ?,`nombre` =?,`apellido` = ?,`contraseña` = ? WHERE `legajo` = ?";
	
	public LinkedList<Profesional> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Profesional> prof= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Profesional");
			
			if(rs!=null) {
				while(rs.next()) {
					Profesional p=new Profesional();
					
					p.setLegajo(rs.getInt("legajo"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setContraseña(rs.getString("contraseña"));				
					
					prof.add(p);
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
		
		
		return prof;
	}
	public Profesional getOne(int legajo) {
		Profesional elProfesional= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyLEGAJO);
			ps.setInt(1, legajo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elProfesional=new Profesional();
					
					elProfesional.setLegajo(rs.getInt("legajo"));
					elProfesional.setNombre(rs.getString("nombre"));
					elProfesional.setApellido(rs.getString("apellido"));
					elProfesional.setContrasenia(rs.getString("contrasenia"));
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
		return elProfesional;
	}
	public Profesional getUsuarioxContra(int legajo, String contrasenia) {
		Profesional elProfesional= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyLegajoyContra);
			ps.setInt(1, legajo);
			ps.setString(4, contrasenia);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					elSocio=new Socio();
					
					
					elProfesional.setLegajo(rs.getInt("legajo"));
					elProfesional.setNombre(rs.getString("nombre"));
					elProfesional.setApellido(rs.getString("apellido"));
					elProfesional.setContrasenia(rs.getString("contrasenia"));
					
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
		return elProfesional;
	}
	public void add(Profesional p) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newProfesional);
			ps.setInt(1, p.getLegajo());
			ps.setString(2, p.getNombre());
			ps.setString(3,p.getApellido());
			ps.setString(4,p.getContraseña());
			
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
	public void delete (int legajo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteProfesional);
			ps.setInt(1, lagajo);
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
	public void update (Profesional p, int legajoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			
			ps.setInt(1, p.getLegajo());
			ps.setString(2, p.getNombre());
			ps.setString(3,p.getApellido());
			ps.setString(4,p.getContraseña());
			ps.setInt(5, legajoold);
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
	
	public  LinkedList<Profesional>  buscabyLegajo(Int legajo) {
		LinkedList<Profesional> Profesionales= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyLegajo);
			ps.setString(1, legajo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Profesional p=new Profesional();
					
					p.setLegajo(rs.getInt("legajo"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setContraseña(rs.getString("contraseña"));				
					
					profesionales.add(p);
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
		return profesionales;
	}

		
	
}
