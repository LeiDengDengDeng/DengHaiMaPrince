package demo.mysql.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManage {
	private static Connection conn;
	
	public static Connection getConnection()
	{	
		if(conn == null){
			connection();
		}
		return conn;
	}
	
	private static void connection() {
		  try {			  
			  Class.forName("com.mysql.jdbc.Driver");     //加载Mysql JDBC驱动程序   

		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
		  try {
			  //连接URL为'jdbc:mysql//服务器地址/数据库名 ' ，后面的2个参数分别是登陆用户名和密码
			  conn = DriverManager.getConnection(
					  "jdbc:mysql://localhost:3306/se2_demo","root","123456");
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	
	private static void disconnect(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
