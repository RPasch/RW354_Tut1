/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw354_tut1_client;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rw354_tut1_client.RW354_tut1_client;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
import static rw354_tut1_client.RW354_tut1_client.connect;
import static rw354_tut1_client.RW354_tut1_client.valid_con;
import static rw354_tut1_client.RW354_tut1_client.valid_usrnm;

/**
 *
 * @author rabbp
 */
public class ChatInterface extends javax.swing.JFrame {
    String username;
    String msg;
    String serverName = RW354_tut1_client.getServerName();
    String IP ;
    List<String> list = null; 
    /**
     * Creates new form ChatInterface
     */
    public ChatInterface() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Chat_txt = new java.awt.TextArea();
        users_txt = new java.awt.TextArea();
        send_btn = new javax.swing.JButton();
        chat_choice_dropdown = new java.awt.Choice();
        username_txt = new javax.swing.JTextField();
        connect_btn = new javax.swing.JButton();
        disconnect_btn = new javax.swing.JButton();
        msg_txt = new javax.swing.JTextField();
        IP_addr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Chat_txt.setEditable(false);

        users_txt.setEditable(false);

        send_btn.setText("Send");
        send_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_btnActionPerformed(evt);
            }
        });

        chat_choice_dropdown.add("All");

        username_txt.setText("BloodRabz");
        username_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_txtActionPerformed(evt);
            }
        });

        connect_btn.setText("Connect");
        connect_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_btnActionPerformed(evt);
            }
        });

        disconnect_btn.setText("Disconnect");
        disconnect_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnect_btnActionPerformed(evt);
            }
        });

        msg_txt.setText("Whatup");
        msg_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_txtActionPerformed(evt);
            }
        });

        IP_addr.setText("146.232.50.101");
        IP_addr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IP_addrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Chat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chat_choice_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IP_addr, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connect_btn)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(users_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disconnect_btn))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connect_btn)
                    .addComponent(disconnect_btn)
                    .addComponent(IP_addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Chat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(users_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chat_choice_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send_btn))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_btnActionPerformed
        try {
            // TODO add your handling code here:
            String msg_choice = chat_choice_dropdown.getSelectedItem();
            msg_txtActionPerformed(evt);
            RW354_tut1_client.sendMessage(msg, msg_choice);
            
            
            //printMsg(msg, msg_choice);
        } catch (IOException ex) {
            System.out.println("SENDING ERROR" + ex);
        }
    }//GEN-LAST:event_send_btnActionPerformed

    private void username_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_txtActionPerformed
        // TODO add your handling code here:
        username = username_txt.getText();
    }//GEN-LAST:event_username_txtActionPerformed

    private void connect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_btnActionPerformed
        try {
            // TODO add your handling code here:
            boolean validIP = false;
            username_txtActionPerformed(evt);
            IP_addrActionPerformed(evt);
//validIP = checkIP(IP);
//            if(!validIP){
//                
//                JOptionPane.showMessageDialog(rootPane, "invalid IP");
////                return;
//            }
            connect(serverName, username);
            if(!valid_usrnm){
                JOptionPane.showMessageDialog(rootPane, "Nickname already chosen");
            }
            if(valid_con){
                
               
            } else{
                JOptionPane.showMessageDialog(rootPane, "Connection Failed");
            }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(rootPane, "Server not responding : " + ex);

            Logger.getLogger(ChatInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connect_btnActionPerformed

    private void msg_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_txtActionPerformed
        // TODO add your handling code here:
        msg = msg_txt.getText();

    }//GEN-LAST:event_msg_txtActionPerformed

    private void disconnect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnect_btnActionPerformed
        // TODO add your handling code here:
        RW354_tut1_client.disconnect(username);
        dispose();
    }//GEN-LAST:event_disconnect_btnActionPerformed

    private void IP_addrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IP_addrActionPerformed
        // TODO add your handling code here:
        IP = IP_addr.getText();
        
    }//GEN-LAST:event_IP_addrActionPerformed
    public void printMsg(String msg, String FromWho ){
        Chat_txt.append( FromWho + ":" + msg +"\n");
    }
    public void printConnection(String toWho,boolean connectDis ){
        if(connectDis){
            Chat_txt.append( toWho + " is connected \n");
        }else{
            Chat_txt.append( toWho + "  disconected\n");
        }
        
    }
    public void addUsr(String usr){
        users_txt.append( usr + "\n");
        chat_choice_dropdown.add(usr);
        
    }
    public void addAllusers(String list_of_users) {
        String newUsr= "";
        chat_choice_dropdown.removeAll();
        users_txt.setText("");
        users_txt.append("All \n");
        chat_choice_dropdown.add("All");
        List<String> tempList = Arrays.asList(list_of_users.split(","));
         if (list == null){
             list = tempList;
             newUsr = username;
         }else{
             System.out.println(list + " list \n " + tempList + " tmep list");
             for(String s : tempList){
                 if(!list.contains(s)){
                     newUsr = s;
                     System.out.println(newUsr+ " this is new user");
                 }
             }
             list = tempList;
         }
        printConnection(newUsr, true);
        for (int i = 0; i < list.size(); i++) {
                        addUsr(list.get(i));
        }
    }
    public static boolean checkIP(String ip){
        boolean valid = false;
//        if(ip.substring(0, 8).equals("146.232.")){
//            String ip_sub = ip.substring(8,10);
//            int ip_sub_int = Integer.parseInt(ip_sub);
//            if(ip.charAt(10) == '.'){
//                if(ip_sub_int > 10 && ip_sub_int<99 ){
//                   int ip_sub_int_two = Integer.parseInt(ip.substring(11,14));
//                    System.out.println(ip.substring(11,14));
//                   if(ip_sub_int_two>=100 && ip_sub_int_two<=255){
//                       valid = true;
//                   }
//                }
//            }
//        }

        Scanner sc = new Scanner(ip);
        sc.useDelimiter("\\.");
        String part1 = sc.next();//Integer.parseInt(sc.next());
        String  part2 = sc.next();
        String  part3 = sc.next();
        String  part4 = sc.next();
        sc.close();
        System.out.println("part3 : " + ip );
        int part3_i = Integer.parseInt(part3);
        int part4_i = Integer.parseInt(part4);
        if(part1.equals("146")){
            if(part2.equals("232")){
                if(part3_i >=10 && part3_i<=99){
                    if(part4_i >= 100 && part4_i<=255){
                        valid = true;
                    }
                }
            }
        }
            
        return valid;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea Chat_txt;
    private javax.swing.JTextField IP_addr;
    private java.awt.Choice chat_choice_dropdown;
    private javax.swing.JButton connect_btn;
    private javax.swing.JButton disconnect_btn;
    private javax.swing.JTextField msg_txt;
    private javax.swing.JButton send_btn;
    private javax.swing.JTextField username_txt;
    private java.awt.TextArea users_txt;
    // End of variables declaration//GEN-END:variables

    
}
