package demo.dataservice.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import demo.dataservice.CommodityDataService;
import demo.po.CommodityPO;

public class CommodityDataServiceTxtFileImpl implements CommodityDataService {

	public CommodityPO find(String no) {
		File file = new File("TxtData/Commodity.txt");
		  try {
			  InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			   BufferedReader br = new BufferedReader(read);
		   String s = br.readLine();
		   while(s!=null){
		     if(s.indexOf(no)!=-1){
		      String[] data=s.split(":");
		      String commodityNo=data[0];
		      String commodityName=data[1];
		      String commodityType=data[2];
		      Double commoditybPrice=Double.valueOf(data[3]);
		      Double commoditysPrice=Double.valueOf(data[4]);
		      Boolean commodityMark=Boolean.parseBoolean(data[5]);
		      
		      CommodityPO commodityPo=new CommodityPO(commodityNo,commodityName,commodityType
		    		                                 ,commoditybPrice,commoditysPrice,commodityMark);
		      return commodityPo;
		     }
		     s = br.readLine();
		   }
		  
		   br.close();
		   
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		  return null;
		  
		 }
	}

