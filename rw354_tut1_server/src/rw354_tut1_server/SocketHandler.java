package rw354_tut1_server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {

    private Socket clientSocket;
    static InputStream inFromClient;
    static DataInputStream in;
    
    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    

    @Override
    public void run() {
        try {
            inFromClient = clientSocket.getInputStream(); 
            in = new DataInputStream(inFromClient);
            String message = in.readUTF();
            Server.broadcast(message);
        } catch (Exception e) {
            
        }
        
        Listener listener = new Listener(clientSocket);
        listener.start();
    }
    
    public Socket getClientSocket(){
        return clientSocket;
    }
    
}
