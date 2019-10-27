package serverChat;

import java.net.Socket;
import java.util.*;


import clientChat.MessageObject;

public class NotifySBOnlineOffline {
	
	
	public NotifySBOnlineOffline(MessageObject mo)
	{
		
		mo.setUSe("TellSBOnlineOffline");
		mo.setModel(Server.model);
//		mo.setMap(Server.socketMap);
		mo.setMsg("SB上线通知已下发");
		
		Set<Map.Entry<String, Socket>> entrySet = Server.socketMap.entrySet();
		Iterator<Map.Entry<String, Socket>> iter = entrySet.iterator();
		
		while(iter.hasNext())
		{
			System.out.println("SB上线通知已下发");
			Map.Entry<String, Socket> s = iter.next();
			new Thread(new SendToClient(s.getValue(),mo)).start();
		}
		
	}
}
