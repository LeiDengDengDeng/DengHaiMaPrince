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
	String statement; // ±¸×¢
	String time;

	public LogPO(String position, String name, String operation,
				 String statement, String time) {
		super();
		this.position = position;
		this.name = name;
		this.operation = operation;
		this.statement = statement;
		this.time = time;
	}

	public String getDate() {
		return time;
	}

	public String getPosition() {
		return position;
	}

	public String getOperation() {
		return operation;
	}

	public String getName() {
		return name;
	}

	public String getStatement() {
		return statement;
	}
}
