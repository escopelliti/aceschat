package Network;


import Database.databaseQueries;
import General.generalView;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JOptionPane;

/*Classe che si occupa di operazioni riguardanti più utenti;
 * ad esempio l'operazione di invio mail o di invio messaggio/file;
 */
public class serverExecutor {
    
    /*L'oggetto generalView permette di visualizzare a schermo, all'amministratore, le azioni
     * che ogni utente effettua nel tempo;
     */
    public serverExecutor(generalView gv,databaseQueries query){
        
        this.logClient = new Hashtable<String, Vector>();
        this.query = query;
        this.gv = gv;
        this.gv.setExecutor(this);        
    }
     
    /*Metodo che invia il messaggio;Il vector mess è composto da tre elementi:
     * 0: sorgente del messaggio;
     * 1: Oggetto del messaggio (file o testo);
     * 2: Destinatario/i del messaggio;
     */
    public void sendMess(Vector mess) throws InterruptedException, ClassNotFoundException, SQLException{
            
        Vector receiver;
        Vector participants;        
        int count,idSender;
        Object message;
        String source;
        
        count = 0;
        source = mess.get(0).toString();
        participants = (Vector) mess.get(2);
        message = mess.get(1);
                     
        idSender = query.selectId(source,"");
        /*Inviamo i messaggi a tutti i destinatari;
         * Prendiamo il vettore corrispondente ai vari utenti dall'HashMap e gli inseriamo l'oggetto del messaggio;
         * Successivamente questi messaggi saranno richiesti (Stimolazione da parte del Client) di modo
         * da essere recapitati a destinazione;
         */
        while(count < participants.size()){
           
            if(!source.equals(participants.get(count))){
                receiver = logClient.get(participants.get(count));        
                receiver.add(mess);
                gv.enqueueEvent("L'utente "+source+" ha inviato un messaggio/file a "+ participants.get(count).toString());
            }
            count++;
        }
        
        /*Azioni effettuate nel DB per codificare l'invio del messaggio;
         * Secondo la casistica (testo o file) intraprendiamo strade diverse,
         * codificando diversamente;
         */
        if(message.getClass().getName().equals("java.lang.String"))                                  
            query.addMessToDb(idSender,message.toString(),participants,0);
        else
            query.addFileToDb(idSender,(File)message,participants);
    }
    
    public Vector getVector(String username){
        
        return this.logClient.get(username);
    }
    
    public int selectId(String username,String email) throws SQLException{
        
        return this.query.selectId(username, email);
    }
    
    /*Aggiunge un vettore all'hashmap dei clienti loggati con chiave username;
     * in questo modo riusciremo sempre ad identificare quanti e quali sono i messaggi/file per gli utenti
     * che hanno effettuato il logina ll'applicazione
     */
    public void addMe(Vector toAdd,String username){       
        this.logClient.put(username, toAdd);
    }
    
    /*Permette all'amministratore di inserire nella blacklist un utente*/
    public void addToBlackList(int id) throws SQLException{
        
        this.query.addToBlackList(id);
    }
    
    /*Permette l'invio di una mail attraverso la classe Mail*/
    public String sendMail(Vector vect) throws IOException{
        
        Mail toSend;
        String comunication;

        toSend = new Mail(vect.get(0).toString(), vect.get(1).toString());
        try{
            toSend.start();
            comunication = "Invito inviato con successo.";
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Errore di invio Mail:"+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
            comunication = "Errore!!";
        }

        return comunication;
    }
    
    
      
    private Hashtable<String,Vector> logClient;
    private generalView gv;
    private databaseQueries query;
}
