/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw354_tut1_client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rw354_tut1_client.RW354_tut1_client.receiveMsg;

/**
 *
 * @author 18214304
 */
public class waitForMessage extends Thread {

    
    ChatInterface chat = null;
    public waitForMessage(ChatInterface chat) {
        this.chat = chat;
        
    }
    
    @Override
    public void run(){
    
        try {
            waitForMsg(chat);
        } catch (IOException ex) {
            System.out.println("Error in WaitForMessage : "+ ex);
        }
        
    }
    
    
     public static void waitForMsg(ChatInterface chat) throws IOException{
         
        String list_of_users = RW354_tut1_client.receiveMsg();
        chat.addAllusers(list_of_users.substring(1, list_of_users.length()));
         while(true){
            
            String anything = RW354_tut1_client.receiveMsg();
            switch (anything.charAt(0)) {
                case '&':
                    System.out.println(list_of_users+ "\n");
                    String connectedUsr = anything.substring(1, anything.length());
                    System.out.println(connectedUsr+ " conncetedUser");
                    chat.addAllusers(connectedUsr);
                    break;
                case '#':
                    
                    String disconnectedUsr = RW354_tut1_client.receiveMsg();
                    String list_of = RW354_tut1_client.receiveMsg().substring(1);
                    chat.removeUsers(disconnectedUsr,list_of);
//   chat.printConnection(whoDiscon, false);
                    break;
                default:
                    String who = anything;
                    String message = RW354_tut1_client.receiveMsg();
                    chat.printMsg(message, who);
                    break;
            }
            
        }
     }
    
    
}