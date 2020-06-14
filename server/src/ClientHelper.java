
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHelper extends Thread {
	private Socket s;
	
	
	private static final String green  ="green_uniform";
	private static final String orange  ="orange_uniform";
	private static final String staff  ="staff";
	private DataInputStream dis;
	private green_uniform gr;// green_uniform object in server side
	private orange_uniform or;// orange_uniform object in server side
	private staff st;// Staff object in server side
	
	private String nameObject;// Name of the object will be created
	private String nameTrhead;// Name of the thread will be created
	private String nameMethod;// Name of the method will be executed

	// Constructor
	public ClientHelper(Socket s, DataInputStream dis) {
		this.s = s;
		this.dis = dis;
		
	}

	public void run() {
		String received = null;
		try {
			
			received = dis.readUTF();// reading object type
			nameTrhead = dis.readUTF();// reading thread name from the client side  thread 
										
			// Creating an object staff in the Server.
			if (received.equals(staff)) {
				st = new staff(nameTrhead);
				nameObject = staff;
			}
			// Creating an object green_uniform in the Server.
			if (received.equals(green)) {
				gr = new green_uniform(nameTrhead);
				nameObject = green;
			}
			// Creating an object orange_uniform in the Server.
			if (received.equals(orange)) {
				or = new orange_uniform(nameTrhead);
				nameObject = orange ;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				
				nameMethod = dis.readUTF();// Reading the method's name to
											// execute.

				if (nameObject.equals(staff)) {// Choosing a method according
					sleep(4000);						// to staff object.
					if (nameMethod.equals("callThestudent")) 
					
						st.callThestudent();
						
					
				}
				
				if (nameObject.equals(green)) {// Choosing a method according to green_uniform
													// object.
					switch (nameMethod) {
					case "entryGoups":
						gr.entryGoups();
						break;
					case "enterShow":
						gr.enterShow();;
						break;
					case "circlingArround":
	                     gr.circlingArround();;;
	                      break;
					
					
					}
				
				}
				if (nameObject.equals(orange)) {// Choosing a method
													// according to  orange_uniform 
													// object.
					
	                  switch (nameMethod) {
	                      case "entryGoups":
	                     	  or.entryGoups();
		                      break;
	                      case "enterShow":
		                      or.enterShow();;
		                      break;
	                      case "circlingArround":
		                      or.circlingArround();
		                      break;
		                      
	
	             }
				}

				if (nameMethod.equals("EXIT")) {// Finishing the methods that were sent by the client
					System.out.println("Client " + nameTrhead + "Closing ");
					break;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}try

	{
		// closing resources
		this.dis.close();
	} catch(

	IOException e)

	{
		e.printStackTrace();
	}
}}