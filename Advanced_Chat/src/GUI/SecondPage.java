/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SecondPage.java
 *
 * Created on 5-ott-2011, 15.30.31
 */

package GUI;

import fileManager.fileOperation;
import General.MD5;
import Networking.Requests;
import User.User;
import XML.XML;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author enrico
 */
public class SecondPage extends javax.swing.JFrame {

    /** Creates new form SecondPage */
    public SecondPage(User user) {
        initComponents();
        this.user = user;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        politicCheck = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TechnologyCheck = new javax.swing.JCheckBox();
        sportCheck = new javax.swing.JCheckBox();
        cultureCheck = new javax.swing.JCheckBox();
        gossipCheck = new javax.swing.JCheckBox();
        portField = new javax.swing.JTextField();
        rememberMeCheckBox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        pswField = new javax.swing.JPasswordField();
        psw_Field = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        enterButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(238, 162, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel1.setForeground(new java.awt.Color(6, 6, 6));
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel2.setForeground(new java.awt.Color(6, 6, 6));
        jLabel2.setText("Reinserisci la password:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel3.setForeground(new java.awt.Color(6, 6, 6));
        jLabel3.setText("Inserisci la password:");

        politicCheck.setFont(new java.awt.Font("SansSerif", 1, 15));
        politicCheck.setForeground(new java.awt.Color(6, 6, 6));
        politicCheck.setText("Politica");
        politicCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                politicCheckActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel4.setForeground(new java.awt.Color(6, 6, 6));
        jLabel4.setText("I tuoi interessi:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel5.setForeground(new java.awt.Color(6, 6, 6));
        jLabel5.setText("Ip :");

        TechnologyCheck.setFont(new java.awt.Font("SansSerif", 1, 15));
        TechnologyCheck.setForeground(new java.awt.Color(6, 6, 6));
        TechnologyCheck.setText("Tecnologia");
        TechnologyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TechnologyCheckActionPerformed(evt);
            }
        });

        sportCheck.setFont(new java.awt.Font("SansSerif", 1, 15));
        sportCheck.setForeground(new java.awt.Color(6, 6, 6));
        sportCheck.setText("Sport");
        sportCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportCheckActionPerformed(evt);
            }
        });

        cultureCheck.setFont(new java.awt.Font("SansSerif", 1, 15));
        cultureCheck.setForeground(new java.awt.Color(6, 6, 6));
        cultureCheck.setText("Cultura");
        cultureCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureCheckActionPerformed(evt);
            }
        });

        gossipCheck.setFont(new java.awt.Font("SansSerif", 1, 15));
        gossipCheck.setForeground(new java.awt.Color(6, 6, 6));
        gossipCheck.setText("Gossip");
        gossipCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gossipCheckActionPerformed(evt);
            }
        });

        portField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portFieldActionPerformed(evt);
            }
        });

        rememberMeCheckBox.setFont(new java.awt.Font("SansSerif", 1, 15));
        rememberMeCheckBox.setForeground(new java.awt.Color(6, 6, 6));
        rememberMeCheckBox.setText("Salva credenziali");
        rememberMeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberMeCheckBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel7.setForeground(new java.awt.Color(6, 6, 6));
        jLabel7.setText("Porta:");

        jTextPane1.setBackground(new java.awt.Color(15, 64, 133));
        jTextPane1.setFont(new java.awt.Font("SansSerif", 1, 15));
        jTextPane1.setForeground(new java.awt.Color(252, 245, 245));
        jTextPane1.setText("Con ACES puoi parlare con i tuoi amici a cui più tieni.\nCondividere file in tutta libertà.\nDivertirti con i tuoi amici\n");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rememberMeCheckBox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sportCheck)
                                .addGap(18, 18, 18)
                                .addComponent(gossipCheck)
                                .addGap(18, 18, 18)
                                .addComponent(cultureCheck)
                                .addGap(18, 18, 18)
                                .addComponent(politicCheck)
                                .addGap(18, 18, 18)
                                .addComponent(TechnologyCheck))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(psw_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(pswField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(usernameField))
                                .addGap(103, 103, 103)))
                        .addGap(313, 313, 313))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psw_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sportCheck)
                    .addComponent(gossipCheck)
                    .addComponent(cultureCheck)
                    .addComponent(politicCheck)
                    .addComponent(TechnologyCheck))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rememberMeCheckBox)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(15, 64, 133));

        enterButton.setFont(new java.awt.Font("SansSerif", 1, 24));
        enterButton.setForeground(new java.awt.Color(6, 6, 6));
        enterButton.setText("Accedi");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo2.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 36));
        jLabel12.setForeground(new java.awt.Color(238, 162, 30));
        jLabel12.setText("Advanced Chat Easy Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //tutte le azioni da intraprendere al momento della registrazione  //gestione mancata connessione al server
    //gestione eventuale controllo dell'username (unico se lo deve essere) tramite richiesta al server;
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        try{

            Requests request = new Requests(ipField.getText(),portField.getText());

            if(!usernameField.getText().equals("") && !pswField.getText().equals("") && !psw_Field.getText().equals("") && pswField.getText().equals(psw_Field.getText()) && !ipField.getText().equals("") && !portField.getText().equals("")){
            
                this.user.setUsername(usernameField.getText());
                this.user.setPassword(pswField.getText());
                if(!sportCheck.isSelected() && !cultureCheck.isSelected() && !politicCheck.isSelected() && !gossipCheck.isSelected() && !TechnologyCheck.isSelected())
                    this.user.setInterests("Nessuno");

                if(request.registerMe(this.user)){//se la registrazione è andata a buon fine ed è stata caricata la Home;
                    this.dispose();//chiudiamo questa finestra
                    initialize();//creiamo cartelle e file di configurazione
                    saveConfiguration();
                    }

                }
            }
            catch(Exception ex){

                JOptionPane.showMessageDialog(null, ex.toString(), "ACES", JOptionPane.ERROR_MESSAGE);

            }
    }//GEN-LAST:event_enterButtonActionPerformed

    private void initialize() throws IOException{

            boolean created = false;
            while(!created){
                if(application.getOS().equals("Windows")){
                    if(fileOperation.exist("ACES")){
                        created = true;
                        break;
                    }
                    created = application.createDirectory("ACES\\History");
                               
                    }
                else{
                    if(fileOperation.exist("ACES")){
                        created = true;
                        break;
                    }
                    created = application.createDirectory("ACES/History");

                    }

            }       
    }

    private void saveConfiguration(){ //crea i file xml di configurazione per il server e con le credenziali dell'utente

        if(application.getOS().equals("Windows")/* || application.getOS().equals("WINDOWS")*/){
            try {
                new XML().writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getPassword().toString(),getRememberMe());
                new XML().writeXml("ACES\\config.xml", ipField.getText(), portField.getText());
             } catch (IOException ex) {
                Logger.getLogger(SecondPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                new XML().writeXml("ACES/config.xml", ipField.getText(), portField.getText());
                new XML().writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(),getRememberMe());
            } catch (IOException ex) {
                Logger.getLogger(SecondPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    //da levare
    private void portFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portFieldActionPerformed

    //se si diventa no e viceversa per permettere l'eventuale modifica del file xml "credentials.xml"
    /*in modo da eventualmente caricare le info personali all'avvio dell'applicazione */
    private void rememberMeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberMeCheckBoxActionPerformed

        if(getRememberMe().equals("no"))
        setRememberMe("si");
        else setRememberMe("no");

    }//GEN-LAST:event_rememberMeCheckBoxActionPerformed


    //vari metodi che settano la stringa di interessi che va a scrivere nel file xml
    private void sportCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportCheckActionPerformed
        this.user.setInterests("sport");
    }//GEN-LAST:event_sportCheckActionPerformed

    private void gossipCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gossipCheckActionPerformed
        this.user.setInterests("gossip");

    }//GEN-LAST:event_gossipCheckActionPerformed

    private void cultureCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultureCheckActionPerformed
        this.user.setInterests("cultura");
    }//GEN-LAST:event_cultureCheckActionPerformed

    private void politicCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_politicCheckActionPerformed
        this.user.setInterests("politica");
    }//GEN-LAST:event_politicCheckActionPerformed

    private void TechnologyCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TechnologyCheckActionPerformed
        this.user.setInterests("tecnologia");
    }//GEN-LAST:event_TechnologyCheckActionPerformed

   
    private String rememberMe = "no";  //serve per capire se dobbiamo memorizzare "ricordami" nel file XML;
    private User user;
    private fileOperation application = new fileOperation();

    //componenti swing per il form;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox TechnologyCheck;
    private javax.swing.JCheckBox cultureCheck;
    private javax.swing.JButton enterButton;
    private javax.swing.JCheckBox gossipCheck;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JCheckBox politicCheck;
    private javax.swing.JTextField portField;
    private javax.swing.JPasswordField pswField;
    private javax.swing.JPasswordField psw_Field;
    private javax.swing.JCheckBox rememberMeCheckBox;
    private javax.swing.JCheckBox sportCheck;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

}




/**
 *
 * @author enrico
 */


