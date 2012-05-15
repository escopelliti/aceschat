/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;


import GUI.Home;
import GUI.userDialog;
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


/**
 *
 * @author enrico
 */
public class Requests {

    private String ip;
    private String port;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    

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

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ObjectOutputStream getOut() {
        return out;
    }


    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }
    
    public void getMess(String clientUsername) throws IOException{
        
        this.out.writeObject(new Packet(9,clientUsername));
        
    }

    public String getIp() {
        return ip;
    }

    
    public void getFriends(int idUser) throws IOException{
        
        Packet packet;
        
        packet = new Packet(6, idUser);
        this.out.writeObject(packet);
    }
    
    
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



    //vedere perchè mi fa quell'eccezzione cannot be cast
    //potremo evitare di rimanare l'user se è tutto ok dato che comunque è andato a buon fine..
    public boolean registerMe(User user) throws IOException, ClassNotFoundException{

        Packet toSend;
        Object response;

        user.setIp(socket.getLocalAddress().toString());
        toSend = new Packet(0,user);

        this.out.writeObject(toSend);

        response = this.in.readObject();

        if(response.getClass().getName().equals("java.lang.String")){

            new userDialog(response.toString()).setVisible(true);
            return false;
        }
        else{
            user = (User) response;
            Requests toCon = new Requests(this.ip, this.port);
            new Home(toCon,user).setVisible(true);
            return true;
        }


    }

    
    public void sendImage(File image,int idUser) throws IOException{
        
        Packet packet;
        Vector infoImage;
      
        infoImage = new Vector();
        infoImage.add(0,idUser);
        infoImage.add(1,image);
        packet = new Packet(10, infoImage);
        
        this.out.writeObject(packet);
  
    }
    

    public void sendMail(String sender,String mailToInvite) throws IOException{

        Packet packet;
        Vector vect;

        vect = new Vector();
        vect.add(0,sender);
        vect.add(1,mailToInvite);

        packet = new Packet(3,vect);
        this.out.writeObject(packet);
    }

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
            
            new userDialog(response.toString()).setVisible(true);
            return false;
        }
        else{
            
            User user_log = (User) response;
            Requests logged = new Requests(this.ip, this.port);
            new Home(logged,user_log).setVisible(true);
            return true;
        }
    }

    //unico metodo insieme a registerMe che aspetta la risposta sulla socket nello stesso posto da dove manda la richiesta
    //non c'è conflitto di altre richieste perchè sono uniche (e le prime tra l'altro);
      //questo è fatto per poter bloccare l'accesso in caso non vada a buon fine;
        //per le altre richieste non ci sono problemi di questo tipo; --> ClientFetching





    public void modifyPersonalInfo(User user) throws IOException{

        Packet toSend;

        toSend = new Packet(7, user);

        this.out.writeObject(toSend);

    }


    public void addFriend(String friend,int id) throws IOException{

        Packet toSend;
        Vector v;

        v = new Vector();
        v.add(0,id);
        v.add(1,friend);

        toSend = new Packet(1,v);

        this.out.writeObject(toSend);

    }



    
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
    
    public void logout(int id) throws IOException{

        Packet packet;   
        Vector toSend;
        
        toSend=new Vector();
        toSend.add(0,id);
        toSend.add(1,0);
        
        packet = new Packet(2,toSend);
        this.out.writeObject(packet);
    }
    
}





