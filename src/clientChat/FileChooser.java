package clientChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FileChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static FileChooser frame;
	public static String fileName = "";
	public static String directory = "";

	
	/**
	 * Launch the application.
	 */
	public void on() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FileChooser();
					frame.setVisible(false);
					FileDialog fd = new FileDialog(frame,"请选择文件",FileDialog.LOAD);
					fd.setVisible(true);
					
					fileName = fd.getFile();
//					System.out.println(fd.getFile());

					directory = fd.getDirectory();
					
					
					if(!FileChooser.fileName.equals(""))
					{
						MessageObject mo = new MessageObject();
						System.out.println("Client1：");

						mo.setFileData(new FileTransmit().getFromFile());
						System.out.println("Client1：");

						mo.setUSe("TransmitFile");
						mo.setTo(ChatPage.to);
						mo.setFrom(Client.defaultMo.getAccount());
						new Thread(new SendToServer(mo)).start();;
						mo.setFileName(FileChooser.fileName);
						System.out.println("Client：已给到SendToServer");

					}
					else
					{
						System.out.println("您没有选择文件");
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileChooser() {
		
		
//		System.out.println(fd.getFile());
//		System.out.println(fd.getDirectory());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
