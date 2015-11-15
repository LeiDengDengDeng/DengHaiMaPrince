package src.po;

import java.util.ArrayList;

public class CommodityPO {
	private String StorageId;//�ֿ�id
	private int isOccupied;//��λ���Ƿ����л���
	private ArrayList<GoodsPO> goodslist;//�ֿ��ڵĻ�����Ϣ
	private StoragePO spo;//�ֿ�Ŀ����Ϣ
	
	public CommodityPO(String storageId, int isOccupied,
			ArrayList<GoodsPO> goodslist, StoragePO spo) {
		super();
		StorageId = storageId;
		this.isOccupied = isOccupied;
		this.goodslist = goodslist;
		this.spo = spo;
	}

	public String getStorageId() {
		return StorageId;
	}

	public void setStorageId(String storageId) {
		StorageId = storageId;
	}

	public int getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(int isOccupied) {
		this.isOccupied = isOccupied;
	}

	public ArrayList<GoodsPO> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(ArrayList<GoodsPO> goodslist) {
		this.goodslist = goodslist;
	}

	public StoragePO getSpo() {
		return spo;
	}

	public void setSpo(StoragePO spo) {
		this.spo = spo;
	}
	
	

}
