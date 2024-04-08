package Scan;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyScanner {

	private InputStream source;
	private String delim = " ";

	// Constructors
	
	public MyScanner(InputStream source) {
		this.source = source;
	}
	
	public MyScanner(File source) throws FileNotFoundException {
		this.source = new FileInputStream(source);
	}
	
	public MyScanner(String source) {
		this.source = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
	}
	
	// Methods
	
	public String next() throws IOException {
		int nextChar;
		String buffer = "";
		nextChar = source.read();
		while (nextChar != -1 && nextChar != delim.getBytes()[0]) {
			buffer += asciiToString(nextChar);
			source.mark(2);
			nextChar = source.read();
		}
		if (buffer.length() == 0) {
			throw new NoSuchElementException();
		}
		source.reset();
		return buffer;
	}
	
	public int nextInt() throws IOException {
		int nextToken;
		String buffer = "";
		source.mark(2);
		nextToken = source.read();
		if (nextToken == 45) {
			buffer += asciiToString(nextToken);
			source.mark(2);
			nextToken = source.read();
		}
		while (nextToken > 47 && nextToken < 58) {
			buffer += asciiToString(nextToken);
			source.mark(2);
			nextToken = source.read();	
		}
		source.reset();
		if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
			throw new InputMismatchException();
		}
		return Integer.parseInt(buffer);

	}

	public long nextLong() throws IOException {
		int nextToken;
		String buffer = "";
		source.mark(2);
		nextToken = source.read();
		if (nextToken == -1) {
			throw new NoSuchElementException();
		}
		if (nextToken == 45) {
			buffer += asciiToString(nextToken);
			source.mark(2);
			nextToken = source.read();
		}
		while (nextToken > 47 && nextToken < 58) {
			buffer += asciiToString(nextToken);
			source.mark(2);
			nextToken = source.read();	
		}
		source.reset();
		if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
			throw new InputMismatchException();
		}
		return Long.parseLong(buffer);
	}
	
	public double nextDouble() throws IOException {
	    int nextToken;
	    Boolean noDec = true;
	    String buffer = "";
	    source.mark(2);
	    nextToken = source.read();
	    if (nextToken == -1) {
	        throw new NoSuchElementException();
	    }
	    if (nextToken == 45) { // Handle negative sign
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = source.read();
	    }
	    while ((nextToken >= 48 && nextToken <= 57) || (nextToken == 46 && noDec)) { // Allow digits and decimal point
	        buffer += asciiToString(nextToken);
	        if (nextToken == 46) {
	        	noDec = false;
	        }
	        source.mark(2);
	        nextToken = source.read();
	        
	    }
	    source.reset();
	    if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
	        throw new InputMismatchException();
	    }
	    return Double.parseDouble(buffer);
	}
	
	public float nextFloat() throws IOException {
	    int nextToken;
	    Boolean noDec = true;
	    String buffer = "";
	    source.mark(2);
	    nextToken = source.read();
	    if (nextToken == -1) {
	        throw new NoSuchElementException();
	    }
	    if (nextToken == 45) { // Handle negative sign
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = source.read();
	    }
	    while ((nextToken >= 48 && nextToken <= 57) || (nextToken == 46 && noDec)) { // Allow digits and decimal point
	        buffer += asciiToString(nextToken);
	        if (nextToken == 46) {
	        	noDec = false;
	        }
	        source.mark(2);
	        nextToken = source.read();
	    }
	    source.reset();
	    if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
	        throw new InputMismatchException();
	    }
	    return Float.parseFloat(buffer);
	}

	public short nextShort() throws IOException {
	    int nextToken;
	    String buffer = "";
	    source.mark(2);
	    nextToken = (short) source.read(); // Cast to short
	    if (nextToken == 45) {
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = (short) source.read(); // Cast to short
	    }
	    while (nextToken > 47 && nextToken < 58) {
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = (short) source.read(); // Cast to short
	    }
	    source.reset();
	    if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
	        throw new InputMismatchException();
	    }
	    return Short.parseShort(buffer); // Parse to short
	}

	public byte nextByte() throws IOException {
	    int nextToken;
	    String buffer = "";
	    source.mark(2);
	    nextToken = source.read(); // Cast to byte
	    if (nextToken == 45) {
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = source.read(); // Cast to byte
	    }
	    while (nextToken > 47 && nextToken < 58) {
	        buffer += asciiToString(nextToken);
	        source.mark(2);
	        nextToken = source.read(); // Cast to byte
	    }
	    source.reset();
	    if (buffer.length() == 0 || (buffer.length() == 1 && buffer.charAt(0) == '-')) {
	        throw new InputMismatchException();
	    }
	    return Byte.parseByte(buffer); // Parse to byte
	}

	public String nextLine() throws NoSuchElementException, IOException {
		int nextToken;
		String buffer = "";
		nextToken = source.read();
		while (nextToken != 10 && nextToken != -1) {
			buffer += asciiToString(nextToken);
			nextToken = source.read();
		}
		if (buffer.length() == 0) {
			throw new NoSuchElementException();
		}
		return buffer;
	}
	
	public Boolean nextBoolean() throws InputMismatchException, IOException {
		byte[] boolBytes = new byte[5];
		source.mark(6);
		source.read(boolBytes);
		if (boolBytes.equals("false".getBytes())) {
			return false;
		}
		source.reset();
		if (Arrays.copyOfRange(boolBytes, 0, 4).equals("true".getBytes())) {
			source.readNBytes(4);
			return true;
		}
		throw new InputMismatchException();
	}
	
	public void useDelimiter(String pattern) {
		delim = pattern;
	}
	
	public Boolean hasNext() throws IOException {
		if (source.available() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean hasNextInt() {
		source.mark(14);
		try {
			nextInt();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	public Boolean hasNextDouble() {
		source.mark(40);
		try {
			nextDouble();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	public Boolean hasNextLong() {
		source.mark(40);
		try {
			nextLong();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	public Boolean hasNextFloat() {
		source.mark(40);
		try {
			nextFloat();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	public Boolean hasNextShort() {
		source.mark(40);
		try {
			nextShort();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	public Boolean hasNextByte() {
		source.mark(2);
		try {
			nextByte();
		} catch (InputMismatchException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		try {
			source.reset();
		} catch (IOException e) {}
		return true;
	}
	
	private String asciiToString(int intByte) {
	    return new String(new byte[]{(byte) intByte}, StandardCharsets.UTF_8);
	}
}
	
