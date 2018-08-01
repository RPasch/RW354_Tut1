package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends Thread{
    static OutputStream outFromServer;
    static DataOutputStream out;
    static InputStream inFromClient;
    static DataInputStream in;
    public static ConcurrentHashMap<String, SocketHandler> listOfUsers = new ConcurrentHashMap<>();
    
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
        
        
//        while(true){
//            try {
//                clientSocket = serverSocket.accept();
//                SocketHandler sh = new SocketHandler(clientSocket);
//                Thread t = new Thread(sh);
//                //add to the hashmap
//                t.start();
//                
//                System.out.println("new user connected");
//                 
//           } catch (Exception e) {
//               
//           }
//        }

        try {
            clientSocket = serverSocket.accept();
            SocketHandler sh = new SocketHandler(clientSocket);
                //Thread t = new Thread(sh);
                //add to the hashmap
                //t.start();
                
            //System.out.println("new user connected");
                 
        } catch (Exception e) {
                System.err.println(e);
        }

        ClientConnecter connector = new ClientConnecter(serverSocket, clientSocket);
        connector.start();
        System.out.println("gtrhtgte");
        
        try {
            inFromClient = clientSocket.getInputStream();
            outFromServer = clientSocket.getOutputStream();
            
            in = new DataInputStream(inFromClient);
            out = new DataOutputStream(outFromServer);
            System.out.println(in.readUTF());
            out.writeUTF("hi");
            out.writeUTF("hi423");
            out.writeUTF("fchhhhhhhhhhhhhhhhhhh");
            out.writeUTF("h4444");
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
        } catch (Exception e) {
            System.err.println("SERVER: "+ e);
        }
        
    }
    
    
}
//ip route get 8.8.8.8 | awk '{print $NF; exit}'