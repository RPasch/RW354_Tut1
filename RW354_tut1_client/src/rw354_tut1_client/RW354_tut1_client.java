/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw354_tut1_client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import rw354_tut1_client.ChatInterface;
import java.net.Socket;


/**
 *
 * @author 18214304
 */
public class RW354_tut1_client {
    public boolean valid_connection = true;
    private static  int port = 8000;
    static String serverName = "1";

    public static boolean valid_usrnm = true;
    public static boolean valid_con = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*if ( args.length<1){
            System.out.println("more inputs " + args.length);
            
        }
        else{*/
        serverName = args[0];
       // }
        
        ChatInterface chat = new ChatInterface();
        chat.show();
        
        
    }
    public static void connect(String serverName) throws IOException {
        
       try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         valid_usrnm = true;
         valid_usrnm = true;
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         client.close();
      } catch (IOException e) {
      }
        
    }

    public static String getServerName() {
        return serverName;
    }
    
    
    
}
