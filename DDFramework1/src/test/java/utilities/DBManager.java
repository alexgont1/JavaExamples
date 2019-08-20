package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	
	//YOU MUST CONNECT EXTERNAL LIBRARY FROM MYSQL - Connector-J
	private static Connection con = null;
	private static Connection conn = null;

	public static void setDBConnection() {
		
		try {
			Class.forName(DBconfig.driver);
			con=DriverManager.getConnection(DBconfig.dbConnectionUrl,
					DBconfig.dbUserName, DBconfig.dbPassword);
			
			if(!con.isClosed())
				System.out.println("Connected to DB server");
			
		}catch(Exception e) {
			System.err.println("Cannot connect to DB: "+e.getMessage());
		}
	}
	
	public static void setMysqlDBConnection() {
		
		try {
			Class.forName(DBconfig.mysqldriver);
			conn=DriverManager.getConnection(DBconfig.mysqlurl,
					DBconfig.mysqluserName, DBconfig.mysqlpassword);
			
			if(!conn.isClosed())
				System.out.println("Connected to MySQL server");
			
		}catch(Exception e) {
			System.err.println("Cannot connect to MySQL DB: "+e.getMessage());
		}
	}
	
	public static List<String> getQuery(String query) throws SQLException{
		Statement St = con.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values = new ArrayList<String>();
		while(rs.next()) {
			values.add(rs.getString(1));
		}		
		return values;		
	}
	
	public static List<String> getMysqlQuery(String query) throws SQLException{
		Statement St = conn.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values1 = new ArrayList<String>();
		while(rs.next()) {
			values1.add(rs.getString(1));
		}		
		return values1;		
	}
	
	public static Connection getConnection() {
		return con;
	}
}
