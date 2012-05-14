/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 28-nov-2011, 22.39.07
 */

package GUI;

import Networking.Requests;
import User.User;
import fileManager.fileOperation;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author enrico
 */
public class fileChooser extends javax.swing.JFrame {


    public fileChooser(User client,JLabel imageLabel,Requests toCon,int use) {
        
        initComponents();
        this.client = client;
        this.imageLabel = imageLabel;
        this.toCon = toCon;
        this.use = use;
        

    }
    
    public fileChooser(Requests toCon,User client,int use,String receiver) {
        
        initComponents();
        this.client = client;
        this.toCon = toCon;
        this.use = use;
        this.receiver = receiver;

    }

  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        loadButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser1.setControlButtonsAreShown(false);
        jFileChooser1.setCurrentDirectory(null);
        jFileChooser1.setDialogTitle("Seleziona l'immagine da caricare");

        loadButton.setText("Carica");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Esci");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        
        File selectedFile = jFileChooser1.getSelectedFile();

        try{//potremmo fare un controllo su variabile che non ci sono nel costruttore come per esempio
            //quando carichiamo un file non ci sarà instaurata la label o per l'immagine il receiver;
            if(use == 1)
                loadImageFile(selectedFile);
            else
                loadFile(selectedFile);
            
        }
        catch(IOException ex){
            
            new userDialog("Si è verificato un problema. Riprova più tardi").setVisible(true);
        }
        
        dispose();
        
}//GEN-LAST:event_loadButtonActionPerformed

    
    private void loadImageFile(File imageFile) throws IOException{
        
        ImageIcon icon = fileOperation.loadImage(imageFile);
        this.imageLabel.setIcon(icon);            
        toCon.sendImage(imageFile,this.client.getIdPerson());//forse dobbiamo metterla nel DB
        
    }

    
    private void loadFile(File selectedFile) throws IOException{
        
        toCon.send(selectedFile,this.receiver,this.client.getUsername());
        
    }

private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed

        dispose();
    
}//GEN-LAST:event_exitButtonActionPerformed

    private String receiver;
    private int use;
    private User client;
    private Requests toCon;
    private JLabel imageLabel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JButton loadButton;
    // End of variables declaration//GEN-END:variables

}
