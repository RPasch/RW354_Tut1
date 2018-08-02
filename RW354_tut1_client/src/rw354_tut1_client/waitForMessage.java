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
            Logger.getLogger(waitForMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public static void waitForMsg(ChatInterface chat) throws IOException{
        String list_of_users = RW354_tut1_client.receiveMsg();
        chat.addAllusers(list_of_users);
         while(true){
            
            String anything = RW354_tut1_client.receiveMsg();
            if(anything.charAt(0) == '&'){
                String connectedUsr = anything.substring(1, anything.length());
                chat.addAllusers(connectedUsr);

            }else if(anything.charAt(0)== '#'){
                String disconnectedUsr = anything.substring(1,anything.length());
                chat.printConnection(disconnectedUsr, false);
            
            }else{
                
                String who = anything;
                String message = RW354_tut1_client.receiveMsg();
                chat.printMsg(message, who);
            }
            
        }
     }
    
    
}