
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Vector;


	public class green_uniform  implements Runnable   {
		
		
		private String num;
		private Socket s;
		private DataOutputStream out;
		private Thread thread;
		private ClientSocket cs;
		public green_uniform(String nu, ClientSocket cs) {
			
			this.num="green_"+nu;
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
				
			 
			 synchronized(clock.convey1) {// WAIT FOR THE PRIDE TO BE OPEN BY THE CLOCK 
					
						
						try {
							clock.convey1.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			 out.writeUTF("green_uniform");// SEND THE OBJECT NAME 
			 executing("sending object name  request");
			 out.writeUTF(num);// SEND THE THREAD NAME 
			 executing("sending thread name request");
			 out.writeUTF("entryGoups");// SEND THE METHOD NAME
			 executing("calling entry group method");
			 out.writeUTF("circlingArround");// SEND THE 2ND METHOD NAME
			 executing("calling entry show  method");
			 out.writeUTF("enterShow");// SEND THE 3rD METHOD NAME
			 executing("calling circlingArround group method");
			 
			 out.writeUTF("EXIT");// SEND THE SIGNAL TO CLIENTHELPER TO CLOSE CONNECTION
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
