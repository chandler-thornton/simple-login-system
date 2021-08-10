import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Database {
	
	private String username;
	private String password;
	boolean loginValid = false;
	
	public Database(String userInput, String passInput) {
		this.username = userInput;
		this.password = passInput;
	}
	
	public boolean checkLoginValid() {
		return loginValid;
	}
	
	//Read database to verify entered login information
	public Connection checkLogin() throws IOException{
		
		//Read MySQL login information from dbconfig.properties file
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\chanm\\git\\simple-login-system\\Simple Login System\\src\\resources\\dbconfig.properties");
		prop.load(ip);
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = prop.getProperty("dburl");
			String user = prop.getProperty("dbusername");
			String pass = prop.getProperty("dbpassword");
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected");
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM loginsystemtable WHERE username = '" + username + "' and password = '" + password + "'");
			System.out.println("Data retrieved");
			if(rs.next()) {
				loginValid = true;
			}
			else {
				System.out.println("Login Failed");
			}
			
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
			
		}
	}
