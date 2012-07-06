package GUI;

import fileManager.fileOperation;
import Feed.Feed;
import Feed.FeedMessage;
import Feed.RSSFeedParser;
import Networking.chatManager;
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

/*Home dell'applicazione. Attraverso questa classe l'utente può accedere a 
 * tutte le funzionalità dell'applicazione; il costruttore inizializza la costruzione
 * del form e quindi dell'aspetto grafico e si occupa di inizializzare le principali 
 * funzionalità.
 */
public class Home extends javax.swing.JFrame implements Runnable{

    public Home(Requests toCon,User logged) throws IOException{
        
        initComponents();
        initSystem(toCon,logged);      
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
        usernameLabel = new javax.swing.JLabel();
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
        statisticsButton = new javax.swing.JButton();
        decoImageLabel = new javax.swing.JLabel();
        iconAcesLabel = new javax.swing.JLabel();
        chatroomTabPanel = new javax.swing.JPanel();
        friendListScroll = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList();
        contactMultiUsers = new javax.swing.JButton();
        addtoMultiChat = new javax.swing.JButton();
        multiChatScroll = new javax.swing.JScrollPane();
        multichatList = new javax.swing.JTextArea();
        textAreaInfoScroll = new javax.swing.JScrollPane();
        textAreaInfo = new javax.swing.JTextArea();
        iconAcesLabel1 = new javax.swing.JLabel();
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
        chronoSearchButton = new javax.swing.JButton();
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
        FeedView.setFont(new java.awt.Font("SansSerif", 1, 15));
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
                .addComponent(FeedScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
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
        infoView.setForeground(new java.awt.Color(6, 6, 6));
        infoView.setText("Visualizza le tue informazioni personali");
        infoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoViewActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        usernameLabel.setForeground(new java.awt.Color(6, 6, 6));
        usernameLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        photoLoadButton.setFont(new java.awt.Font("SansSerif", 1, 15));
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
                                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
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
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 19, Short.MAX_VALUE)
        );

        TabPanel.setForeground(new java.awt.Color(6, 6, 6));
        TabPanel.setFont(new java.awt.Font("SansSerif", 1, 16));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logo2.png"))); // NOI18N

        infoText.setBackground(new java.awt.Color(254, 254, 254));
        infoText.setEditable(false);
        infoText.setFont(new java.awt.Font("SansSerif", 1, 14));
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

