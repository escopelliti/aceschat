package GUI;


import fileManager.fileOperation;
import Feed.Feed;
import Feed.FeedMessage;
import Feed.RSSFeedParser;
import Networking.ChatSession;
import Networking.ClientFetching;
import Networking.Requests;
import User.User;
import XML.XML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame implements Runnable{

    public Home(Requests toCon,User logged) throws IOException {
        
        initComponents();
        init(toCon,logged);      
        setMap();
        new ClientFetching(this.toCon,this,newSession).start();
        setUpdate();
        up = new Thread(this);
        up.start();


    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FeedPanel = new javax.swing.JPanel();
        decoScroll = new javax.swing.JScrollPane();
        decorationFeedPanel = new javax.swing.JTextPane();
        FeedScroll = new javax.swing.JScrollPane();
        FeedView = new javax.swing.JTextPane();
        infoPanel = new javax.swing.JPanel();
        userImageLabel = new javax.swing.JLabel();
        LevelPanel = new javax.swing.JPanel();
        firstStarLabel = new javax.swing.JLabel();
        secondStarLabel = new javax.swing.JLabel();
        thirdStarLabel = new javax.swing.JLabel();
        infoView = new javax.swing.JButton();
        UsernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        decorationInfoPanel = new javax.swing.JPanel();
        photoLoadButton = new javax.swing.JButton();
        DecorationFunctionPanel = new javax.swing.JPanel();
        TabPanel = new javax.swing.JTabbedPane();
        firstTabPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        infoTextScroll = new javax.swing.JScrollPane();
        infoText = new javax.swing.JTextPane();
        friendTabPanel = new javax.swing.JPanel();
        contactListScroll = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        contactButton = new javax.swing.JButton();
        nLoginField = new javax.swing.JTextField();
        nFriendsField = new javax.swing.JTextField();
        nMessField = new javax.swing.JTextField();
        dateTimeField = new javax.swing.JTextField();
        friendsLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        messLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        statisticButton = new javax.swing.JButton();
        chatroomTabPanel = new javax.swing.JPanel();
        friendListScroll = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList();
        contactMultiUsers = new javax.swing.JButton();
        addtoMultiChat = new javax.swing.JButton();
        multiChatScroll = new javax.swing.JScrollPane();
        multichatList = new javax.swing.JTextArea();
        textAreaInfoScroll = new javax.swing.JScrollPane();
        textAreaInfo = new javax.swing.JTextArea();
        addTabPanel = new javax.swing.JPanel();
        friendtoAdd = new javax.swing.JTextField();
        addFriendButton = new javax.swing.JButton();
        addFriendTitle = new javax.swing.JTextField();
        toAddLabel = new javax.swing.JTextField();
        logoLabel1 = new javax.swing.JLabel();
        inviteTabPanel = new javax.swing.JPanel();
        inviteTextScroll = new javax.swing.JScrollPane();
        inviteTextArea = new javax.swing.JTextArea();
        emailInviteLabel = new javax.swing.JTextField();
        emailToInvite = new javax.swing.JTextField();
        decoInvitePanel = new javax.swing.JPanel();
        DecoInvitePanel1 = new javax.swing.JPanel();
        inviteButton = new javax.swing.JButton();
        chronoTabPanel = new javax.swing.JPanel();
        infoChronoLabel = new javax.swing.JLabel();
        usernameChronoLabel = new javax.swing.JLabel();
        userHistoryField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        historyScroll = new javax.swing.JScrollPane();
        historyTextArea = new javax.swing.JTextArea();
        searchTabPanel = new javax.swing.JPanel();
        logoLabel2 = new javax.swing.JLabel();
        searchFriendButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        usernameSearchLabel = new javax.swing.JLabel();
        imageFriendLabel = new javax.swing.JLabel();
        usernameFriendLabel = new javax.swing.JLabel();
        nameFriendLabel = new javax.swing.JLabel();
        surnameFriendLabel = new javax.swing.JLabel();
        cityFriendLabel = new javax.swing.JLabel();
        emailFriendLabel = new javax.swing.JLabel();
        levelFriendLabel = new javax.swing.JLabel();
        usertoSearch = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        usernameFriendField = new javax.swing.JTextField();
        levelField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        decoHomePanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        disconnectMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Home - ACES");
        setResizable(false);

        decorationFeedPanel.setBackground(new java.awt.Color(15, 64, 133));
        decorationFeedPanel.setEditable(false);
        decorationFeedPanel.setFont(new java.awt.Font("SansSerif", 1, 22));
        decorationFeedPanel.setForeground(new java.awt.Color(254, 254, 254));
        decorationFeedPanel.setText("          LE NEWS CHE TI INTERESSANO");
        decoScroll.setViewportView(decorationFeedPanel);

        FeedView.setEditable(false);
        FeedView.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        FeedView.setForeground(new java.awt.Color(6, 6, 6));
        FeedScroll.setViewportView(FeedView);

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(decoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addComponent(FeedScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        FeedPanelLayout.setVerticalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addComponent(decoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FeedScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
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

        infoView.setFont(new java.awt.Font("SansSerif", 1, 8)); // NOI18N
        infoView.setForeground(new java.awt.Color(6, 6, 6));
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

        decorationInfoPanel.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout decorationInfoPanelLayout = new javax.swing.GroupLayout(decorationInfoPanel);
        decorationInfoPanel.setLayout(decorationInfoPanelLayout);
        decorationInfoPanelLayout.setHorizontalGroup(
            decorationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        decorationInfoPanelLayout.setVerticalGroup(
            decorationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        photoLoadButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        photoLoadButton.setForeground(new java.awt.Color(6, 6, 6));
        photoLoadButton.setText("Carica una foto");
        photoLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoLoadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decorationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LevelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(infoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(photoLoadButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(decorationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LevelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(infoView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photoLoadButton))
                    .addComponent(userImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap())
        );

        DecorationFunctionPanel.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout DecorationFunctionPanelLayout = new javax.swing.GroupLayout(DecorationFunctionPanel);
        DecorationFunctionPanel.setLayout(DecorationFunctionPanelLayout);
        DecorationFunctionPanelLayout.setHorizontalGroup(
            DecorationFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        DecorationFunctionPanelLayout.setVerticalGroup(
            DecorationFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        TabPanel.setForeground(new java.awt.Color(6, 6, 6));
        TabPanel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo2.png"))); // NOI18N

        infoText.setBackground(new java.awt.Color(254, 254, 254));
        infoText.setEditable(false);
        infoText.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        infoText.setForeground(new java.awt.Color(6, 6, 6));
        infoText.setText("\n\n\n\n\nScopri tutte le funzionalità di \"ACES \".\n\nCon l'utilizzo della barra soprastante potrai accedere a tutti i servizi.");
        infoTextScroll.setViewportView(infoText);

        javax.swing.GroupLayout firstTabPanelLayout = new javax.swing.GroupLayout(firstTabPanel);
        firstTabPanel.setLayout(firstTabPanelLayout);
        firstTabPanelLayout.setHorizontalGroup(
            firstTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        firstTabPanelLayout.setVerticalGroup(
            firstTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstTabPanelLayout.createSequentialGroup()
                .addGroup(firstTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstTabPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addGroup(firstTabPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(infoTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        TabPanel.addTab("Pagina iniziale", firstTabPanel);

        contactList.setFont(new java.awt.Font("Purisa", 1, 18)); // NOI18N
        contactList.setForeground(new java.awt.Color(234, 29, 29));
        contactList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactListMouseClicked(evt);
            }
        });
        contactListScroll.setViewportView(contactList);

        contactButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        contactButton.setForeground(new java.awt.Color(6, 6, 6));
        contactButton.setText("Contatta");
        contactButton.setEnabled(false);
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });

        nLoginField.setEditable(false);
        nLoginField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        nLoginField.setForeground(new java.awt.Color(6, 6, 6));

        nFriendsField.setEditable(false);
        nFriendsField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        nFriendsField.setForeground(new java.awt.Color(6, 6, 6));

        nMessField.setEditable(false);
        nMessField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        nMessField.setForeground(new java.awt.Color(6, 6, 6));

        dateTimeField.setEditable(false);
        dateTimeField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dateTimeField.setForeground(new java.awt.Color(6, 6, 6));

        friendsLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        friendsLabel.setForeground(new java.awt.Color(6, 6, 6));
        friendsLabel.setText("Amici : ");
        friendsLabel.setFocusCycleRoot(true);

        loginLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(6, 6, 6));
        loginLabel.setText("Login : ");

        messLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        messLabel.setForeground(new java.awt.Color(6, 6, 6));
        messLabel.setText("Messaggi : ");

        dateLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(6, 6, 6));
        dateLabel.setText("Giorni su ACES :");

        statisticButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        statisticButton.setForeground(new java.awt.Color(6, 6, 6));
        statisticButton.setText("Statistiche");
        statisticButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout friendTabPanelLayout = new javax.swing.GroupLayout(friendTabPanel);
        friendTabPanel.setLayout(friendTabPanelLayout);
        friendTabPanelLayout.setHorizontalGroup(
            friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendTabPanelLayout.createSequentialGroup()
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contactListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(contactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(friendsLabel)
                            .addComponent(loginLabel)
                            .addComponent(messLabel)
                            .addComponent(dateLabel))
                        .addGap(95, 95, 95)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nMessField, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(nFriendsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(nLoginField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendTabPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statisticButton)
                        .addGap(150, 150, 150))))
        );
        friendTabPanelLayout.setVerticalGroup(
            friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contactListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactButton)
                .addContainerGap())
            .addGroup(friendTabPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(friendsLabel)
                    .addComponent(nFriendsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLabel))
                .addGap(18, 18, 18)
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nMessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messLabel))
                .addGap(18, 18, 18)
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLabel)
                    .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(statisticButton)
                .addGap(66, 66, 66))
        );

        TabPanel.addTab("Lista Amici", friendTabPanel);

        friendList.setFont(new java.awt.Font("Purisa", 1, 18)); // NOI18N
        friendList.setForeground(new java.awt.Color(234, 29, 29));
        friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendListMouseClicked(evt);
            }
        });
        friendListScroll.setViewportView(friendList);

        contactMultiUsers.setBackground(new java.awt.Color(254, 254, 254));
        contactMultiUsers.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        contactMultiUsers.setForeground(new java.awt.Color(6, 6, 6));
        contactMultiUsers.setText("Contatta");
        contactMultiUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactMultiUsersActionPerformed(evt);
            }
        });

        addtoMultiChat.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        addtoMultiChat.setForeground(new java.awt.Color(6, 6, 6));
        addtoMultiChat.setText("Aggiungi");
        addtoMultiChat.setEnabled(false);
        addtoMultiChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoMultiChatActionPerformed(evt);
            }
        });

        multichatList.setColumns(20);
        multichatList.setEditable(false);
        multichatList.setFont(new java.awt.Font("Purisa", 1, 18)); // NOI18N
        multichatList.setForeground(new java.awt.Color(234, 29, 29));
        multichatList.setRows(5);
        multiChatScroll.setViewportView(multichatList);

        textAreaInfo.setColumns(20);
        textAreaInfo.setEditable(false);
        textAreaInfo.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        textAreaInfo.setRows(5);
        textAreaInfo.setText("Seleziona un amico,e \"Aggiungilo\" \nalla lista dei partecipanti alla \nconversazione. Quando avrai \nselezionato tutti i partecipanti \n\"contatta\" i tuoi amici.\n");
        textAreaInfoScroll.setViewportView(textAreaInfo);

        javax.swing.GroupLayout chatroomTabPanelLayout = new javax.swing.GroupLayout(chatroomTabPanel);
        chatroomTabPanel.setLayout(chatroomTabPanelLayout);
        chatroomTabPanelLayout.setHorizontalGroup(
            chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(addtoMultiChat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(textAreaInfoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactMultiUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiChatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(163, 163, 163))
        );
        chatroomTabPanelLayout.setVerticalGroup(
            chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                .addGroup(chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(multiChatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactMultiUsers))
                            .addComponent(friendListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(textAreaInfoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addtoMultiChat)))
                .addContainerGap())
        );

        TabPanel.addTab("ChatRoom", chatroomTabPanel);

        addFriendButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        addFriendButton.setForeground(new java.awt.Color(6, 6, 6));
        addFriendButton.setText("Aggiungi");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        addFriendTitle.setEditable(false);
        addFriendTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        addFriendTitle.setForeground(new java.awt.Color(6, 6, 6));
        addFriendTitle.setText("Aggiungi una persona all'elenco dei tuoi contatti.");

        toAddLabel.setEditable(false);
        toAddLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        toAddLabel.setForeground(new java.awt.Color(6, 6, 6));
        toAddLabel.setText("Username dell'utente da inserire:");

        logoLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/ACES.png"))); // NOI18N

        javax.swing.GroupLayout addTabPanelLayout = new javax.swing.GroupLayout(addTabPanel);
        addTabPanel.setLayout(addTabPanelLayout);
        addTabPanelLayout.setHorizontalGroup(
            addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTabPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addFriendButton)
                    .addGroup(addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(addTabPanelLayout.createSequentialGroup()
                            .addComponent(toAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendtoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(addFriendTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103)
                .addComponent(logoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        addTabPanelLayout.setVerticalGroup(
            addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTabPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logoLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addTabPanelLayout.createSequentialGroup()
                        .addComponent(addFriendTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(addTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(friendtoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addComponent(addFriendButton)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        TabPanel.addTab("Aggiungi un amico", addTabPanel);

        inviteTextArea.setColumns(20);
        inviteTextArea.setEditable(false);
        inviteTextArea.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        inviteTextArea.setForeground(new java.awt.Color(6, 6, 6));
        inviteTextArea.setRows(5);
        inviteTextArea.setText("Riempiendo il campo sottostante potrai invitare i tuoi amici ad usare ACES.\nCon ACES puoi sempre rimanere in contatto con le persone a te più care.\nInvita tutti i tuoi amici per poter far crescere la comunity ACES.");
        inviteTextScroll.setViewportView(inviteTextArea);

        emailInviteLabel.setEditable(false);
        emailInviteLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        emailInviteLabel.setForeground(new java.awt.Color(6, 6, 6));
        emailInviteLabel.setText("Indirizzo Email a cui mandare l'invito:");

        emailToInvite.setFont(new java.awt.Font("SansSerif", 1, 15));
        emailToInvite.setForeground(new java.awt.Color(6, 6, 6));

        decoInvitePanel.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout decoInvitePanelLayout = new javax.swing.GroupLayout(decoInvitePanel);
        decoInvitePanel.setLayout(decoInvitePanelLayout);
        decoInvitePanelLayout.setHorizontalGroup(
            decoInvitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        decoInvitePanelLayout.setVerticalGroup(
            decoInvitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        DecoInvitePanel1.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout DecoInvitePanel1Layout = new javax.swing.GroupLayout(DecoInvitePanel1);
        DecoInvitePanel1.setLayout(DecoInvitePanel1Layout);
        DecoInvitePanel1Layout.setHorizontalGroup(
            DecoInvitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        DecoInvitePanel1Layout.setVerticalGroup(
            DecoInvitePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        inviteButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        inviteButton.setForeground(new java.awt.Color(6, 6, 6));
        inviteButton.setText("Invita");
        inviteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inviteTabPanelLayout = new javax.swing.GroupLayout(inviteTabPanel);
        inviteTabPanel.setLayout(inviteTabPanelLayout);
        inviteTabPanelLayout.setHorizontalGroup(
            inviteTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inviteTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inviteTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inviteTabPanelLayout.createSequentialGroup()
                        .addComponent(emailInviteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailToInvite, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(inviteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inviteTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecoInvitePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(decoInvitePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        inviteTabPanelLayout.setVerticalGroup(
            inviteTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inviteTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inviteTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(decoInvitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(inviteTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inviteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailToInvite)
                    .addComponent(emailInviteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(DecoInvitePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabPanel.addTab("Invita un amico", inviteTabPanel);

        infoChronoLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        infoChronoLabel.setForeground(new java.awt.Color(15, 64, 133));
        infoChronoLabel.setText("Visualizza le tue conversazioni passate.");

        usernameChronoLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        usernameChronoLabel.setForeground(new java.awt.Color(15, 64, 133));
        usernameChronoLabel.setText("Inserisci l'username:");

        searchButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        searchButton.setForeground(new java.awt.Color(6, 6, 6));
        searchButton.setText("Cerca");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        historyTextArea.setColumns(20);
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        historyTextArea.setForeground(new java.awt.Color(15, 64, 133));
        historyTextArea.setRows(5);
        historyScroll.setViewportView(historyTextArea);

        javax.swing.GroupLayout chronoTabPanelLayout = new javax.swing.GroupLayout(chronoTabPanel);
        chronoTabPanel.setLayout(chronoTabPanelLayout);
        chronoTabPanelLayout.setHorizontalGroup(
            chronoTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chronoTabPanelLayout.createSequentialGroup()
                .addGroup(chronoTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoChronoLabel)
                    .addComponent(usernameChronoLabel)
                    .addComponent(userHistoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(historyScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        chronoTabPanelLayout.setVerticalGroup(
            chronoTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chronoTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoChronoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(usernameChronoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userHistoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(historyScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        TabPanel.addTab("Cronologia", chronoTabPanel);

        logoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo2.png"))); // NOI18N

        searchFriendButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        searchFriendButton.setForeground(new java.awt.Color(6, 6, 6));
        searchFriendButton.setText("Cerca");
        searchFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFriendButtonActionPerformed(evt);
            }
        });

        nameField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        nameField.setForeground(new java.awt.Color(6, 6, 6));

        usernameSearchLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameSearchLabel.setForeground(new java.awt.Color(6, 6, 6));
        usernameSearchLabel.setText("Username dell'utente da cercare : ");

        usernameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        usernameFriendLabel.setText("Username :");

        nameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nameFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        nameFriendLabel.setText("Name : ");

        surnameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        surnameFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        surnameFriendLabel.setText("Surname : ");

        cityFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        cityFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        cityFriendLabel.setText("City : ");

        emailFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        emailFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        emailFriendLabel.setText("E-mail : ");

        levelFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        levelFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        levelFriendLabel.setText("Level : ");

        surnameField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        surnameField.setForeground(new java.awt.Color(6, 6, 6));

        cityField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cityField.setForeground(new java.awt.Color(6, 6, 6));

        usernameFriendField.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        usernameFriendField.setForeground(new java.awt.Color(6, 6, 6));

        levelField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        levelField.setForeground(new java.awt.Color(6, 6, 6));

        emailField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(6, 6, 6));

        javax.swing.GroupLayout searchTabPanelLayout = new javax.swing.GroupLayout(searchTabPanel);
        searchTabPanel.setLayout(searchTabPanelLayout);
        searchTabPanelLayout.setHorizontalGroup(
            searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchTabPanelLayout.createSequentialGroup()
                        .addComponent(logoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTabPanelLayout.createSequentialGroup()
                                .addComponent(levelFriendLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(levelField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTabPanelLayout.createSequentialGroup()
                                .addComponent(emailFriendLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTabPanelLayout.createSequentialGroup()
                                .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameFriendLabel)
                                    .addComponent(surnameFriendLabel)
                                    .addComponent(cityFriendLabel)
                                    .addComponent(usernameFriendLabel))
                                .addGap(30, 30, 30)
                                .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameFriendField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(imageFriendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(searchTabPanelLayout.createSequentialGroup()
                        .addComponent(usernameSearchLabel)
                        .addGap(20, 20, 20)
                        .addComponent(usertoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchFriendButton)
                        .addContainerGap(331, Short.MAX_VALUE))))
        );
        searchTabPanelLayout.setVerticalGroup(
            searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchFriendButton)
                    .addComponent(usertoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchTabPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(logoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(searchTabPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameFriendLabel)
                            .addComponent(usernameFriendField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameFriendLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameFriendLabel)
                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityFriendLabel)
                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailFriendLabel))
                        .addGap(18, 18, 18)
                        .addGroup(searchTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(levelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelFriendLabel))
                        .addGap(57, 57, 57))))
            .addGroup(searchTabPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(imageFriendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        TabPanel.addTab("Cerca", searchTabPanel);

        decoHomePanel.setBackground(new java.awt.Color(244, 167, 66));

        javax.swing.GroupLayout decoHomePanelLayout = new javax.swing.GroupLayout(decoHomePanel);
        decoHomePanel.setLayout(decoHomePanelLayout);
        decoHomePanelLayout.setHorizontalGroup(
            decoHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        decoHomePanelLayout.setVerticalGroup(
            decoHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
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

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(TabPanel, 0, 0, Short.MAX_VALUE)
            .addComponent(DecorationFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(decoHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecorationFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(decoHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUser(User n_user){

        loggedUser = n_user;
    }

    private void init(Requests toCon,User logged){
        
        int count = 0;
        this.map = new HashMap();
        this.index = 0;
        this.toCon = toCon;
        support = toCon;
        this.chatParticipants = new Vector[15];
        loggedUser = logged;
        this.newSession = new ChatSession(loggedUser,toCon);
        icon = new ImageIcon("stellina.png", null);
        while(count < this.chatParticipants.length){
            
            this.chatParticipants[count] = new Vector();
            count++;
        }
    }
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        
        try{
            
            toCon.logout(loggedUser.getIdPerson());
        }
        catch(IOException ex){
            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

public void run(){

    while(true){

        try{

            up.sleep(5000);
            setUpdate();
            if(this.index == 15) this.index = 0;
        }
        catch(InterruptedException ex){

            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);           
        }
        catch(IOException ex_){
            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
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

    
    public void setContactList(Vector friends){
        
        contactList.setListData(friends);
        friendList.setListData(friends);
        
    }
    
   
    private void contactListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactListMouseClicked

       contactButton.setEnabled(true);
    }//GEN-LAST:event_contactListMouseClicked

    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed

        if(!contactList.isSelectionEmpty()){

            try {
                
                Vector chatVector = buildChat(contactList.getSelectedValue().toString(),new Vector());
                chatVector.add(loggedUser.getUsername());
                newSession.start(chatVector);

            } catch (IOException ex) {
            
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
            }
    }//GEN-LAST:event_contactButtonActionPerformed


    
    private Vector buildChat(String username,Vector userlist) throws IOException{
        
        userlist.add(username);       
        try{
            
            new XML().genXml("ACES/History/".concat(username.concat(".xml")));
        
        }
        
        catch (FileNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null,"Problema nella generazione della cronologia. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            
        }
  
        return userlist;
    }
    
    
    private void disconnectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectMenuItemActionPerformed
        
        try {
            
            toCon.logout(loggedUser.getIdPerson());
            this.dispose();
            new InputForm().setVisible(true);
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_disconnectMenuItemActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if(!userHistoryField.getText().equals("")){
            XML xml = new XML();
            int index = 0;
            if(fileOperation.exist("ACES/History/"+userHistoryField.getText()+".xml")){
                ArrayList conversation = xml.readXml("ACES/History/" + userHistoryField.getText()+".xml");

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

                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void inviteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviteButtonActionPerformed

        if(!emailToInvite.getText().equals(""))
            try{
                toCon.sendMail(loggedUser.getUsername(),emailToInvite.getText());
            }
            catch(IOException ex){

                JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_inviteButtonActionPerformed

    private void contactMultiUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactMultiUsersActionPerformed
        
        try{
            this.chatParticipants[this.index].add(loggedUser.getUsername());
            newSession.start(this.chatParticipants[this.index]);
            this.index = this.index + 1;
            this.multichatList.setText(null);
        
        } catch(IOException ex){
            
            
        }

    }//GEN-LAST:event_contactMultiUsersActionPerformed

    
    private void addtoMultiChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoMultiChatActionPerformed
      
        if(!friendList.isSelectionEmpty()){
            
            multichatList.append( (String) friendList.getSelectedValue()+"\n");
            try{
                buildChat(friendList.getSelectedValue().toString(),this.chatParticipants[this.index]);
            }
            catch(IOException ex){
                
            }
        }
        
    }//GEN-LAST:event_addtoMultiChatActionPerformed

    private void friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendListMouseClicked
        
        addtoMultiChat.setEnabled(true);
    }//GEN-LAST:event_friendListMouseClicked

    //aggiungere try-catch
private void searchFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFriendButtonActionPerformed
    
     if(usertoSearch.getText()!=""){
            try {
                this.toCon.searchUser(usertoSearch.getText());
            }
            
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
            }

            }  
}//GEN-LAST:event_searchFriendButtonActionPerformed

    private void statisticButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticButtonActionPerformed

        try {
            this.toCon.statistic(loggedUser.getIdPerson());
           
        } 
        
        catch (IOException ex) {
        
        }
    }//GEN-LAST:event_statisticButtonActionPerformed
    
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
                    JOptionPane.showMessageDialog(null,"Problemi tecnici nel caricamente dei Feed." , "ACES", JOptionPane.ERROR_MESSAGE);
                }
                return x;
    }

    public void setInfo(User user) {
        
        Integer level;
        level = user.getLevel();
        
        usernameFriendField.setText(user.getUsername());
        nameField.setText(user.getName());
        surnameField.setText(user.getSurname());
        cityField.setText(user.getCity());
        emailField.setText(user.getEmail());
        levelField.setText(level.toString());
        imageFriendLabel.setIcon(user.getPersonalImage());
    }

     public void setStatistic(Vector vector) {
       
        nFriendsField.setText(vector.get(0).toString());
        nLoginField.setText(vector.get(1).toString());
        nMessField.setText(vector.get(2).toString());
        dateTimeField.setText(vector.get(3).toString()); 
     }
     
     
    private Vector[] chatParticipants;
    private int index;
    private ChatSession newSession;
    private final String tech = "http://www.repubblica.it/rss/tecnologia/rss2.0.xml";
    private final String culture = "http://rss.feedsportal.com/c/32275/f/438644/index.rss";
    private final String politic = "http://www.repubblica.it/rss/politica/rss2.0.xml";
    private final String gossip = "http://rss.feedsportal.com/c/625/f/8192/index.rss";
    private final String sport = "http://www.repubblica.it/rss/sport/rss2.0.xml";
    private final String nothing = "http://rss.feedsportal.com/c/32275/f/438637/index.rss";
    private HashMap map;
    private Icon icon;
    private Thread up;
    private static User loggedUser;
    private  Requests toCon;
    private static Requests support;

//componenti swing instanziati sopra del form/frame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecoInvitePanel1;
    private javax.swing.JPanel DecorationFunctionPanel;
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JScrollPane FeedScroll;
    private javax.swing.JTextPane FeedView;
    private javax.swing.JPanel LevelPanel;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JButton addFriendButton;
    private javax.swing.JTextField addFriendTitle;
    private javax.swing.JPanel addTabPanel;
    private javax.swing.JButton addtoMultiChat;
    private javax.swing.JPanel chatroomTabPanel;
    private javax.swing.JPanel chronoTabPanel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityFriendLabel;
    private javax.swing.JButton contactButton;
    private javax.swing.JList contactList;
    private javax.swing.JScrollPane contactListScroll;
    private javax.swing.JButton contactMultiUsers;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTimeField;
    private javax.swing.JPanel decoHomePanel;
    private javax.swing.JPanel decoInvitePanel;
    private javax.swing.JScrollPane decoScroll;
    private javax.swing.JTextPane decorationFeedPanel;
    private javax.swing.JPanel decorationInfoPanel;
    private javax.swing.JMenuItem disconnectMenuItem;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailFriendLabel;
    private javax.swing.JTextField emailInviteLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailToInvite;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel firstStarLabel;
    private javax.swing.JPanel firstTabPanel;
    private javax.swing.JList friendList;
    private javax.swing.JScrollPane friendListScroll;
    private javax.swing.JPanel friendTabPanel;
    private javax.swing.JLabel friendsLabel;
    private javax.swing.JTextField friendtoAdd;
    private javax.swing.JScrollPane historyScroll;
    private javax.swing.JTextArea historyTextArea;
    private javax.swing.JLabel imageFriendLabel;
    private javax.swing.JLabel infoChronoLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextPane infoText;
    private javax.swing.JScrollPane infoTextScroll;
    private javax.swing.JButton infoView;
    private javax.swing.JButton inviteButton;
    private javax.swing.JPanel inviteTabPanel;
    private javax.swing.JTextArea inviteTextArea;
    private javax.swing.JScrollPane inviteTextScroll;
    private javax.swing.JTextField levelField;
    private javax.swing.JLabel levelFriendLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel messLabel;
    private javax.swing.JScrollPane multiChatScroll;
    private javax.swing.JTextArea multichatList;
    private javax.swing.JTextField nFriendsField;
    private javax.swing.JTextField nLoginField;
    private javax.swing.JTextField nMessField;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameFriendLabel;
    private javax.swing.JButton photoLoadButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchFriendButton;
    private javax.swing.JPanel searchTabPanel;
    private javax.swing.JLabel secondStarLabel;
    private javax.swing.JButton statisticButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameFriendLabel;
    private javax.swing.JTextArea textAreaInfo;
    private javax.swing.JScrollPane textAreaInfoScroll;
    private javax.swing.JLabel thirdStarLabel;
    private javax.swing.JTextField toAddLabel;
    private javax.swing.JTextField userHistoryField;
    private javax.swing.JLabel userImageLabel;
    private javax.swing.JLabel usernameChronoLabel;
    private javax.swing.JTextField usernameFriendField;
    private javax.swing.JLabel usernameFriendLabel;
    private javax.swing.JLabel usernameSearchLabel;
    private javax.swing.JTextField usertoSearch;
    // End of variables declaration//GEN-END:variables

   

    
}
