package src.vo;

import src.enums.GoodsType;

public class GoodsVO {
	private String expressNumber;//��ݱ��
	private String goodsName;//�ڼ�Ʒ��
	private int goodsNumber;//ԭ������
	private double length;//����ĳ�
	private double width;//����Ŀ�
	private double height;//����ĸ�
	private double factWeight;//ʵ������
	private double size;//�������
	private GoodsType expressForm;//��ݷ�ʽ
	private GoodsType packagingForm;//��װ��ʽ
	
	public GoodsVO(String expressNumber,String goodsName, int goodsNumber, double length,
			double width, double height, double factWeight, double size,
			GoodsType expressForm, GoodsType packagingForm) {
		super();
		this.expressNumber = expressNumber;
		this.goodsName = goodsName;
		this.goodsNumber = goodsNumber;
		this.length = length;
		this.width = width;
		this.height = height;
		this.factWeight = factWeight;
		this.size = size;
		this.expressForm = expressForm;
		this.packagingForm = packagingForm;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getFactWeight() {
		return factWeight;
	}

	public void setFactWeight(double factWeight) {
		this.factWeight = factWeight;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public GoodsType getExpressForm() {
		return expressForm;
	}

	public void setExpressForm(GoodsType expressForm) {
		this.expressForm = expressForm;
	}

	public GoodsType getPackagingForm() {
		return packagingForm;
	}

	public void setPackagingForm(GoodsType packagingForm) {
		this.packagingForm = packagingForm;
	}

}
