
public class staff {
	private String num;
	public static int turn=-1;
	private String con="0";
	private Thread thread;
	public staff(String nu) {
		this.con=nu;
		this.num=nu;
		}
	public static Object convey5=new Object();
	public static long time = System.currentTimeMillis();
	public  void msg(String m) {
		 System.out.println(time +num+m);
	}
	public void callThestudent() {
		
		msg("end of the show ");// release other student who couldn't  attend the show first time 
		int count=0;
		while(count<=3)
			while(monitor.waitingTheshow.size()>0) {
				synchronized(monitor.waitingTheshow.elementAt(0)) {// releasing the student left outside the tent in FCFS ORDER
				monitor.waitingTheshow.elementAt(0).notify();
				}
				monitor.waitingTheshow.removeElementAt(0);
				count++;
				
			}
		
	}

}
