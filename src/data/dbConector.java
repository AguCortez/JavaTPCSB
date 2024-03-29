package data;

import java.sql.*;

public class dbConector {

	private static dbConector instancia;

	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="db4free.net";
	private String port="3306";
	private String user="aguangisil";
	private String password="javajava";
	private String db="gimnasiojava";
	private int conectados=0;
	private Connection conn=null;
	private dbConector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static dbConector getInstancia() {
		if (instancia == null) {
			instancia = new dbConector();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}