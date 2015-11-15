package src.vo;

public class StorageNumVO {
	private int inNum;//入库数量
	private int outNUm;//出库数量
	private int totalNUm;//总库存数量
	
	public StorageNumVO(int inNum, int outNUm, int totalNUm) {
		super();
		this.inNum = inNum;
		this.outNUm = outNUm;
		this.totalNUm = totalNUm;
	}

	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

	public int getOutNUm() {
		return outNUm;
	}

	public void setOutNUm(int outNUm) {
		this.outNUm = outNUm;
	}

	public int getTotalNUm() {
		return totalNUm;
	}

	public void setTotalNUm(int totalNUm) {
		this.totalNUm = totalNUm;
	}
	
}
