package rw354_tut1_server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // use concurrent hashmap
    public static void main(String[] args) {
        int portNumber = 8000;//Integer.parseInt(args[0]);
        ServerSocket serverSocket = null;
        Socket clientSocket = null;        
        
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println(serverSocket);
            //create socket handler class
            //constructor takes client socket
            //
        } catch (Exception e) {
            System.exit(0);
        }
        
        while(true){
            try {
                clientSocket = serverSocket.accept();
                SocketHandler sh = new SocketHandler(clientSocket);
                new Thread(sh).start();
                
                System.out.println("new user connected");
                 
           } catch (Exception e) {
               
           }
        }
        
    }
}
