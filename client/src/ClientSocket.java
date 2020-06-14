import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;


	public class ClientSocket {
		private String nameServer = null;
		private int portServer;
		private Socket s;

		public ClientSocket(String name, int portNum) {
			nameServer = name;
			portServer = portNum;

		}

		public String getNameServer() {
			return nameServer;
		}

		public int getPortServer() {
			return portServer;
		}

		

		public Socket getClientSocket() {
			return (Socket) s;
		}

	}


