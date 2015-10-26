package src.businesslogicservice.institutionbl;

import java.util.ArrayList;

import src.businesslogicservice.institutionblService.InstitutionBLService;
import src.po.InstitutionPO;
import src.vo.InstitutionVO;

public class InstitutionBLService_Driver {

	public void drive(InstitutionBLService institutionBLService){
		institutionBLService.addInstitution(new InstitutionPO("Apart", 000000,
				null, "Manage staff"));
		institutionBLService.getInstitutionInfo(000000);
		ArrayList<InstitutionVO> institutionVOs = institutionBLService.getAllInstitution();
		institutionBLService.changeSalary(000000, 4000);
		institutionBLService.changeStaffPosition("Manager", 000000);
		institutionBLService.deleteInstitution(new InstitutionPO("Apart", 000000,
				null, "Manage staff"));
		institutionBLService.endManagement();
		
	}
}
