package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        SocketHandler sh = null;    
        try {
            clientSocket = serverSocket.accept();
            sh = new SocketHandler(clientSocket);
            
                Thread t = new Thread(sh);
                //add to the hashmap
                t.start();
                
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
            
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
            broadcast(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            System.out.println(in.readUTF());
//            
//            in.close();
//            out.close();
        } catch (Exception e) {
            System.err.println("SERVER: "+ e);
        }
        
    }
    
    
    
    public static String getListOfUsers() {
        String userList = "";
        
        for (String key : listOfUsers.keySet()) {
            userList = userList + key + ",";
        }
        
        userList = userList.substring(0, userList.length() - 1);
        
        return userList;
    }
    
    public static void broadcast(String message) {
        OutputStream outFromServer;
        DataOutputStream out;
        //outFromServer = clientSocket.getOutputStream();
        //out = new DataOutputStream(outFromServer);
        System.out.println("kaka "+message+" kaka ");
        for (Map.Entry<String, SocketHandler> pair : listOfUsers.entrySet()) {
            try {
                outFromServer = pair.getValue().getClientSocket().getOutputStream();//.getClientSocket().getOutputStream();
                out = new DataOutputStream(outFromServer);
                out.writeUTF(pair.getKey()); //pair.getKey is the username
                out.writeUTF(message);
//                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void whisper() {
        
    }
    
}
//ip route get 8.8.8.8 | awk '{print $NF; exit}'