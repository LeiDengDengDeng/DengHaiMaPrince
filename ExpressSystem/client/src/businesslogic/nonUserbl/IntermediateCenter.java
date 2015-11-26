package src.businesslogic.nonUserbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.IntermediateCenterBLService;
import src.dataservice.nonUserdataservice.IntermediateCenterDataService;
import src.po.IntermediateCenterPO;
import src.vo.IntermediateCenterVO;

public class IntermediateCenter implements IntermediateCenterBLService{
	
	LogBLService logBLService;
	IntermediateCenterDataService intermediateCenterDataService;
	
	public IntermediateCenter(IntermediateCenterDataService 
			intermediateCenterDataService){
		super();
		this.intermediateCenterDataService = intermediateCenterDataService;
	}

	@Override
	public IntermediateCenterVO getIntermediateCenterInfo(String id) {
		IntermediateCenterPO iPo = null;
		
		try {
			iPo = intermediateCenterDataService.findIntermediateCenterPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		IntermediateCenterVO iVo= new IntermediateCenterVO(iPo.getCity(), 
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
		
		int i = 0;
		while(ipos.get(i) != null){
			ivos.add(new IntermediateCenterVO(ipos.get(i).getCity(), 
					ipos.get(i).getSpo(), ipos.get(i).getBpos()));
			i++;
		}
		return ivos;
	}

	@Override
	public void addIntermediateCenter(IntermediateCenterVO intermediateCenter) {
		IntermediateCenterPO iPo = new IntermediateCenterPO(intermediateCenter.getCity(), 
				intermediateCenter.getSpo(), intermediateCenter.getBpos());
		
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
		int i = 0;
		while(ipos.get(i) != null){
			if(!cs.contains(ipos.get(i).getCity())){
				cs.add(ipos.get(i).getCity());
			}
			i++;
		}
		
		return cs;
	}


}
