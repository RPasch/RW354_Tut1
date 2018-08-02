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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//146.232.49.154

/**
 *
 * @author 18214304
 */
public class RW354_tut1_client {
    public boolean valid_connection = true;
    private static  int port = 8000;
    static String serverName = "146.232.49.154";
    static OutputStream outToServer;
    static DataOutputStream out;
    static InputStream inFromServer;
    static DataInputStream in;
    static Socket client;
    public static boolean valid_usrnm = true;
    public static boolean valid_con = true;
    public static ChatInterface chat ;
    public static String IP_ad;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        /*if ( args.length<1){
            System.out.println("more inputs " + args.length);
            
        }
        else{*/
        //serverName = args[0];
       // }
       
        String message ;
        String who ;
        chat = new ChatInterface();
        chat.show();
        
        
        
    }
    public static void connect(String serverName, String usr) throws IOException {
        
       try {
         IP_ad = chat.IP;
         System.out.println(IP_ad);
         System.out.println("Connecting to " + IP_ad + " on port " + port);
         client = new Socket(IP_ad, port);
         valid_usrnm = true;
         valid_usrnm = true;
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         outToServer = client.getOutputStream();
         out = new DataOutputStream(outToServer);
         out.writeUTF(usr);
         waitForMessage waitFor = new waitForMessage(chat);

         waitFor.start();
         //out.writeUTF("Hello from " + client.getLocalSocketAddress());
         
         //String inputFromServer = in.readUTF(); // this is fucking up my shit
         //System.out.println("Server says " + in.readUTF());
      } catch (IOException e) {
           JOptionPane.showMessageDialog(chat, "Invalid IP Address");
      }
        
    }
    public static String getIPaddr(){
        return IP_ad;
    }
    public static String getServerName() {
        return serverName;
    }
    
    public static void sendMessage(String msg, String usr) throws IOException{
         out.writeUTF(usr);
         out.writeUTF(msg);
       
        
    }
    
    public static void disconnect(){
        try {
            out.writeUTF("@");
            out.close();
            outToServer.close();
            in.close();
            inFromServer.close();
            client.close();
            JOptionPane.showMessageDialog(chat, "Disconnected from Server");
        } catch (IOException ex) {
            Logger.getLogger(RW354_tut1_client.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    public static String receiveMsg() throws IOException{
       System.out.println(client);
       inFromServer = client.getInputStream();
       in = new DataInputStream(inFromServer);
       String inputFromServer = in.readUTF();
       return inputFromServer;
    }
    
 
   
    
    }
    
    

