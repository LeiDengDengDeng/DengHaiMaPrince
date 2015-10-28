package demo.dataservice.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import demo.dataservice.SupplierDataService;
import demo.po.SupplierPO;

public class SupplierDataServiceTxtFileImpl implements SupplierDataService {

	public List<SupplierPO> findAll() {
		File file = new File("TxtData/Supplier.txt");
		List<SupplierPO> supplierPos=new ArrayList<SupplierPO>();
		  try {
			  InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
		   BufferedReader br = new BufferedReader(read);
		   String s = br.readLine();
		   while(s!=null){
		      String[] data=s.split(":");
		      int supplierId=Integer.valueOf(data[0]);
		      String supplierName=data[1];
		      Boolean supplierMark=Boolean.parseBoolean(data[2]);
		      
		     SupplierPO supplierPo=new SupplierPO(supplierId,supplierName,supplierMark);
		      supplierPos.add(supplierPo);
		      s = br.readLine();
		     }
		   

		  br.close();
		   
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }

		  
		  return supplierPos;
		  
		 }
	}


