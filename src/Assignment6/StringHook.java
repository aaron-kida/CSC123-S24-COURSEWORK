package Assignment6;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringHook extends AbstractCurrencyLoader{

	@Override
	protected InputStream getStream() {
		String line="CAD,Canadian Dollar,0.60\n"
				+ "EUR,Euro Dollar,1.2\n";
		ByteArrayInputStream bi=new ByteArrayInputStream(line.getBytes());
		return bi;
	}
	

}