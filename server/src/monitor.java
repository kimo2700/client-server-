
import java.util.Vector;

public class monitor {
	public static int numb=12; // number of people in the show 
	public static Vector<Object> waitingGreen=new Vector<Object>();
	public static Vector<Object> waitingOrange=new Vector<Object>();
	public static Vector<Object> waitingTheshow=new Vector<Object>();
	//public static Vector<Object> watchingTheshow=new Vector<Object>();
	
	
	public synchronized static boolean notReadyorange (Object convey) {// case of upcoming orange
		boolean status;
		if (waitingGreen.size()>=2) {
			status=false;
			synchronized(waitingGreen.elementAt(0)) {// notify the 2 first green
			waitingGreen.elementAt(0).notify();
		}
			waitingGreen.removeElementAt(0);
			synchronized(waitingGreen.elementAt(0)) {
				waitingGreen.elementAt(0).notify();
			}
			waitingGreen.removeElementAt(0);
		
		
	}
		else {status=true;
		 waitingOrange.addElement(convey);}
		return status;

}
	public synchronized static boolean notReadygreen (Object convey) {//case of upcoming green 
		boolean status;
		if (waitingGreen.size()>=1&&waitingOrange.size()>=1 ) {
			status=false;
			synchronized(waitingGreen.elementAt(0)) {// notify the first green and the first orange
				waitingGreen.elementAt(0).notify();
				
			}
			waitingGreen.removeElementAt(0);
			synchronized(waitingOrange.elementAt(0)) {
				waitingOrange.elementAt(0).notify();
			}
			waitingOrange.removeElementAt(0);
		
		
	}
		else{status=true;
		waitingGreen.addElement(convey);}
		return status;
			
		}
	public synchronized  static boolean showOn(Object convey) {
		
		boolean status;
		if (numb<0) {
			status=true;
			waitingTheshow.addElement(convey);
			
			
		}
		else {
			status=false;
			
		}
		//watchingTheshow.addElement(convey);
		return status;
		
		
	}
	public synchronized static void incNumb() {
	++numb;
	}
	public synchronized static void decNumb() {
numb--;
	}
	public synchronized static boolean isEmpty() {
		if (numb>=6)
		return true;
		else return false;
				
				
	}
	
}