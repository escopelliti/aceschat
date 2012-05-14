/*
 * Home.java
 *
 * Created on 5-ott-2011, 22.29.26
 */

package GUI;


import fileManager.fileOperation;
import Feed.Feed;
import Feed.FeedMessage;
import Feed.RSSFeedParser;
import Networking.ChatSession;
import Networking.ClientFetching;
import Networking.Requests;
import User.User;
import XML.createXml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;





/**
 *
 * @author enrico
 *
 * //        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice cc = ge.getDefaultScreenDevice();
//        setVisible(true);
//        cc.setFullScreenWindow(this);
 *
 *
 */
public class Home extends javax.swing.JFrame implements Runnable{

    //inizializziamo nel costruttore i componenti del form/frame;
    public Home(Requests toCon,User logged) throws IOException {
        
        initComponents();

        this.toCon = toCon;
        support = toCon;
        loggedUser = logged;
        this.newSession = new ChatSession(loggedUser,toCon);
        icon = new ImageIcon("/home/enrico/Scrivania/stellina.png", null);
        setMap();

        new ClientFetching(this.toCon,this,newSession).start();

        setUpdate();

        up = new Thread(this);
        up.start();


    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        FeedPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TitleFieldPanel = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        FeedView = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        userImageLabel = new javax.swing.JLabel();
        LevelPanel = new javax.swing.JPanel();
        firstStarLabel = new javax.swing.JLabel();
        secondStarLabel = new javax.swing.JLabel();
        thirdStarLabel = new javax.swing.JLabel();
        infoView = new javax.swing.JButton();
        UsernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        photoLoadButton = new javax.swing.JButton();
        DecorationFunctionPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        multichatList = new javax.swing.JTextPane();
        contactMultiUsers = new javax.swing.JButton();
        addtoMultiChat = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        friendtoAdd = new javax.swing.JTextField();
        addFriendButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        emailToInvite = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        DecorationFunctionPanel2 = new javax.swing.JPanel();
        inviteButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userHistoryField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        historyTextArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        friendImageLabel = new javax.swing.JLabel();
        contactButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        friendLevel = new javax.swing.JTextField();
        friendUsername = new javax.swing.JTextField();
        friendEmail = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        disconnectMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TitleFieldPanel.setBackground(new java.awt.Color(15, 64, 133));
        TitleFieldPanel.setEditable(false);
        TitleFieldPanel.setFont(new java.awt.Font("SansSerif", 1, 22));
        TitleFieldPanel.setForeground(new java.awt.Color(254, 254, 254));
        TitleFieldPanel.setText("          LE NEWS CHE TI INTERESSANO");
        jScrollPane2.setViewportView(TitleFieldPanel);

        FeedView.setEditable(false);
        FeedView.setFont(new java.awt.Font("SansSerif", 1, 15));
        jScrollPane4.setViewportView(FeedView);

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        FeedPanelLayout.setVerticalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        );

        userImageLabel.setBackground(new java.awt.Color(212, 165, 122));
        userImageLabel.setForeground(new java.awt.Color(212, 165, 122));
        userImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        LevelPanel.setBackground(new java.awt.Color(245, 211, 151));

        firstStarLabel.setBackground(new java.awt.Color(254, 241, 240));

        secondStarLabel.setBackground(new java.awt.Color(254, 241, 240));

        thirdStarLabel.setBackground(new java.awt.Color(254, 241, 240));

