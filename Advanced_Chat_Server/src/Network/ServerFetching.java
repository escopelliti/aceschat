package Network;

import Database.databaseQueries;
import General.Packet;
import General.generalView;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JOptionPane;

/*Un oggetto di questa classe si occupa in maniera parallela di soddisfare tutte le
 * richieste arrivate dal Client e predisporre metodi e coerenti comportamenti
 * a seconda dell'azione richiesta.
 */
public class ServerFetching extends Thread{

    /*Costruttore con Socket su cui "ascoltiamo", serverExecutor per interazioni con altri utenti e generalView
     * per poter visualizzare gli eventi a schermo.
     */
    public ServerFetching(Socket clientSocket,generalView gv,databaseQueries query) throws IOException{

            this.socket = clientSocket;           
            this.accepted = new Clients(socket,responder,gv,query);
            this.responder = responder;
    }

    /*Fetching delle richieste da parte dell'utente*/
    private void fetch() throws IOException, ClassNotFoundException, SQLException, InterruptedException{

            Packet request;

            while(true){

                request = (Packet) accepted.getIn().readObject();

                switch(request.getHeader()){
                    //Richiesta registrazione
                  case 0: this.accepted.registerMe(request.getPayload()); break;
                    //Richiesta di amicizia  
                  case 1: this.accepted.doFriendship(request.getPayload()); break;
                    //Richiesta di logout o aggiornamento stato  
                  case 2: this.accepted.updateStatus(request.getPayload());break;
                    //Richiesta di invio mail d'invito  
                  case 3: this.accepted.sendMail(request.getPayload()); break;
                    //Richiesta di Login
                  case 4: this.accepted.logMe(request.getPayload());  break;
                    //Richiesta di segnalazione abuso  
                  case 5: this.accepted.signAbuse(request.getPayload()); break;
                    //Richiesta della lista amici  
                  case 6: this.accepted.getFriendList(request.getPayload()); break;
                    //Richiesta di modifica informazioni personali  
                  case 7: this.accepted.modifyPersonalInfo(request.getPayload()); break;
                    //Richiesta di invio messaggi  
                  case 8: responder.sendMess((Vector) request.getPayload()); break;
                    //Richiesta di lettura dei messaggi  
                  case 9: this.accepted.getMyMess((String) request.getPayload()); break;
                    //Richiesta di impostazione immagine del profilo  
                  case 10: this.accepted.setPersonalImage(request.getPayload()); break;
                    //Richiesta di ricerca amico 
                  case 13: this.accepted.searchFriend((String)(request.getPayload()));break;
                     //Richiesta di generazione statistiche   
                  case 15: this.accepted.statistic((Integer)request.getPayload());break;
                      
                }
            }
    }
    
    //Codice di esecuzione del Thread di Fetching che rimane sempre in ascolto di richieste da parte del Client;
    @Override
     public void run(){

            try{
                fetch();
            }catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null,"Errore caricamento classe. Check it: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);    
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Errore nella ricezione dei pacchetti: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Errore SQL: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }catch(InterruptedException ex){
                JOptionPane.showMessageDialog(null,"Errore runtime col thread di fetcing: "+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            }
     }

    private Clients accepted;
    private Socket socket;
    private serverExecutor responder;

}





