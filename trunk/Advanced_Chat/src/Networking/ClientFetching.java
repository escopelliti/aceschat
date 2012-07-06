package Networking;

import GUI.Home;
import General.Packet;
import User.User;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;

/*Classe che si occupa dell'amministrazione/gestione delle risposte del server*/
public class ClientFetching extends Thread{

    public ClientFetching(Requests connection,Home thehome,chatManager newSession){

        this.connection = connection;
        this.thehome = thehome;
        this.newSession = newSession;
    }

    /*Thread che si occupa del "fetch delle richieste"*/
    public void run(){

        try{
            fetch();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Codice di esecuzione del Thread;
    //Aspetta le risposte sull' inputstream della socket; quando arriva un oggetto della
    //classe Packet, legge l'header del pacchetto e assegna il payload del pacchetto
    //al metodo opportuno che lo gestirà.
    private void fetch() throws IOException, ClassNotFoundException{

        Packet response;       
        while(true){
            
            response = (Packet) connection.getIn().readObject();
            switch(response.getHeader()){
               //scambio di messaggi
               case 1: this.newSession.messaging((Vector)response.getPayload()); break;
               //aggiornamento delle liste d'amici
               case 6: this.thehome.setContactList((Vector) response.getPayload()); break;
       //imposta il nuovo oggetto user come predefinito della Home dell'applicazione - usato in caso di modifiche del profilo
               case 7: this.thehome.setUser((User) response.getPayload()); break;
           //codice d'errore generico - mostra un finestra di dialogo con la stringa nel payload del Packet    
               case 666: JOptionPane.showMessageDialog(null, response.getPayload().toString(), "ACES", JOptionPane.INFORMATION_MESSAGE); break;
               //Impostiamo i componenti swing per la visualizzazione di utente "cercato"
               case 8: this.thehome.setInfoSearch((User)response.getPayload()); break;
               //Impostiamo i componenti swing per la visualizzazione delle statistiche sull'utente;
               case 9: this.thehome.setStatistic((Vector)response.getPayload());break;
            }
        }
    }

    private Requests connection;
    private chatManager newSession;
    private Home thehome;
}