        javax.swing.GroupLayout LevelPanelLayout = new javax.swing.GroupLayout(LevelPanel);
        LevelPanel.setLayout(LevelPanelLayout);
        LevelPanelLayout.setHorizontalGroup(
            LevelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LevelPanelLayout.createSequentialGroup()
                .addComponent(firstStarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondStarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thirdStarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        LevelPanelLayout.setVerticalGroup(
            LevelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LevelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(firstStarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(secondStarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(thirdStarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        infoView.setFont(new java.awt.Font("SansSerif", 1, 8));
        infoView.setText("Visualizza le tue informazioni personali");
        infoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoViewActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        UsernameLabel.setForeground(new java.awt.Color(6, 6, 6));
        UsernameLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        emailLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jPanel1.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        photoLoadButton.setText("Carica una foto");
        photoLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoLoadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LevelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(infoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(photoLoadButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LevelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(infoView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photoLoadButton))
                    .addComponent(userImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );

        DecorationFunctionPanel1.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout DecorationFunctionPanel1Layout = new javax.swing.GroupLayout(DecorationFunctionPanel1);
        DecorationFunctionPanel1.setLayout(DecorationFunctionPanel1Layout);
        DecorationFunctionPanel1Layout.setHorizontalGroup(
            DecorationFunctionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        DecorationFunctionPanel1Layout.setVerticalGroup(
            DecorationFunctionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 1, 13));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo2.png"))); // NOI18N

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("SansSerif", 1, 14));
        jTextPane1.setText("\n\n\n\n\nScopri tutte le funzionalità di \"ACES \".\n\nCon l'utilizzo della barra soprastante potrai accedere a tutti i servizi.");
        jScrollPane7.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pagina iniziale", jPanel3);

        friendList.setFont(new java.awt.Font("SansSerif", 1, 18));
        friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendListMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(friendList);

        jScrollPane9.setViewportView(multichatList);

        contactMultiUsers.setText("Contatta");

        addtoMultiChat.setText("Aggiungi");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(addtoMultiChat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactMultiUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(237, 237, 237))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactMultiUsers))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(addtoMultiChat)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crea una ChatRoom", jPanel7);

        addFriendButton.setText("Aggiungi");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("SansSerif", 1, 18));
        jTextField2.setForeground(new java.awt.Color(6, 6, 6));
        jTextField2.setText("Aggiungi una persona all'elenco dei tuoi contatti.");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("SansSerif", 1, 12));
        jTextField3.setForeground(new java.awt.Color(6, 6, 6));
        jTextField3.setText("Username dell'utente da inserire:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/ACES.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addFriendButton)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendtoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(friendtoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addComponent(addFriendButton)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aggiungi un amico", jPanel9);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 1, 18));
        jTextArea1.setForeground(new java.awt.Color(6, 6, 6));
        jTextArea1.setRows(5);
        jTextArea1.setText("Riempiendo il campo sottostante potrai invitare i tuoi amici ad usare ACES.\nCon ACES puoi sempre rimanere in contatto con le persone a te più care.\nInvita tutti i tuoi amici per poter far crescere la comunity ACES.");
        jScrollPane6.setViewportView(jTextArea1);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 15));
        jTextField1.setForeground(new java.awt.Color(6, 6, 6));
        jTextField1.setText("Indirizzo Email a cui mandare l'invito:");

        emailToInvite.setFont(new java.awt.Font("SansSerif", 1, 15));
        emailToInvite.setForeground(new java.awt.Color(6, 6, 6));

        jPanel14.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        DecorationFunctionPanel2.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout DecorationFunctionPanel2Layout = new javax.swing.GroupLayout(DecorationFunctionPanel2);
        DecorationFunctionPanel2.setLayout(DecorationFunctionPanel2Layout);
        DecorationFunctionPanel2Layout.setHorizontalGroup(
            DecorationFunctionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        DecorationFunctionPanel2Layout.setVerticalGroup(
            DecorationFunctionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        inviteButton.setText("Invita");
        inviteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailToInvite, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(inviteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecorationFunctionPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inviteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailToInvite)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(DecorationFunctionPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Invita un amico", jPanel10);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel4.setForeground(new java.awt.Color(15, 64, 133));
        jLabel4.setText("Visualizza le tue conversazioni passate.");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabel6.setForeground(new java.awt.Color(15, 64, 133));
        jLabel6.setText("Inserisci l'username:");

        searchButton.setText("Cerca");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        historyTextArea.setColumns(20);
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new java.awt.Font("SansSerif", 1, 15));
        historyTextArea.setForeground(new java.awt.Color(15, 64, 133));
        historyTextArea.setRows(5);
        jScrollPane5.setViewportView(historyTextArea);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(userHistoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userHistoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cronologia", jPanel11);

        contactList.setFont(new java.awt.Font("SansSerif", 1, 18));
        contactList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(contactList);

        friendImageLabel.setBackground(new java.awt.Color(255, 255, 255));
        friendImageLabel.setText("image");
        friendImageLabel.setEnabled(false);

        contactButton.setText("Contatta");
        contactButton.setEnabled(false);
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Livello:");

        friendLevel.setEditable(false);
        friendLevel.setFont(new java.awt.Font("SansSerif", 1, 12));
        friendLevel.setForeground(new java.awt.Color(6, 6, 6));
        friendLevel.setEnabled(false);

        friendUsername.setEditable(false);
        friendUsername.setFont(new java.awt.Font("SansSerif", 1, 12));
        friendUsername.setForeground(new java.awt.Color(6, 6, 6));
        friendUsername.setEnabled(false);

        friendEmail.setEditable(false);
        friendEmail.setFont(new java.awt.Font("SansSerif", 1, 12));
        friendEmail.setForeground(new java.awt.Color(6, 6, 6));
        friendEmail.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(friendImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addGap(136, 136, 136))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friendLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(friendUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(327, 327, 327))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(friendImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(friendUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friendLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(contactButton)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Amici", jPanel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(670, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cerca", jPanel5);

        jPanel13.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        menuBar.setBackground(new java.awt.Color(6, 6, 6));
        menuBar.setForeground(new java.awt.Color(251, 250, 247));

        fileMenu.setForeground(new java.awt.Color(254, 253, 250));
        fileMenu.setText("File");

        disconnectMenuItem.setText("Disconnetti");
        disconnectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(disconnectMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setForeground(new java.awt.Color(254, 253, 250));
        editMenu.setText("Edit");

        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setForeground(new java.awt.Color(254, 253, 250));
        helpMenu.setText("Help");

        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, 0, 0, Short.MAX_VALUE)
            .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecorationFunctionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUser(User n_user){

        loggedUser = n_user;
    }

    //dal menu File --> Exit : permette di uscire dal software;
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

public void run(){

    while(true){

        try{

            up.sleep(5000);
            setUpdate();
        }
        catch(InterruptedException ex){

            new userDialog("Problemi tecnici. Ci scusiamo per l'inconveniente.").setVisible(true);
            System.out.println(ex.getMessage());
        }
        catch(IOException ex_){
            
            new userDialog("Problemi tecnici. Ci scusiamo per l'inconveniente.").setVisible(true);
            System.out.println(ex_.getMessage());
        }
    
     }
    }
 
    private void infoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoViewActionPerformed
        
        new infoView(this.loggedUser,this.toCon).setVisible(true);

    }//GEN-LAST:event_infoViewActionPerformed

    private void setMap(){
        
        map.put("sport", sport);
        map.put("cultura",culture);
        map.put("tecnologia",tech);
        map.put("Nessuno",nothing);
        map.put("politica",politic);
        map.put("gossip", gossip);
        
    }

    public User getUser(){
        
        return this.loggedUser;
    }
    
    private void setUpdate() throws IOException{

        UsernameLabel.setText(loggedUser.getUsername());
        emailLabel.setText(loggedUser.getEmail());
        FeedView.setText(viewFeed());
        userImageLabel.setIcon(loggedUser.getPersonalImage());
        this.toCon.getFriends(this.loggedUser.getIdPerson());
        this.toCon.getMess(this.loggedUser.getUsername());
        switch(loggedUser.getLevel()){
        
            case 1: firstStarLabel.setIcon(icon); break;
            case 2: firstStarLabel.setIcon(icon); secondStarLabel.setIcon(icon); break;
            case 3: firstStarLabel.setIcon(icon); secondStarLabel.setIcon(icon); thirdStarLabel.setIcon(icon); break;
        }

    }

    
    public void setContactList(Vector friendList){
        
        contactList.setListData(friendList);
        
    }
    
   
    private void contactListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactListMouseClicked

        //visualizziamo solo la lista delle stringhe degli amici del client, se c'è una richiesta
        //particolare allora facciamo vedere le informazioni personali dell'amico;la richiesta particolare
        //avviene quando clicchiamo su un elemento della lista;
        //metodo uguale al cerca amico che mi restituisce le info personali dell'utente preciso;
        friendEmail.setEnabled(true);
        friendUsername.setEnabled(true);
        friendImageLabel.setEnabled(true);
        friendLevel.setEnabled(true);
        contactButton.setEnabled(true);
        friendUsername.setText(contactList.getSelectedValue().toString());
        //metodo che mi setta le informazioni che voglio;
        
        

    }//GEN-LAST:event_contactListMouseClicked

    //crea una nuova istanza di Message per iniziare una conversazione e "genera" un file xml col nome del client seleziona-
    //-to dall'utente e da conttatare;
    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed

        if(!contactList.isSelectionEmpty()){
            
//        Message conv;
            try {
            //instauriamo un oggetto ChatSession e gli passiamo l'user cosi evitiamo static User;
//            conv = new Message(loggedUser,contactList.getSelectedValue().toString(),toCon);
//            conv.setVisible(true);
                newSession.start(contactList.getSelectedValue().toString());
//            newSession.setConvList(contactList.getSelectedValue().toString(), conv);
                createXml.genXml("ACES/History/".concat(contactList.getSelectedValue().toString().concat(".xml")));

            } catch (FileNotFoundException ex) {
            
                new userDialog("Problema nella generazione della cronologia. Ci scusiamo per l'inconveniente.").setVisible(true);
            
            } catch (IOException ex) {
            
                new userDialog("Ci sono problemi tecnici. Ci scusiamo per l'inconveniente.").setVisible(true);
            }
            }
    }//GEN-LAST:event_contactButtonActionPerformed

    private void disconnectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectMenuItemActionPerformed
        try {
            toCon.logout(loggedUser.getIdPerson());
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        new InputForm().setVisible(true);
    }//GEN-LAST:event_disconnectMenuItemActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if(!userHistoryField.getText().equals("")){

            int index = 0;
            if(fileOperation.exist("ACES/History/"+userHistoryField.getText()+".xml")){
                ArrayList conversation = createXml.readXml("ACES/History/" + userHistoryField.getText()+".xml");

                while( index < conversation.size()){

                    historyTextArea.append(conversation.get(index).toString()+"\n");
                    if(index != 0 && (index+1) % 3 == 0)
                        historyTextArea.append("\n");
                    index++;
                }
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void photoLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoLoadButtonActionPerformed

        new fileChooser(this.loggedUser,userImageLabel,toCon,1).setVisible(true);
    }//GEN-LAST:event_photoLoadButtonActionPerformed

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed

        if(!friendtoAdd.getText().equals("")){
            try{

                toCon.addFriend(friendtoAdd.getText(),loggedUser.getIdPerson());

            }
            catch(IOException ex){

                new userDialog("Ci sono problemi tecnici.\nCi scusiamo per l'inconveniente.").setVisible(true);
            }
        }


    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void inviteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviteButtonActionPerformed

        if(!emailToInvite.getText().equals(""))
            try{
                toCon.sendMail(loggedUser.getUsername(),emailToInvite.getText());
            }
            catch(IOException ex){

                new userDialog("Ci sono problemi tecnici.\nRiprova più tardi").setVisible(true);
            }
    }//GEN-LAST:event_inviteButtonActionPerformed

    private void friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_friendListMouseClicked

    
