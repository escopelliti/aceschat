package GUI;

import General.DateTime;
import Networking.Requests;
import User.User;
import XML.createXml;
import java.io.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.jdom.Document;




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Message.java
 *
 * Created on 9-ott-2011, 20.05.05
 */

/**
 *
 * @author alberto
 */
public class Message extends javax.swing.JFrame {

    /** Costruttore della classe Message; initComponents() costruisce e setta tutti i componenti swing */
    public Message(User client,Vector toContact,Requests toCon) throws IOException {

        initComponents();

        this.client = client;
        this.toContact = toContact;
        this.request = toCon;
        this.participantList.setListData(toContact);
        this.clientLabel.setText(client.getUsername());

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
//GraphicsDevice cc = ge.getDefaultScreenDevice();
//setVisible(true);
//cc.setFullScreenWindow(Message);
    }


    public void append(String toAppend){

        ConversationArea.append(toAppend);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sendMess = new javax.swing.JButton();
        abuseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientText = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConversationArea = new javax.swing.JTextArea();
        friendLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        sendFile = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        participantList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        sendMess.setText("Invia");
        sendMess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessActionPerformed(evt);
            }
        });

        abuseButton.setText("Segnala");
        abuseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abuseButtonActionPerformed(evt);
            }
        });

        ClientText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(ClientText);

        ConversationArea.setBackground(new java.awt.Color(252, 241, 173));
        ConversationArea.setColumns(20);
        ConversationArea.setEditable(false);
        ConversationArea.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        ConversationArea.setForeground(new java.awt.Color(6, 6, 6));
        ConversationArea.setRows(5);
        jScrollPane1.setViewportView(ConversationArea);

        friendLabel.setText("Partecipanti:");

        sendFile.setText("Invia un file");
        sendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(participantList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(sendMess, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abuseButton)
                    .addComponent(friendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendMess, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(friendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3)
                                        .addGap(18, 18, 18)
                                        .addComponent(abuseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(238, 162, 30));
        jPanel2.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 28));
        jLabel3.setForeground(new java.awt.Color(15, 64, 133));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ACES");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/my_Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //azioni da intraprendere quando si invia un messaggio;
    private void sendMessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessActionPerformed
        
        
        if(ClientText.getText() != ""){
        //ricaviamo data/ora grazie al metodo;
            String[] datetime = DateTime.getDateTime();
         //scriviamo nella text area della conversazione;
            String toSend = this.client.getUsername() + "["+datetime[0]+datetime[1]+datetime[2]+" "+datetime[3]+datetime[4]+datetime[5]+" "+DateTime.getAmPm()+"] :"+ClientText.getText()+"\n";
            ConversationArea.append(toSend);

            try{
             
                request.send(toSend, this.toContact, this.client.getUsername());
                writingFile(this.client.getUsername(),ClientText.getText(),this.toContact);
            }
            catch(IOException ex){

                JOptionPane.showMessageDialog(null, "Chat temporaneamente non disponibile.", "ACES", JOptionPane.ERROR_MESSAGE);
            }
        

        //svuotiamo la casella di testo del client che scrive
            ClientText.setText(null);
        }
    }//GEN-LAST:event_sendMessActionPerformed

    
    
    public void writingFile(String client,String text,Vector toContact) throws IOException{
        
         String toWrite;
         int count = 0;
         
         while(count < this.toContact.size()){
             
            toWrite = (String) toContact.get(count);
            Document doc = createXml.modifyXml(client,text,createXml.getDocument("ACES/History/"+toWrite.concat(".xml")));
            createXml.write(doc,"ACES/History/"+toWrite.concat(".xml"));
            
            count++;
         }
    }
    
    
        public void writingFile(String client,String text,String nameFile) throws IOException{
        
            Document doc = createXml.modifyXml(client,text,createXml.getDocument("ACES/History/"+nameFile.concat(".xml")));
            createXml.write(doc,"ACES/History/"+nameFile.concat(".xml"));
                
        }

    //metodo che invia richiesta al server di decodifica il messaggio di abuso fatto al Client che segnala da parte dal client
    //con cui sta parlando;
    private void abuseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abuseButtonActionPerformed

        if(!participantList.isSelectionEmpty()){
            
            new abuseDialog(this.client.getIdPerson(),request,participantList.getSelectedValue().toString()).setVisible(true);
            
        }
        //DA IMPLEMENTARE: frame che ti chiede quello che serve (offesa e altro) per inviare la richiesta di segnalazione
        //abuso al server;

    }//GEN-LAST:event_abuseButtonActionPerformed

    private void sendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileActionPerformed
        //0 identifica un uso del file chooser per mandare un file
        new fileChooser(this.request,this.client,0,this.toContact).setVisible(true);
        
    }//GEN-LAST:event_sendFileActionPerformed

    private Vector toContact;
    private User client;
    private Requests request;
    //componenti swing per il form;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane ClientText;
    private javax.swing.JTextArea ConversationArea;
    private javax.swing.JButton abuseButton;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JLabel friendLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList participantList;
    private javax.swing.JButton sendFile;
    private javax.swing.JButton sendMess;
    // End of variables declaration//GEN-END:variables

}
