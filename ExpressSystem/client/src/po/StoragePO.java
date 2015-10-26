package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StoragePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5780752231210513001L;
	
	//在入库时调用add方法增加库存数量，在出库时调用minus方法减少库存数量
	private int inNum;//入库数量
	private int outNum;//出库数量
	private int storageNumber;//商品库存总数量
	private int shippingNumber;//航运区库存数量
	private int railNumber;//铁运区库存数量
	private int transportNumber;//汽运区库存数量
	private int flxibleNumber;//机动区库存数量
	private double alarmScale;//警戒比例
	private int shippingStart;//航运区起始
	private int shippingEnd;//航运区终止
	private int railStart;//铁运区起始
	private int railEnd;//铁运区终止
	private int transportStart;//汽运区起始
	private int transportEnd;//汽运区终止
	private int flxibleStart;//机动区起始
	private int flxibleEnd;//机动区终止
	private ArrayList<GoodsPO> gpos;
	
	public StoragePO(int inNum, int outNum, int storageNumber,
			int shippingNumber, int railNumber, int transportNumber,
			int flxibleNumber, double alarmScale, int shippingStart,
			int shippingEnd, int railStart, int railEnd, int transportStart,
			int transportEnd, int flxibleStart, int flxibleEnd,
			ArrayList<GoodsPO> gpos) {
		super();
		this.inNum = inNum;
		this.outNum = outNum;
		this.storageNumber = storageNumber;
		this.shippingNumber = shippingNumber;
		this.railNumber = railNumber;
		this.transportNumber = transportNumber;
		this.flxibleNumber = flxibleNumber;
		this.alarmScale = alarmScale;
		this.shippingStart = shippingStart;
		this.shippingEnd = shippingEnd;
		this.railStart = railStart;
		this.railEnd = railEnd;
		this.transportStart = transportStart;
		this.transportEnd = transportEnd;
		this.flxibleStart = flxibleStart;
		this.flxibleEnd = flxibleEnd;
		this.gpos = gpos;
	}

	public void addInNum(){
		inNum++;
	}
	
	public void minusInNum(){
		inNum--;
	}

	public int getInNum() {
		return inNum;
	}
	
	public void addOutNum(){
		outNum++;
	}
	
	public void minusOutNum(){
		outNum--;
	}

	public int getOutNum() {
		return outNum;
	}

	public double getAlarmScale() {
		return alarmScale;
	}

	public void setAlarmScale(double alarmScale) {
		this.alarmScale = alarmScale;
	}

	public int getShippingStart() {
		return shippingStart;
	}

	public void setShippingStart(int shippingStart) {
		this.shippingStart = shippingStart;
	}

	public int getShippingEnd() {
		return shippingEnd;
	}

	public void setShippingEnd(int shippingEnd) {
		this.shippingEnd = shippingEnd;
	}

	public int getRailStart() {
		return railStart;
	}

	public void setRailStart(int railStart) {
		this.railStart = railStart;
	}

	public int getRailEnd() {
		return railEnd;
	}

	public void setRailEnd(int railEnd) {
		this.railEnd = railEnd;
	}

	public int getTransportStart() {
		return transportStart;
	}

	public void setTransportStart(int transportStart) {
		this.transportStart = transportStart;
	}

	public int getTransportEnd() {
		return transportEnd;
	}

	public void setTransportEnd(int transportEnd) {
		this.transportEnd = transportEnd;
	}

	public int getFlxibleStart() {
		return flxibleStart;
	}

	public void setFlxibleStart(int flxibleStart) {
		this.flxibleStart = flxibleStart;
	}

	public int getFlxibleEnd() {
		return flxibleEnd;
	}

	public void setFlxibleEnd(int flxibleEnd) {
		this.flxibleEnd = flxibleEnd;
	}
	
	public void addStorageNUm(){
		storageNumber++;
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

	public void addGpos(GoodsPO gpo) {
		gpos.add(gpo);
	}
	
}
