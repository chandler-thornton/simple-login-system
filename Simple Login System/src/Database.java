import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
	
	//Read database to verify entered login information
	public static Connection checkLogin() throws IOException{
		
		//Read MySQL login information from dbconfig.properties file
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\chanm\\git\\simple-login-system\\Simple Login System\\src\\resources\\dbconfig.proeperties");
		prop.load(ip);
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = prop.getProperty("dburl");
			String user = prop.getProperty("dbusername");
			String pass = prop.getProperty("dbpassword");
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			
			
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
			
		}
	}
