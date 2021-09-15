package threadRace;

import java.util.ArrayList;
import java.util.List;

public class Founder implements Runnable{
	private List<Integer> list=new ArrayList<>();
	private List<Integer> odd=new ArrayList<>();
	private List<Integer> even=new ArrayList<>();
	
	


	public Founder(List<Integer> numberList) {
		for(int i=1;i<numberList.size();i++) {
			list.add(numberList.get(i));
		}
	}




	@Override
	public void run() {
		
		for(int i=0;i<list.size();i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(list.get(i) % 2 == 0)
				synchronized (even) {
					even.add(list.get(i));	
					System.out.println(list.get(i)+" even "+Thread.currentThread().getName());
				}
			else
				synchronized (odd) {
					odd.add(list.get(i));
					System.out.println(list.get(i)+" odd "+Thread.currentThread().getName());
				}
		}
		
		System.out.println(Thread.currentThread().getName()+ " total even elements :"+even.size());
		System.out.println(Thread.currentThread().getName()+ " total odd elements :"+odd.size());
	}
}