//    public void setImage(Object imageFile) throws IOException{
//        
//        File image;
//        
//        image = (File) imageFile;
//        ImageIcon loadedImage = fileOperation.loadImage(image);
//        userImageLabel.setIcon(loadedImage);
//        
//    }

    private String viewFeed(){

                boolean flag = true;
                String x = "";
                int a = 0;
                Random ran = new Random();
                String[] interests;
                interests = loggedUser.getInterests();

                while(flag){

                    a = ran.nextInt(6);
                    if(interests[a] == null)
                        continue;
                    else
                        flag = false;
                }

                try{

                RSSFeedParser parser = new RSSFeedParser(map.get(interests[a]).toString());
		Feed feed = parser.readFeed();
                for(FeedMessage message : feed.getMessages())
		x = x.concat((message.getTitle()+"\n\n"));
                }
                catch(Exception ex){
                    new userDialog("Impossibile caricare i Feed.\n\nErrore riscontrato:\n".concat(ex.getMessage())).setVisible(true);
                }
                return x;
    }

    private ChatSession newSession;
    private final String tech = "http://www.repubblica.it/rss/tecnologia/rss2.0.xml";
    private final String culture = "http://rss.feedsportal.com/c/32275/f/438644/index.rss";
    private final String politic = "http://www.repubblica.it/rss/politica/rss2.0.xml";
    private final String gossip = "http://rss.feedsportal.com/c/625/f/8192/index.rss";
    private final String sport = "http://www.repubblica.it/rss/sport/rss2.0.xml";
    private final String nothing = "http://rss.feedsportal.com/c/32275/f/438637/index.rss";
    private HashMap map = new HashMap();
    private Icon icon;
    private Thread up;
    private static User loggedUser;
    private  Requests toCon;
    private static Requests support;

//componenti swing instanziati sopra del form/frame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecorationFunctionPanel1;
    private javax.swing.JPanel DecorationFunctionPanel2;
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JTextPane FeedView;
    private javax.swing.JPanel LevelPanel;
    private javax.swing.JTextPane TitleFieldPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addFriendButton;
    private javax.swing.JButton addtoMultiChat;
    private javax.swing.JButton contactButton;
    private javax.swing.JList contactList;
    private javax.swing.JButton contactMultiUsers;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenuItem disconnectMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailToInvite;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel firstStarLabel;
    private javax.swing.JTextField friendEmail;
    private javax.swing.JLabel friendImageLabel;
    private javax.swing.JTextField friendLevel;
    private javax.swing.JList friendList;
    private javax.swing.JTextField friendUsername;
    private javax.swing.JTextField friendtoAdd;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JTextArea historyTextArea;
    private javax.swing.JButton infoView;
    private javax.swing.JButton inviteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextPane multichatList;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JButton photoLoadButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel secondStarLabel;
    private javax.swing.JLabel thirdStarLabel;
    private javax.swing.JTextField userHistoryField;
    private javax.swing.JLabel userImageLabel;
    // End of variables declaration//GEN-END:variables

}
