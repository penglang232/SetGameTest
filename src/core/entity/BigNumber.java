package core.entity;

import java.math.BigInteger;

/**
 * 
 * K M B T q Q s S O
 * 
 * 1 O=10^3 S=10^6 s=10^9 Q=10^12 q=10^15 T+10^18 B=10^21 M=10^24 K=10^27
 * 
 */

public class BigNumber{
	private BigInteger val = null;
	private static final String[] orders = {"","K","M","B","T","q","Q","s","S","O"};
	
	public BigNumber(String val) {
		this.val = new BigInteger(val);
	}

	@Override
	public String toString() {
		if(val == null) {
			return "";
		}
		String valStr = val.toString();
		int len = valStr.length();
		int orderIndex = (len-1)/3;
		if(orderIndex==0) {
			return valStr;
		}else if(orderIndex<orders.length) {
			int left = len%3;
			if(left == 0) {
				return valStr.substring(0, 3)+orders[orderIndex];
			}else {
				return valStr.substring(0, left)+"."+valStr.substring(left, 3)+orders[orderIndex];
			}
		}else {
			return valStr.substring(0, 1)+"."+valStr.substring(1, 3)+"e"+3*orderIndex;
		}
	}

	public BigInteger getVal() {
		return val;
	}
	
	public void add(BigNumber val) {
		this.val = getVal().add(val.getVal());
	}
	
	public static void main(String[] args) {
		BigNumber b1 = new BigNumber("114455");
		System.out.println(b1.toString());
		BigNumber b2 = new BigNumber("12");
		b2.add(b1);
		System.out.println(b2);
	}
}
