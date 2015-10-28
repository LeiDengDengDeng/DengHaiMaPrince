package demo.dataservice.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.dataservice.ImportListDataService;
import demo.po.CommodityPO;
import demo.po.ImportListPO;

public class ImportListDataServiceSerializableFileImpl implements
		ImportListDataService {

	@SuppressWarnings({ "unchecked", "resource" })
	public boolean insert(ImportListPO importList) {
		try {
			FileInputStream fis = new FileInputStream("SerializableData/ImportList.file");
			

	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        List<ImportListPO>  importListPos = (List<ImportListPO>) ois.readObject();
	        
//	        for(ImportListPO po:importListPos){
//	        	System.out.println(po.getNo());
//	        }
	        
            importListPos.add(importList);
            FileOutputStream fos = new FileOutputStream("SerializableData/ImportList.file");
			 ObjectOutputStream oos = new ObjectOutputStream(fos);
			 oos.writeObject(importListPos);
            ois.close();
            oos.close();
            return true;
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

		return false;
		   
	}


	@SuppressWarnings({ "unchecked", "unused" })
	public String getLatestNo(Date date) {
		File file = new File("SerializableData/ImportListPO.file");	
		List<Integer> noList=new ArrayList<Integer>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int noResult=0;
		String date_no = formatter.format(date);
		try {
			FileInputStream fis = new FileInputStream("SerializableData/ImportList.file");
			

	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        @SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(bis);  
	        List<ImportListPO>  importListPos = (List<ImportListPO>) ois.readObject();
	        
           for(ImportListPO importListPo:importListPos){
        	   if(importListPo.getNo().indexOf(date_no)!=-1){
        		   String[] noData=importListPo.getNo().split("-");
				   noList.add(Integer.valueOf(noData[2]));
        	   }
           }
           for(Integer integer:noList){
 			  int no=integer.intValue();			 
 			  if(no>noResult){
 				  noResult=no;
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
		String latestNo="JHD-"+date_no+"-"+String.format("%05d",noResult);
		  return latestNo;
	}

}
