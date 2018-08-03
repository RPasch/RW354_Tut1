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
            
            inFromClient = clientSocket.getInputStream();
            in = new DataInputStream(inFromClient);
            outFromServer = clientSocket.getOutputStream();
            out = new DataOutputStream(outFromServer);
            
            out.writeUTF("");
            
            String username = in.readUTF();
            System.out.println("Welcome: "+username+"to the chat");
            
            sh = new SocketHandler(username, clientSocket);
            
            Thread t = new Thread(sh);
                //add to the hashmap
            t.start();
                
            listOfUsers.put(username, sh);
            
//            String userList = getListOfUsers();
//            out.writeUTF("&");
//            out.writeUTF(userList);
//            sendUserList(userList);
                
            //System.out.println("new user connected");
                 
        } catch (Exception e) {
                System.err.println(e);
        }

        ClientConnecter connector = new ClientConnecter(serverSocket, clientSocket);
        connector.start();
        System.out.println("gtrhtgte");
        
        try {
            
            
            //inFromClient = clientSocket.getInputStream();
            outFromServer = clientSocket.getOutputStream();
            
            //in = new DataInputStream(inFromClient);
            out = new DataOutputStream(outFromServer);
            
            //String username = in.readUTF();
            //System.out.println("Welcome: "+username+"to the chat");
            
            //listOfUsers.put(username, sh);
            
            String userList = getListOfUsers();
            out.writeUTF("&"+userList);
            
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
                //System.out.println("IM IN HERE "+listOfUsers.keySet());

        userList = userList.substring(0, userList.length() - 1);
        
        return userList;
    }
    
    public static void sendUserList(String userList){
        OutputStream outFromServer;
        DataOutputStream out;
        
        for (Map.Entry<String, SocketHandler> pair : listOfUsers.entrySet()) {
            try {
                outFromServer = pair.getValue().getClientSocket().getOutputStream();//.getClientSocket().getOutputStream();
                out = new DataOutputStream(outFromServer);
                
                //out.writeUTF("&");
                out.writeUTF("&"+userList); 
                
//                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void broadcast(String username, String message) {
        OutputStream outFromServer;
        DataOutputStream out;
        //outFromServer = clientSocket.getOutputStream();
        //out = new DataOutputStream(outFromServer);
        //System.out.println("kaka "+message+" kaka ");
        for (Map.Entry<String, SocketHandler> pair : listOfUsers.entrySet()) {
            try {
                outFromServer = pair.getValue().getClientSocket().getOutputStream();//.getClientSocket().getOutputStream();
                out = new DataOutputStream(outFromServer);
                out.writeUTF(username); //pair.getKey is the username
                out.writeUTF(message);
//                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void whisper(String usernameFrom, String usernameTo, String message) {
        OutputStream outFromServer;
        DataOutputStream out;
        
        for (Map.Entry<String, SocketHandler> pair : listOfUsers.entrySet()) {
            if (pair.getKey().equals(usernameTo) || pair.getKey().equals(usernameFrom)) {
                try {
                    outFromServer = pair.getValue().getClientSocket().getOutputStream();//.getClientSocket().getOutputStream();
                    out = new DataOutputStream(outFromServer);
                    out.writeUTF(usernameFrom+" > "+usernameTo); 
                    out.writeUTF(message);
                } catch (Exception e) {
                    System.err.println("could not whisper : " + e);
                }
            }
        }
    }
    
}
//ip route get 8.8.8.8 | awk '{print $NF; exit}'