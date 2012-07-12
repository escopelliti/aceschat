package Network;

import Database.databaseQueries;
import Database.statisticQueries;
import General.Packet;
import General.generalView;
import User.User;
import fileManager.fileOperation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*Classe che risponde alle principali esigenze del Client*/
public class Clients{
    
    
    public Clients(Socket client,serverExecutor responder,generalView gv,databaseQueries query) throws IOException{

        this.clientSocket = client;
        this.gv = gv;
        this.query = query;
        this.responder = responder;
        this.out = new ObjectOutputStream(client.getOutputStream());
        this.in = new ObjectInputStream(client.getInputStream());
        
    }
 
    public ObjectInputStream getIn(){
        
        return this.in;
    }
    
    /*Metodo per la modifica delle informazioni personali di un utente*/
    public void modifyPersonalInfo(Object payload) throws SQLException, IOException, InterruptedException{

        User new_user_info;        
        Packet response;

        new_user_info = (User) payload;
        try{  
            if(!this.query.checkUserTable(new_user_info.getIdPerson(),new_user_info.getEmail(),new_user_info.getUsername())){
                this.query.updateProfileUser(new_user_info);//aggiorniamo i dati nel Database
                response = new Packet(7, new_user_info);//rispediamo l'user e il ClientFetching lo passerà alla Home;
                this.out.writeObject(response);
                gv.enqueueEvent("L'utente "+new_user_info.getUsername()+" ha aggiornato le sue informazioni personali.");
            }else{
                response = new Packet(666, "\nAggiornamento delle informazioni personali non riuscito.\n"
                                        + "Username già utilizzato da un altro utente.");
                this.out.writeObject(response);
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Errore IO nell'aggiornamento delle info personali:\n"+ ex , "ACES", JOptionPane.ERROR_MESSAGE);
            response = new Packet(666,"Problemi tecnici. Riprova più tardi.");
            this.out.writeObject(response);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Errore SQL nell'aggiornamento delle info personali:\n"+ ex, "ACES", JOptionPane.ERROR_MESSAGE);
            response = new Packet(666,"Problemi tecnici. Riprova più tardi.");
            this.out.writeObject(response);
        }
    }
    
    /*Metodo che si occupa di inviare un mail di invito ad un utente specificato dal richiedente;
     * "Risponde" al client inviando un responso dell'operazione.
     */
    public void sendMail(Object payload) throws IOException, InterruptedException{
        
        String comunication;
        Packet response;
        Vector vect = (Vector) payload;
        
        comunication = responder.sendMail(vect);     
        response = new Packet(666, comunication);
        
        this.out.writeObject(response);
        gv.enqueueEvent("L'utente "+vect.get(0).toString()+" ha inviato un invito via mail a "+vect.get(1).toString());
    }
    
    /*Segnalazione abuso; il client invia un struttura dati contenente: 0) id di chi ha inviato l'abuso
     *  1)Username dell'"abusante"  2) testo dell'offesa
     */
    public void signAbuse(Object payload) throws SQLException, IOException{

            Vector sign = (Vector) payload;
            
            int idOffending,warning;
            Packet response;

            try{      
                idOffending = this.query.selectId(sign.get(1).toString(),"");
                if(!this.query.checkAbuse((Integer)sign.get(0),idOffending)){

                   this.query.insertAbuse((Integer)sign.get(0),idOffending,sign.get(2).toString());
                   
                   
                   warning = this.query.selectWarning(idOffending);

                   if(warning == 3){
        
                        /*Se l'utente ha 3 Warning, abbasso il suo livello;*/                      
                        this.query.downLevel(idOffending);
                   }else{
                    //aumento i warning per l'utente
                    this.query.upWarning(idOffending);
                   }
                    response = new Packet(666,"Segnalazione avvenuta con successo!");
                    this.out.writeObject(response);
                    }else{
                        response = new Packet(666, "Hai già segnalato questo utente.");
                        this.out.writeObject(response);
                    }
                }
                catch(SQLException ex){
                    
                    JOptionPane.showMessageDialog(null,"Errore SQL nell'inserimento di un Abuse:\n"+ ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
                    response = new Packet(666, "Problemi tecnici. Riprova più tardi."); 
                    this.out.writeObject(response);                                                        
                }
    }
    
    //Inviamo i messaggi per l'utente dopo aver ricevuto la richiesta di lettura di essi;
    public void getMyMess(String username) throws IOException{
        
        Vector mess;        
        mess = this.responder.getVector(username);        
        while(!mess.isEmpty())                        
            this.out.writeObject(new Packet(1,mess.remove(mess.size() - 1)));
        this.out.flush();                 
    }
    
    /*Con questo metodo aggiorniamo lo stato dell'utente*/
    public void updateStatus(Object payload) throws SQLException, InterruptedException, IOException{

            Vector info = (Vector)payload;            

       //il primo elemento del vettore sarà l'idUser che fa la richiesta;Il secondo l'id dello stato in cui vuole "andare"
            this.query.updateStatus((Integer)info.get(0), (Integer)info.get(1));
            String myUsername = this.query.selectUsername((Integer) info.get(0));
            switch((Integer) info.get(1)){ /*Per ora abbiamo codificato solo due stati Online e Offline (1 - 0)*/
             
                case 0: gv.enqueueEvent("L'utente "+myUsername+" ha effettuato il logout."); 
                        gv.removeLoggedUsers(myUsername); break;
                
            }
    }
 
     /*Richiesta di registrazione da parte di un utente*/       
     public void registerMe(Object payload) throws SQLException, IOException{

        User new_user = (User) payload;
        String response;

        try{
            if(!this.query.checkBlackList(new_user.getEmail())){
    
                if(!this.query.checkUserTable(new_user.getUsername(), new_user.getEmail())){

                    this.query.insertUser(new_user.getUsername(), new_user.getPassword(), new_user.getEmail());                    
                    new_user.setIdPerson(this.query.selectId(new_user.getUsername(),""));                    
                    this.query.insertPerson(new_user);
                    this.query.insertInterests(new_user.getIdPerson(),new_user.getInterests());
                    this.query.insertLogin(new_user.getIdPerson(), clientSocket.getInetAddress().toString());
                    this.query.insertStatus(new_user.getIdPerson(),1);
                    this.query.insertActivation(new_user.getIdPerson());
                    this.query.insertLevel(new_user.getIdPerson());                          
                    
                    this.responder.addMe(new Vector(),new_user.getUsername());                                       
                    gv.enqueueEvent("L'utente "+new_user.getUsername()+" <"+new_user.getEmail()+"> si è registrato con successo. - IP: "+new_user.getIp());
                    gv.addLoggedUsers(new_user.getUsername());
                    this.out.writeObject(new_user);
               }else{
                    response = "Username e/o email già utilizzati da un altro utente.";
                    this.out.writeObject(response);
               }
                      
            }else{
                response = "Non puoi accedere alla community.";
                this.out.writeObject(response);
            }

           
        }catch(NullPointerException ex){
            this.out.writeChars("Abbiamo dei problemi tecnici. Riprova più tardi.");
            JOptionPane.showMessageDialog(null,"Errore durante la registrazione di un utente:\n"+ ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }catch(InterruptedException ex){
            this.out.writeChars("Abbiamo dei problemi tecnici. Riprova più tardi.");
            JOptionPane.showMessageDialog(null,"Errore durante la registrazione di un utente:\n"+ ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    /*Imposta e salva l'immagine personale scelta dell'utente per il proprio profilo*/
    public void setPersonalImage(Object payload) throws FileNotFoundException, IOException, InterruptedException, SQLException{
        
        Vector imageInfo;
        Integer idUser;
        File image;
        InputStream reader;
        fileOperation fo;
           
        fo = new fileOperation();
        imageInfo = (Vector) payload;
        idUser = (Integer) imageInfo.get(0);
        image = (File) imageInfo.get(1);
        reader = new FileInputStream(image);
          
        if(fileOperation.exist("Utenti/"+idUser+"/Immagini"))
           fo.writeFile(idUser, reader);          
        else{
           fo.createFiles("Utenti/"+idUser+"/Immagini");
           fo.writeFile(idUser, reader);                
        }
            
        this.out.writeObject(new Packet(666, "Le modifiche saranno visibili al prossimo accesso."));
        gv.enqueueEvent("L'utente "+this.query.selectUsername(idUser)+" ha cambiato l'immagine personale in :"+"'"+image.getName()+"'");
    }
       
    /*Due utenti attraverso questo metodo "fanno amicizia"*/
     public void doFriendship(Object payload) throws SQLException, IOException, InterruptedException{

                Vector info = (Vector) payload;                
                Integer idUser;
                int idFriend;
                Packet response;
                
                idUser = (Integer) info.get(0);

                try{ 
                    idFriend = this.query.selectId(info.get(1).toString(), info.get(1).toString());
                    if(idFriend != -1){
                        if(!this.query.checkFriendship(idUser, idFriend)){
                            this.query.insertFriend(idUser, idFriend);
                            response = new Packet(666,"L'aggiunta dell'utente da te selezionato è avvenuta con successo!");
                            this.out.writeObject(response);
                            gv.enqueueEvent("L'utente "+this.query.selectUsername(idUser) +" ha fatto amicizia con "+info.get(1).toString());
                        }else{
                            response = new Packet(666, "L'utente è già tuo amico!");
                            this.out.writeObject(response);
                        }
                    }else{
                        response = new Packet(666,"L'username da te inserito non esiste.");
                        this.out.writeObject(response);
                    }
                }catch(IOException ex){

                    response = new Packet(666,"Servizio temporaneamente non disponibile.\n");
                    this.out.writeObject(response);
                    JOptionPane.showMessageDialog(null,"Errore IO in doFriendship:\n"+ ex, "ACES", JOptionPane.ERROR_MESSAGE);
                }
                catch(SQLException ex){

                    response = new Packet(666,"Servizio temporaneamente non disponibile.\n\nErrore:\n"+ex.getMessage());
                    this.out.writeObject(response);
                    JOptionPane.showMessageDialog(null,"Errore SQL in doFriendship:\n"+ ex, "ACES", JOptionPane.ERROR_MESSAGE);
                }
    }
    
    /*Seleziona un immagine in un cartella e ritorna un oggetto ImageIcon per esso */
    private ImageIcon getImage(int idUser) throws IOException{
        
        final String path;
        ImageIcon icon = null;
        File image;
        
        path = "Utenti/"+idUser+"/Immagini/"+idUser;
        
        if(fileOperation.exist(path)){
            
            image = new File(path);
            icon = new fileOperation().loadImage(image);
        }
        return icon;
    }
    
    /*Login all'applicazione*/
    public void logMe(Object payload) throws IOException{

        User user;
        Vector v = (Vector) payload;
        ImageIcon personalImage;
        String response;
        
        try{
            user = this.query.selectUser(v.get(0).toString(),v.get(1).toString());
            if(!this.query.checkBlackList(user.getUsername())){
                        
                if(this.query.checkActivation(user.getIdPerson())){
                            
                    user = this.query.selectPerson(user);
                    user = this.query.selectInterests(user);
                    this.query.updateStatus(user.getIdPerson(),1);
                    this.query.insertLogin(user.getIdPerson(),this.clientSocket.getInetAddress().toString());
                    
                    user.setIp(this.clientSocket.getInetAddress().toString());
                    personalImage = getImage(user.getIdPerson());
                    if(!(personalImage == null))//da modificare
                        user.setPersonalImage(personalImage);               
                    gv.enqueueEvent("L'utente "+user.getUsername()+" <"+user.getEmail()+"> ha effettuato l'accesso. - IP: "+user.getIp());
                    gv.addLoggedUsers(user.getUsername());
                    this.responder.addMe(new Vector(),user.getUsername());
                    this.out.writeObject(user); 
                }else{
                    response = "Non sei più parte della comunity.";
                    this.out.writeObject(response);                                                               
                }
                
             }else{
                response = "Non puoi più accedere alla comunity.";
                this.out.writeObject(response);
             }
             
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Errore SQL nel login:\n"+ ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
            response = "Problemi tecnici. Riprova più tardi.";
            this.out.writeObject(response);      
        }catch(NullPointerException ex){
            response = "Informazioni di Login errate.";
            this.out.writeObject(response);
        }catch(InterruptedException ex){
            JOptionPane.showMessageDialog(null,"Errore runtime:\n"+ ex, "ACES - Server", JOptionPane.ERROR_MESSAGE);
            response = "Problemi tecnici. Riprova più tardi.";
            this.out.writeObject(response); 
        }       
    }
         
    /*Restituiamo all'utente le informazioni personali di un utente*/
    public void searchFriend(String username) throws IOException, InterruptedException{
                 
        Packet packet;
        User user = new User();
        ImageIcon icon = null;

        try{
            user = this.query.selectUser(username);
            icon=getImage(user.getIdPerson());
            user.setPersonalImage(icon);
           
            packet=new Packet(8,user);
            this.out.writeObject(packet);
        }catch(IOException ex){
            
            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato IO per il cerca amico:\n"+ex , "ACES -Server", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);
        }catch(SQLException ex){
            
            packet = new Packet(666,"\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato SQL per il cerca amico:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);
        }        
    }
    
    /*Manda all'utente la lista dei suoi amici*/
    public void getFriendList(Object payload) throws IOException{

        Integer id;        
        Packet packet;
        try{
            id = (Integer) payload;
            packet = new Packet(6,this.query.selectFriends(id));
            this.out.writeObject(packet);
        }catch(IOException ex){
            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato IO per la lista amici:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);
        }catch(SQLException ex){
            packet = new Packet(666,"\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato SQL per la lista amici:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);
        }
    }
    
    /*Calcola le statistiche per l'utente che ne ha fatto richiesta*/
    public void getStatistics(int idUser) throws IOException, InterruptedException{
        
        statisticQueries stat;
        Vector statistics;
        Packet packet;  
        try{
            stat = new statisticQueries(this.query.getCon());
            statistics= new Vector();
        
            //elemento 0 = numero di amici
            statistics.add(0,stat.countFriends(idUser));
        
            //elemento 1 = numero di login
            statistics.add(1,stat.countLogin(idUser));
        
            //elemento 2 = numero di messaggi
            statistics.add(2,stat.countMessage(idUser));
        
            //elemento 3 = giorni dalla registrazione
            statistics.add(3,stat.timeInAces(idUser));
    
            packet = new Packet(9,statistics);
            this.out.writeObject(packet);
            gv.enqueueEvent("L'utente "+this.query.selectUsername(idUser)+" ha richiesto la visualizzazione di statistiche");
        }catch(SQLException ex){
            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato SQL per la generazione di statistiche:\n"+ex , "ACES", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);            
        }catch(IOException ex){
            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            JOptionPane.showMessageDialog(null,"Problema riscontrato IO per la generazione di statistiche:\n"+ex, "ACES", JOptionPane.ERROR_MESSAGE);
            this.out.writeObject(packet);           
        }
    }

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket clientSocket;
    private generalView gv;
    private serverExecutor responder;
    private databaseQueries query;
}
