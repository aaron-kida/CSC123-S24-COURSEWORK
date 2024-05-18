package Assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCurrencyLoader {

	
	public static AbstractCurrencyLoader getInstance(String type) {
		type=type.strip();
		
		if(type.equals("File")) {
			return new FileCurrencyLoader();
			
		}
		else if (type.equals("Network")){
			return new NetworkCurrencyLoader();
		}
		
		else if(type.equals("String")) {
			return new StringHook();		
		}		
		return null;		
	}
	
	public Map<String, MyCurrency> loadCurrencies() throws Exception{
		Map m=new HashMap<String, MyCurrency>();
		BufferedReader br=new BufferedReader(new InputStreamReader(getStream()));
		
		String line=null;
		while((line=br.readLine())!=null) {
			String[] tokens=line.split(",");
			String currencyCode=tokens[0];
			double exchangeRate=Double.valueOf(tokens[2]);
			m.put(currencyCode,new MyCurrency(currencyCode, exchangeRate));
		}
		return m;
	}
	
	protected abstract InputStream getStream() throws FileNotFoundException, IOException;
 	
}