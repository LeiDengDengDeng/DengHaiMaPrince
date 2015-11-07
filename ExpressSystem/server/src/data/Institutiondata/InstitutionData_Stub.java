package src.data.Institutiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;

public class InstitutionData_Stub implements InstitutionDataService{

	@Override
	public InstitutionPO find(long InstitutionId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find successfully!");
		return new InstitutionPO("Apart", 000000, "Manage Staff");
	}

	@Override
	public ArrayList<InstitutionPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find all successfully!");
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		institutionPOs.add(new InstitutionPO("Apart", 000000, "Manage Staff"));
		return institutionPOs;
	}

	@Override
	public void insert(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert successfully!");
	}

	@Override
	public void update(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update successfully!");
	}

	@Override
	public void delete(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
	}

}
