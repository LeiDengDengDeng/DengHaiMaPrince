package po;


public class ConstantPO implements Sheet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7774935977364748669L;
	
	double distant;
	double price;
	
	public ConstantPO(double distant, double price) {
		super();
		this.distant = distant;
		this.price = price;
	}

	public double getDistant() {
		return distant;
	}

	public void setDistant(double distant) {
		this.distant = distant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
