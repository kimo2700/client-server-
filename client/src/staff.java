import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Vector;

public class staff  implements Runnable   {
		
		
		
		
		private String num;
		private Socket s;
		private DataOutputStream out;
		private ClientSocket cs;
		private Thread thread;
		public staff(String nu,ClientSocket cs) {
			this.cs=cs;
			this.num="staff"+nu;
			this.thread=new Thread(this,num);
			
			}
		public void start() {
		    thread.start();
		  }
		public static long time = System.currentTimeMillis();
		public  void msg(String m) {
			 System.out.println(time +num+m);
		}
		private void executing(String t) {
			try {
				
				msg(" sending :" +t);
				Thread .sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
			}
		}	 
		@Override
		public void run() {
			 try {
					s = new Socket(cs.getNameServer(), cs.getPortServer());
				    out = new DataOutputStream(s.getOutputStream());
				    msg(" trying to connect to server...");
				    out.writeUTF("staff");//SEND OBJECT NAME 
					 executing("sending object name  request");
					 out.writeUTF(num);// SEND THREAD NAME  
					 executing("sending thread name  request");
				    thread.sleep(3000);// WAIT TO THE END OF THE SHOW 
					 out.writeUTF("callThestudent");// SEND CALLSTUDENTS METHOD TO LET THE STUDENT LEFT OUT
					 executing("calling students");
					 out.writeUTF("EXIT");// SIGNAL CLIENTHELPER THREAD OF THE STAFF TO CLOSE THE STREAMING
					 executing(" ending");
			 } catch (ConnectException e) {
					// TODO Auto-generated catch block
					System.out.println("Problem with sion. Check the port or name machine to connect.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				    
			
			
		}

}
