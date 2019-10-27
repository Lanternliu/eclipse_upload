package serverChat;
import java.net.*;

import clientChat.MessageObject;

import java.io.*;

public class SendToClient implements Runnable{
	private Socket s;
	private MessageObject mo;
	public SendToClient(Socket s,MessageObject mo)
	{
		this.s = s;
		this.mo = mo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(s);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(mo);
			System.out.println(mo.getUse()+mo.getTo()+mo.getMsg());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
