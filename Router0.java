import java.io.*;
import java.net.*;

public class Router0{
	public static void main(String[] args){
		Socket clientSocket = null;
		int[] routingTable = {0, 1, 3, 7};
		int localRouter = 0;
		int receivedRouter;
		boolean updated = true;
		try{
			while(updated == true){
				updated = false;
				//open connection to Router 1
				clientSocket = ConnectRouter1();
				
				//open writer to send message to client
				OutputStream output = clientSocket.getOutputStream();
				OutputStreamWriter streamWriter = new OutputStreamWriter(output);
				BufferedWriter buffWrite = new BufferedWriter(streamWriter);
				//send routing table over to server
				int dist00 = routingTable[0];
				int dist01 = routingTable[1];
				int dist02 = routingTable[2];
				int dist03 = routingTable[3];
				buffWrite.write(String.valueOf(localRouter) + "\n");
				buffWrite.write(String.valueOf(dist00) + "\n");
				buffWrite.write(String.valueOf(dist01) + "\n");
				buffWrite.write(String.valueOf(dist02) + "\n");
				buffWrite.write(String.valueOf(dist03) + "\n");
				buffWrite.flush();
				//print initial table
				System.out.println("Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + dist01);
				System.out.println("Distance to Router 2: " + dist02);
				System.out.println("Distance to Router 3: " + dist03 + "\n");
					
				//open reader to retrieve messages from the server
				InputStream input = clientSocket.getInputStream();
				InputStreamReader streamReader = new InputStreamReader(input);
				BufferedReader buffRead = new BufferedReader(streamReader);
				//receive routing table from server
				receivedRouter = Integer.parseInt(buffRead.readLine());
				int[] receivedTable = new int[4];
				for(int i = 0; i < 4; i++){
					String received = buffRead.readLine();
					receivedTable[i] = Integer.parseInt(received);
				}
				System.out.println("Received Router: " + receivedRouter);
				System.out.println("Distance to Router 0: " + receivedTable[0]);
				System.out.println("Distance to Router 1: " + receivedTable[1]);
				System.out.println("Distance to Router 2: " + receivedTable[2]);
				System.out.println("Distance to Router 3: " + receivedTable[3] + "\n");
					
				//update Router0's table based on which of the 4 routers was received
				if(receivedRouter == 1){
					if(((dist01 + receivedTable[2]) < dist02) && (receivedTable[2] != -1)){
						routingTable[2] = dist01 + receivedTable[2];
						updated = true;
					}
					if(((dist01 + receivedTable[3]) < dist03) && (receivedTable[3] != -1)){
						routingTable[3] = dist01 + receivedTable[3];
						updated = true;
					}
				}
					
				//print out updated table
				System.out.println("New Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + routingTable[1]);
				System.out.println("Distance to Router 2: " + routingTable[2]);
				System.out.println("Distance to Router 3: " + routingTable[3]);
				System.out.println(" ");
				
				//open connection to Router 2
				clientSocket = ConnectRouter2();
				
				//open writer to send message to client
				output = clientSocket.getOutputStream();
				streamWriter = new OutputStreamWriter(output);
				buffWrite = new BufferedWriter(streamWriter);
				//send routing table over to server
				dist00 = routingTable[0];
				dist01 = routingTable[1];
				dist02 = routingTable[2];
				dist03 = routingTable[3];
				buffWrite.write(String.valueOf(localRouter) + "\n");
				buffWrite.write(String.valueOf(dist00) + "\n");
				buffWrite.write(String.valueOf(dist01) + "\n");
				buffWrite.write(String.valueOf(dist02) + "\n");
				buffWrite.write(String.valueOf(dist03) + "\n");
				buffWrite.flush();
				//print initial table
				System.out.println("Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + dist01);
				System.out.println("Distance to Router 2: " + dist02);
				System.out.println("Distance to Router 3: " + dist03 + "\n");
					
				//open reader to retrieve messages from the server
				input = clientSocket.getInputStream();
				streamReader = new InputStreamReader(input);
				buffRead = new BufferedReader(streamReader);
				//receive routing table from server
				receivedRouter = Integer.parseInt(buffRead.readLine());
				for(int i = 0; i < 4; i++){
					String received = buffRead.readLine();
					receivedTable[i] = Integer.parseInt(received);
				}
				System.out.println("Received Router: " + receivedRouter);
				System.out.println("Distance to Router 0: " + receivedTable[0]);
				System.out.println("Distance to Router 1: " + receivedTable[1]);
				System.out.println("Distance to Router 2: " + receivedTable[2]);
				System.out.println("Distance to Router 3: " + receivedTable[3] + "\n");
					
				//update Router0's table based on which of the 4 routers was received
				if(receivedRouter == 2){
					if(((dist02 + receivedTable[1]) < dist01) && (receivedTable[1] != -1)){
						routingTable[1] = dist02 + receivedTable[1];
						updated = true;
					}
					if(((dist02 + receivedTable[3]) < dist03) && (receivedTable[3] != -1)){
						routingTable[3] = dist02 + receivedTable[3];
						updated = true;
					}
				}
					
				//print out updated table
				System.out.println("New Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + routingTable[1]);
				System.out.println("Distance to Router 2: " + routingTable[2]);
				System.out.println("Distance to Router 3: " + routingTable[3]);
				System.out.println(" ");
				
				//open connection to Router 3
				clientSocket = ConnectRouter3();
				
				//open writer to send message to client
				output = clientSocket.getOutputStream();
				streamWriter = new OutputStreamWriter(output);
				buffWrite = new BufferedWriter(streamWriter);
				//send routing table over to server
				dist00 = routingTable[0];
				dist01 = routingTable[1];
				dist02 = routingTable[2];
				dist03 = routingTable[3];
				buffWrite.write(String.valueOf(localRouter) + "\n");
				buffWrite.write(String.valueOf(dist00) + "\n");
				buffWrite.write(String.valueOf(dist01) + "\n");
				buffWrite.write(String.valueOf(dist02) + "\n");
				buffWrite.write(String.valueOf(dist03) + "\n");
				buffWrite.flush();
				//print initial table
				System.out.println("Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + dist01);
				System.out.println("Distance to Router 2: " + dist02);
				System.out.println("Distance to Router 3: " + dist03 + "\n");
					
				//open reader to retrieve messages from the server
				input = clientSocket.getInputStream();
				streamReader = new InputStreamReader(input);
				buffRead = new BufferedReader(streamReader);
				//receive routing table from server
				receivedRouter = Integer.parseInt(buffRead.readLine());
				for(int i = 0; i < 4; i++){
					String received = buffRead.readLine();
					receivedTable[i] = Integer.parseInt(received);
				}
				System.out.println("Received Router: " + receivedRouter);
				System.out.println("Distance to Router 0: " + receivedTable[0]);
				System.out.println("Distance to Router 1: " + receivedTable[1]);
				System.out.println("Distance to Router 2: " + receivedTable[2]);
				System.out.println("Distance to Router 3: " + receivedTable[3] + "\n");
					
				//update Router0's table based on which of the 4 routers was received
				if(receivedRouter == 3){
					if(((dist03 + receivedTable[1]) < dist01) && (receivedTable[1] != -1)){
						routingTable[1] = dist03 + receivedTable[1];
						updated = true;
					}
					if(((dist03 + receivedTable[2]) < dist02) && (receivedTable[2] != -1)){
						routingTable[2] = dist03 + receivedTable[2];
						updated = true;
					}
				}
					
				//print out updated table
				System.out.println("New Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + routingTable[1]);
				System.out.println("Distance to Router 2: " + routingTable[2]);
				System.out.println("Distance to Router 3: " + routingTable[3]);
				System.out.println("-----------------------------------------");
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			//close connection
			try{
				clientSocket.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	public static Socket ConnectRouter1(){
		Socket cSocket = null;
		try{	
			String host = "osl1.njit.edu";
			int port = 12121;
			cSocket = new Socket(host, port);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return cSocket;
		}
	}
	
	public static Socket ConnectRouter2(){
		Socket cSocket = null;
		try{	
			String host = "osl1.njit.edu";
			int port = 12122;
			cSocket = new Socket(host, port);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return cSocket;
		}
	}
	
	public static Socket ConnectRouter3(){
		Socket cSocket = null;
		try{	
			String host = "osl1.njit.edu";
			int port = 12123;
			cSocket = new Socket(host, port);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return cSocket;
		}
	}
}