package GUI;

import fileManager.fileOperation;
import Networking.Mail;
import Networking.Requests;
import User.User;
import XML.XML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


public class InputForm extends javax.swing.JFrame {

    public InputForm() throws FileNotFoundException, IOException {

        initComponents();
        initFiles();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        birthdayLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        sexLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        dayComboBox = new javax.swing.JComboBox();
        monthComboBox = new javax.swing.JComboBox();
        sexComboBox = new javax.swing.JComboBox();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        mailField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        yearComboBox = new javax.swing.JComboBox();
        nationField = new javax.swing.JTextField();
        nationLabel = new javax.swing.JLabel();
        credentialsPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        pswField = new javax.swing.JPasswordField();
        pswLabel = new javax.swing.JLabel();
        enterButton = new javax.swing.JButton();
        credentialsCheckBox = new javax.swing.JCheckBox();
        iconLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        subtitleLable = new javax.swing.JLabel();
        titleLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        infoPanel.setBackground(new java.awt.Color(238, 162, 30));

        nameLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(6, 6, 6));
        nameLabel.setText("Nome:");

        surnameLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(6, 6, 6));
        surnameLabel.setText("Cognome:");

        emailLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(6, 6, 6));
        emailLabel.setText("E-mail:");

        birthdayLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        birthdayLabel.setForeground(new java.awt.Color(6, 6, 6));
        birthdayLabel.setText("Data di Nascita:");

        cityLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        cityLabel.setForeground(new java.awt.Color(6, 6, 6));
        cityLabel.setText("Città:");

        sexLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        sexLabel.setForeground(new java.awt.Color(6, 6, 6));
        sexLabel.setText("Sesso:");

        registerButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        registerButton.setForeground(new java.awt.Color(6, 6, 6));
        registerButton.setText("Registrati!");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        dayComboBox.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        monthComboBox.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        monthComboBox.setForeground(new java.awt.Color(6, 6, 6));
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre" }));

        sexComboBox.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sexComboBox.setForeground(new java.awt.Color(6, 6, 6));
        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));

        nameField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nameField.setForeground(new java.awt.Color(6, 6, 6));

        surnameField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        surnameField.setForeground(new java.awt.Color(6, 6, 6));

        mailField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        mailField.setForeground(new java.awt.Color(0, 0, 0));

        cityField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        cityField.setForeground(new java.awt.Color(6, 6, 6));

        yearComboBox.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        yearComboBox.setForeground(new java.awt.Color(6, 6, 6));
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(calculateYears()));

        nationField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nationField.setForeground(new java.awt.Color(6, 6, 6));

        nationLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nationLabel.setForeground(new java.awt.Color(6, 6, 6));
        nationLabel.setText("Paese:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(nationField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(birthdayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearComboBox, 0, 97, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115))
                                .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(registerButton)
                .addContainerGap())
        );

        credentialsPanel.setBackground(new java.awt.Color(15, 64, 133));

        usernameField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameField.setForeground(new java.awt.Color(6, 6, 6));

        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(254, 254, 254));
        usernameLabel.setText("Username:");

        pswField.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        pswField.setForeground(new java.awt.Color(6, 6, 6));

        pswLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        pswLabel.setForeground(new java.awt.Color(254, 254, 254));
        pswLabel.setText("Password:");

        enterButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        enterButton.setForeground(new java.awt.Color(6, 6, 6));
        enterButton.setText("Accedi!");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        credentialsCheckBox.setBackground(new java.awt.Color(15, 64, 133));
        credentialsCheckBox.setFont(new java.awt.Font("SansSerif", 1, 15));
        credentialsCheckBox.setForeground(new java.awt.Color(254, 254, 254));
        credentialsCheckBox.setText("Salva credenziali");
        credentialsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credentialsCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout credentialsPanelLayout = new javax.swing.GroupLayout(credentialsPanel);
        credentialsPanel.setLayout(credentialsPanelLayout);
        credentialsPanelLayout.setHorizontalGroup(
            credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, credentialsPanelLayout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addGroup(credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(credentialsCheckBox)
                    .addGroup(credentialsPanelLayout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pswLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(enterButton)))
                .addGap(32, 32, 32))
        );
        credentialsPanelLayout.setVerticalGroup(
            credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, credentialsPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(credentialsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton)
                    .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(credentialsCheckBox)
                .addGap(9, 9, 9))
        );

        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo1.png"))); // NOI18N

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/chat.jpg"))); // NOI18N
        imageLabel.setPreferredSize(new java.awt.Dimension(460, 280));

        subtitleLable.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        subtitleLable.setForeground(new java.awt.Color(15, 64, 133));
        subtitleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLable.setText("Condividere non è mai stato cosi divertente!");

        titleLable.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        titleLable.setForeground(new java.awt.Color(238, 162, 30));
        titleLable.setText("Advanced Chat Easy Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(titleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(subtitleLable))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(credentialsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtitleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(credentialsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private String[] calculateYears(){
        
        String[] item = new String[120];
        String a = null;
        int year;
        
        Calendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        for(int index = 0; index < 120 ; index++){
            item[index] = a.valueOf((year - index));
            }
        
        return item;
    }

    private String getRememberme() {
        return rememberme;
    }

    private void setRememberme(String rememberme) {
        this.rememberme = rememberme;
    }

    private int getFlag() {
        return flag;
    }

    public void setConfiguration(String ip,String port) {

        configuration.add(0,"ip");
        configuration.add(1,ip);
        configuration.add(2,"porta");
        configuration.add(3,ip);
    }

    private void initFiles() throws FileNotFoundException, IOException{
        
        ArrayList credentials;
        XML xml = new XML();
        fileOperation fo = new fileOperation();
        
        this.rememberme = "no";
        this.flag = 0;
        configuration = null;
        request = null;
        
        if(fo.getOS().equals("Windows")){
            
            if(fileOperation.exist("ACES\\credentials.xml")){
            
                credentials = xml.readXml("ACES\\credentials.xml");
                setCredentials(credentials);
            }
        }
            
        else{ 
             if(fileOperation.exist("ACES/credentials.xml")){
            
                credentials = xml.readXml("ACES/credentials.xml");
                setCredentials(credentials);
        }
        }
    }

    private void setCredentials(ArrayList credentials){
      
           if(credentials.get(5).toString().equals("si")){

                setRememberme("si");
                usernameField.setText(credentials.get(1).toString());
                pswField.setText(credentials.get(3).toString());
                credentialsCheckBox.setSelected(true);           
        }
    }
    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        
        if(!nameField.getText().equals("") && !surnameField.getText().equals("") && !nationField.getText().equals("") && !cityField.getText().equals("") && !mailField.getText().equals("")){
     
                if(Mail.checkMail(mailField.getText())){ 
                    this.setVisible(false);
                    String year = (String) yearComboBox.getSelectedItem();
                    int month = monthComboBox.getSelectedIndex();
                    String day = (String) dayComboBox.getSelectedItem();
                    String sex = (String) sexComboBox.getSelectedItem();
                    new_user = new User(nameField.getText(),surnameField.getText(),mailField.getText(),year.concat("-"+month).concat("-"+day),cityField.getText(),nationField.getText(),sex,"");
                    new SecondPage(new_user).setVisible(true);
                }      
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loadConfig(){

        XML xml = new XML();
        fileOperation fo = new fileOperation();
        
        if(fo.getOS().equals("Windows")){

            if(fileOperation.exist("ACES\\config.xml"))
                configuration = xml.readXml("ACES\\config.xml");
            else
                createConfig();                      
        }
        else{
            
            if(fileOperation.exist("ACES/config.xml"))              
                configuration = xml.readXml("ACES/config.xml");            
            else               
                createConfig();                         
            }
    }

    private void createConfig(){
        
        configuration = new ArrayList<String>();
        new configDialog(this, rootPaneCheckingEnabled,this).setVisible(true);
    }
    
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        XML xml = new XML();
        fileOperation fo = new fileOperation();
        try {
           
            loadConfig();            
            request = new Requests(configuration.get(1).toString(), configuration.get(3).toString());      
            if(request.logMe(usernameField.getText(),pswField.getText())){
                                                   
               if((getFlag() % 2) != 0){
                          
                   if(fo.getOS().equals("Windows") && fileOperation.exist("ACES\\credentials.xml"))                               
                        xml.writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                   else{                                
                        fo.createFile("ACES\\credentials.xml");
                        xml.writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                       }                                
                   if(!(fo.getOS().equals("Windows")) && fileOperation.exist("ACES/credentials.xml"))                        
                       xml.writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                   else{                                
                       fo.createFile("ACES/credentials.xml");
                       xml.writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                       }                  
                }
               this.dispose();
             }
        }   
        catch (Exception ex){
                        
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi.", "ACES", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_enterButtonActionPerformed
    }
    
    private void credentialsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credentialsCheckBoxActionPerformed

        flag++;
        if(getRememberme().equals("si"))
            setRememberme("no");
        else setRememberme("si");
    }//GEN-LAST:event_credentialsCheckBoxActionPerformed
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new InputForm().setVisible(true);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private Requests request;
    private ArrayList<String> configuration;
    private User new_user;
    private String rememberme; //ci permette di codificare se ricordare al prossimo avvio dell'applicazione le cred-
    private int flag;               //-denziali d'accesso;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JCheckBox credentialsCheckBox;
    private javax.swing.JPanel credentialsPanel;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextField mailField;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nationField;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JPasswordField pswField;
    private javax.swing.JLabel pswLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox sexComboBox;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JLabel subtitleLable;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel titleLable;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

}