        contactList.setFont(new java.awt.Font("Purisa", 1, 18));
        contactList.setForeground(new java.awt.Color(234, 29, 29));
        contactList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactListMouseClicked(evt);
            }
        });
        contactListScroll.setViewportView(contactList);

        contactButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        contactButton.setForeground(new java.awt.Color(6, 6, 6));
        contactButton.setText("Contatta");
        contactButton.setEnabled(false);
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });

        nLoginField.setEditable(false);
        nLoginField.setFont(new java.awt.Font("SansSerif", 1, 12));
        nLoginField.setForeground(new java.awt.Color(6, 6, 6));

        nFriendsField.setEditable(false);
        nFriendsField.setFont(new java.awt.Font("SansSerif", 1, 12));
        nFriendsField.setForeground(new java.awt.Color(6, 6, 6));

        nMessField.setEditable(false);
        nMessField.setFont(new java.awt.Font("SansSerif", 1, 12));
        nMessField.setForeground(new java.awt.Color(6, 6, 6));

        dateTimeField.setEditable(false);
        dateTimeField.setFont(new java.awt.Font("SansSerif", 1, 12));
        dateTimeField.setForeground(new java.awt.Color(6, 6, 6));

        friendsLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        friendsLabel.setForeground(new java.awt.Color(6, 6, 6));
        friendsLabel.setText("Amici : ");
        friendsLabel.setFocusCycleRoot(true);

        loginLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        loginLabel.setForeground(new java.awt.Color(6, 6, 6));
        loginLabel.setText("Login : ");

        messLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        messLabel.setForeground(new java.awt.Color(6, 6, 6));
        messLabel.setText("Messaggi : ");

        dateLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        dateLabel.setForeground(new java.awt.Color(6, 6, 6));
        dateLabel.setText("Giorni su ACES :");

        statisticsButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        statisticsButton.setForeground(new java.awt.Color(6, 6, 6));
        statisticsButton.setText("Statistiche");
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });

        decoImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decoImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/my_Logo.png"))); // NOI18N

        iconAcesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/ACES.png"))); // NOI18N

        javax.swing.GroupLayout friendTabPanelLayout = new javax.swing.GroupLayout(friendTabPanel);
        friendTabPanel.setLayout(friendTabPanelLayout);
        friendTabPanelLayout.setHorizontalGroup(
            friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendTabPanelLayout.createSequentialGroup()
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contactListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decoImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconAcesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLabel)
                            .addComponent(messLabel)
                            .addComponent(friendsLabel)
                            .addComponent(loginLabel))
                        .addGap(75, 75, 75)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nMessField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nLoginField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nFriendsField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                .addComponent(statisticsButton))
                            .addGroup(friendTabPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(contactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174))
        );
        friendTabPanelLayout.setVerticalGroup(
            friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addComponent(contactListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contactButton))
                    .addGroup(friendTabPanelLayout.createSequentialGroup()
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(decoImageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, friendTabPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(friendsLabel)
                                    .addComponent(nFriendsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(loginLabel)
                                    .addComponent(nLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(friendTabPanelLayout.createSequentialGroup()
                                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(messLabel)
                                    .addComponent(nMessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(friendTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dateLabel)
                                    .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(statisticsButton))
                            .addComponent(iconAcesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
        );

        TabPanel.addTab("Lista Amici", friendTabPanel);

        friendList.setFont(new java.awt.Font("Purisa", 1, 18));
        friendList.setForeground(new java.awt.Color(234, 29, 29));
        friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendListMouseClicked(evt);
            }
        });
        friendListScroll.setViewportView(friendList);

        contactMultiUsers.setBackground(new java.awt.Color(254, 254, 254));
        contactMultiUsers.setFont(new java.awt.Font("SansSerif", 1, 15));
        contactMultiUsers.setForeground(new java.awt.Color(6, 6, 6));
        contactMultiUsers.setText("Contatta");
        contactMultiUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactMultiUsersActionPerformed(evt);
            }
        });

        addtoMultiChat.setFont(new java.awt.Font("SansSerif", 1, 15));
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
        multichatList.setFont(new java.awt.Font("Purisa", 1, 18));
        multichatList.setForeground(new java.awt.Color(234, 29, 29));
        multichatList.setRows(5);
        multiChatScroll.setViewportView(multichatList);

        textAreaInfo.setColumns(20);
        textAreaInfo.setEditable(false);
        textAreaInfo.setFont(new java.awt.Font("SansSerif", 1, 15));
        textAreaInfo.setRows(5);
        textAreaInfo.setText("Seleziona un amico,e \"Aggiungilo\" \nalla lista dei partecipanti alla \nconversazione. Quando avrai \nselezionato tutti i partecipanti \n\"contatta\" i tuoi amici.\n");
        textAreaInfoScroll.setViewportView(textAreaInfo);

        iconAcesLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAcesLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/ACES.png"))); // NOI18N

        javax.swing.GroupLayout chatroomTabPanelLayout = new javax.swing.GroupLayout(chatroomTabPanel);
        chatroomTabPanel.setLayout(chatroomTabPanelLayout);
        chatroomTabPanelLayout.setHorizontalGroup(
            chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(chatroomTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(textAreaInfoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(addtoMultiChat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatroomTabPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(iconAcesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(addtoMultiChat)
                        .addGap(18, 18, 18)
                        .addComponent(iconAcesLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabPanel.addTab("ChatRoom", chatroomTabPanel);

        addFriendButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        addFriendButton.setForeground(new java.awt.Color(6, 6, 6));
        addFriendButton.setText("Aggiungi");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        addFriendTitle.setEditable(false);
        addFriendTitle.setFont(new java.awt.Font("SansSerif", 1, 18));
        addFriendTitle.setForeground(new java.awt.Color(6, 6, 6));
        addFriendTitle.setText("Aggiungi una persona all'elenco dei tuoi contatti.");

        toAddLabel.setEditable(false);
        toAddLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        toAddLabel.setForeground(new java.awt.Color(6, 6, 6));
        toAddLabel.setText("Username dell'utente da inserire:");

        logoLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/ACES.png"))); // NOI18N

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
        inviteTextArea.setFont(new java.awt.Font("SansSerif", 1, 18));
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

        inviteButton.setFont(new java.awt.Font("SansSerif", 1, 15));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
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

        chronoSearchButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        chronoSearchButton.setForeground(new java.awt.Color(6, 6, 6));
        chronoSearchButton.setText("Cerca");
        chronoSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chronoSearchButtonActionPerformed(evt);
            }
        });

        historyTextArea.setColumns(20);
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new java.awt.Font("SansSerif", 1, 15));
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
                    .addComponent(chronoSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(chronoSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(historyScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        TabPanel.addTab("Cronologia", chronoTabPanel);

        logoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logo1.png"))); // NOI18N

        searchFriendButton.setFont(new java.awt.Font("SansSerif", 1, 15));
        searchFriendButton.setForeground(new java.awt.Color(6, 6, 6));
        searchFriendButton.setText("Cerca");
        searchFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFriendButtonActionPerformed(evt);
            }
        });

        nameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        nameField.setForeground(new java.awt.Color(6, 6, 6));

        usernameSearchLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        usernameSearchLabel.setForeground(new java.awt.Color(6, 6, 6));
        usernameSearchLabel.setText("Username dell'utente da cercare : ");

        usernameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        usernameFriendLabel.setText("Username :");

        nameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        nameFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        nameFriendLabel.setText("Name : ");

        surnameFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        surnameFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        surnameFriendLabel.setText("Surname : ");

        cityFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        cityFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        cityFriendLabel.setText("City : ");

        emailFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        emailFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        emailFriendLabel.setText("E-mail : ");

        levelFriendLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        levelFriendLabel.setForeground(new java.awt.Color(6, 6, 6));
        levelFriendLabel.setText("Level : ");

        surnameField.setFont(new java.awt.Font("SansSerif", 1, 12));
        surnameField.setForeground(new java.awt.Color(6, 6, 6));

        cityField.setFont(new java.awt.Font("SansSerif", 1, 12));
        cityField.setForeground(new java.awt.Color(6, 6, 6));

        usernameFriendField.setFont(new java.awt.Font("SansSerif", 0, 12));
        usernameFriendField.setForeground(new java.awt.Color(6, 6, 6));

        levelField.setFont(new java.awt.Font("SansSerif", 1, 12));
        levelField.setForeground(new java.awt.Color(6, 6, 6));

        emailField.setFont(new java.awt.Font("SansSerif", 1, 12));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
            .addGap(0, 941, Short.MAX_VALUE)
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
            .addComponent(DecorationFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(decoHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecorationFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decoHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUser(User n_user){
        loggedUser = n_user;
    }

    /*Inizializza le principali funzionalità dell'applicazione: Impostazione del profilo
     * Creazione strutture dati per le conversazioni, istanza oggetto requests per la gestione
     * delle richieste al server, ClientFetching(vedi classe) per la gestione delle "risposte"
     * del server alle richieste del client...
     */
    private void initSystem(Requests toCon,User loggedUser)throws IOException{

        int count = 0;
        this.index = 0;
        this.toCon = toCon;      
        this.loggedUser = loggedUser;
        this.chatSession = new chatManager(loggedUser,toCon);
        levelIcon = new ImageIcon((getClass().getResource("/GUI/Images/stellina.png")), null);
        this.chatParticipants = new Vector[15];
        while(count < this.chatParticipants.length){
            this.chatParticipants[count] = new Vector();
            count++;
        }
        initMap();
        new ClientFetching(this.toCon,this,chatSession).start();
        setUpdate();
        refresher = new Thread(this);
        refresher.start();
    }
  
    /*Logout(Requests si occupa della richiesta) e uscita dall'applicazione*/
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        
        try{            
            toCon.logout(loggedUser.getIdPerson());
            this.toCon.close();
        }catch(IOException ex){           
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /*Thread che si occupa di eseguire periodicamente setUpdate() - vedi poco sotto*/
    public void run(){

        while(true){

            try{
                refresher.sleep(5000);
                setUpdate();
                if(this.index == 15) this.index = 0;
            }catch(InterruptedException ex){
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);           
            }
            catch(IOException ex_){           
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }   
        }
    }
 
    //Visualizza le informazioni personali dell'utente di modo da eventualmente modificarle;
    private void infoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoViewActionPerformed
        
        new infoView(this.loggedUser,this.toCon).setVisible(true);
    }//GEN-LAST:event_infoViewActionPerformed

    /*Struttura dati di supporto alla gestione dei Feed in base agli interessi dell'utente - ad ogni interesse
     * corrisponde un URL per il download dei Feed
     */
    private void initMap(){
        
        mapFeed = new HashMap();
        mapFeed.put("sport", sport);
        mapFeed.put("cultura",culture);
        mapFeed.put("tecnologia",tech);
        mapFeed.put("Nessuno",nothing);
        mapFeed.put("politica",politic);
        mapFeed.put("gossip", gossip);       
    }
  
    /*Aggiorna i componenti Swing più importanti nella Home riguardanti il profilo dell'utente;
     * inoltre si occupa di inoltrare richieste di ricezione di messaggi e visualizzazione della lista
     * amici dell'utente aggiornata;Infine aggiorna i feed alle notizie più recenti;
     */
    private void setUpdate() throws IOException{

        usernameLabel.setText(loggedUser.getUsername());
        emailLabel.setText(loggedUser.getEmail());
        FeedView.setText(viewFeed());
        userImageLabel.setIcon(loggedUser.getPersonalImage());
        this.toCon.getFriends(this.loggedUser.getIdPerson());
        this.toCon.getMess(this.loggedUser.getUsername());
        switch(loggedUser.getLevel()){
        
            case 1: firstStarLabel.setIcon(levelIcon); break;
            case 2: firstStarLabel.setIcon(levelIcon); secondStarLabel.setIcon(levelIcon); break;
            case 3: firstStarLabel.setIcon(levelIcon); secondStarLabel.setIcon(levelIcon); thirdStarLabel.setIcon(levelIcon); break;
        }
    }
    
    //Aggiorna la lista amici dell'utente;
    public void setContactList(Vector friends){
        
        contactList.setListData(friends);
        friendList.setListData(friends);        
    }
   
    private void contactListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactListMouseClicked

       contactButton.setEnabled(true);
    }//GEN-LAST:event_contactListMouseClicked
    
    //Contatta l'amico scelto tramite la lista amici presente nell'applicazione;
    //chatSession si occuperà dello scambio di informazioni;
    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed

        if(!contactList.isSelectionEmpty()){

            try{             
                Vector chatVector = buildChat(contactList.getSelectedValue().toString(),new Vector());
                chatVector.add(loggedUser.getUsername());
                chatSession.start(chatVector);
            }catch (IOException ex) {           
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_contactButtonActionPerformed
    
    /*Permette l'impostazione di una conversazione con amici(costruisce un vettore di utenti partecipanti;
     *inoltre crea i file XML per poter
     * scrivere dentro le informazioni legate allo scambio di messaggi tra gli utenti;
     */
    private Vector buildChat(String username,Vector userlist) throws IOException{
        
        userlist.add(username);       
        try{
            
            new XML().genXml("ACES/History/".concat(username.concat(".xml")));
        
        }catch (FileNotFoundException ex) {          
            JOptionPane.showMessageDialog(null,"Problema nella generazione della cronologia. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);           
        }  
        return userlist;
    }
    
    /*Attraverso il menu File possiamo disconnetere il profilo dall'applicazione - Logout*/    
    private void disconnectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectMenuItemActionPerformed
        
        try {           
            toCon.logout(loggedUser.getIdPerson());           
            new InputForm().setVisible(true);
        }catch (Exception ex) {            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_disconnectMenuItemActionPerformed
   
    /*Prendiamo l'identificativo dell'utente di cui caricare la cronologia(un arraylist dal
     * file XML) e affidiamo la visualizzazione
    * di essa a chronoAppend();*/
    private void chronoSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chronoSearchButtonActionPerformed

        try{
            String userHistory = userHistoryField.getText();
            XML xml = new XML();
            if(new fileOperation().getOS().equals("Windows")){
               ArrayList conversation = xml.readXml("ACES\\History\\" + userHistory+".xml");
               chronoAppend(conversation);    
            }else{
               ArrayList conversation = xml.readXml("ACES/History/" + userHistory+".xml");
               chronoAppend(conversation);  
            }
         }catch(NullPointerException ex){       
            JOptionPane.showMessageDialog(null,"L'utente da te cercato non esiste e/o non l'hai ancora contattato per la prima volta." , "ACES", JOptionPane.ERROR_MESSAGE);  
         }   
    }//GEN-LAST:event_chronoSearchButtonActionPerformed
    
    /*Visualizza in apposite TextArea il contenuto di un arraylist in modo ordinato;
     * Legato alla funzionalità "Cronologia"
     */
    private void chronoAppend(ArrayList conversation){
        
        while( index < conversation.size()){

                    historyTextArea.append(conversation.get(index).toString()+"\n");
                    if(index != 0 && (index+1) % 3 == 0)
                        historyTextArea.append("\n");
                    index++;
                }
    }
    
    //Affida a fileChooser la gestione del caricamento di una foto per il profilo dell'utente;
    private void photoLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoLoadButtonActionPerformed

        new fileChooser(this.loggedUser,userImageLabel,toCon,1).setVisible(true);
    }//GEN-LAST:event_photoLoadButtonActionPerformed
    
    //Codifica della richiesta di amicizia
    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed

        try{
           String friend = friendtoAdd.getText();
           toCon.addFriend(friend,loggedUser.getIdPerson());
        }catch(IOException ex){
           JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException ex){
           JOptionPane.showMessageDialog(null,"Mancato inserimento di un valore." , "ACES", JOptionPane.ERROR_MESSAGE);          
        }      
    }//GEN-LAST:event_addFriendButtonActionPerformed
    
    /*Permette di inoltrare tramite un istanza della classe Requests la richiesta di invito (via mail)
     * verso un utente identificato dalla email che l'utente "passa" all'applicazione.
     */
    private void inviteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviteButtonActionPerformed

        if(!emailToInvite.getText().equals("")){
            try{
                toCon.sendMail(loggedUser.getUsername(),emailToInvite.getText());
            }catch(IOException ex){

                JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_inviteButtonActionPerformed
    
    /*Con questo metodo facciamo partire la conversazione passando il vettore dei partecipanti
     ad un oggetto della classe ChatManager (chatSession in particolare) che gestirà opportunamente
     lo scambio di messaggi/file*/
    private void contactMultiUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactMultiUsersActionPerformed
        
        try{
            this.chatParticipants[this.index].add(loggedUser.getUsername());
            chatSession.start(this.chatParticipants[this.index]);
            this.index = this.index + 1;
            this.multichatList.setText(null);
        
        } catch(IOException ex){
            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_contactMultiUsersActionPerformed
   
    /*Aggiunge utenti alla lista di partecipanti alla multichat (visualizzandoli a schermo 
     * ed impostando le strutture dati, Vector, per contenerli)*/
    private void addtoMultiChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoMultiChatActionPerformed
      
        if(!friendList.isSelectionEmpty()){
            
            multichatList.append( (String) friendList.getSelectedValue()+"\n");
            try{
                buildChat(friendList.getSelectedValue().toString(),this.chatParticipants[this.index]);
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_addtoMultiChatActionPerformed

    private void friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendListMouseClicked

        addtoMultiChat.setEnabled(true);
    }//GEN-LAST:event_friendListMouseClicked

    /*Codifichiamo la richiesta da parte dell'utente di ricerca di un utente all'interno dell'applicazione;
     * la classe Requests si occupa di inoltrare la richiesta al server;
     */
private void searchFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFriendButtonActionPerformed
    
            try {
                String username = usertoSearch.getText();
                this.toCon.searchUser(username);
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null,"Non hai inserito un valore." , "ACES", JOptionPane.ERROR_MESSAGE);
            }
        
}//GEN-LAST:event_searchFriendButtonActionPerformed
    
/*Codifichiamo la richiesta da parte dell'utente di statistiche; la classe requests si occuperà di inoltrare
 * la richiesta al server.
 */
    private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsButtonActionPerformed

        try {            
            this.toCon.getStatistics(loggedUser.getIdPerson());         
        }catch (IOException ex) {
            
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Riprova più tardi." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_statisticsButtonActionPerformed
    
    /*Permette la visualizzazione di notizie sottoforma di Feed nel pannello predisposto nella Home
     * dell'applicazione.In particolare visualizza Feed relativi agli interessi selezionati in fase di registrazione
     * dall'utente in modo del tutto casuale e trasparente per l'utente, che potrà leggere le notizie più recenti sugli
     * argomenti che più gli interessano;
     */
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

                RSSFeedParser parser = new RSSFeedParser(mapFeed.get(interests[a]).toString());
		Feed feed = parser.readFeed();
                for(FeedMessage message : feed.getMessages())
                    x = x.concat((message.getTitle()+"\n\n"));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Problemi tecnici nel caricamento dei Feed." , "ACES", JOptionPane.ERROR_MESSAGE);
                }
                return x;
    }
    
    /*Imposta la visualizzazione delle informazioni del profilo di un utente;
     * collegato alla funzionalità "Cerca"
     */
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
    
    /*Ricevuto un vettore con le statistiche dell'utente, le inserisce all'interno di
     * oggetti JSwing per la visualizzazione all'utente che ne ha fatto richiesta.
     */
    public void setStatistic(Vector vector) {
       
        nFriendsField.setText(vector.get(0).toString());
        nLoginField.setText(vector.get(1).toString());
        nMessField.setText(vector.get(2).toString());
        dateTimeField.setText(vector.get(3).toString()); 
     }
         
    private Vector[] chatParticipants;
    private int index;
    private chatManager chatSession;
    private final String tech = "http://www.repubblica.it/rss/tecnologia/rss2.0.xml";
    private final String culture = "http://rss.feedsportal.com/c/32275/f/438644/index.rss";
    private final String politic = "http://www.repubblica.it/rss/politica/rss2.0.xml";
    private final String gossip = "http://rss.feedsportal.com/c/625/f/8192/index.rss";
    private final String sport = "http://www.repubblica.it/rss/sport/rss2.0.xml";
    private final String nothing = "http://rss.feedsportal.com/c/32275/f/438637/index.rss";
    private HashMap mapFeed;
    private Icon levelIcon;
    private Thread refresher;
    private User loggedUser;
    private Requests toCon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DecoInvitePanel1;
    private javax.swing.JPanel DecorationFunctionPanel;
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JScrollPane FeedScroll;
    private javax.swing.JTextPane FeedView;
    private javax.swing.JPanel LevelPanel;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JButton addFriendButton;
    private javax.swing.JTextField addFriendTitle;
    private javax.swing.JPanel addTabPanel;
    private javax.swing.JButton addtoMultiChat;
    private javax.swing.JPanel chatroomTabPanel;
    private javax.swing.JButton chronoSearchButton;
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
    private javax.swing.JLabel decoImageLabel;
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
    private javax.swing.JLabel iconAcesLabel;
    private javax.swing.JLabel iconAcesLabel1;
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
    private javax.swing.JButton searchFriendButton;
    private javax.swing.JPanel searchTabPanel;
    private javax.swing.JLabel secondStarLabel;
    private javax.swing.JButton statisticsButton;
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
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameSearchLabel;
    private javax.swing.JTextField usertoSearch;
    // End of variables declaration//GEN-END:variables
}
