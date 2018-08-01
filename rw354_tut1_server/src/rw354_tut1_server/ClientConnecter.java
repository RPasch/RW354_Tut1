package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static rw354_tut1_server.Server.inFromClient;
import static rw354_tut1_server.Server.outFromServer;

public class ClientConnecter extends Thread {
    
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    static InputStream inFromClient;
    static DataInputStream in;
    
    public ClientConnecter (ServerSocket serverSocket, Socket clientSocket) {
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                clientSocket = serverSocket.accept();
                SocketHandler sh = new SocketHandler(clientSocket);
                //Thread t = new Thread(sh);
                //add to the hashmap
                //t.start();
                inFromClient = clientSocket.getInputStream();
                in = new DataInputStream(inFromClient);
                
                String username = in.readUTF();
                
                Server.listOfUsers.put(username, sh);
                
                System.out.println("Welcome: "+username+"to the chat");
                
                
                 
            } catch (Exception e) {
                System.err.println(e);
            }
            
            
        }
    }
    
    
}
