package task;

import core.Entitys;

public class MainTask extends Thread{
	private static final int stepTimes = 5;
	@Override
	public void run() {
		Entitys instance = Entitys.getSingleInstance();
		long runtimes = 0;
		while(true) {
			instance.getGold().add(instance.getGoldadd());
			instance.getExp().add(instance.getExpadd());
			runtimes++;
//			System.out.println(runtimes);
			if(runtimes == Long.MAX_VALUE) {
				runtimes = 0;
			}
			if(runtimes>stepTimes && runtimes%stepTimes==0) {
				instance.getGoldadd().add(instance.getGoldstep());
				instance.getExpadd().add(instance.getExpstep());
				System.out.println("Now Gold Add:"+instance.getGoldadd()+" Exp Add:"+instance.getExpadd());
			}
			System.out.println("Now Gold:"+instance.getGold()+" Exp:"+instance.getExp());
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
