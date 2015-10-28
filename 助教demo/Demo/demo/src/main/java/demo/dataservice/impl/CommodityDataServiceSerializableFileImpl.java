package demo.dataservice.impl;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import demo.dataservice.CommodityDataService;
import demo.po.CommodityPO;

public class CommodityDataServiceSerializableFileImpl implements
		CommodityDataService {

	@SuppressWarnings({ "resource", "unchecked" })
	public CommodityPO find(String no) {
		try {
			FileInputStream fis = new FileInputStream("SerializableData/Commodity.file");
			

	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        List<CommodityPO>  commodityPos = (List<CommodityPO>) ois.readObject();
            
	        for(CommodityPO po:commodityPos){
	        	if (po.getNo().equals(no)){
	        		return po;
	        	}
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
