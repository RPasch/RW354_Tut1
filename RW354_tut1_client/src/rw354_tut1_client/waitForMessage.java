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
         String uselesCode = RW354_tut1_client.receiveMsg();
         String list_of_users = RW354_tut1_client.receiveMsg();
        chat.addAllusers(list_of_users);
         while(true){
            String code = RW354_tut1_client.receiveMsg();
            String anything = RW354_tut1_client.receiveMsg();
            switch (code) {
                case "&":
                    System.out.println(list_of_users+ "\n");
                    System.out.println(anything);
                    chat.addAllusers(anything);
                    break;
                case "#":
                    chat.printConnection(anything, false);
                    break;
                default:
                    String who = code;
                    String message = anything;
                    chat.printMsg(message, who);
                    break;
            }
            
        }
     }
    
    
}
