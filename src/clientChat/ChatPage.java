package clientChat;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static DefaultListModel<String> model = new DefaultListModel<String>();
	public static JLabel label; 
	public static JTextArea textArea;
	public static JList<String> list_1;
	public static String to = "";
	public static JTextArea textArea_1;
	public static JScrollPane scrollPane;
	private JButton button_1;
	public ChatPage frame;
	
	/**
	 * Launch the application.
	 */
	public void chatPageNew() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChatPage();
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
	public ChatPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 56, 614, 342);
		contentPane.add(scrollPane);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane.setViewportView(textArea_1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("在线人数");
		lblNewLabel.setBounds(19, 14, 61, 16);
		panel.add(lblNewLabel);
		
		
		label = new JLabel();
		label.setBounds(79, 14, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(822, 14, 61, 16);
		panel.add(label_1);
		label_1.setText(Client.myAccount);
		
		JButton button = new JButton("发送");
		button.setBounds(768, 543, 117, 29);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print(textArea.getText());
				MessageObject mo = new MessageObject();
				mo.setMsg(textArea.getText());
				mo.setTo(to);
				mo.setFrom(Client.defaultMo.getAccount());
				mo.setUSe("sendPrivateMessage");
				new Thread(new SendToServer(mo)).start();
				if(!mo.getTo().equals(""))
				{
					new DisplayMsg(mo,"我");
				}
				
//				textArea_1.append(textArea.getText()+"\n");
				
				textArea.setText("");
				
			}
		});
		button.setBackground(Color.DARK_GRAY);
		contentPane.add(button);
		
		
		textArea = new JTextArea();
		textArea.setBounds(271, 407, 614, 136);
		textArea.setBackground(Color.WHITE);
		contentPane.add(textArea);
		
		
		
		
		list_1 = new JList<String>();
		list_1.setBounds(10, 56, 249, 484);
		contentPane.add(list_1);
		list_1.setModel(model);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setBounds(698, 543, 71, 29);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}
		});
		contentPane.add(btnNewButton);
		
		button_1 = new JButton("发送文件");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FileChooser().on();
				
				
					
			}
		});
		button_1.setBounds(266, 543, 96, 29);
		contentPane.add(button_1);
		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				to = list_1.getSelectedValue();
			}
		});
		
		
	}
}
//class ListContent
//{
//	public static JList<String> list;
//}
