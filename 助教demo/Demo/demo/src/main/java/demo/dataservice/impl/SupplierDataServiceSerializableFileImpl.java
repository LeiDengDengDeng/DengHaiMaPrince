package demo.dataservice.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import demo.dataservice.SupplierDataService;
import demo.po.SupplierPO;

public class SupplierDataServiceSerializableFileImpl implements
		SupplierDataService {

	@SuppressWarnings({ "unchecked", "resource" })
	public List<SupplierPO> findAll() {
		try {
			FileInputStream fis = new FileInputStream("SerializableData/Supplier.file");
			

	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        List<SupplierPO>  supplierPos = (List<SupplierPO>) ois.readObject();
            
	        return supplierPos;
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
