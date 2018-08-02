package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
//146.232.49.154
public class Listener extends Thread{
    
    private Socket clientSocket;
    
    static InputStream inFromClient;
    static DataInputStream in;
    
    public Listener(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        
        try {
            inFromClient = clientSocket.getInputStream(); 
            in = new DataInputStream(inFromClient);
        } catch (Exception e) {
            
        }
        
        while(true){
            try {
                String message = in.readUTF();
                System.out.println("deez nuts");
                Server.broadcast(message);
                System.out.println("her nutz");
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
