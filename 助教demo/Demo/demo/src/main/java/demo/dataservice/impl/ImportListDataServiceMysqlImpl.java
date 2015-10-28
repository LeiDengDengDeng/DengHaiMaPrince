package demo.dataservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.dataservice.ImportListDataService;
import demo.mysql.config.DBManage;
import demo.po.ImportItemPO;
import demo.po.ImportListPO;

public class ImportListDataServiceMysqlImpl implements ImportListDataService {
	 private Connection conn;
		

		public  ImportListDataServiceMysqlImpl() {

			this.conn =DBManage.getConnection();
		}
	public boolean insert(ImportListPO importList) {
		try {
			String sql = "insert into import_list values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, importList.getNo());
			pstmt.setInt(2, importList.getSupplier_id());
			java.sql.Date sqldate = new java.sql.Date(importList.getAdd_time().getTime());
			pstmt.setDate(3, sqldate);
			pstmt.execute();
            for(ImportItemPO importItem:importList.getImportList()){
            	String itemsql = "insert into import_item values(?, ?, ?, ?, ?)";
            	PreparedStatement itempstmt = conn.prepareStatement(itemsql);
            	itempstmt.setString(1, importItem.getList_no());
            	itempstmt.setString(2, importItem.getCommidity_no());
            	itempstmt.setDouble(3, importItem.getPrice());
            	itempstmt.setInt(4, importItem.getAmount());
            	itempstmt.setString(5, importItem.getNote());
            	itempstmt.execute();
            }
            return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public String getLatestNo(Date date) {
		List<Integer> noList=new ArrayList<Integer>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date_no = formatter.format(date);
		int noResult=0;
		try {
			String sql = "select * from import_list ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet result=pstmt.executeQuery();
			while(result.next()){
				if(result.getString(1).indexOf(date_no)!=-1){
					 String[] noData=result.getString(1).split("-");
					   noList.add(Integer.valueOf(noData[2]));
				}
			}
			for(Integer integer:noList){
	 			  int no=integer.intValue();			 
	 			  if(no>noResult){
	 				  noResult=no;
	 			  }
	 		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String latestNo="JHD-"+date_no+"-"+String.format("%05d",noResult);
		  return latestNo;
	}

}
