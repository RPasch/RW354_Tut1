package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static rw354_tut1_server.ClientConnecter.out;

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

        SocketHandler sh = null;    
        try {
            clientSocket = serverSocket.accept();
            sh = new SocketHandler(clientSocket);
            
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
            
            String username = in.readUTF();
            System.out.println("Welcome: "+username+"to the chat");
            
            listOfUsers.put(username, sh);
            
            String userList = getListOfUsers();
            out.writeUTF(userList);
            
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
        } catch (Exception e) {
            System.err.println("SERVER: "+ e);
        }
        
    }
    
    public static String getListOfUsers() {
        String userList = "";
        
        for (String key : Server.listOfUsers.keySet()) {
            userList = userList + key + ",";
        }
        
        userList = userList.substring(0, userList.length() - 1);
        
        return userList;
    }
    
    
}
//ip route get 8.8.8.8 | awk '{print $NF; exit}'