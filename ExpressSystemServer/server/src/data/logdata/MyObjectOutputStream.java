package src.data.logdata;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);// �����writeStreamHeader()
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		super.reset();
	}
}
