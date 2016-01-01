package src.vo;

import src.enums.GoodsType;

public class GoodsVO {
	private String expressNumber;//快递编号
	private String goodsName;//内件品名
	private int goodsNumber;//原件数量
	private double length;//货物的长
	private double width;//货物的宽
	private double height;//货物的高
	private double factWeight;//实际重量
	private double size;//货物体积
	private GoodsType expressForm;//快递方式
	private GoodsType packagingForm;//包装方式
	
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
