package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketHandler implements Runnable {

    private String username;
    private Socket clientSocket;
    InputStream inFromClient;
    DataInputStream in;
    
    public SocketHandler(String username, Socket clientSocket) {
        this.username = username;
        this.clientSocket = clientSocket;
    }
    
    

    @Override
    public void run() {
        System.out.println("yup this client has a thread");
        //Server.broadcast(username, "I shat mah pants");
        
        try {
            inFromClient = clientSocket.getInputStream(); 
            in = new DataInputStream(inFromClient);
        } catch (Exception e) {
            System.out.println("could not open stream for this client "+e);
        }
        
        while(true){
            try {
                String toUser = in.readUTF();
                String message = in.readUTF();
                //System.out.println("deez nuts");
                if (toUser.equals("All")) {
                    Server.broadcast(username, message);
                } else if (toUser.equals("@")) {
                    Server.broadcast("#", username);
                    in.close();
                    inFromClient.close();
                    clientSocket.close();
                } else {
                    Server.whisper(username, toUser, message);
                }
                //System.out.println("her nutz");
            } catch (IOException ex) {
                System.err.println(ex);
                //bc that user disconnected
                try {
                    clientSocket.close();
                } catch (Exception e) {
                    System.err.println("could not disconnect ");
                }
                break;
            }
        }

    }
    
    public Socket getClientSocket(){
        return clientSocket;
    }
    
    //        try {
    //            inFromClient = clientSocket.getInputStream(); 
    //            in = new DataInputStream(inFromClient);
    //            String message = in.readUTF();
    //            Server.broadcast(message);
    //        } catch (Exception e) {
    //            
    //        }
    //        
    //        Listener listener = new Listener(clientSocket);
    //        listener.start();
}
