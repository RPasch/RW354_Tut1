/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw354_tut1_client;
import rw354_tut1_client.ChatInterface;
/**
 *
 * @author 18214304
 */
public class RW354_tut1_client {
    public boolean valid_connection = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ChatInterface chat = new ChatInterface();
        chat.show();
    }
    
    
    
    
}
