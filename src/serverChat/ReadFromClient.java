package serverChat;
import java.net.*;

import clientChat.MessageObject;

import java.io.*;


public class ReadFromClient implements Runnable{
	private Socket s;
	public ReadFromClient(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		try {
			while(true)
			{
//				System.out.println("server的read我倒这里了");

				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				MessageObject mo = (MessageObject)ois.readObject();
				System.out.println("server的read"+mo.getAccount());

				if(mo.getUse().equals("sendPrivateMessage"))
				{
					System.out.println(mo.getFrom()+":"+mo.getMsg());

					Socket s = Server.socketMap.get(mo.getTo());
					
					Thread.sleep(2000);
					new Thread(new SendToClient(s,mo)).start();
					System.out.println("消息已转发到:"+mo.getTo());
					System.out.println("消息已转发到:"+Server.socketMap);
				}
				if(mo.getUse().equals("TransmitFile"))
				{
					new Thread(new SendToClient(s,mo)).start();
					System.out.println("文件已转发到:"+mo.getTo());

				}
//				if(mo.getUse().equals("sendMsg"))
//				{
//					Socket st = Server.socketMap.get(mo.getAccount());
//					
//					new Thread(new SendToClient(st,mo)).start();
//					System.out.println("消息已转发到:"+mo.getTo());
//				
//				}
				if(mo.getUse().equals("login"))
				{
					System.out.println("server的read我倒这里了查询mysql");
					new sqlCheck(s,mo).connect();
				}
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
