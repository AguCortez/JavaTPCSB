package data;

import java.sql.PreparedStatement;


public class dataTiporutina {
	
	private String buscabyIdtipo = "select * from Tiporutina where idtipo LIKE %?";
	private String getOnebyIdtipo="select * from Tiporutina where idtipo=? ";
	
	private String newTiporutina="insert into tiporutina (`idtipo`, `descripcion`) VALUES (?,?)";
	private String deleteTiporutina= "delete from tiporutina where idtipo=?";
	private String modifica= "UPDATE tiporutina SET `idtipo` = ?,`descripcion` =? WHERE `idtipo` = ?";
	
	
	
public LinkedList<Tiporutina> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		LinkedList<Tiporutina> tip= new LinkedList<>();
		
		try {
			stmt= dbConector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from Tiporutina");
			
			if(rs!=null) {
				while(rs.next()) {
					Tiporutina t=new Tiporutina();
					
					t.setIdtipo(rs.getInt("id tipo"));
					t.setDescripcion(rs.getString("descripcion"));
					
					tip.add(t);
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
		
		
		return tip;
	}
	public Tiporutina getOne(int idtipo) {
		Tiporutina laTiporutina= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(getOnebyIdtipo);
			ps.setInt(1, idtipo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{
					laTiporutina = new Tiporutina();
					laTiporutina.setIdtipo(rs.getInt("id tipo"));
					laTiporutina.setDescripcion(rs.getString("descripcion"));
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
		return laTiporutina;
	
	}
	public void add(Tiporutina t) {
		PreparedStatement ps=null;
		
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(newTiporutina);
			ps.setInt(1, t.getIdtipo());
			ps.setString(2, t.getDescripcion());
			
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
	public void delete (int idtipo) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(deleteTiporutina);
			ps.setInt(1, idtipo);
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
	public void update (Tiporutina t, int idtipoold) {
		PreparedStatement ps=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(modifica);
			
			ps.setInt(1, t.getIdtipo());
			ps.setString(2, t.getDescripcion());
			ps.setInt(3, idtipoold);
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
	
	public  LinkedList<Tiporutina>  buscabyIdtipo(int idtipo) {
		LinkedList<Tiporutina> Tiporutinas= new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=dbConector.getInstancia().getConn().prepareStatement(buscabyIdtipo);
			ps.setString(1, idtipo);
			rs=ps.executeQuery();
			
				if(rs!=null && rs.next())
				{while(rs!=null && rs.next()) {
					Tiporutina t=new Tiporutina();
					
					
					t.setIdtipo(rs.getInt("id tipo"));
					t.setDescripcion(rs.getString("descripcion"));
									
					
					Tiporutinas.add(t);
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
		return Tiporutinas;
	}

		
	
