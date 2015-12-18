package src.po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Ӫҵ���־û�����
 * @author Potter
 *
 */
public class BussinessHallPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7257618010378578228L;
	private String hallName;//Ӫҵ������
	private String hallId;//Ӫҵ�����
	private ArrayList<DriverPO> drivers;
	private ArrayList<TruckPO> trucks;
	
	public BussinessHallPO(String hallName, String hallId,
			ArrayList<DriverPO> drivers, ArrayList<TruckPO> trucks) {
		super();
		this.hallName = hallName;
		this.hallId = hallId;
		this.drivers = drivers;
		this.trucks = trucks;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public String getHallId() {
		return hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}

	public ArrayList<DriverPO> getDrivers() {
		return drivers;
	}

	public void setDrivers(ArrayList<DriverPO> drivers) {
		this.drivers = drivers;
	}

	public ArrayList<TruckPO> getTrucks() {
		return trucks;
	}

	public void setTrucks(ArrayList<TruckPO> trucks) {
		this.trucks = trucks;
	}
	
}
