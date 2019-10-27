package clientChat;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayMsg {
//	private MessageObject displayMessageObject;
	private Point p = new Point();
	public DisplayMsg(MessageObject mo,String name)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
//        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制） 
		
        
        String msg = name+"  "+sdf.format(date)+"\n"+"    "+mo.getMsg()+"\n";
        ChatPage.textArea_1.append(msg);
        
        p.setLocation(0,ChatPage.textArea_1.getLineCount()*10);
        ChatPage.scrollPane.getViewport().setViewPosition(p);

	}
	
	
}
