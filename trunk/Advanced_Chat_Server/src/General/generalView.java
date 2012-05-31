/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * generalView2.java
 *
 * Created on 9-mar-2012, 11.43.46
 */
package General;

import Network.serverExecutor;
import XML.XML;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author enrico
 */
public class generalView extends javax.swing.JFrame implements Runnable{


    public generalView(Begin starter) {
        
        initComponents();
        this.starter = starter;
        events = new ArrayList<String>();
        loggedUsers = new Vector();
        sem = new Semaphore(1);
        
        update = new Thread(this);
        update.start();
        
    }

    
    public void setExecutor(serverExecutor se){
        
        this.se = se;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DecorationFunctionPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        loggedUsersList = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        dumpMenuItem = new javax.swing.JMenu();
        signUser = new javax.swing.JMenuItem();
        dumpDB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Utenti connessi");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eventi");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/enrico/NetBeansProjects/Advanced Chat/src/GUI/ACES.png")); // NOI18N

        DecorationFunctionPanel1.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout DecorationFunctionPanel1Layout = new javax.swing.GroupLayout(DecorationFunctionPanel1);
        DecorationFunctionPanel1.setLayout(DecorationFunctionPanel1Layout);
        DecorationFunctionPanel1Layout.setHorizontalGroup(
            DecorationFunctionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        DecorationFunctionPanel1Layout.setVerticalGroup(
            DecorationFunctionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        eventList.setColumns(20);
        eventList.setEditable(false);
        eventList.setFont(new java.awt.Font("SansSerif", 1, 15));
        eventList.setForeground(new java.awt.Color(203, 31, 31));
        eventList.setRows(5);
        jScrollPane2.setViewportView(eventList);

        jScrollPane1.setViewportView(loggedUsersList);

        dumpMenuItem.setText("Operazioni");

        signUser.setText("Aggiungi un utente alla BlackList");
        signUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUserActionPerformed(evt);
            }
        });
        dumpMenuItem.add(signUser);

        dumpDB.setText("Fai un backup del Database");
        dumpDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dumpDBActionPerformed(evt);
            }
        });
        dumpMenuItem.add(dumpDB);

        jMenuBar1.add(dumpMenuItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 290, 290)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(241, 241, 241)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed

        //logout dell'amministratore via DB, il server continua a girare;
        this.dispose();
        starter.setVisible(true);
}//GEN-LAST:event_logoutButtonActionPerformed

    private void dumpDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dumpDBActionPerformed
        
        XML xml = new XML();
        xml.dumpDB();
        
    }//GEN-LAST:event_dumpDBActionPerformed

    private void signUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUserActionPerformed
        
        if(!loggedUsersList.isSelectionEmpty()){
            try{
                int idtoSign = this.se.selectId(loggedUsersList.getSelectedValue().toString());
                this.se.addToBlackList(idtoSign);
            }
            catch(SQLException ex){
                
                JOptionPane.showMessageDialog(null,"Problema riscontrato:\n"+ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_signUserActionPerformed

    public void addLoggedUsers(String username) throws InterruptedException{
        
        this.loggedUsers.add(username);
    }

    public void removeLoggedUsers(String username) throws InterruptedException{
        
        this.loggedUsers.remove(username);
    }
    

    public void enqueueEvent(String incomingEvent) throws InterruptedException{
        
        sem.acquire(1);
        events.add(incomingEvent);
        sem.release(1);
        
    }
    
    private void dequeueEvent() throws InterruptedException{
        
        if(!events.isEmpty()){
            
            sem.acquire(1);
            String new_event = events.remove(events.size() - 1);
            sem.release(1);
            eventList.append(new_event+"\n"); 
            
        }
    }
    
    
    private void updateLoggedUsers(){
        
        loggedUsersList.setListData(loggedUsers);
        
    }
    
    
    public void run(){
        
        while(true){    
            
            try{
                
                dequeueEvent();
                updateLoggedUsers();
                update.sleep(2000);
            }
            catch(InterruptedException ex){
                
                System.out.println(ex.getMessage());
            }
        
        }
        
    }
    
    private serverExecutor se;
    private Semaphore sem;
    private ArrayList<String> events;
    private Vector loggedUsers;
    private Thread update;
    private Begin starter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecorationFunctionPanel1;
    private javax.swing.JMenuItem dumpDB;
    private javax.swing.JMenu dumpMenuItem;
    private javax.swing.JTextArea eventList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList loggedUsersList;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenuItem signUser;
    // End of variables declaration//GEN-END:variables
}
