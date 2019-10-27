package serverChat;
import java.io.IOException;
import java.net.*;
import java.util.*;

import javax.swing.DefaultListModel;



public class Server {
	
	public static Map<String,Socket> socketMap = new HashMap<String,Socket>();
	public static DefaultListModel<String> model = new DefaultListModel<String>();

	
	public static void main(String[] args)
	{
		
		try {
			
			ServerSocket ss = new ServerSocket(2955);
			while(true)
			{
				Socket s = ss.accept();
				new Thread(new ReadFromClient(s)).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
