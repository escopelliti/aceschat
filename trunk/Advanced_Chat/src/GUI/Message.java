package GUI;

import General.DateTime;
import Networking.Requests;
import User.User;
import XML.createXml;
import java.io.*;
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
    public Message(User client,String toContact,Requests toCon) throws IOException {

        initComponents();

        this.client = client;
        this.toContact = toContact;
        this.request = toCon;


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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abuseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientText = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConversationArea = new javax.swing.JTextArea();
        friendLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        sendFile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        sendMess.setText("Invia");
        sendMess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessActionPerformed(evt);
            }
        });

        jLabel1.setText("Foto 1");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Foto 2");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        abuseButton.setText("Segnala");
        abuseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abuseButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(ClientText);

        ConversationArea.setBackground(new java.awt.Color(254, 254, 254));
        ConversationArea.setColumns(20);
        ConversationArea.setEditable(false);
        ConversationArea.setFont(new java.awt.Font("SansSerif", 1, 10));
        ConversationArea.setForeground(new java.awt.Color(6, 6, 6));
        ConversationArea.setRows(5);
        jScrollPane1.setViewportView(ConversationArea);

        sendFile.setText("Invia un file");
        sendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(friendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(sendMess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(abuseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(friendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abuseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(sendMess)))
                .addContainerGap())
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
                .addContainerGap(342, Short.MAX_VALUE))
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

                new userDialog("Chat temporaneamente non disponibile.").setVisible(true);
            }
        //modifichiamo l'xml,qualora esistesse(col nome del client a cui scrivi (altrimenti la crea)),
        
        
        //svuotiamo la casella di testo del client che scrive
            ClientText.setText(null);
        }
    }//GEN-LAST:event_sendMessActionPerformed

    
    
    public void writingFile(String client,String text,String toContact) throws IOException{
        
         Document doc = createXml.modifyXml(this.client.getUsername(),ClientText.getText(),createXml.getDocument("ACES/History/"+this.toContact.concat(".xml")));
         createXml.write(doc,"ACES/History/"+this.toContact.concat(".xml"));
    }

    //metodo che invia richiesta al server di decodifica il messaggio di abuso fatto al Client che segnala da parte dal client
    //con cui sta parlando;
    private void abuseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abuseButtonActionPerformed

        //DA IMPLEMENTARE: this.toCon.sendAbuse(friend.getUsername(),client.getID(),"OFFESA");
        //

    }//GEN-LAST:event_abuseButtonActionPerformed

    private void sendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileActionPerformed
        //0 identifica un uso del file chooser per mandare un file
        new fileChooser(this.client.getUsername(),this.request,this.client.getIdPerson(),0,this.toContact).setVisible(true);
        
    }//GEN-LAST:event_sendFileActionPerformed

    private String toContact;
    private User client;
    private Requests request;
    //componenti swing per il form;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane ClientText;
    private javax.swing.JTextArea ConversationArea;
    private javax.swing.JButton abuseButton;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JLabel friendLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sendFile;
    private javax.swing.JButton sendMess;
    // End of variables declaration//GEN-END:variables

}
