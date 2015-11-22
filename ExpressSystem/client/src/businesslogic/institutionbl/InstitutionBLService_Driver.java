package src.businesslogic.institutionbl;

import java.util.ArrayList;

import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.po.InstitutionPO;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;

public class InstitutionBLService_Driver {

	public void drive(InstitutionBLService institutionBLService){
		institutionBLService.addInstitution(new InstitutionVO("Apart", 000000,
				null, "Manage staff"));
		institutionBLService.getInstitutionInfo(000000);
		ArrayList<InstitutionVO> institutionVOs = institutionBLService.getAllInstitution();
		institutionBLService.changeSalary(000000, new SalaryVO(2000));
		institutionBLService.changeStaffPosition("Manager", 000000);
		institutionBLService.deleteInstitution(000000);
		institutionBLService.endManagement();
		
	}
}
