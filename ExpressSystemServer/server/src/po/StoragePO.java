package src.po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �����Ϣ�־û�����
 * @author Potter
 *
 */
public class StoragePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5780752231210513001L;
	
	//�����ʱ����add�������ӿ���������ڳ���ʱ����minus�������ٿ������
	private String city;//�ֿ����ڳ���
//	private int inNum;//�������
//	private int outNum;//��������
	private int storageNumber;//��Ʒ���������
	private int shippingNumber;//�������������
	private int railNumber;//�������������
	private int transportNumber;//�������������
	private int flxibleNumber;//�������������
	private double alarmScale;//�������
	private int shippingSize;//��������С
	private int railSize;//��������С
	private int transportSize;//��������С
	private int flxibleSize;//��������С
//	private int shippingStart;//��������ʼ
//	private int shippingEnd;//��������ֹ
//	private int railStart;//��������ʼ
//	private int railEnd;//��������ֹ
//	private int transportStart;//��������ʼ
//	private int transportEnd;//��������ֹ
//	private int flxibleStart;//��������ʼ
//	private int flxibleEnd;//��������ֹ
	private ArrayList<GoodsPO> gpos;//�ֿ��ڵĻ�����Ϣ
	
	public StoragePO(String city, int storageNumber, int shippingNumber,
			int railNumber, int transportNumber, int flxibleNumber,
			double alarmScale, int shippingSize, int railSize,
			int transportSize, int flxibleSize, ArrayList<GoodsPO> gpos) {
		super();
		this.city = city;
		this.storageNumber = storageNumber;
		this.shippingNumber = shippingNumber;
		this.railNumber = railNumber;
		this.transportNumber = transportNumber;
		this.flxibleNumber = flxibleNumber;
		this.alarmScale = alarmScale;
		this.shippingSize = shippingSize;
		this.railSize = railSize;
		this.transportSize = transportSize;
		this.flxibleSize = flxibleSize;
		this.gpos = gpos;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


//	public void addInNum(){
//		inNum++;
//	}
//	
//	public void minusInNum(){
//		inNum--;
//	}
//
//	public int getInNum() {
//		return inNum;
//	}
//	
//	public void addOutNum(){
//		outNum++;
//	}
//	
//	public void minusOutNum(){
//		outNum--;
//	}
//
//	public int getOutNum() {
//		return outNum;
//	}

	public double getAlarmScale() {
		return alarmScale;
	}

	public void setAlarmScale(double alarmScale) {
		this.alarmScale = alarmScale;
	}

//	public int getShippingStart() {
//		return shippingStart;
//	}
//
//	public void setShippingStart(int shippingStart) {
//		this.shippingStart = shippingStart;
//	}
//
//	public int getShippingEnd() {
//		return shippingEnd;
//	}
//
//	public void setShippingEnd(int shippingEnd) {
//		this.shippingEnd = shippingEnd;
//	}
//
//	public int getRailStart() {
//		return railStart;
//	}
//
//	public void setRailStart(int railStart) {
//		this.railStart = railStart;
//	}
//
//	public int getRailEnd() {
//		return railEnd;
//	}
//
//	public void setRailEnd(int railEnd) {
//		this.railEnd = railEnd;
//	}
//
//	public int getTransportStart() {
//		return transportStart;
//	}
//
//	public void setTransportStart(int transportStart) {
//		this.transportStart = transportStart;
//	}
//
//	public int getTransportEnd() {
//		return transportEnd;
//	}
//
//	public void setTransportEnd(int transportEnd) {
//		this.transportEnd = transportEnd;
//	}
//
//	public int getFlxibleStart() {
//		return flxibleStart;
//	}
//
//	public void setFlxibleStart(int flxibleStart) {
//		this.flxibleStart = flxibleStart;
//	}
//
//	public int getFlxibleEnd() {
//		return flxibleEnd;
//	}
//
//	public void setFlxibleEnd(int flxibleEnd) {
//		this.flxibleEnd = flxibleEnd;
//	}
	
	
	
	public void addStorageNUm(){
		storageNumber++;
	}
	
	public int getShippingSize() {
		return shippingSize;
	}


	public void setShippingSize(int shippingSize) {
		this.shippingSize = shippingSize;
	}


	public int getRailSize() {
		return railSize;
	}


	public void setRailSize(int railSize) {
		this.railSize = railSize;
	}


	public int getTransportSize() {
		return transportSize;
	}


	public void setTransportSize(int transportSize) {
		this.transportSize = transportSize;
	}


	public int getFlxibleSize() {
		return flxibleSize;
	}


	public void setFlxibleSize(int flxibleSize) {
		this.flxibleSize = flxibleSize;
	}


	public void minusStorageNUm(){
		storageNumber--;
	}
	
	public int getStorageNumber() {
		return storageNumber;
	}

	public void addShippingNUm(){
		shippingNumber++;
	}
	
	public void minusShippingNUm(){
		storageNumber--;
	}
	
	public int getShippingNumber() {
		return shippingNumber;
	}

	public void addRailNUm(){
		railNumber++;
	}
	
	public void minusRailNUm(){
		storageNumber--;
	}
	
	public int getRailNumber() {
		return railNumber;
	}

	public void addTransportNUm(){
		transportNumber++;
	}
	
	public void minusTransportNUm(){
		storageNumber--;
	}
	
	public int getTransportNumber() {
		return transportNumber;
	}

	public void addFlxibleNUm(){
		flxibleNumber++;
	}
	
	public void minusFlxibleNUm(){
		storageNumber--;
	}

	public int getFlxibleNumber() {
		return flxibleNumber;
	}

	public ArrayList<GoodsPO> getGpos() {
		return gpos;
	}

	public void setGpos(ArrayList<GoodsPO> gpos) {
		this.gpos = gpos;
	}

	public void addGpos(GoodsPO gpo) {
		gpos.add(gpo);
	}
	
}
