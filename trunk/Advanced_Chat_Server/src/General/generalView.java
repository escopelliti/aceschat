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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.Semaphore;

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
        dumpButton = new javax.swing.JButton();

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
            .addGap(0, 954, Short.MAX_VALUE)
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
            .addGap(0, 954, Short.MAX_VALUE)
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

        dumpButton.setText("Dump");
        dumpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dumpButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dumpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dumpButton)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
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

    private void dumpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dumpButtonActionPerformed
        
        
        
    }//GEN-LAST:event_dumpButtonActionPerformed

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
    
    private Semaphore sem;
    private ArrayList<String> events;
    private Vector loggedUsers;
    private Thread update;
    private Begin starter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecorationFunctionPanel1;
    private javax.swing.JButton dumpButton;
    private javax.swing.JTextArea eventList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList loggedUsersList;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables
}
