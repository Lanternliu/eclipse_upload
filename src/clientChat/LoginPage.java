package clientChat;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static LoginPage frame;
	/**
	 * Launch the application.
	 */
	public 	void createLoginPage(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(141, 89, 32, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(141, 123, 32, 16);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(179, 84, 121, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 118, 121, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String account = textField.getText();
				String psw = textField_1.getText();
				MessageObject mo = new MessageObject();
				mo.setAccount(account);
				mo.setPsw(psw);
				mo.setUSe("login");
				mo.setMsg("客户端:我来了");
				new Thread(new SendToServer(mo)).start();
				Client.defaultMo.setAccount(account);
				System.out.println("客户端登录");
				
			}
		});
		button.setBounds(160, 188, 117, 29);
		contentPane.add(button);
	}
}
