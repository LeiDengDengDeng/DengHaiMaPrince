package demo.dataservice.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.dataservice.CommodityDataService;
import demo.mysql.config.DBManage;
import demo.po.CommodityPO;

public class CommodityDataServiceMysqlImpl implements CommodityDataService {
    private Connection conn;
	

	public CommodityDataServiceMysqlImpl() {

		this.conn =DBManage.getConnection();
	}


	public CommodityPO find(String no) {
		try {
			String sql = "select * from commodity where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			ResultSet result=pstmt.executeQuery();
			while(result.next()){
				CommodityPO commodityPo=new CommodityPO();
				commodityPo.setNo(result.getString(1));
				commodityPo.setName(result.getString(2));
				commodityPo.setType(result.getString(3));
				commodityPo.setB_price(result.getDouble(4));
				commodityPo.setS_price(result.getDouble(5));
				commodityPo.setMark(result.getBoolean(6));
				
				return commodityPo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;

	}


}
