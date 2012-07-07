package General;

import Database.databaseQueries;
import Network.Server;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/*Classe da cui partono le attività dal server*/
public class Begin extends javax.swing.JFrame {

    /**Nel costruttore inizializzamo i componenti swing */
    public Begin() {
        initComponents();
        serverStateField.setText("Stopped");        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        welcomeTitle = new javax.swing.JTextField();
        loginTextField = new javax.swing.JTextField();
        pswAdmin = new javax.swing.JPasswordField();
        userAdmin = new javax.swing.JTextField();
        serverStateField = new javax.swing.JTextField();
        serverStateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/General/Images/logo2.png"))); // NOI18N

        welcomeTitle.setEditable(false);
        welcomeTitle.setFont(new java.awt.Font("SansSerif", 1, 15));
        welcomeTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        welcomeTitle.setText("Welcome Administrator!");

        loginTextField.setEditable(false);
        loginTextField.setFont(new java.awt.Font("SansSerif", 1, 15));
        loginTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginTextField.setText("Login:");

        serverStateField.setEditable(false);
        serverStateField.setFont(new java.awt.Font("SansSerif", 1, 15));

        serverStateLabel.setFont(new java.awt.Font("SansSerif", 1, 15));
        serverStateLabel.setText("Stato del Server:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userAdmin)
                                    .addComponent(pswAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(serverStateField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(welcomeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(pswAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(serverStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(serverStateField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Parte il Server;
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        try{
            databaseQueries query;            
            generalView gv;
            Server server;

            query = new databaseQueries();
            gv = new generalView(this);
            gv.setVisible(true);
            server = new Server(gv,query);
            server.start();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Errore di connessione: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);          
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null,"Errore di caricamente classe: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Errore SQL: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }
                
        startButton.setEnabled(false);
        serverStateField.setText("Running");       
        this.setVisible(false);      
    }//GEN-LAST:event_startButtonActionPerformed

    /**
    * metodo main da cui parte il server
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Begin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPasswordField pswAdmin;
    private javax.swing.JTextField serverStateField;
    private javax.swing.JLabel serverStateLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField userAdmin;
    private javax.swing.JTextField welcomeTitle;
    // End of variables declaration//GEN-END:variables

}
