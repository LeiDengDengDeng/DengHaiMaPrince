package src.po;

import java.util.ArrayList;


public class ConstantPO implements SheetPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7774935977364748669L;
	
	ArrayList<Double> distant = new ArrayList<Double>();
	double price;
	
	public ConstantPO(ArrayList<Double> distant, double price) {
		super();
		this.distant = distant;
		this.price = price;
	}

	public ArrayList<Double> getDistant() {
		return distant;
	}

	public void setDistant(ArrayList<Double> distant) {
		this.distant = distant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
