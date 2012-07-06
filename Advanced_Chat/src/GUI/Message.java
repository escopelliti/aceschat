package GUI;

import General.DateTime;
import Networking.Requests;
import User.User;
import XML.XML;
import fileManager.fileOperation;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.jdom.Document;

/* 
 * Classe per la gestione della visualizzazione dei messaggi tra due client/utenti
 */
public class Message extends javax.swing.JFrame {

    /* Costruttore della classe Message; initComponents() costruisce e setta tutti i componenti swing
    *  toContact rappresenta il vettore dei partecipanti alla chat
    */
    public Message(User client,Vector toContact,Requests toCon) throws IOException {

        initComponents();

        this.client = client;
        this.toContact = toContact;
        this.request = toCon;
        this.participantList.setListData(toContact);
        this.clientLabel.setText(client.getUsername());
    }

// il metodo aggiunge alla JTextArea Conversation la stringa passata come argomento
    public void append(String toAppend){
        ConversationArea.append(toAppend);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        sendMess = new javax.swing.JButton();
        abuseButton = new javax.swing.JButton();
        scroll2 = new javax.swing.JScrollPane();
        ClientText = new javax.swing.JTextPane();
        scroll1 = new javax.swing.JScrollPane();
        ConversationArea = new javax.swing.JTextArea();
        friendLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        sendFile = new javax.swing.JButton();
        scroll3 = new javax.swing.JScrollPane();
        participantList = new javax.swing.JList();
        decoPanel = new javax.swing.JPanel();
        acesLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();

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
        scroll2.setViewportView(ClientText);

        ConversationArea.setBackground(new java.awt.Color(252, 241, 173));
        ConversationArea.setColumns(20);
        ConversationArea.setEditable(false);
        ConversationArea.setFont(new java.awt.Font("SansSerif", 1, 10));
        ConversationArea.setForeground(new java.awt.Color(6, 6, 6));
        ConversationArea.setRows(5);
        scroll1.setViewportView(ConversationArea);

        friendLabel.setText("Partecipanti:");

        sendFile.setText("Invia un file");
        sendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileActionPerformed(evt);
            }
        });

        scroll3.setViewportView(participantList);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addComponent(scroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(sendMess, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abuseButton)
                    .addComponent(friendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendMess, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                                        .addComponent(friendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(scroll3)
                                        .addGap(18, 18, 18)
                                        .addComponent(abuseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        decoPanel.setBackground(new java.awt.Color(238, 162, 30));
        decoPanel.setAutoscrolls(true);

        acesLabel.setFont(new java.awt.Font("SansSerif", 1, 28));
        acesLabel.setForeground(new java.awt.Color(15, 64, 133));
        acesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acesLabel.setText("ACES");

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/my_Logo.png"))); // NOI18N

        javax.swing.GroupLayout decoPanelLayout = new javax.swing.GroupLayout(decoPanel);
        decoPanel.setLayout(decoPanelLayout);
        decoPanelLayout.setHorizontalGroup(
            decoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(acesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        decoPanelLayout.setVerticalGroup(
            decoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoPanelLayout.createSequentialGroup()
                .addGroup(decoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addGroup(decoPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(acesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(decoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(decoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Gestione dell'azione di invio messaggio da parte dell'utente*/
    private void sendMessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessActionPerformed
        
        try{           
            String message = ClientText.getText();
            int count = 0;
            String toSend = this.client.getUsername() + "["+DateTime.getDateTime()+"] :"+message+"\n";
            ConversationArea.append(toSend);
     
            /*Inviamo la richiesta di invio messaggio e scriviamo i file XML per la cronologia*/
            request.send(toSend, this.toContact, this.client.getUsername());
            while(count < this.toContact.size() && toContact.get(count) != client){
                writingFile(this.client.getUsername(),message,this.toContact.get(count).toString());
                count++;
            }
            ClientText.setText(null);
            
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Chat temporaneamente non disponibile.", "ACES", JOptionPane.ERROR_MESSAGE);
            }catch(NullPointerException ex){            
                JOptionPane.showMessageDialog(null, "Non hai inserito il messaggio.", "ACES", JOptionPane.ERROR_MESSAGE);
            }         
    }//GEN-LAST:event_sendMessActionPerformed

    /*Scriviamo i file XML relativi all'argomento toWrite il text passato come argomento*/ 
    public void writingFile(String client,String text,String toWrite) throws IOException{
        
        Document doc;
        XML xml = new XML();
   
        if(!new fileOperation().getOS().equals("Windows")){
            if(!fileOperation.exist("ACES/History/"+toWrite.concat(".xml")))
                xml.genXml("ACES/History/".concat(toWrite.concat(".xml")));
            doc = xml.modifyXml(client,text,xml.getDocument("ACES/History/"+toWrite.concat(".xml")));
            xml.write(doc,"ACES/History/"+toWrite.concat(".xml"));
        }else{
            if(!fileOperation.exist("ACES\\History\\"+toWrite.concat(".xml")))
                xml.genXml("ACES\\History\\".concat(toWrite.concat(".xml")));
            doc = xml.modifyXml(client,text,xml.getDocument("ACES\\History\\"+toWrite.concat(".xml")));
            xml.write(doc,"ACES\\History\\"+toWrite.concat(".xml"));
        }  
    }

    /*Attraverso questo metodo codifichiamo l'azione intrapresa dall'utente di segnalare un altro utente;
         * Attraverso la finestra abuseDialog chiediamo di descrivere l'abuso fatto dall'utente;
         */
    private void abuseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abuseButtonActionPerformed
   
        if(!participantList.isSelectionEmpty()){            
            new abuseDialog(this.client.getIdPerson(),request,participantList.getSelectedValue().toString()).setVisible(true);            
        }
        
    }//GEN-LAST:event_abuseButtonActionPerformed

    //metodo che affida a fileChooser la gestione di un file da inviare da parte dell'utente
    //use = 0 identifica un uso di fileChooser per inviare un file e non per caricare un immagine
    //personale;
    private void sendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileActionPerformed
        
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
    private javax.swing.JLabel acesLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JPanel decoPanel;
    private javax.swing.JLabel friendLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JList participantList;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JButton sendFile;
    private javax.swing.JButton sendMess;
    // End of variables declaration//GEN-END:variables

}
