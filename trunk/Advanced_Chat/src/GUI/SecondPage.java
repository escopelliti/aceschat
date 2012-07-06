package GUI;

import fileManager.fileOperation;
import Networking.Requests;
import User.User;
import XML.XML;
import java.io.IOException;
import javax.swing.JOptionPane;

/*Classe che permette di gestire e far inserire altre informazioni che andranno a costituire l'utente da registrare*/
public class SecondPage extends javax.swing.JFrame {
    
    /*inizializziamo i componenti Swing*/
    public SecondPage(User user) {
        initComponents();
        this.user = user;
        this.fo = new fileOperation();
        this.rememberMe = "no";
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        repswLabel = new javax.swing.JLabel();
        pswLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        politicCheck = new javax.swing.JCheckBox();
        interestsLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        TechnologyCheck = new javax.swing.JCheckBox();
        sportCheck = new javax.swing.JCheckBox();
        cultureCheck = new javax.swing.JCheckBox();
        gossipCheck = new javax.swing.JCheckBox();
        portField = new javax.swing.JTextField();
        rememberMeCheckBox = new javax.swing.JCheckBox();
        portLabel = new javax.swing.JLabel();
        textScroolPanel = new javax.swing.JScrollPane();
        infoTextPanel = new javax.swing.JTextPane();
        pswField = new javax.swing.JPasswordField();
        psw_Field = new javax.swing.JPasswordField();
        enterPanel = new javax.swing.JPanel();
        enterButton = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        infoPanel.setBackground(new java.awt.Color(238, 162, 30));

        usernameField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameField.setForeground(new java.awt.Color(6, 6, 6));

        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(6, 6, 6));
        usernameLabel.setText("Username:");

        repswLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        repswLabel.setForeground(new java.awt.Color(6, 6, 6));
        repswLabel.setText("Reinserisci la password:");

        pswLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        pswLabel.setForeground(new java.awt.Color(6, 6, 6));
        pswLabel.setText("Inserisci la password:");

        ipField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        ipField.setForeground(new java.awt.Color(6, 6, 6));

