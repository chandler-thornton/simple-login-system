import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {

	public static void main(String[] args) {
		setupJframe();
	}
	
	public static void setupJframe() {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,175);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		JLabel userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 20, 100, 25);
		JTextField usernameInput = new JTextField(20);
		usernameInput.setBounds(80, 25, 200, 18);
		panel.add(userLabel);
		panel.add(usernameInput);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 50, 125, 25);
		JTextField passwordInput = new JTextField(20);
		passwordInput.setBounds(80, 55, 200, 18);
		panel.add(passLabel);
		panel.add(passwordInput);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 100, 70, 18);
		panel.add(loginButton);
		
		frame.setVisible(true);
		
	}

}
