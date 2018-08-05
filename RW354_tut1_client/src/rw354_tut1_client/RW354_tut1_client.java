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
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;
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
    private static int port = 8000;
    static String serverName = "146.232.49.154";
    static OutputStream outToServer;
    static DataOutputStream out;
    static InputStream inFromServer;
    static DataInputStream in;
    static Socket client;
    public static ChatInterface chat;
    public static String IP_ad;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String message;
        String who;
        chat = new ChatInterface();
        chat.show();
    }

    public static void connect(String serverName, String usr) throws IOException {
        boolean validIP = false;
        try {
            IP_ad = chat.IP;
            client = new Socket(IP_ad, port);

            validIP = client.isConnected();
            if (!validIP) {
                JOptionPane.showMessageDialog(chat, "invalid IP");
                return;
            }
            String userList_intial = receiveMsg();
            boolean validUsrn = checkUsername(userList_intial, chat.username);
            if (!validUsrn) {
                JOptionPane.showMessageDialog(chat, "Username taken , new username : " + chat.username);
            }
            outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);
            out.writeUTF(chat.username);
            waitForMessage waitFor = new waitForMessage(chat);

            waitFor.start();
            //out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //String inputFromServer = in.readUTF(); 
            //System.out.println("Server says " + in.readUTF());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(chat, "Could not connect to server : " + e);
        }

    }

    public static String getIPaddr() {
        return IP_ad;
    }

    public static String getServerName() {
        return serverName;
    }

    public static void sendMessage(String msg, String usr) throws IOException {
        out.writeUTF(usr);
        out.writeUTF(msg);

    }

    public static void disconnect(String usr) {
        try {
            out.writeUTF("@");
            out.writeUTF(usr);
            out.close();
            outToServer.close();
            in.close();
            inFromServer.close();
            client.close();

            JOptionPane.showMessageDialog(chat, "Disconnected from Server");
            chat.dispose();
        } catch (IOException ex) {
            System.err.println("Disconnection Error : " + ex);
        }

    }

    public static String receiveMsg() throws IOException {
        inFromServer = client.getInputStream();
        in = new DataInputStream(inFromServer);
        String inputFromServer = in.readUTF();
        return inputFromServer;
    }

    public static boolean checkUsername(String list, String usrnm) {
        boolean valid = true;
        List<String> tempList = Arrays.asList(list.split(","));
        if (tempList.contains(usrnm)) {
            valid = false;
            double randomInt = (Math.random());
            chat.username = chat.username + (int) (randomInt * 100);
        }

        return valid;
    }

}
