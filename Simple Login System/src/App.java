import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App implements ActionListener{
	
	private static JLabel userLabel;
	private static JTextField usernameTxtField;
	private static JLabel passLabel;
	private static JTextField passwordTxtField;
	private static JButton loginButton;

	public static void main(String[] args) {
		setupJframe();
	}
	
	
	//Setup GUI
	public static void setupJframe() {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,175);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 20, 100, 25);
		usernameTxtField = new JTextField(20);
		usernameTxtField.setBounds(80, 25, 200, 18);
		panel.add(userLabel);
		panel.add(usernameTxtField);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 50, 125, 25);
		passwordTxtField = new JTextField(20);
		passwordTxtField.setBounds(80, 55, 200, 18);
		panel.add(passLabel);
		panel.add(passwordTxtField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 100, 70, 18);
		loginButton.addActionListener(new App());
		panel.add(loginButton);
		
		frame.setVisible(true);
		
	}
	
	//Action Listener (loginButton)
	@Override
	public void actionPerformed(ActionEvent e) {
		String usernameInput = usernameTxtField.getText();
		String passwordInput = passwordTxtField.getText();
		Database db = new Database(usernameInput, passwordInput);
		try {
			db.checkLogin();
			if(db.checkLoginValid()) {
				loggedIn();
			}
			else {
				System.exit(0);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void loggedIn() {
		JFrame loggedInFrame = new JFrame("Logged In");
		loggedInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loggedInFrame.setSize(300,175);
		
		JPanel loggedInPanel = new JPanel();
		loggedInPanel.setLayout(null);
		loggedInFrame.add(loggedInPanel);
		
		JLabel loggedInLabel = new JLabel("You're now logged in!");
		loggedInLabel.setBounds(120,90,100,100);
		loggedInFrame.add(loggedInLabel);
		
		loggedInFrame.setVisible(true);
	}

}
