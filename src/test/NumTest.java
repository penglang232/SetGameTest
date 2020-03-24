package test;

import java.math.BigInteger;

public class NumTest {
	public static void main(String[] args) {
		String a = "";
		String b = "";
		long start = System.currentTimeMillis();
		for(int i=0;i<5000;i++) {
			a += "1";
			b += "2";
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		
		System.out.println(a);
		System.out.println(b);
		BigInteger ba = new BigInteger(a);
		BigInteger bb = new BigInteger(b);
		
		ba = ba.add(bb);
		System.out.println((System.currentTimeMillis() - start) + " ms");
		System.out.println(ba.toString());
	}
}
