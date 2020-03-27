package core.entity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * K M B T q Q s S O
 * 
 * 1 O=10^3 S=10^6 s=10^9 Q=10^12 q=10^15 T+10^18 B=10^21 M=10^24 K=10^27
 * 
 */

public class BigNumber_old {
	
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
	
	private Map<Integer,Integer> digitMap = new HashMap<Integer,Integer>();
	
	public BigNumber_old(String str) {
		int j=0;
		for(int i=str.length();i>0;i-=3){
			if(i>=3){
				digitMap.put(j++, Integer.valueOf(str.substring(i-3, i)));
			}else{
				digitMap.put(j++, Integer.valueOf(str.substring(0, i)));
			}
		}
		
	}
	
	public Map<Integer, Integer> getDigitMap() {
		return digitMap;
	}

	public int getRest() {
		return digitMap.containsKey(0) ? digitMap.get(0) : 0;
	}
	public int getK() {
		return digitMap.containsKey(1) ? digitMap.get(1) : 0;
	}
	public int getM() {
		return digitMap.containsKey(2) ? digitMap.get(2) : 0;
	}
	public int getB() {
		return digitMap.containsKey(3) ? digitMap.get(3) : 0;
	}
	public int getT() {
		return digitMap.containsKey(4) ? digitMap.get(4) : 0;
	}
	public int getq() {
		return digitMap.containsKey(5) ? digitMap.get(5) : 0;
	}
	public int getQ() {
		return digitMap.containsKey(6) ? digitMap.get(6) : 0;
	}
	public int gets() {
		return digitMap.containsKey(7) ? digitMap.get(7) : 0;
	}
	public int getS() {
		return digitMap.containsKey(8) ? digitMap.get(8) : 0;
	}
	public int getO() {
		return digitMap.containsKey(9) ? digitMap.get(9) : 0;
	}
	public int getDigit(int index) {
		return digitMap.containsKey(index) ? digitMap.get(index) : 0;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int len = digitMap.size();
		boolean hasNum = false;
		
		for(int i=len-1;i>=0;i--){
			int temp = digitMap.get(i);
			if(temp>0) {
				hasNum = true;
			}
			if(hasNum) {
				if(i == len-1) {
					sb.append(temp);
				}else {
					sb.append(formatNum(temp));
				}
			}
		}
		if(sb.length()==0) {
			sb.append("0");
		}
		return sb.toString();
	}

	private String formatNum(int temp) {
		String result = String.valueOf(temp);
		while(result.length()<3) {
			result = "0" + result;
		}
		return result;
	}
	
	public int compareTo(BigNumber_old num) {
		int len = digitMap.size();
		int lenNum = num.getDigitMap().size();
		if(len>lenNum) {
			return 1;
		}else if(len>lenNum) {
			return -1;
		}else {
			for(int i = 0;i<len;i++) {
				if(getDigit(i)>num.getDigit(i)) {
					return 1;
				}else if(getDigit(i)<num.getDigit(i)) {
					return -1;
				}
			}
		}
		return 0;
	}

	public void add(BigNumber_old num) {
		int len = digitMap.size();
		int lenNum = num.getDigitMap().size();
		int carry = 0;
		int add = 0;
		len = len >= lenNum ? len : lenNum;
		int i = 0;
		for(;i<len;i++) {
			add = getDigit(i)+num.getDigit(i)+carry;
			digitMap.put(i, add%1000);
			carry = add/1000;
		}
		if(carry!=0) {
			digitMap.put(i, carry);
		}
	}
	
	public void sub(BigNumber_old num) throws Exception {
		if(compareTo(num)<0) {
			throw new Exception("无法计算负数");
		}
		int len = digitMap.size();
		int lenNum = num.getDigitMap().size();
		int carry = 0;
		int preCarry = 0;
		int sub = 0;
		len = len >= lenNum ? len : lenNum;
		int i = 0;
		for(;i<len;i++) {
			if(getDigit(i)<(num.getDigit(i)-carry)) {
				sub = getDigit(i)-num.getDigit(i)+carry;
				preCarry=0;
				while(sub<0) {
					sub+=1000;
					preCarry++;
				}
				preCarry = -1*preCarry;
			}else {
				sub = getDigit(i)-num.getDigit(i)+carry;
				preCarry = 0;
			}
			digitMap.put(i, sub);
			carry = preCarry;
		}
		if(carry!=0) {
			digitMap.put(i, carry);
		}
	}

	public void multi(BigNumber_old num) {
		int len = digitMap.size();
		int lenNum = num.getDigitMap().size();
		int carry = 0;
		int multi = 0;
		len = len >= lenNum ? len : lenNum;
		int i = 0;
		for(;i<len;i++) {
			multi = getDigit(i)*num.getDigit(i)+carry;
			digitMap.put(i, multi%1000);
			carry = multi/1000;
		}
		if(carry!=0) {
			digitMap.put(i, carry);
		}
	}

	public static void main(String[] args) throws Exception {
//		int times = 1000000;
//		long start = System.currentTimeMillis();
//		BigNumber bi1 = new BigNumber("12345678987654321");
//		BigNumber bi2 = new BigNumber("12345678987654321");
//		for(int i=0;i<times;i++){
//			bi1.add(bi2);
//		}
//		System.out.println(bi1.toString());
//		System.out.println((System.currentTimeMillis() - start) + " ms");
//		
//		start = System.currentTimeMillis();
//		BigInteger m = new BigInteger("12345678987654321");
//		BigInteger n = new BigInteger("12345678987654321");
//		for(int i=0;i<times;i++){
//			m=m.add(n);
//		}
//		System.out.println(m.toString());
//		System.out.println((System.currentTimeMillis() - start) + " ms");
		
		BigNumber_old bit = new BigNumber_old("999999");
		BigNumber_old bit2 = new BigNumber_old("1");
		System.out.println(bit.toString());
		bit.add(bit2);
		System.out.println(bit.toString());
		bit.sub(bit2);
		System.out.println(bit.toString());
//		System.out.println(bit.compareTo(bit2));
	}
}
