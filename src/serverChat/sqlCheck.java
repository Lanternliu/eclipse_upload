package serverChat;

import java.net.Socket;
//import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import clientChat.MessageObject;

class sqlCheck
{	
	private MessageObject mo;
	private Socket s;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/java聊天室?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "12341234";
	public sqlCheck(Socket s,MessageObject mo)
	{
		this.mo = mo;
		this.s = s;
	}
	public void connect()
	{	
//    	s = Server.socketMap.get(mo.getAccount());
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = null;
            sql = "SELECT account,psw FROM 账号密码";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.print("mysql没问题");
            boolean flag = false;
            while(rs.next()){
                // 通过字段检
                
                String accountDB = rs.getString("account");
                String pswDB = rs.getString("psw");
                if(accountDB.equals(mo.getAccount())&&(pswDB.equals(mo.getPsw())))
                {
                	if(!Server.socketMap.containsKey(mo.getAccount()))
    				{
    					Server.socketMap.put(mo.getAccount(), s);
//    					System.out.println("server的read我倒这里了:往map加");

    				}
                	mo.setLetItOnline("YES");
                	new Thread(new SendToClient(s,mo)).start();
                	if(!Server.model.contains(mo.getAccount()))
                		Server.model.addElement(mo.getAccount());
            		
            		Thread.sleep(2000);
            		new NotifySBOnlineOffline(mo);
                	
                	flag = true;
                	System.out.println("密码校验成功，已登录");
                	break;
                }
                // 输出数据
                System.out.print("account: " + accountDB);
                System.out.print(", psw: " + pswDB);
            }
            if(flag==false)
            {
            	mo.setLetItOnline("NO");
            	new Thread(new SendToClient(s,mo)).start();
            	System.out.println("密码校验错误，拒绝登录");
            }
            	
            conn.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}
}