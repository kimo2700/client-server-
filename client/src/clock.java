
public class clock implements Runnable {
	public static int itr;

	public  static Object convey1=new Object();
	private String num;
	private Thread thread;
	public clock(String nu) {
		
		this.num="clock"+nu;
		this.thread=new Thread(this,num);
		
		}
	public void start() {
	    thread.start();
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
public void run() {
	msg("Parade 11:00am start");
	try {
		thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	synchronized(convey1) {
		
		
      convey1.notifyAll();
          }
	
		
		
	
	
}
}
