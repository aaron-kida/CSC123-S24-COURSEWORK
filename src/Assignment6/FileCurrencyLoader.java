package Assignment6;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileCurrencyLoader extends AbstractCurrencyLoader{

	@Override
	protected InputStream getStream() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\dan80\\Downloads\\currencies.csv");
		InputStream fileStream = new FileInputStream(file);
		return fileStream;
	}

}