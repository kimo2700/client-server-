import java.util.Random;
import java.util.Vector;

public class green_uniform {
	public static int itr;
	
	public static Object convey3=new Object();
	public static Object convey4=new Object();
	public static Object[]  conveys= new Object[14];
	public static Vector<Object> waitingGreen=new Vector<Object>();
	public static Vector<Object> waitingOrange=new Vector<Object>();
	private String num;
	public static int turn=-1;
	private String con="0";
	private Thread thread;
	public green_uniform(String nu) {
		this.con=nu;
		
		this.num=nu;
		
		
		
		}
	private void executing(String t) {
		try {
			
			msg(" executing :" +t);
			Thread .sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
		}
	}
	public static long time = System.currentTimeMillis();
	public  void msg(String m) {
		 System.out.println(time +num+m);
	}
	public void entryGoups() {// enter the group method
		executing("creating group of 2 green and 1 orange");
	}
	public void  circlingArround() {
		executing("circling arround the stadium ");
		
	}
        
	
	public void enterShow() {// enter the show method 
		 Object convey =new Object();
		 synchronized(convey) {
			 monitor.decNumb();
			 if (monitor.showOn(convey)) {msg("Left the tent");
				 
					try {
						
						convey.wait();
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 
		 }
		 }
		 msg("entered the show");
	 }
	
}
