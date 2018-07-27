package rw354_tut1_server;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        
        //System.out.println(portNumber);
        
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println(serverSocket);
        } catch (Exception e) {
            System.exit(0);
        }
        
    }
}
