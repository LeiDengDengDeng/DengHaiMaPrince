package src.data.logdata;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class MyObjectOutputStream extends ObjectOutputStream implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);// »áµ÷ÓÃwriteStreamHeader()
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		super.reset();
	}
}
