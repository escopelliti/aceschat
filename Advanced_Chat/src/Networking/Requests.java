package Networking;


import GUI.Home;
import General.MD5;
import General.Packet;
import User.User;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import javax.swing.JOptionPane;

/*Con questa classe ci occupiamo delle richieste che il client inoltra al server.
 * Nel costruttore creiamo un oggetto della classe Socket che ci permette tramite lo stream di input
 * e output di comunicare col Server remoto.
 */
public class Requests {

    public Requests(String ip,String port) throws UnknownHostException, IOException{

        this.ip = ip;
        this.port = port;

        Integer n_port = new Integer(port);
        socket = new Socket(this.ip,n_port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public ObjectInputStream getIn() {
        return in;
    }
    
    public void getMess(String clientUsername) throws IOException{
        
        this.out.writeObject(new Packet(9,clientUsername));        
    }
   
    public void getFriends(int idUser) throws IOException{
        
        Packet packet;
        
        packet = new Packet(6, idUser);
        this.out.writeObject(packet);
    }   
    /*Invio di un messaggio ad un altro client;è codificata la multichat ovvero il messaggio
     * può avere più destinatari
     */
    public void send(String message,Vector receiver,String sender) throws IOException{

        Packet packet;
        Vector toSend;

        toSend = new Vector();
        toSend.add(0,sender);
        toSend.add(1,message);
        toSend.add(2,receiver);
        packet = new Packet(8,toSend);
        this.out.writeObject(packet);
    }
    /*Meccanismo che implementa l'autoregolazione della community. Un utente invia una segnalazione di abuso
     * di modo da segnalare al server che agirà di conseguenza.
     */
    public void sendAbuse(int idSender,String offense,String offender) throws IOException{
        
        Vector toSend;
        Packet packet;
        
        toSend = new Vector();
        toSend.add(0, idSender);
        toSend.add(1,offender);
        toSend.add(2, offense);
        packet = new Packet(5, toSend);
        this.out.writeObject(packet);        
    }
    /*Richiesta di registrazione di un utente; si attende la risposta del server, che in caso
     * di ammissione dell'utente alla community,rende visibile la Home dell'applicazione.
     */
    public boolean registerMe(User user) throws IOException, ClassNotFoundException{

        Packet toSend;
        Object response;

        user.setIp(socket.getLocalAddress().toString());
        toSend = new Packet(0,user);

        this.out.writeObject(toSend);

        response = this.in.readObject();

        if(response.getClass().getName().equals("java.lang.String")){

            JOptionPane.showMessageDialog(null, response.toString(), "ACES", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            user = (User) response;
            Requests toCon = new Requests(this.ip, this.port);
            new Home(toCon,user).setVisible(true);
            return true;
        }


    }
    /*Invia un'immagine scelta dall'utente per il suo profilo ACES.*/
    public void sendImage(File image,int idUser) throws IOException{
        
        Packet packet;
        Vector infoImage;
      
        infoImage = new Vector();
        infoImage.add(0,idUser);
        infoImage.add(1,image);
        packet = new Packet(10, infoImage);
        
        this.out.writeObject(packet);
  
    }
    /*Richiesta di invio di un invito ad usare l'applicazione all'indirizzo di posta selezionato*/
    public void sendMail(String sender,String mailToInvite) throws IOException{

        Packet packet;
        Vector vect;

        vect = new Vector();
        vect.add(0,sender);
        vect.add(1,mailToInvite);

        packet = new Packet(3,vect);
        this.out.writeObject(packet);
    }
    /*Invio Richiesta di login all'applicazione, in caso di avvenuta autenticazione, carica la home
     * la Home dell'applicazione e le strutture dati necessarie per il corretto funzionamento.
     */
    public boolean logMe(String username,String password) throws IOException, ClassNotFoundException, NoSuchAlgorithmException{

        Packet toSend;
        Vector info = null;
        Object response;
      
        info = new Vector();
        password = MD5.encode(password);
       
        info.add(0,username);
        info.add(1,password);
        toSend = new Packet(4, info);

        this.out.writeObject(toSend);
        response = this.in.readObject();
        if(response.getClass().getName().equals("java.lang.String")){
            JOptionPane.showMessageDialog(null, response.toString(), "ACES", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        else{
            User user_log = (User) response;
            Requests logged = new Requests(this.ip, this.port);
            new Home(logged,user_log).setVisible(true);
            return true;
        }
    }

    /*Inviamo un nuovo oggetto della classe User che comprende tutte le modifiche al profilo personale dell'utente*/
    public void modifyPersonalInfo(User user) throws IOException{

        Packet toSend;

        toSend = new Packet(7, user);

        this.out.writeObject(toSend);
    }
    /*Inviamo una richiesta al server di invio delle informazioni riguardanti l'utente
     * identificato tramite l'username.
     */
    public void searchUser(String username) throws IOException{
        
        Packet toSend;
        toSend = new Packet(13,username);
        this.out.writeObject(toSend);             
    }
    /*L'utente tramite questo metodo invia una richiesta al server al fine di aggiungere un amico alla propria
     * lista d'amici.
     */
    public void addFriend(String friend,int id) throws IOException{

        Packet toSend;
        Vector v;

        v = new Vector();
        v.add(0,id);
        v.add(1,friend);

        toSend = new Packet(1,v);

        this.out.writeObject(toSend);
    }

    /*Inviamo un file a più destinatari o ad un singolo destinario*/
    public void send(File file,Vector receiver,String sender) throws IOException{

        Packet packet;
        Vector toSend;

        toSend = new Vector();
        toSend.add(0,sender);
        toSend.add(1,file);
        toSend.add(2,receiver);//lo modificheremo in un vettore di destinatari
        packet = new Packet(8,toSend);
        this.out.writeObject(packet);
        this.out.flush();
    }
    /*Richiesta di logout dall'applicazione.*/
    public void logout(int id) throws IOException{

        Packet packet;   
        Vector toSend;
        toSend=new Vector();
        toSend.add(0,id);
        toSend.add(1,0);
        packet = new Packet(2,toSend);
        this.out.writeObject(packet);
    }
    
    public void close() throws IOException{
        
        this.socket.close();
    }
    
    /*Richiede le statistiche riguardanti l'utente fin dalla registrazione del'utente.*/
    public void getStatistics(int IdUser) throws IOException{
        
        Packet packet;
        packet = new Packet(15,IdUser);
        this.out.writeObject(packet);  
    }
       
    private String ip;
    private String port;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;    
}





