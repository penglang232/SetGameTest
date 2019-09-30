package core;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * K M B T q Q s S O
 * 
 * 1 O=10^3 S=10^6 s=10^9 Q=10^12 q=10^15 T+10^18 B=10^21 M=10^24 K=10^27
 * 
 */

public class BigNumber {
	
//	int rest;
//	int K;
//	int M;
//	int B;
//	int T;
//	int q;
//	int Q;
//	int s;
//	int S;
//	int O;
	
	Map<Integer,Integer> digitMap = new HashMap<Integer,Integer>();
	
	public BigNumber(String str) {
		int j=0;
		for(int i=str.length();i>0;i-=3){
			if(i>=3){
				digitMap.put(j++, Integer.valueOf(str.substring(i-3, i)));
			}else{
				digitMap.put(j++, Integer.valueOf(str.substring(0, i)));
			}
		}
		
	}
	
	public int getRest() {
		return digitMap.containsKey(0) ? digitMap.get(0) : -1;
	}
	public int getK() {
		return digitMap.containsKey(1) ? digitMap.get(1) : -1;
	}
	public int getM() {
		return digitMap.containsKey(2) ? digitMap.get(2) : -1;
	}
	public int getB() {
		return digitMap.containsKey(3) ? digitMap.get(3) : -1;
	}
	public int getT() {
		return digitMap.containsKey(4) ? digitMap.get(4) : -1;
	}
	public int getq() {
		return digitMap.containsKey(5) ? digitMap.get(5) : -1;
	}
	public int getQ() {
		return digitMap.containsKey(6) ? digitMap.get(6) : -1;
	}
	public int gets() {
		return digitMap.containsKey(7) ? digitMap.get(7) : -1;
	}
	public int getS() {
		return digitMap.containsKey(8) ? digitMap.get(8) : -1;
	}
	public int getO() {
		return digitMap.containsKey(9) ? digitMap.get(9) : -1;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int len = digitMap.size();
		for(int i=len-1;i>=0;i--){
			int temp = digitMap.get(i);
			if(temp >= 0)
				sb.append(temp);
		}
		return sb.toString();
	}



	public static void main(String[] args) {
//		long start = System.currentTimeMillis();
//		BigInteger bi1 = new BigInteger("12345678987654321");
//		BigInteger bi2 = new BigInteger("12345678987654321");
//		for(int i=0;i<10000000;i++){
//			bi1 = bi1.add(bi2);
//		}
//		System.out.println(bi1.toString());
//		System.out.println((System.currentTimeMillis() - start) + " ms");
//		
//		start = System.currentTimeMillis();
//		long m = 12345678987654321L;
//		long n = 12345678987654321L;
//		for(int i=0;i<10000000;i++){
//			m+=n;
//		}
//		System.out.println(m);
//		System.out.println((System.currentTimeMillis() - start) + " ms");
		
		BigNumber bit = new BigNumber("12345678987654321");
		System.out.println(bit.toString());
		System.out.println(bit.getRest());
		System.out.println(bit.getO());
	}
}
