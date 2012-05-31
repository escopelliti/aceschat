/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputForm.java
 *
 * Created on 4-ott-2011, 23.41.50
 */

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



/**
 *
 * @author enrico
 */
public class InputForm extends javax.swing.JFrame {

    /** inizializza i componenti swing che fanno parte del Frame/form */
    public InputForm() throws FileNotFoundException, IOException {

        initComponents();
        init();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pswField = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        enterButton = new javax.swing.JButton();
        credentialsCheckBox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(238, 162, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel1.setForeground(new java.awt.Color(6, 6, 6));
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel2.setForeground(new java.awt.Color(6, 6, 6));
        jLabel2.setText("Cognome:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel3.setForeground(new java.awt.Color(6, 6, 6));
        jLabel3.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel4.setForeground(new java.awt.Color(6, 6, 6));
        jLabel4.setText("Data di Nascita:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel5.setForeground(new java.awt.Color(6, 6, 6));
        jLabel5.setText("Città:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel6.setForeground(new java.awt.Color(6, 6, 6));
        jLabel6.setText("Sesso:");

        registerButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        registerButton.setForeground(new java.awt.Color(6, 6, 6));
        registerButton.setText("Registrati!");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre" }));

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));

        nameField.setFont(new java.awt.Font("SansSerif", 1, 15));
        nameField.setForeground(new java.awt.Color(0, 0, 0));

        surnameField.setFont(new java.awt.Font("SansSerif", 1, 15));
        surnameField.setForeground(new java.awt.Color(0, 0, 0));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(calculateYears()));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel13.setForeground(new java.awt.Color(6, 6, 6));
        jLabel13.setText("Paese:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(nationField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearComboBox, 0, 86, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115))
                                .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(registerButton)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(15, 64, 133));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Username:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Password:");

        enterButton.setFont(new java.awt.Font("SansSerif", 1, 15));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(credentialsCheckBox)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(enterButton)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton)
                    .addComponent(pswField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(credentialsCheckBox)
                .addGap(9, 9, 9))
        );

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo1.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/chat.jpg"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(460, 280));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 25));
        jLabel11.setForeground(new java.awt.Color(15, 64, 133));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Condividere non è mai stato cosi divertente!");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 36));
        jLabel12.setForeground(new java.awt.Color(238, 162, 30));
        jLabel12.setText("Advanced Chat Easy Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo per creare una lista di item da passare alla checkbox che permette la scelta dell'anno di nascita;
    private String[] calculateYears(){
        
        String[] item = new String[100];
        String a = null;
        int year;
        
        Calendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        for(int index = 0; index < 100 ; index++){
            item[index] = a.valueOf((year - index));
            }
        
        return item;
    }

    public String getRememberme() {
        return rememberme;
    }

    public void setRememberme(String rememberme) {
        this.rememberme = rememberme;
    }

    public int getFlag() {
        return flag;
    }

    public static ArrayList getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(String ip,String port) {

        configuration.add(0,"ip");
        configuration.add(1,ip);
        configuration.add(2,"porta");
        configuration.add(3,ip);
    }


    private void init() throws FileNotFoundException, IOException{

       
        ArrayList credentials;
        XML xml = new XML();
        fileOperation fo = new fileOperation();
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
    
    //entriamo nella seconda pagina di registrazione;i dati vanno controllati per eventuale bloccare gia qui se ci sono err-
    //-rori di qualche genere;vanno implementati metodi per il network e controlli su campi vuoi e/o sulla correttezza di que-
    //-sti ultimi;

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        
        if(!nameField.getText().equals("") && !surnameField.getText().equals("") && !nationField.getText().equals("") && !cityField.getText().equals("") && !mailField.getText().equals("")){

                //per ora controlla solo che abbia il formato giusto  
                if(Mail.checkMail(mailField.getText())){ //correggere
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
                
            
            else{

                configuration = new ArrayList<String>();
                new configDialog(this, rootPaneCheckingEnabled).setVisible(true);
                
            }
        }
        else{

            if(fileOperation.exist("ACES/config.xml"))
                
                configuration = xml.readXml("ACES/config.xml");
            
            else{
                
                configuration = new ArrayList<String>();
                new configDialog(this, rootPaneCheckingEnabled).setVisible(true);
                
            }
            }

    }


    //azioni da intraprendere quando entri nell'applicazione;ovviamente va IMPLEMENTATO un metodo  con network per loggarsi;
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        XML xml = new XML();
        fileOperation fo = new fileOperation();
        try {
           
            loadConfig(); //carica la configurazione per connettersi dal file XML e se esso non esiste richiede i parametri
                            //che servono per la connessione e crea il file XML; al prossimo avvio non lo richiederà più            
            request = new Requests(configuration.get(1).toString(), configuration.get(3).toString());      
            if(!usernameField.getText().equals("") && !pswField.getText().equals("")){
               
                    if(request.logMe(usernameField.getText(),pswField.getText())){
                    
                        this.setVisible(false);          
                        if((getFlag() % 2) != 0){

                            if(fo.getOS().equals("Windows") && fileOperation.exist("ACES\\credentials.xml"))

                                xml.writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                            else{
                                
                                fo.createDirectory("ACES\\credentials.xml");
                                xml.writeXml("ACES\\credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                            }
                                
                            if(!(fo.getOS().equals("Windows")) && fileOperation.exist("ACES/credentials.xml")) 
                                xml.writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                            else{
                                
                                fo.createDirectory("ACES/credentials.xml");
                                xml.writeXml("ACES/credentials.xml", usernameField.getText(), pswField.getText(), getRememberme());
                            }
                        }
                    }
                    }
        }
                    catch (Exception ex){
                        
                        JOptionPane.showMessageDialog(null, ex.toString(), "ACES", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_enterButtonActionPerformed
    }
    



    //stesso discorso fatto per salvacredenziali in SecondPage ma con l'aggiunta del flag per capire se è stato modificato
    //questo campo rispetto al file xml;
    private void credentialsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credentialsCheckBoxActionPerformed

        flag++;
        if(getRememberme().equals("si"))
            setRememberme("no");
        else setRememberme("si");

    }//GEN-LAST:event_credentialsCheckBoxActionPerformed
        



//da qui parte l'applicazione;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new InputForm().setVisible(true);
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    private Requests request = null;
    private static ArrayList<String> configuration = null;
    private User new_user;
    private String rememberme = "no"; //ci permette di codificare se ricordare al prossimo avvio dell'applicazione le cred-
    private int flag = 0;               //-denziali d'accesso;

    //Componenti swing del form/frame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JCheckBox credentialsCheckBox;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mailField;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nationField;
    private javax.swing.JPasswordField pswField;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox sexComboBox;
    private javax.swing.JTextField surnameField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

}
