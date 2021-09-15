package threadRace;

import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numberList=new ArrayList<>();
		for(int i=0;i<10001;i++) {
			numberList.add(i);
		}
		
		ArrayList<Integer> sublist1=new ArrayList<Integer>(numberList.subList(0, 2501));
		ArrayList<Integer> sublist2=new ArrayList<Integer>(numberList.subList(2500,5001 ));
		ArrayList<Integer> sublist3=new ArrayList<Integer>(numberList.subList(5000, 7501));
		ArrayList<Integer> sublist4=new ArrayList<Integer>(numberList.subList(7500, 10001));

		Founder f1=new Founder(sublist1);
		Founder f2=new Founder(sublist2);
		Founder f3=new Founder(sublist3);
		Founder f4=new Founder(sublist4);
		
		Thread t1=new Thread(f1);
		Thread t2=new Thread(f2);
		Thread t3=new Thread(f3);
		Thread t4=new Thread(f4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		}
}
