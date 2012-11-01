package nl.onvz.test;

import java.util.ArrayList;


public class ByteObject {

	/*
	The idea when creating this class was that the user could exactly add one byte to the memory every time as often as a user wants.
	
	But a byte in memory actually takes up way more than just 1 byte in memory. 
	Depending on 32-bit or 64-bit cpu architecture it can take either 4 or 8 bytes.
	The problem we are having though, is that the arraylist and each spot of it also consumes memory, telfo
	so there is no way for sure we can tell how many bytes we are really filling into the memory.
	Therefore, we have to test this out manually in the webapplication.
	
	Rens Groenveld
	*/
	
	ArrayList<Byte> bytelist = new ArrayList<Byte>();
	
	public ByteObject(int amountOfBytes) {

		for (int i=0; i<amountOfBytes; i++){
			bytelist.add((byte) 1);
		}
		
	}


}

//public class ByteObject {
//	private byte[] bytes = null;
//
//	public ByteObject(int amountOfBytes) {
//		bytes = new byte[amountOfBytes];
//		
//		for (int i=0; i<bytes.length; i++) {
//			Random random = new Random(System.currentTimeMillis());
//			random.nextBytes(bytes);
//		}
//	}
//
//	public byte[] getBytes() {
//		return bytes;
//	}
//}
