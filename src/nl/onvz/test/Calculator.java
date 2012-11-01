package nl.onvz.test;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

public class Calculator {

	public boolean isPrime(long n){
		for(long i=2;i<n;i++) {
	        if(n%i==0) return false;
	    }
	    return true;
	}

	public ArrayList<ByteObject> fillMemoryWithRandombytes(long numberofprimenumbers, int amountOfBytes) {
		
		ArrayList<ByteObject> list = new ArrayList<ByteObject>();
				
		for(long l = 0; l < numberofprimenumbers; l++){
			
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(new ByteObject(amountOfBytes));
			
		
		}
		
		return list;
	}
}
