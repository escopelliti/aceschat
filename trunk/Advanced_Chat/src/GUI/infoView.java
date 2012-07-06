package GUI;

import Networking.Requests;
import User.User;
import javax.swing.JOptionPane;

/*
 * Classe per la visualizzazione e la modifica dei dati  personali
 */
public class infoView extends javax.swing.JFrame {
    
    /*costruttore della classe*/
    public infoView(User user,Requests toModify) {

        initComponents();
        initInfoView(user,toModify);
    }

    //inizializzazione dei dati del form
    private void initInfoView(User user,Requests toModify){
        
        flag = false;
        this.user = user;
        this.toModify = toModify;
        setComponent(this.user);
    }
    
    //setta i campi coi dati dell'user
    private void setComponent(User user){

        Integer warning;
        Integer level;

        level = new Integer(user.getLevel());
        warning = new Integer(user.getWarning());
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
        setCheckBoxes(user.getInterests());

    }
    
    //setta gli interessi dell'utente
    private void setCheckBoxes(String[] interests){
        
        int index = -1;
        
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

   //inizializza un user con i nuovi dati modificati presenti nei campi del form
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoViewTitle = new javax.swing.JLabel();
        decoInfoViewPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        sexLabel = new javax.swing.JLabel();
        modifyNameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        modifySurnameField = new javax.swing.JTextField();
        modifySexField = new javax.swing.JTextField();
        modifyCityField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        birthdayLabel = new javax.swing.JLabel();
        modifyBirthdayField = new javax.swing.JTextField();
        nationLabel = new javax.swing.JLabel();
        modifyNationField = new javax.swing.JTextField();
        jobLabel = new javax.swing.JLabel();
        modifyJobField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        modifyUsernameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        modifyEmailField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();
        modifyWarningField = new javax.swing.JTextField();
        levelLabel = new javax.swing.JLabel();
        modifyLevelField = new javax.swing.JTextField();
        modifyButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        interestLabel = new javax.swing.JLabel();
        sportCheck = new javax.swing.JCheckBox();
        gossipCheck = new javax.swing.JCheckBox();
        techCheck = new javax.swing.JCheckBox();
        cultureCheck = new javax.swing.JCheckBox();
        politicCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        infoViewTitle.setBackground(new java.awt.Color(254, 254, 254));
        infoViewTitle.setFont(new java.awt.Font("SansSerif", 1, 18));
        infoViewTitle.setForeground(new java.awt.Color(6, 6, 6));
        infoViewTitle.setText("Il tuo profilo");

        decoInfoViewPanel.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout decoInfoViewPanelLayout = new javax.swing.GroupLayout(decoInfoViewPanel);
        decoInfoViewPanel.setLayout(decoInfoViewPanelLayout);
        decoInfoViewPanelLayout.setHorizontalGroup(
            decoInfoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        decoInfoViewPanelLayout.setVerticalGroup(
            decoInfoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        nameLabel.setBackground(new java.awt.Color(254, 254, 254));
        nameLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        nameLabel.setForeground(new java.awt.Color(6, 6, 6));
        nameLabel.setText("Nome:");

        sexLabel.setBackground(new java.awt.Color(254, 254, 254));
        sexLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        sexLabel.setForeground(new java.awt.Color(6, 6, 6));
        sexLabel.setText("Sesso:");

        modifyNameField.setBackground(new java.awt.Color(254, 254, 254));
        modifyNameField.setEditable(false);
        modifyNameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyNameField.setForeground(new java.awt.Color(6, 6, 6));

        surnameLabel.setBackground(new java.awt.Color(254, 254, 254));
        surnameLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        surnameLabel.setForeground(new java.awt.Color(6, 6, 6));
        surnameLabel.setText("Cognome:");

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

        cityLabel.setBackground(new java.awt.Color(254, 254, 254));
        cityLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        cityLabel.setForeground(new java.awt.Color(6, 6, 6));
        cityLabel.setText("Città:");

        birthdayLabel.setBackground(new java.awt.Color(254, 254, 254));
        birthdayLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        birthdayLabel.setForeground(new java.awt.Color(6, 6, 6));
        birthdayLabel.setText("Data di Nascita:");

        modifyBirthdayField.setBackground(new java.awt.Color(254, 254, 254));
        modifyBirthdayField.setEditable(false);
        modifyBirthdayField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyBirthdayField.setForeground(new java.awt.Color(6, 6, 6));

        nationLabel.setBackground(new java.awt.Color(254, 254, 254));
        nationLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        nationLabel.setForeground(new java.awt.Color(6, 6, 6));
        nationLabel.setText("Nazione:");

        modifyNationField.setBackground(new java.awt.Color(254, 254, 254));
        modifyNationField.setEditable(false);
        modifyNationField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyNationField.setForeground(new java.awt.Color(6, 6, 6));

        jobLabel.setBackground(new java.awt.Color(254, 254, 254));
        jobLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        jobLabel.setForeground(new java.awt.Color(6, 6, 6));
        jobLabel.setText("Lavoro:");

        modifyJobField.setBackground(new java.awt.Color(254, 254, 254));
        modifyJobField.setEditable(false);
        modifyJobField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyJobField.setForeground(new java.awt.Color(6, 6, 6));

        usernameLabel.setBackground(new java.awt.Color(254, 254, 254));
        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        usernameLabel.setForeground(new java.awt.Color(6, 6, 6));
        usernameLabel.setText("Username:");

        modifyUsernameField.setBackground(new java.awt.Color(254, 254, 254));
        modifyUsernameField.setEditable(false);
        modifyUsernameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyUsernameField.setForeground(new java.awt.Color(6, 6, 6));

        emailLabel.setBackground(new java.awt.Color(254, 254, 254));
        emailLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        emailLabel.setForeground(new java.awt.Color(6, 6, 6));
        emailLabel.setText("Email:");

        modifyEmailField.setBackground(new java.awt.Color(254, 254, 254));
        modifyEmailField.setEditable(false);
        modifyEmailField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyEmailField.setForeground(new java.awt.Color(6, 6, 6));

        warningLabel.setBackground(new java.awt.Color(254, 254, 254));
        warningLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        warningLabel.setForeground(new java.awt.Color(6, 6, 6));
        warningLabel.setText("Warning:");

        modifyWarningField.setBackground(new java.awt.Color(254, 254, 254));
        modifyWarningField.setEditable(false);
        modifyWarningField.setFont(new java.awt.Font("SansSerif", 1, 12));
        modifyWarningField.setForeground(new java.awt.Color(6, 6, 6));

        levelLabel.setBackground(new java.awt.Color(254, 254, 254));
        levelLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        levelLabel.setForeground(new java.awt.Color(6, 6, 6));
        levelLabel.setText("Level:");

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

        interestLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        interestLabel.setForeground(new java.awt.Color(6, 6, 6));
        interestLabel.setText("I tuoi interessi:");

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
                        .addComponent(infoViewTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usernameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(warningLabel)
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
                                                .addComponent(levelLabel)))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(modifyEmailField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                            .addComponent(modifyLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(modifyJobField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(interestLabel))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(modifyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(sexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(modifySexField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                            .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(birthdayLabel))
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
            .addComponent(decoInfoViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(decoInfoViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(infoViewTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifySexField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifySurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(nationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifyBirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(modifyNationField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyJobField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sportCheck)
                    .addComponent(techCheck)
                    .addComponent(gossipCheck)
                    .addComponent(cultureCheck)
                    .addComponent(politicCheck))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyWarningField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton)
                    .addComponent(modifyButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //il metodo mi permette di rendere accassibili emodificabili i campi, per poter inseerire i nuovi dati
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

    
    // inviare le modifiche al dei dati personali al server
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        if(flag){

            //crea l'utente con i nuovi dati da mandare al server
            fillUser();
            
            //prova a mandare i nuovi dati
            try{

                toModify.modifyPersonalInfo(this.user);
            }
            
            catch(Exception err){

                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }                              
        }
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
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JCheckBox cultureCheck;
    private javax.swing.JPanel decoInfoViewPanel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JCheckBox gossipCheck;
    private javax.swing.JLabel infoViewTitle;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel levelLabel;
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
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox politicCheck;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JCheckBox sportCheck;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JCheckBox techCheck;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables

}
