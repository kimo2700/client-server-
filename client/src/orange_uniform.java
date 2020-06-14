
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Vector;


	public class orange_uniform  implements Runnable   {
		
		
		private String num;
		private Socket s;
		private DataOutputStream out;
		private Thread thread;
		private ClientSocket cs;
		public orange_uniform(String nu, ClientSocket cs) {
			
			this.num="orange_"+nu;
			this.cs=cs;
	
			this.thread=new Thread(this,num);
			
			}
		public static long time = System.currentTimeMillis();
		public  void msg(String m) {
			 System.out.println(time +num+m);}
		public void start() {
		    thread.start();
		  }
		private void executing(String t) {
			try {
				
				msg(" sending :" +t);
				Thread .sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
			}
		}	 
		
		 public void run() {
			 try {
				s = new Socket(cs.getNameServer(), cs.getPortServer());
			    out = new DataOutputStream(s.getOutputStream());
			    msg(" trying to connect to server...");
				
			 
			 synchronized(clock.convey1) {// wait to the open pride 
					
						
						try {
							clock.convey1.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			 out.writeUTF("orange_uniform");//SEND OBJECT NAME 
			 executing(" object name  request");
			 out.writeUTF(num);// SEND THREAD NAME 
			 executing(" thread name request");
			 out.writeUTF("entryGoups");//SEND METHOD NAME 
			 executing("calling entry group method");
			 out.writeUTF("circlingArround");// SEND THE 2nd METHOD NAME
			 executing("calling entry show  method");
			 out.writeUTF("enterShow");//SEND 3 rD METHOD NAME 
			 executing("calling entry show  method");
			 
			 out.writeUTF("EXIT");// SEND SIGNAL TO CLIENTHELPER THREAD TO CLOSE THE STREAMING 
			 executing(" ending");
			 
			 
			 } catch (ConnectException e) {
					// TODO Auto-generated catch block
					System.out.println("Problem with sion. Check the port or name machine to connect.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 }