        politicCheck.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        politicCheck.setForeground(new java.awt.Color(6, 6, 6));
        politicCheck.setText("Politica");
        politicCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                politicCheckActionPerformed(evt);
            }
        });

        interestsLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        interestsLabel.setForeground(new java.awt.Color(6, 6, 6));
        interestsLabel.setText("I tuoi interessi:");

        ipLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        ipLabel.setForeground(new java.awt.Color(6, 6, 6));
        ipLabel.setText("Ip :");

        TechnologyCheck.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        TechnologyCheck.setForeground(new java.awt.Color(6, 6, 6));
        TechnologyCheck.setText("Tecnologia");
        TechnologyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TechnologyCheckActionPerformed(evt);
            }
        });

        sportCheck.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        sportCheck.setForeground(new java.awt.Color(6, 6, 6));
        sportCheck.setText("Sport");
        sportCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportCheckActionPerformed(evt);
            }
        });

        cultureCheck.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        cultureCheck.setForeground(new java.awt.Color(6, 6, 6));
        cultureCheck.setText("Cultura");
        cultureCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureCheckActionPerformed(evt);
            }
        });

        gossipCheck.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        gossipCheck.setForeground(new java.awt.Color(6, 6, 6));
        gossipCheck.setText("Gossip");
        gossipCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gossipCheckActionPerformed(evt);
            }
        });

        portField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        portField.setForeground(new java.awt.Color(6, 6, 6));

        rememberMeCheckBox.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        rememberMeCheckBox.setForeground(new java.awt.Color(6, 6, 6));
        rememberMeCheckBox.setText("Salva credenziali");
        rememberMeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberMeCheckBoxActionPerformed(evt);
            }
        });

        portLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        portLabel.setForeground(new java.awt.Color(6, 6, 6));
        portLabel.setText("Porta:");

        infoTextPanel.setBackground(new java.awt.Color(15, 64, 133));
        infoTextPanel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        infoTextPanel.setForeground(new java.awt.Color(252, 245, 245));
        infoTextPanel.setText("Con ACES puoi parlare con i tuoi amici a cui più tieni.\nCondividere file in tutta libertà.\nDivertirti con i tuoi amici\n");
        textScroolPanel.setViewportView(infoTextPanel);

        pswField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        pswField.setForeground(new java.awt.Color(6, 6, 6));

        psw_Field.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        psw_Field.setForeground(new java.awt.Color(6, 6, 6));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(portLabel)
                                    .addComponent(ipLabel))
                                .addGap(65, 65, 65)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rememberMeCheckBox)))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(sportCheck)
                                .addGap(18, 18, 18)
                                .addComponent(gossipCheck)
                                .addGap(18, 18, 18)
                                .addComponent(cultureCheck)
                                .addGap(18, 18, 18)
                                .addComponent(politicCheck)
                                .addGap(18, 18, 18)
                                .addComponent(TechnologyCheck))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repswLabel)
                                    .addComponent(pswLabel)
                                    .addComponent(usernameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(psw_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(pswField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(usernameField))
                                .addGap(103, 103, 103)))
                        .addGap(313, 313, 313))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(interestsLabel)
                            .addComponent(textScroolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repswLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psw_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(interestsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sportCheck)
                    .addComponent(gossipCheck)
                    .addComponent(cultureCheck)
                    .addComponent(politicCheck)
                    .addComponent(TechnologyCheck))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rememberMeCheckBox)
                .addGap(34, 34, 34)
                .addComponent(textScroolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        enterPanel.setBackground(new java.awt.Color(15, 64, 133));

        enterButton.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        enterButton.setForeground(new java.awt.Color(6, 6, 6));
        enterButton.setText("Accedi");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enterPanelLayout = new javax.swing.GroupLayout(enterPanel);
        enterPanel.setLayout(enterPanelLayout);
        enterPanelLayout.setHorizontalGroup(
            enterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterPanelLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        enterPanelLayout.setVerticalGroup(
            enterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logo2.png"))); // NOI18N

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(238, 162, 30));
        titleLabel.setText("Advanced Chat Easy Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*Azioni da intraprendere a fine registrazione - se tutti i dati sono inseriti*/
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

            if(!usernameField.getText().equals("") && !pswField.getText().equals("") && !psw_Field.getText().equals("") && pswField.getText().equals(psw_Field.getText()) && !ipField.getText().equals("") && !portField.getText().equals("")){
                try{
                    Requests request = new Requests(ipField.getText(),portField.getText());
                    this.user.setUsername(usernameField.getText());
                    this.user.setPassword(pswField.getText());
                    if(!sportCheck.isSelected() && !cultureCheck.isSelected() && !politicCheck.isSelected() && !gossipCheck.isSelected() && !TechnologyCheck.isSelected())
                        this.user.setInterests("Nessuno");
            
                    if(request.registerMe(this.user)){//se la registrazione è andata a buon fine viene caricata la Home;
                        this.dispose();                     //dell'applicazione
                        
                        //creiamo cartelle e file di configurazione per i prossimi accessi
                        saveConfiguration();
                    }
                    }catch(Exception ex){
                        
                        JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
                    }
            }
 
    }//GEN-LAST:event_enterButtonActionPerformed

    /*Creiamo cartelle che conterrano file di configurazione e cronologia dell'applicazione*/
    private void initialize() throws IOException{

        fileOperation fo = new fileOperation();
        if(fo.getOS().equals("Windows"))
            fo.createFile("ACES\\History");
        else                       
            fo.createFile("ACES/History");              
    }

    /*Scriviamo i file di configurazione con le credenziali d'accesso
     * all'applicazione e il file di configurazione con IP e PORTA del server.
     */
    private void saveConfiguration() throws IOException{
        
        try{
            initialize();
            if(fo.getOS().equals("Windows")){
                new XML().writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getPassword().toString(),getRememberMe());
                new XML().writeXml("ACES\\config.xml", ipField.getText(), portField.getText());
            }else{        
                new XML().writeXml("ACES/config.xml", ipField.getText(), portField.getText());
                new XML().writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(),getRememberMe());
            } 
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
}

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    /*Implmentazione funzionalità "Ricordami" al prossimo avvio*/
    private void rememberMeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberMeCheckBoxActionPerformed

        if(getRememberMe().equals("no"))
        setRememberMe("si");
        else setRememberMe("no");
    }//GEN-LAST:event_rememberMeCheckBoxActionPerformed

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

   
    private String rememberMe;
    private User user;
    private fileOperation fo;
    //componenti swing per il form;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox TechnologyCheck;
    private javax.swing.JCheckBox cultureCheck;
    private javax.swing.JButton enterButton;
    private javax.swing.JPanel enterPanel;
    private javax.swing.JCheckBox gossipCheck;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextPane infoTextPanel;
    private javax.swing.JLabel interestsLabel;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JCheckBox politicCheck;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JPasswordField pswField;
    private javax.swing.JLabel pswLabel;
    private javax.swing.JPasswordField psw_Field;
    private javax.swing.JCheckBox rememberMeCheckBox;
    private javax.swing.JLabel repswLabel;
    private javax.swing.JCheckBox sportCheck;
    private javax.swing.JScrollPane textScroolPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

}