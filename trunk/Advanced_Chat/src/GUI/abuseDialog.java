package GUI;

import Networking.Requests;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * Classe per la segnalazionedell'abuso
 */
public class abuseDialog extends javax.swing.JFrame {

    public abuseDialog(int idSender,Requests toCon,String toSign) {
        initComponents();
        this.toCon = toCon;
        this.idSender = idSender;
        this.offender = toSign;
    }
   //inizializzazione elementi swing
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        offenseMessage = new javax.swing.JTextArea();
        decorationPanel = new javax.swing.JPanel();
        textPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        confirmButton.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        confirmButton.setText("Conferma");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        offenseMessage.setColumns(20);
        offenseMessage.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        offenseMessage.setForeground(new java.awt.Color(6, 6, 6));
        offenseMessage.setRows(5);
        jScrollPane1.setViewportView(offenseMessage);

        decorationPanel.setBackground(new java.awt.Color(15, 64, 133));

        javax.swing.GroupLayout decorationPanelLayout = new javax.swing.GroupLayout(decorationPanel);
        decorationPanel.setLayout(decorationPanelLayout);
        decorationPanelLayout.setHorizontalGroup(
            decorationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        decorationPanelLayout.setVerticalGroup(
            decorationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        textPanel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        textPanel.setText("Inserisci l'offesa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decorationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(decorationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(confirmButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        
        if(offenseMessage.getText() != ""){
            
            try{
                //invia la segnalazione
                this.toCon.sendAbuse(this.idSender,offenseMessage.getText(),this.offender);
            }
            
            catch(IOException ex){
                
                JOptionPane.showMessageDialog(null, ex.toString(), "ACES", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void doClose(){
        
        dispose();
    }

    
    private Requests toCon;
    private int idSender;
    private String offender;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel decorationPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea offenseMessage;
    private javax.swing.JLabel textPanel;
    // End of variables declaration//GEN-END:variables

}
