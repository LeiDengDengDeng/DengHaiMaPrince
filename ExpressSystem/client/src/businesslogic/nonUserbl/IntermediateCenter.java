package src.businesslogic.nonUserbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.IntermediateCenterBLService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.dataservice.nonUserdataservice.IntermediateCenterDataService;
import src.po.IntermediateCenterPO;
import src.vo.IntermediateCenterVO;

public class IntermediateCenter implements IntermediateCenterBLService{
	
	Log log;
	IntermediateCenterDataService intermediateCenterDataService;
	
	public IntermediateCenter(Log log){
		super();
		try {
			intermediateCenterDataService =(IntermediateCenterDataService) Naming.lookup("rmi://127.0.0.1:6600/intermediateCenterData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IntermediateCenterVO getIntermediateCenterInfo(String id) {
		IntermediateCenterPO iPo = null;
		
		try {
			iPo = intermediateCenterDataService.findIntermediateCenterPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(iPo == null){
			return null;
		}
		IntermediateCenterVO iVo= new IntermediateCenterVO(iPo.getCity(), iPo.getId(),
				iPo.getSpo(), iPo.getBpos());
		return iVo;
	}

	@Override
	public ArrayList<IntermediateCenterVO> getAllIntermediateCenterInfo() {
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ArrayList<IntermediateCenterVO> ivos = new ArrayList<IntermediateCenterVO>();
		
		try {
			ipos = intermediateCenterDataService.findsIntermediateCenterPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		for(int i = 0;i < ipos.size();i++){
			ivos.add(new IntermediateCenterVO(ipos.get(i).getCity(), ipos.get(i).getId(),
					ipos.get(i).getSpo(), ipos.get(i).getBpos()));
		}
		return ivos;
	}

	@Override
	public void addIntermediateCenter(IntermediateCenterVO intermediateCenter) {
		IntermediateCenterPO iPo = new IntermediateCenterPO(intermediateCenter.getCity(),
				intermediateCenter.getId(),intermediateCenter.getSpo(), 
				intermediateCenter.getBpos());
		
		try {
			intermediateCenterDataService.insert(iPo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteIntermediateCenter(String id) {
		try {
			intermediateCenterDataService.deleteIntermediateCenterPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> getcity() {
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ArrayList<String> cs = new ArrayList<String>();
		try {
			ipos = intermediateCenterDataService.findsIntermediateCenterPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i < ipos.size();i++){
			if(!cs.contains(ipos.get(i).getCity())){
				cs.add(ipos.get(i).getCity());
			}
		}
		
		return cs;
	}


}
