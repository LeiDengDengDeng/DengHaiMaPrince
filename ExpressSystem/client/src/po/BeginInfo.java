package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class BeginInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 722606905171710148L;

	ArrayList<DriverPO> beginDriver;
	ArrayList<InstitutionPO> beginInstitution;
	ArrayList<TruckPO> beginTruck;
	
	ConstantPO beginConstant;
	
	
}
