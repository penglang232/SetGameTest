package core;

import core.entity.BigNumber;

public class Entitys {
	private static Entitys instance = null;
	private BigNumber gold = new BigNumber("0");
	private BigNumber exp = new BigNumber("0");
	private BigNumber goldadd = new BigNumber("5");
	private BigNumber expadd = new BigNumber("5");
	private BigNumber goldstep = new BigNumber("20000000");
	private BigNumber expstep = new BigNumber("10000000");
	
	private Entitys() {
		
	}
	
	public static Entitys getSingleInstance() {
		if(instance == null) {
			instance = new Entitys();
		}
		return instance;
	}

	public BigNumber getGold() {
		return gold;
	}

	public BigNumber getExp() {
		return exp;
	}

	public BigNumber getGoldadd() {
		return goldadd;
	}

	public BigNumber getExpadd() {
		return expadd;
	}

	public BigNumber getGoldstep() {
		return goldstep;
	}

	public BigNumber getExpstep() {
		return expstep;
	}
	
	
}
