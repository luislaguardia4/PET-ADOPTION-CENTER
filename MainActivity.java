package PetAdoption;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField password;
	private JCheckBox chckbxNewCheckBox;
	private static JLabel errorMessage;
    
	
	
	/**	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainActivity frame = new MainActivity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainActivity() {
		setRootPaneCheckingEnabled(false);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setForeground(new Color(144, 238, 144));
		panel.setBounds(357, 0, 442, 579);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Labels/Texts
		JLabel Login = new JLabel("Login");
		Login.setBounds(137, 34, 78, 37);
		contentPane.add(Login);
		Login.setForeground(new Color(0, 0, 0));
		Login.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		
		JLabel text1 = new JLabel("Accessing this course requires a login");
		text1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text1.setForeground(Color.GRAY);
		text1.setBounds(73, 80, 233, 13);
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("Please enter your username & password below!");
		text2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text2.setForeground(Color.GRAY);
		text2.setBounds(45, 95, 274, 13);
		contentPane.add(text2);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.BOLD, 11));
		Username.setForeground(Color.DARK_GRAY);
		Username.setBounds(149, 138, 66, 30);
		contentPane.add(Username);

		JLabel Password = new JLabel("Password");
		Password.setForeground(Color.DARK_GRAY);
		Password.setFont(new Font("Tahoma", Font.BOLD, 11));
		Password.setBounds(149, 211, 60, 30);
		contentPane.add(Password);
		
		JLabel Register = new JLabel("Register");
		Register.setBounds(154, 214, 120, 37);
		panel.add(Register);
		Register.setForeground(new Color(0, 0, 0));
		Register.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		
		JLabel text5 = new JLabel("Don't have an account? Register one!");
		text5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		text5.setForeground(new Color(0, 0, 0));
		text5.setBounds(104, 261, 215, 26);
		panel.add(text5);
		
		// Separator Field
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 371, 162, 8);
		contentPane.add(separator);
		
		// Email/Number Field
		JFormattedTextField email = new JFormattedTextField();
		email.setBounds(54, 167, 245, 30);
		contentPane.add(email);

		
		// Password Field
 		password = new JPasswordField();
		password.setBounds(54, 239, 245, 30);
		contentPane.add(password);
		
		// Image Field
		ImageIcon human = new ImageIcon("C:\\Pet Adopt Pics\\DESIGN AND LOGO\\human.png");
		JLabel humanLabel = new JLabel(human);
		humanLabel.setBounds(28, 167, 24, 30);
		contentPane.add(humanLabel);
		
		ImageIcon lock = new ImageIcon("C:\\Pet Adopt Pics\\DESIGN AND LOGO\\lock.png");
		JLabel lockLabel = new JLabel(lock);
		lockLabel.setBounds(28, 239, 24, 30);
		contentPane.add(lockLabel);
		
		ImageIcon paw = new ImageIcon("C:\\Pet Adopt Pics\\DESIGN AND LOGO\\paw.png");
		
		// Admin Login Button Field
		JButton loginAdmin = new JButton("Log In as Admin");
		loginAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String enteredUsername = email.getText();
				String enteredPassword = new String(password.getPassword());
				
				if(AdminLogInAcc(enteredUsername,enteredPassword)) {
					JOptionPane.showMessageDialog(contentPane,"Login Successful!", null, JOptionPane.INFORMATION_MESSAGE);
					AfterLogInAdmin next = new AfterLogInAdmin();
					next.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Login Failed!",null, JOptionPane.INFORMATION_MESSAGE);
				}				
			
			}
			
		});
		loginAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
	}
		});
		
		loginAdmin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		loginAdmin.setForeground(new Color(0, 0, 0));
		loginAdmin.setBackground(new Color(153, 204, 204));
		loginAdmin.setBounds(98, 324, 162, 23);
		contentPane.add(loginAdmin);
		
		// Client Login Button Field
		JButton loginClient = new JButton("Log In as Client");
		loginClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String enteredUsername = email.getText();
				String enteredPassword = new String(password.getPassword());
				
				if(ClientLogInAcc(enteredUsername,enteredPassword)) {
					JOptionPane.showMessageDialog(contentPane, "Login Successful!", null, JOptionPane.INFORMATION_MESSAGE);
					AfterLogIn next = new AfterLogIn();
					next.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Login Failed!",null, JOptionPane.INFORMATION_MESSAGE);
				}				
			
			}
		});
		
		loginClient.setForeground(new Color(0, 0, 0));
		loginClient.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		loginClient.setBackground(new Color(153, 204, 204));
		loginClient.setBounds(98, 290, 162, 23);
		contentPane.add(loginClient);
		
		// Register Button Field
		JButton Client = new JButton("Client");
		Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {       
				
			ClientRegister client = new ClientRegister();
			client.setVisible(true);
			setVisible(false);
			dispose();
			}
		});
		
		Client.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		Client.setForeground(new Color(0, 0, 0));
		Client.setBackground(new Color(255, 255, 255));
		Client.setBounds(104, 299, 205, 23);
		panel.add(Client);
		
		JButton Admin = new JButton("Admin");
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			AdminRegister admin = new AdminRegister();

			setVisible(true);
			dispose();
			}
		});
		
		Admin.setForeground(new Color(0, 0, 0));
		Admin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		Admin.setBackground(Color.WHITE);
		Admin.setBounds(104, 349, 205, 23);
		panel.add(Admin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-16, 173, 486, 436);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Pet Adopt Pics\\DESIGN AND LOGO\\pets2.png"));
		
		JLabel lblNewLabel_1 = new JLabel("HAPPY PAW'S");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 38));
		lblNewLabel_1.setBounds(77, 59, 278, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pet Adoption Center");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(123, 110, 183, 23);
		panel.add(lblNewLabel_2);
		

		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		chckbxNewCheckBox.setBounds(305, 239, 21, 30);
		contentPane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		//		chckbxNewCheckBox.setBorder(null);
				chckbxNewCheckBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxNewCheckBox.isSelected()) {
							password.setEchoChar((char)0);
						}else {
							password.setEchoChar('*');
						}
					}
				});
				
				chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
				
				errorMessage = new JLabel((String) null);
				errorMessage.setBounds(54, 407, 272, 30);
				contentPane.add(errorMessage);
				errorMessage.setForeground(new Color(255, 0, 0));
				errorMessage.setFont(new Font("Dialog", Font.BOLD, 12));
				errorMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
				JLabel pawLabel = new JLabel(new ImageIcon("C:\\Pet Adopt Pics\\DESIGN AND LOGO\\HAPPY.png"));
				pawLabel.setBounds(80, 407, 193, 108);
				contentPane.add(pawLabel);
				
	}
	
	private boolean ClientLogInAcc(String username, String password) {
		try {
			String url = "jdbc:sqlserver://BEVS;databasename=adoption;integratedSecurity=true;encrypt=false;";
			Connection conn = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM ClientRegisterAcc WHERE username=? AND password=?";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				ResultSet resultSet = pstmt.executeQuery();
				
				//matching input was found
				return resultSet.next();
		}
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}
	private boolean AdminLogInAcc(String adminUsername, String adminPassword) {
		try {
			String url = "jdbc:sqlserver://BEVS;databasename=adoption;integratedSecurity=true;encrypt=false;";
			Connection conn = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM AdminRegisterAcc WHERE adminUsername=? AND adminPassword=?";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setString(1, adminUsername);
				pstmt.setString(2, adminPassword);
				
				ResultSet resultSet = pstmt.executeQuery();
				
				//matching input was found
				return resultSet.next();
		}
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	}
}
