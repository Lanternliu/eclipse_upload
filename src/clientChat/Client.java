package clientChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import java.io.*;

public class Client {
	public static String myAccount;
	public static Socket s;
	public static MessageObject defaultMo = new MessageObject();
	public static void main(String[] args)
	{
		new LoginPage().createLoginPage();
		try {
			s = new Socket("127.0.0.1",2955);
			new Thread(new ReadFromServer(s)).start();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class ReadFromServer implements Runnable
{
	private Socket s;
//	private MessageObject mo;
	ReadFromServer(Socket s)
	{
		this.s = s;
//		this.mo = mo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
			
				
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				MessageObject mo = (MessageObject)ois.readObject();
				if(mo.getLetItOnline().equals("YES")&&(mo.getUse().equals("login")))
				{	
					Client.myAccount=mo.getAccount();
					LoginPage.frame.setVisible(false);
					new ChatPage().chatPageNew();
					System.out.println("111111222");
				}
				if(mo.getLetItOnline().equals("NO"))
					new NoSuchAccountWarning().no();
				if(mo.getUse().equals("TellSBOnlineOffline"))
				{
//					System.out.println(ChatPage.model);
					ChatPage.model=mo.getModel();
					ChatPage.label.setText(String.valueOf(ChatPage.model.size()));
					ChatPage.model.removeElement(Client.myAccount);
//					if(!ChatPage.model.contains(mo.getAccount()))
//						ChatPage.model.addElement(mo.getAccount());
					ChatPage.list_1.setModel(ChatPage.model);
				}
				if(mo.getUse().equals("sendPrivateMessage"))
				{
					new DisplayMsg(mo,mo.getFrom());
					System.out.println(mo.getFrom()+":"+mo.getMsg());
				}
				if(mo.getUse().equals("TransmitFile"))
					new FileTransmit().writeToFile(mo);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
class SendToServer implements Runnable
{
	private Socket s = Client.s;
	private MessageObject mo;
	SendToServer(MessageObject mo)
	{
//		this.s = s;
		this.mo = mo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
				if(mo.getTo().equals("")&&(!mo.getUse().equals("login")))
				{
					System.out.println("没有发出");

					new ToSbWarining().on();
				}
				else
				{
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(mo);
					oos.flush();
					System.out.println(mo.getAccount());

					System.out.println("已发出");
//					oos.close();
				}	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}