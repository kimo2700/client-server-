import java.io.IOException;


	public class client {
		static int portNumber;
		static String nameHost;
		public static clock clk;
		public static staff staf;
		public static green_uniform [] tor;
		public static orange_uniform [] tor1;

		public static void main(String[] args) throws IOException { //1st green# 2nd orange# 3rd namehost 4th portnumber  
			try {
			nameHost = args[2];
			portNumber = Integer.parseInt(args[3]);
			ClientSocket cs = new ClientSocket(nameHost, portNumber);
			System.out.println("Server name: " + cs.getNameServer() + " Server port: " + cs.getPortServer());
			
			tor1= new orange_uniform[Integer.parseInt(args[1])];
			
			tor= new green_uniform[Integer.parseInt(args[0])];
			
			for (int x=0; x<Integer.parseInt(args[1]); x++) {
			    
				tor1[x]= new orange_uniform(Integer.toString(x),cs);    
		   }
			for (int x=0; x<Integer.parseInt(args[1]); x++) {
				tor1[x].start();
			}
			for (int x=0; x<Integer.parseInt(args[0]); x++) {
			    
			tor[x]= new green_uniform(Integer.toString(x),cs);    
		   }
			for (int x=0; x<Integer.parseInt(args[0]); x++) {
				tor[x].start();
			}
			
			clk=new clock("1");
			clk.start();
			staf=new staff("1",cs);
			staf.start();
			
		

	
		}
			catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("4 arguments required:green number,orange number ,hostName, portServer");
		   }
			
			
		}
			

}
