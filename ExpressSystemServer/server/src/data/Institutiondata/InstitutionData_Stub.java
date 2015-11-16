package src.data.Institutiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;

public class InstitutionData_Stub implements InstitutionDataService{

	public InstitutionPO find(long InstitutionId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find successfully!");
		return new InstitutionPO("Apart", 000000, "Manage Staff");
	}

	public ArrayList<InstitutionPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find all successfully!");
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		institutionPOs.add(new InstitutionPO("Apart", 000000, "Manage Staff"));
		return institutionPOs;
	}

	public void insert(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert successfully!");
	}

	public void update(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update successfully!");
	}

	public void delete(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
	}

}
