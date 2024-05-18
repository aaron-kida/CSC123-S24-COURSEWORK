package Assignment6;

import java.util.HashMap;
import java.util.Map;

public class Currencies {
	
	Map<String,MyCurrency> currencies = new HashMap<String, MyCurrency>();
	
	public Currencies(String loaderType) throws Exception {		
		AbstractCurrencyLoader cl=AbstractCurrencyLoader.getInstance(loaderType);
		if (cl == null) {
			System.out.println("failed to create abscract currency loader of type" + loaderType);
		}
		currencies=cl.loadCurrencies();		
	}	

	public MyCurrency getCurrency(String name) {
        return currencies.get(name.strip().toUpperCase());
    }
	
	public boolean existsCurrency(String name) {
		return currencies.containsKey(name.strip().toUpperCase());
	}	
}
