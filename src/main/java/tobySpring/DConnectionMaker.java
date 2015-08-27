//package tobySpring;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DConnectionMaker implements ConnectionMaker{
//
//	@Override
//	public Connection makeConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/tobee", "2daebong", "eoqjas1");
//		return c;
//	}
//
//	
//	
//}
