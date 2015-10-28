package demo.dataservice.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.dataservice.ImportListDataService;
import demo.po.ImportItemPO;
import demo.po.ImportListPO;

public class ImportListDataServiceTxtFileImpl implements ImportListDataService {

	public boolean insert(ImportListPO importList) {
		File itemFile = new File("TxtData/ImportItem.txt");
		File listFile = new File("TxtData/ImportList.txt");
		for(ImportItemPO importItem:importList.getImportList()){
			try {				
				OutputStreamWriter itemWriter = new OutputStreamWriter(
						new FileOutputStream(itemFile,true),"UTF-8"); 
		            itemWriter.write(importItem.getList_no());
		            itemWriter.write(":");
		            itemWriter.write(importItem.getCommidity_no());
		            itemWriter.write(":");
		            itemWriter.write(Double.toString(importItem.getPrice()));
		            itemWriter.write(":");
		            itemWriter.write(String.valueOf(importItem.getAmount()));
		            itemWriter.write(":");
		            itemWriter.write(importItem.getNote());
		            itemWriter.write("\r\n");
		            itemWriter.close();
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			OutputStreamWriter listWriter = new OutputStreamWriter(
					new FileOutputStream(listFile,true),"UTF-8"); 
				listWriter.write(importList.getNo());
				listWriter.write(":");
				listWriter.write(String.valueOf(importList.getSupplier_id()));
				listWriter.write(":");
				 Date date = new Date();
				 DateFormat df = DateFormat.getDateTimeInstance();
				listWriter.write(df.format(date));
				listWriter.write("\r\n");
				listWriter.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return false;
	}

	public String getLatestNo(Date date) {
		File file = new File("TxtData/ImportList.txt");	
		List<Integer> noList=new ArrayList<Integer>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int noResult=0;
		String date_no = formatter.format(date);
		try {
			 BufferedReader br = new BufferedReader(new FileReader(file));
			 String s = br.readLine();
			   while(s!=null){
				   if(s.indexOf(date_no)!=-1){
					   String[] data=s.split(":");
					   String[] noData=data[0].split("-");
					   noList.add(Integer.valueOf(noData[2]));
				   }
				   s = br.readLine();
			   }
			   br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  for(Integer integer:noList){
			  int no=integer.intValue();
			 
			  if(no>noResult){
				  noResult=no;
			  }
		  }
		  
		  String latestNo="JHD-"+date_no+"-"+String.format("%05d",noResult);
		  System.out.println(latestNo);
		  return latestNo;
		  
	}

}
