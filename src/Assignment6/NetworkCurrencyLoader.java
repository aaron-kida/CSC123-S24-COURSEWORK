package Assignment6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class NetworkCurrencyLoader extends AbstractCurrencyLoader {

    private static final String EXCHANGE_RATE_URL = "http://www.usman.cloud/banking/exchange-rate.csv";

    @Override
    protected InputStream getStream() throws IOException {
        URL url = new URL(EXCHANGE_RATE_URL);
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }
    
}