package src.data.commoditydata;

import java.io.EOFException;
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
	File file = new File(GoodsFILE_PATH);

	@Override
	public GoodsPO findGoodsPO(long id) throws RemoteException {
		GoodsPO gpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			while ((gpo = (GoodsPO) os.readObject()) != null) {
				if (gpo.getExpressNumber() == id)
					break;
			}

			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		if(gpo == null)	System.out.println("Not found!!");
		
		
		return gpo;
	}
	
	@Override
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException {
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		GoodsPO gpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));
			while ((gpo = (GoodsPO) os.readObject()) != null && gpo.getAreaNumber() == type) {
				gpos.add(gpo);
			}

//			for (;;) {
//				GoodsPO po = (GoodsPO) os.readObject();
//				if (po.getAreaNumber() == type)
//					break;
//				gpos.add(po);
//			}

			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		
		
		return gpos;
	}

	@Override
	public ArrayList<GoodsPO> finds() throws RemoteException {
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		GoodsPO gpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			while ((gpo = (GoodsPO) os.readObject()) != null) {
				gpos.add(gpo);
			}

			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		
		
		return gpos;
	}

	@Override
	public void insert(GoodsPO gpo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(GoodsFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(gpo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(gpo);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("FILE NOT FOUND ");
			} catch (EOFException e) {
				System.out.println("END OF FILE");
			} catch (IOException e) {
				System.out.println("IO EXCEPTION");
			}
			
		
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
			System.out.println("FILE NOT FOUND ");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
		}	
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
