

	import java.io.*;
	import java.net.*;

	public class Server {
		static int portNumber;

		@SuppressWarnings("resource")
		public static void main(String[] args) throws IOException {
			try {
				
				portNumber = Integer.parseInt(args[0]);// Port number
				System.out.println("Initializing server side...");
				System.out.println("Listening server port..." + portNumber);
				// server is listening on port...
				ServerSocket ss = new ServerSocket(portNumber);
				

				// running infinite loop for getting client request
				while (true) {
					Socket s = null;

					
					s = ss.accept();// blocking until one socket is linked and then return new socket different then server sockets 
					DataInputStream dis = new DataInputStream(s.getInputStream());
					
					Thread t = new ClientHelper(s, dis);// client helper for each thread

				
					t.start();// start client helper whose handling client requests

				}
			} catch (BindException e) {
				System.out.println("Address already in use.");
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println("1 argument required: portServer");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}