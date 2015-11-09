package src.po;

import java.io.Serializable;

public class LogPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 858482362466559905L;
	
	String position;
	String name;
	String operation;
	String time; // 此处time的类型存疑

	public LogPO(String position, String name, String operation,
			String time) {
		super();
		this.position = position;
		this.name = name;
		this.operation = operation;
		this.time = time;
	}

	public String getDate(){
		return time;
	}
	
	public String getLog() {
		return time + "  " + position + name + operation + "\n";
	}
}
