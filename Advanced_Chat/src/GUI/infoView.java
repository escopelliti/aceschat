/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * infoView.java
 *
 * Created on 25-nov-2011, 12.08.01
 */

package GUI;

import Networking.Requests;
import User.User;
import javax.swing.JOptionPane;

/**
 *
 * @author enrico
 */
public class infoView extends javax.swing.JFrame {

    
    public infoView(User user,Requests toModify) {

        initComponents();
        
        flag = false;
        this.user = user;
        this.toModify = toModify;

        setComponent(this.user);
    }

    private void setComponent(User user){

        int index = -1;
        String[] interests;

        Integer level = new Integer(user.getLevel());
        Integer warning = new Integer(user.getWarning());

        modifyLevelField.setText(level.toString());
        modifyWarningField.setText(warning.toString());
        modifyNameField.setText(user.getName());
        modifySurnameField.setText(user.getSurname());
        modifyBirthdayField.setText(user.getBirthday());
        modifyCityField.setText(user.getCity());
        modifyEmailField.setText(user.getEmail());
        modifyJobField.setText(user.getJob());
        modifySexField.setText(user.getSex());
        modifyNationField.setText(user.getNation());
        modifyUsernameField.setText(user.getUsername());

        interests = this.user.getInterests();

        while(index++ < interests.length){
            
            if(interests[index] == null)
                break;

            if(interests[index].equals("sport")){
                sportCheck.setSelected(true);
                continue;
            }

            if(interests[index].equals("tecnologia")){
                techCheck.setSelected(true);
                continue;
            }

            if(interests[index].equals("gossip")){
                gossipCheck.setSelected(true);
                continue;
            }

            if(interests[index].equals("cultura")){
                cultureCheck.setSelected(true);
                continue;
            }

            if(interests[index].equals("politica")){
                politicCheck.setSelected(true);
                continue;
            }

        }

        sportCheck.setEnabled(false);
        techCheck.setEnabled(false);
        politicCheck.setEnabled(false);
        cultureCheck.setEnabled(false);
        gossipCheck.setEnabled(false);

    }

