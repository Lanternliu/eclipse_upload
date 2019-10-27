package clientChat;

import java.io.Serializable;
import java.net.Socket;


import javax.swing.DefaultListModel;

public class MessageObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account = "";
	private String psw = "";
	private String from = "";
	private String to = "";
	private String msg = "";
	private String use ="";
	private String state ="";
	private String ip ="";
	private String port ="";
	private Socket s ;
	private String letItOnline ="";
	private byte[] fileData;
	private String fileName = "";
	private long fileDataSize; 
	private DefaultListModel<String> model = new DefaultListModel<String>();

	
	public void setFileDataSize(long fileDataSize)
	{
		this.fileDataSize = fileDataSize;
	}
	public long getFileDataSize()
	{
		return fileDataSize;
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return fileName;
	}
	
	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}
	public byte[] getFileData()
	{
		return fileData;
	}
	
	public void setModel(DefaultListModel<String>  model)
	{
		this.model = model;
	}
	public DefaultListModel<String> getModel()
	{
		return model;
	}
	public void setLetItOnline(String letItOnline)
	{
		this.letItOnline = letItOnline;
	}
	public String getLetItOnline()
	{
		return letItOnline;
	}
	
	public void setSocket(Socket s)
	{
		this.s=s;
	}
	public Socket getSocket()
	{
		return s;
	}
	public MessageObject() {
		
	}
	public void setState(String state) {
		this.state=state;
	}
	public void setIp(String ip) {
		this.ip=ip;
	}
	public void setPort(String port) {
		this.port=port;
	}
	public String getState()
	{
		return state;
	}
	public String getIp()
	{
		return ip;
	}
	public String getPort()
	{
		return port;
	}
	
	public void setAccount(String account) {
		this.account=account;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setMsg(String msg) {
		this.msg=msg;
	}
	public void setUSe(String use) {
		this.use=use;
	}
	
	public String getAccount() {
		return account;
	}
	public String getPsw() {
		return psw;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getMsg() {
		return msg;
	}
	public String getUse() {
		return use;
	}
	
	
}
