import java.io.*;
import java.net.*;

public class Router3{
	public static void main(String[] args){
		Socket socket = null;
		ServerSocket serverSocket = null;
		int[] routingTable = {7, -1, 2, 0};
		int[] receivedTable;
		int localRouter = 3;
		int receivedRouter;
		try{
			//create connection
			int port = 12123;
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(25000);
			
			while(true){
				//listen for client sockets
				socket = serverSocket.accept();
				//open reader to receive input from client
				InputStream input = socket.getInputStream();
				InputStreamReader streamReader = new InputStreamReader(input);
				BufferedReader buffRead = new BufferedReader(streamReader);
				//received routing table from other router
				receivedRouter = Integer.parseInt(buffRead.readLine());
				receivedTable = new int[4];
				for(int i = 0; i < 4; i++){
					String received = buffRead.readLine();
					receivedTable[i] = Integer.parseInt(received);
				}
				//find out which router was received
				for(int i = 0; i < 4; i++){
					if(receivedTable[i] == 0){
						receivedRouter = i;
					}
				}			
				
				//open writer to send message to the client
				OutputStream output = socket.getOutputStream();
				OutputStreamWriter streamWrite = new OutputStreamWriter(output);
				BufferedWriter buffWrite = new BufferedWriter(streamWrite);
				//send routingTable back to the connected socket
				int dist30 = routingTable[0];
				int dist31 = routingTable[1];
				int dist32 = routingTable[2];
				int dist33 = routingTable[3];
				buffWrite.write(String.valueOf(localRouter) + "\n");
				buffWrite.write(String.valueOf(dist30) + "\n");
				buffWrite.write(String.valueOf(dist31) + "\n");
				buffWrite.write(String.valueOf(dist32) + "\n");
				buffWrite.write(String.valueOf(dist33) + "\n");
				buffWrite.flush();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		finally{
			//close connection
			try{
				socket.close();
				serverSocket.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}