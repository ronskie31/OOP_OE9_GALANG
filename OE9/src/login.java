import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;


public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setForeground(Color.BLACK);
		setFont(new Font("Courier New", Font.BOLD, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\FILES\\ECLIPSE\\COPL\\img\\login.png"));
		setTitle("LOGIN \r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textUN = new TextField();
		textUN.setFont(new Font("Dialog", Font.ITALIC, 15));
		textUN.setForeground(Color.BLACK);
		textUN.setBounds(216, 154, 311, 32);
		contentPane.add(textUN);
		
		TextField textP = new TextField();
		textP.setFont(new Font("Dialog", Font.ITALIC, 15));
		textP.setForeground(Color.BLACK);
		textP.setBounds(216, 231, 311, 32);
		contentPane.add(textP);
		
		JLabel lblUN = new JLabel("USERNAME");
		lblUN.setBounds(325, 122, 92, 14);
		lblUN.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 17));
		lblUN.setForeground(Color.WHITE);
		contentPane.add(lblUN);
		
		JLabel lblP = new JLabel("PASSWORD");
		lblP.setBounds(325, 203, 92, 14);
		lblP.setForeground(Color.WHITE);
		lblP.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 17));
		contentPane.add(lblP);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(122, 143, 54, 55);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\FILES\\ECLIPSE\\COPL\\img\\id-card.png"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("E:\\FILES\\ECLIPSE\\COPL\\img\\key.png"));
		lblNewLabel_2_1.setBounds(122, 220, 54, 55);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//set the mysql jdbc driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//set the mysql connection string
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
					Statement stmt = (Statement) con.createStatement();
					//sql query for the login 
					String sql = "Select * from users_tbl where username='"+textUN.getText() + "'and password='"+textP.getText()+"'";
					
					//execute query
					ResultSet rs = ((java.sql.Statement)stmt).executeQuery(sql);
										

					// conditions for uname & pword
					if(rs.next()) {
						String userName = textUN.getText();
						main frmtwo = new main();
						
						frmtwo.setVisible(true);
						dispose();
						JOptionPane.showMessageDialog(null, "Login successful...","Login Alert",2);
					}else if (textUN.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Username is required...","Login Warning",2);
					}else if (textP.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Password is required...","Login Warning",2);
					}else {
						JOptionPane.showMessageDialog(null, "Username or password incorrect...","Login Warning",2);
					}
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 13));
		btnLogin.setBounds(297, 292, 148, 46);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon("E:\\FILES\\ECLIPSE\\COPL\\img\\button.png"));
		btnExit.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 12));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(10, 390, 84, 32);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 25));
		lblNewLabel.setBounds(263, 25, 114, 32);
		contentPane.add(lblNewLabel);
	}
}
