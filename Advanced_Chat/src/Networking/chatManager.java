package Networking;

import GUI.Message;
import User.User;
import fileManager.fileOperation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/*Vera e propria gestione dello scambio di messaggi/file tra due client/utenti*/
public class chatManager {
    
    /*Nel costruttore inizializziamo una struttura dati che ci permette di 
     * codificare le conversazioni aperte dall'utente nella sessione;
     */
    public chatManager(User user,Requests toCon){
        
        this.convList = new HashMap<String, Message>();
        this.user = user;
        this.toCon = toCon;       
    }

    /*Si occupa della messagistica e scambio file;Riconosce il pacchetto in arrivo e in base al contenuto
     * esegue parti di codice diverse che gestiscono file e messaggi in modo opportuno redirezionando gli output
     * alle finestre di conversazioni;
     */
    public void messaging(Vector mess) throws IOException{

        boolean flag;
        Object load;
        String source;
        String identifier;
        Vector participants;
        
        source = mess.get(0).toString();
        load = mess.get(1);
        participants = (Vector) mess.get(2);
        identifier = doID(participants);
        flag = isThere(identifier);//Controlliamo se una finestra per quella conversazione non sia già aperta;
      
        if(!flag){//finestra di conversazione non presente
            
            //crea una finestra e segnala che sarà presente per i prossimi messaggi
            Message conv;
            conv = new Message(this.user,participants,this.toCon);
            conv.setVisible(true);
            convList.put(identifier, conv);
            
            /*differenzia le azioni a seconda che l'oggetto inviato è un messaggio o
             * un file;
             */
            if(load.getClass().getName().equals("java.lang.String"))
                signMess(conv, source, load);           
            else              
                signFile(load, new fileOperation(), conv, source);  
            
        }else{//finestra di conversazione presente

            Message conv = convList.get(identifier);
            if(load.getClass().getName().equals("java.lang.String"))
                signMess(conv, source, load);          
            else              
                signFile(load,new fileOperation(), conv, source);           
        }
    }
    
    /*Segnaliamo che l'oggetto arrivato è un file*/
    private void signFile(Object load,fileOperation fo,Message conv,String source) throws FileNotFoundException, IOException{
        
        conv.append("Hai ricevuto un file da "+source+".");    
        fo.writeFile((File) load);
    }
    
    /*Segnaliamo che l'oggetto arrivato è un messaggio testuale e quindi va scritto nella finestra
     * di conversazione;
     */
    private void signMess(Message conv,String source,Object load) throws IOException{
        
        conv.append(load.toString());
        conv.writingFile(source,load.toString(), source);
    }
    
    /*Costruisce un identificativo unico data la lista dei partecipanti alla conversazione*/
    public String doID(Vector vect){
        
        int count = 0;
        String identifier = "";
        
        while(count < vect.size()){           
            identifier = identifier.concat((String) vect.get(count));
            count++;
        }        
        return identifier;        
    }
       
    /*Crea una nuova conversazione(in particolare rende visibile la finestra di scambio
     * messaggi) e aggiunge alla struttura che mantiene le conversazioni quella appena
     * creata;
     */
    public void start(Vector participants) throws IOException{
        
        Message conversation;
        
        conversation = new Message(this.user,participants,this.toCon);
        conversation.setVisible(true);
        setConvList(doID(participants), conversation);
        
    }
    
    private void setConvList(String identifier, Message conversation){
        convList.put(identifier, conversation);
    }
   
    private boolean isThere(String toCheck){

        if(convList.containsKey(toCheck))
            return true;
        else 
            return false;
    }

    private HashMap<String, Message> convList;
    private User user;
    private Requests toCon;
}
