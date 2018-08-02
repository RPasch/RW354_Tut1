package rw354_tut1_server;

import java.net.Socket;

public class SocketHandler implements Runnable {

    private Socket clientSocket;
    
    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    

    @Override
    public void run() {
        
    }
    
    public void listen() {
        while(true) {
            
        }
    }
    
    public Socket getClientSocket(){
        return clientSocket;
    }
    
}