    private void fillUser(){

        this.user.setName(modifyNameField.getText());
        this.user.setSurname(modifySurnameField.getText());
        this.user.setBirthday(modifyBirthdayField.getText());
        this.user.setCity(modifyCityField.getText());
        this.user.setNation(modifyNationField.getText());
        this.user.setEmail(modifyEmailField.getText());
        this.user.setJob(modifyJobField.getText());
        this.user.setSex(modifySexField.getText());
        this.user.setUsername(modifyUsernameField.getText());

        //questo user glielo dobbiamo fare avere alla Home;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        modifyNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modifySurnameField = new javax.swing.JTextField();
        modifySexField = new javax.swing.JTextField();
        modifyCityField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        modifyBirthdayField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        modifyNationField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        modifyJobField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        modifyUsernameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        modifyEmailField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        modifyWarningField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        modifyLevelField = new javax.swing.JTextField();
        modifyButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        sportCheck = new javax.swing.JCheckBox();
        gossipCheck = new javax.swing.JCheckBox();
        techCheck = new javax.swing.JCheckBox();
        cultureCheck = new javax.swing.JCheckBox();
        politicCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel1.setForeground(new java.awt.Color(6, 6, 6));
        jLabel1.setText("Il tuo profilo");

        jPanel1.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel2.setForeground(new java.awt.Color(6, 6, 6));
        jLabel2.setText("Nome:");

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel3.setForeground(new java.awt.Color(6, 6, 6));
        jLabel3.setText("Sesso:");

        modifyNameField.setBackground(new java.awt.Color(254, 254, 254));
        modifyNameField.setEditable(false);
        modifyNameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyNameField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel4.setForeground(new java.awt.Color(6, 6, 6));
        jLabel4.setText("Cognome:");

        modifySurnameField.setBackground(new java.awt.Color(254, 254, 254));
        modifySurnameField.setEditable(false);
        modifySurnameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifySurnameField.setForeground(new java.awt.Color(6, 6, 6));

        modifySexField.setBackground(new java.awt.Color(254, 254, 254));
        modifySexField.setEditable(false);
        modifySexField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifySexField.setForeground(new java.awt.Color(6, 6, 6));

        modifyCityField.setBackground(new java.awt.Color(254, 254, 254));
        modifyCityField.setEditable(false);
        modifyCityField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyCityField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel5.setForeground(new java.awt.Color(6, 6, 6));
        jLabel5.setText("Città:");

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel6.setForeground(new java.awt.Color(6, 6, 6));
        jLabel6.setText("Data di Nascita:");

        modifyBirthdayField.setBackground(new java.awt.Color(254, 254, 254));
        modifyBirthdayField.setEditable(false);
        modifyBirthdayField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyBirthdayField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel7.setBackground(new java.awt.Color(254, 254, 254));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel7.setForeground(new java.awt.Color(6, 6, 6));
        jLabel7.setText("Nazione:");

        modifyNationField.setBackground(new java.awt.Color(254, 254, 254));
        modifyNationField.setEditable(false);
        modifyNationField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyNationField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel8.setBackground(new java.awt.Color(254, 254, 254));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel8.setForeground(new java.awt.Color(6, 6, 6));
        jLabel8.setText("Lavoro:");

        modifyJobField.setBackground(new java.awt.Color(254, 254, 254));
        modifyJobField.setEditable(false);
        modifyJobField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyJobField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel9.setBackground(new java.awt.Color(254, 254, 254));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel9.setForeground(new java.awt.Color(6, 6, 6));
        jLabel9.setText("Username:");

        modifyUsernameField.setBackground(new java.awt.Color(254, 254, 254));
        modifyUsernameField.setEditable(false);
        modifyUsernameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyUsernameField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel10.setBackground(new java.awt.Color(254, 254, 254));
        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel10.setForeground(new java.awt.Color(6, 6, 6));
        jLabel10.setText("Email:");

        modifyEmailField.setBackground(new java.awt.Color(254, 254, 254));
        modifyEmailField.setEditable(false);
        modifyEmailField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyEmailField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel11.setBackground(new java.awt.Color(254, 254, 254));
        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel11.setForeground(new java.awt.Color(6, 6, 6));
        jLabel11.setText("Warning:");

        modifyWarningField.setBackground(new java.awt.Color(254, 254, 254));
        modifyWarningField.setEditable(false);
        modifyWarningField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyWarningField.setForeground(new java.awt.Color(6, 6, 6));

        jLabel12.setBackground(new java.awt.Color(254, 254, 254));
        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel12.setForeground(new java.awt.Color(6, 6, 6));
        jLabel12.setText("Level:");

        modifyLevelField.setBackground(new java.awt.Color(254, 254, 254));
        modifyLevelField.setEditable(false);
        modifyLevelField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyLevelField.setForeground(new java.awt.Color(6, 6, 6));

        modifyButton.setText("Modifica");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel13.setForeground(new java.awt.Color(6, 6, 6));
        jLabel13.setText("I tuoi interessi:");

        sportCheck.setFont(new java.awt.Font("SansSerif", 1, 12));
        sportCheck.setForeground(new java.awt.Color(6, 6, 6));
        sportCheck.setText("Sport");
        sportCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportCheckActionPerformed(evt);
            }
        });

        gossipCheck.setFont(new java.awt.Font("SansSerif", 1, 12));
        gossipCheck.setForeground(new java.awt.Color(6, 6, 6));
        gossipCheck.setText("Gossip");
        gossipCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gossipCheckActionPerformed(evt);
            }
        });

        techCheck.setFont(new java.awt.Font("SansSerif", 1, 12));
        techCheck.setForeground(new java.awt.Color(6, 6, 6));
        techCheck.setText("Tecnologia");
        techCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techCheckActionPerformed(evt);
            }
        });

        cultureCheck.setFont(new java.awt.Font("SansSerif", 1, 12));
        cultureCheck.setForeground(new java.awt.Color(6, 6, 6));
        cultureCheck.setText("Cultura");
        cultureCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureCheckActionPerformed(evt);
            }
        });

        politicCheck.setFont(new java.awt.Font("SansSerif", 1, 12));
        politicCheck.setForeground(new java.awt.Color(6, 6, 6));
        politicCheck.setText("Politica");
        politicCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                politicCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(720, 720, 720))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(modifyUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(modifyWarningField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel12)))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(modifyEmailField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                            .addComponent(modifyLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(modifyJobField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(modifyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(modifySexField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sportCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(techCheck))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(modifyCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(modifySurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(modifyNationField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modifyBirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(modifyButton)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(gossipCheck)
                                            .addGap(12, 12, 12)
                                            .addComponent(cultureCheck)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(politicCheck))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifySexField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifySurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifyBirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(modifyNationField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyJobField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sportCheck)
                    .addComponent(techCheck)
                    .addComponent(gossipCheck)
                    .addComponent(cultureCheck)
                    .addComponent(politicCheck))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyWarningField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(modifyButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed

        modifyNameField.setEditable(true);
        modifySurnameField.setEditable(true);
        modifyBirthdayField.setEditable(true);
        modifyCityField.setEditable(true);
        modifyEmailField.setEditable(true);
        modifyJobField.setEditable(true);
        modifySexField.setEditable(true);
        modifyNationField.setEditable(true);
        modifyUsernameField.setEditable(true);
        sportCheck.setEnabled(true);
        cultureCheck.setEnabled(true);
        techCheck.setEnabled(true);
        gossipCheck.setEnabled(true);
        politicCheck.setEnabled(true);

        modifyButton.setEnabled(false);

        flag = true;
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        if(flag){

            fillUser();

            try{

                toModify.modifyPersonalInfo(this.user);//la risposta sarà gestita dall'opportuno metodo che settrà per la Home
                }                                       //il nuovo user qualora tutto sia andato a buon fine;
            catch(Exception err){

                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }

            this.dispose();                         
        }

        else
            this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void sportCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportCheckActionPerformed
        this.user.setInterests("sport");
}//GEN-LAST:event_sportCheckActionPerformed

    private void gossipCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gossipCheckActionPerformed
        this.user.setInterests("gossip");
    }//GEN-LAST:event_gossipCheckActionPerformed

    private void techCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techCheckActionPerformed
        this.user.setInterests("tecnologia");
    }//GEN-LAST:event_techCheckActionPerformed

    private void cultureCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultureCheckActionPerformed
        this.user.setInterests("musica");
    }//GEN-LAST:event_cultureCheckActionPerformed

    private void politicCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_politicCheckActionPerformed
        this.user.setInterests("politica");
    }//GEN-LAST:event_politicCheckActionPerformed


    
    private boolean flag;
    private User user;
    private Requests toModify;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cultureCheck;
    private javax.swing.JCheckBox gossipCheck;
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
    private javax.swing.JTextField modifyBirthdayField;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField modifyCityField;
    private javax.swing.JTextField modifyEmailField;
    private javax.swing.JTextField modifyJobField;
    private javax.swing.JTextField modifyLevelField;
    private javax.swing.JTextField modifyNameField;
    private javax.swing.JTextField modifyNationField;
    private javax.swing.JTextField modifySexField;
    private javax.swing.JTextField modifySurnameField;
    private javax.swing.JTextField modifyUsernameField;
    private javax.swing.JTextField modifyWarningField;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox politicCheck;
    private javax.swing.JCheckBox sportCheck;
    private javax.swing.JCheckBox techCheck;
    // End of variables declaration//GEN-END:variables

}
