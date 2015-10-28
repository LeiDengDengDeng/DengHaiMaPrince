package demo.dataservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.dataservice.SupplierDataService;
import demo.mysql.config.DBManage;
import demo.po.CommodityPO;
import demo.po.SupplierPO;

public class SupplierDataServiceMysqlImpl implements SupplierDataService{
	 private Connection conn;
		

		public SupplierDataServiceMysqlImpl () {

			this.conn =DBManage.getConnection();
		}



		public List<SupplierPO> findAll() {
			List<SupplierPO> supplierPos=new ArrayList<SupplierPO>();
			try {
				
				String sql = "select * from supplier";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet result=pstmt.executeQuery();
				
				while(result.next()){
					SupplierPO supplierPo=new SupplierPO();
					supplierPo.setId(result.getInt(1));
					supplierPo.setName(result.getString(2));
					supplierPo.setMark(result.getBoolean(3));
					
					supplierPos.add(supplierPo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return supplierPos;
		}

}
