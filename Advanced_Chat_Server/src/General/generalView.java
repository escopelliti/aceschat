package General;

import Database.databaseQueries;
import Network.serverExecutor;
import XML.XML;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/*Classe che implementa un interfaccia grafica per visualizzare eventi all'interno dell'applicazione*/
public class generalView extends javax.swing.JFrame implements Runnable{


    public generalView(Begin starter,databaseQueries query) {
        
        initComponents();
        this.query = query;
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

        textLabel = new javax.swing.JLabel();
        textLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        decoPanel1 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        DecorationFunctionPanel1 = new javax.swing.JPanel();
        scoll1 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JTextArea();
        scoll = new javax.swing.JScrollPane();
        loggedUsersList = new javax.swing.JList();
        menuBar = new javax.swing.JMenuBar();
        dumpMenuItem = new javax.swing.JMenu();
        signUser = new javax.swing.JMenuItem();
        dumpDB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        textLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel.setText("Utenti connessi");

        textLabel1.setFont(new java.awt.Font("SansSerif", 1, 15));
        textLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel1.setText("Eventi");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        decoPanel1.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout decoPanel1Layout = new javax.swing.GroupLayout(decoPanel1);
        decoPanel1.setLayout(decoPanel1Layout);
        decoPanel1Layout.setHorizontalGroup(
            decoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        decoPanel1Layout.setVerticalGroup(
            decoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/General/Images/logo2.png"))); // NOI18N

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
        scoll1.setViewportView(eventList);

        scoll.setViewportView(loggedUsersList);

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

        menuBar.add(dumpMenuItem);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLabel)
                            .addComponent(scoll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scoll1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)))
                    .addComponent(decoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(scoll1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(scoll, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        
        this.dispose();
        starter.setVisible(true);
}//GEN-LAST:event_logoutButtonActionPerformed

    /*Possibilità di Dump Xml del DB*/
    private void dumpDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dumpDBActionPerformed
        try{
            XML xml = new XML(this.query);
            xml.dumpDB();
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Problema riscontrato durante il dump:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }catch(IOException ex){
         
            JOptionPane.showMessageDialog(null,"Problema riscontrato durante il dump:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dumpDBActionPerformed

    /*Possibilità dell'amministratore di segnalare un utente in modo definitivo
     * aggiungendolo alla blacklist
     */
    private void signUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUserActionPerformed
        
        if(!loggedUsersList.isSelectionEmpty()){
            try{
                int idtoSign = this.se.selectId(loggedUsersList.getSelectedValue().toString(),"");
                this.se.addToBlackList(idtoSign);
            }catch(SQLException ex){
                
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
    
    /*Inserisce eventi nella "coda" degli eventi che verranno visualizzati
     Per evitare problemi di concorrenza è previsto l'uso di un semaforo anche se gli ArrayList sono
     strutture sincronizzate*/
    public void enqueueEvent(String incomingEvent) throws InterruptedException{
        
        sem.acquire(1);
        events.add(incomingEvent);
        sem.release(1);       
    }
    
    /*Visualizza eventi a schermo presi dalla "coda" di eventi*/
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
    
    /*Thread che aggiorna a schermo gli eventi che avvengono nell'applicazione*/
    public void run(){
        
        while(true){    
            
            try{
                dequeueEvent();
                updateLoggedUsers();
                update.sleep(2000);
            }catch(InterruptedException ex){
                JOptionPane.showMessageDialog(null,"Errore Runtime durante la visualizzazione dei messaggi:\n"+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);    
            }
        }
    }
    
    private databaseQueries query; 
    private serverExecutor se;
    private Semaphore sem;
    private ArrayList<String> events;
    private Vector loggedUsers;
    private Thread update;
    private Begin starter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecorationFunctionPanel1;
    private javax.swing.JPanel decoPanel1;
    private javax.swing.JMenuItem dumpDB;
    private javax.swing.JMenu dumpMenuItem;
    private javax.swing.JTextArea eventList;
    private javax.swing.JList loggedUsersList;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JScrollPane scoll;
    private javax.swing.JScrollPane scoll1;
    private javax.swing.JMenuItem signUser;
    private javax.swing.JLabel textLabel;
    private javax.swing.JLabel textLabel1;
    // End of variables declaration//GEN-END:variables
}
