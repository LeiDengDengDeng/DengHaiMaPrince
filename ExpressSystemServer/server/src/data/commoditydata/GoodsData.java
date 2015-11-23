package src.data.commoditydata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.enums.GoodsType;
import src.po.GoodsPO;

public class GoodsData implements GoodsDataService{
	
	public static final String GoodsFILE_PATH = "goods.ser";

	@Override
	public GoodsPO findGoodsPO(long id) throws RemoteException {
		GoodsPO gpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("GoodsFILE_PATH"));

			for (;;) {
				GoodsPO po = (GoodsPO) os.readObject();
				if (po.getExpressNumber() == id){
					gpo = po;
					break;
				}
				if(po == null) break;
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(gpo == null)	System.out.println("Not found!!");
		
		
		return gpo;
	}
	
	@Override
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException {
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("GoodsFILE_PATH"));

			for (;;) {
				GoodsPO po = (GoodsPO) os.readObject();
				if (po.getAreaNumber() == type)
					break;
				gpos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return gpos;
	}

	@Override
	public ArrayList<GoodsPO> finds() throws RemoteException {
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("GoodsFILE_PATH"));

			for (;;) {
				GoodsPO po = (GoodsPO) os.readObject();
				if (po == null)
					break;
				gpos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return gpos;
	}

	@Override
	public void insert(GoodsPO gpo) throws RemoteException {
		if(findGoodsPO(gpo.getExpressNumber()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(GoodsFILE_PATH);
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(gpo);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(gpo);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("GoodsFile not found");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		else System.out.println("Already exist!!");
	}

	@Override
	public void update(GoodsPO gpo) throws RemoteException {
		delete(gpo.getExpressNumber());
		insert(gpo);
	}

	@Override
	public void delete(long id) throws RemoteException {
		File file = new File(GoodsFILE_PATH);
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		gpos = finds();
		
		for(int i = 0;i < gpos.size();i++){
			if(gpos.get(i).getExpressNumber() == id){
				gpos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < gpos.size();j++){
				os.writeObject(gpos.get(j));
				os.flush();
			}
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
