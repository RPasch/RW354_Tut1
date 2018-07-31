package rw354_tut1_server;

import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnecter extends Thread {
    
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    
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
                
                System.out.println("new user connected");
                 
           } catch (Exception e) {
                System.err.println(e);
           }
        }
    }
    
    
}
