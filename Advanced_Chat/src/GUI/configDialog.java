package GUI;

import fileManager.fileOperation;
import XML.XML;
import javax.swing.JOptionPane;


/*Piccola finestra di dialogo(extends Jdialog) che permette all'utente, in caso non fosse presente una configurazione di 
 * connessione al server, di inserire IP e PORTA del server.
 */
public class configDialog extends javax.swing.JDialog {
        
    public configDialog(java.awt.Frame parent, boolean modal,InputForm frame) {
        super(parent, modal);
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        portLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        ipLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        portLabel.setBackground(new java.awt.Color(254, 254, 254));
        portLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        portLabel.setForeground(new java.awt.Color(6, 6, 6));
        portLabel.setText("Porta:");

        titleField.setBackground(new java.awt.Color(254, 254, 254));
        titleField.setEditable(false);
        titleField.setFont(new java.awt.Font("SansSerif", 1, 12));
        titleField.setForeground(new java.awt.Color(6, 6, 6));
        titleField.setText("Inserisci i parametri di configurazione del server:");

        portField.setBackground(new java.awt.Color(254, 254, 254));
        portField.setFont(new java.awt.Font("SansSerif", 1, 12));
        portField.setForeground(new java.awt.Color(6, 6, 6));

        ipLabel.setBackground(new java.awt.Color(254, 254, 254));
        ipLabel.setFont(new java.awt.Font("SansSerif", 1, 12));
        ipLabel.setForeground(new java.awt.Color(6, 6, 6));
        ipLabel.setText("Ip:");

        ipField.setBackground(new java.awt.Color(254, 254, 254));
        ipField.setFont(new java.awt.Font("SansSerif", 1, 12));
        ipField.setForeground(new java.awt.Color(6, 6, 6));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(193, Short.MAX_VALUE)
                        .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(157, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose();
    }//GEN-LAST:event_closeDialog
/*Scriviamo un file XML con la configurazione IP PORTA in modo da non doverla richiedere al prossimo accesso*/
    //realizza il file xml di configurazione
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed


     try{
            String ip = ipField.getText();
            String port = portField.getText();
      
            fileOperation fo = new fileOperation();
            frame.setConfiguration(ip,port);
            fo.createFile("ACES");
            if(fo.getOS().equals("Windows"))
                new XML().writeXml("ACES\\config.xml", ipField.getText(), portField.getText());               
            else
                new XML().writeXml("ACES/config.xml",ipField.getText(), portField.getText());
            doClose();   
    
        }catch(NullPointerException ex){
   
            JOptionPane.showMessageDialog(null,"I dati inseriti non sono correti. Riprova." , "ACES", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){

            JOptionPane.showMessageDialog(null,"Si è riscontrato un errore." , "ACES", JOptionPane.ERROR_MESSAGE);
        }   
}//GEN-LAST:event_okButtonActionPerformed

    private void doClose() {
        setVisible(false);
        dispose();
    }

    private InputForm frame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables

}
