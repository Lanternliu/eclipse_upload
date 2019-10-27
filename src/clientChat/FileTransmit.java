package clientChat;
import java.io.*;

public class FileTransmit  {
	public byte[] getFromFile()
	{
		
		try {
			File f = new File(FileChooser.directory+"/"+FileChooser.fileName);
			InputStream is = new FileInputStream(f);
			byte[] fileByte = new byte[(int)f.length()];
			
			is.read(fileByte);
			
			is.close();
			System.out.println("文件读入ok");
			return fileByte;
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public void writeToFile(MessageObject mo)
	{
		
		try {
//			File f = new File("/Users/apple/Desktop/在线人数.txt");
			FileOutputStream fos = new FileOutputStream(new File("/Users/apple/Desktop/收到的文件/"+mo.getFileName()));
			System.out.println(mo.getFileName());
			fos.write(mo.getFileData());
			fos.flush();
			fos.close();
			System.out.println("文件写出ok");
			
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
}
