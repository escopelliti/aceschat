/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import Database.Database;
import General.Operations.Statistics;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author enrico
 */
public class Client{
    

    public Client(Socket client,serverExecutor responder,generalView gv) throws IOException{

        this.clientSocket = client;
        this.gv = gv;
        this.responder = responder;
        this.out = new ObjectOutputStream(client.getOutputStream());
        this.in = new ObjectInputStream(client.getInputStream());
        
    }


    
    public ObjectInputStream getIn(){
        
        return this.in;
    }
    
 
    
    
    public void modifyPersonalInfo(Object payload) throws SQLException, IOException, InterruptedException{

        User new_user_info;
        Connection con;
        PreparedStatement updateInfo;
        ResultSet rs;
        Packet response;

        new_user_info = (User) payload;
        con = Database.getCon();

        try{ 
        
            updateInfo = con.prepareStatement("SELECT User.IdUser FROM User WHERE User.IdUser != ? AND (User.Email = ? OR User.Username = ?)");
            updateInfo.setInt(1, new_user_info.getIdPerson());
            updateInfo.setString(2, new_user_info.getEmail());
            updateInfo.setString(3,new_user_info.getUsername());
            rs = updateInfo.executeQuery();

            if(!rs.next()){

                updateInfo = con.prepareStatement("UPDATE `AdvancedChat`.`User`,`AdvancedChat`.`Person` SET `User`.`Username`=?,"
                                            + "`User`.`Email`=?,`Name`=?, `Surname`=?,`Birthday`=?, "
                                            + "`City`=?, `Nation`=?, `Sex`=?, `Job`=? WHERE `User`.`IdUser` = ? AND"
                                            + " `Person`.`IdPerson`=?");
                updateInfo.setString(1, new_user_info.getUsername());
                updateInfo.setString(2, new_user_info.getEmail());
                updateInfo.setString(3, new_user_info.getName());
                updateInfo.setString(4, new_user_info.getSurname());
                updateInfo.setString(5, new_user_info.getBirthday());
                updateInfo.setString(6, new_user_info.getCity());
                updateInfo.setString(7, new_user_info.getNation());
                updateInfo.setString(8, new_user_info.getSex());
                updateInfo.setString(9, new_user_info.getJob());
                updateInfo.setInt(10, new_user_info.getIdPerson());
                updateInfo.setInt(11, new_user_info.getIdPerson());

                updateInfo.execute();

                response = new Packet(7, new_user_info);//rispediamo l'user e il metodo lo passerà alla Home;
                this.out.writeObject(response);
                gv.enqueueEvent("L'utente "+new_user_info.getUsername()+" ha aggiornato le sue informazioni personali.");
            }
            else{

                response = new Packet(666, "\nAggiornamento delle informazioni personali non riuscito.\n"
                                        + "Username già utilizzato da un altro utente.");

                this.out.writeObject(response);
            }
            }
        catch(IOException ex){

            response = new Packet(666,ex.getMessage());
            this.out.writeObject(response);
        }
        catch(SQLException ex){

            response = new Packet(666,ex.getMessage());
            this.out.writeObject(response);
        }
    }
    
    
    public void sendMail(Object payload) throws IOException, InterruptedException{
        
        String comunication;
        Packet response;
        Vector vect = (Vector) payload;
        
        comunication = responder.sendMail(vect);     
        response = new Packet(666, comunication);
        
        this.out.writeObject(response);
        gv.enqueueEvent("L'utente "+vect.get(0).toString()+"ha inviato un invito via mail a "+vect.get(1).toString());
    }
    
    //nel vettore arriva 0)id di chi sta segnlando 1)l'username da segnalare2)testo dell'offesa
    public void signAbuse(Object payload) throws SQLException, IOException{

            Vector sign = (Vector) payload;
            Connection con = Database.getCon();
            int idOffending,idAbuse,warning;
            PreparedStatement abuse;
            ResultSet rs;
            Packet response;

            try{
                
                abuse = con.prepareStatement("SELECT IdUser FROM `AdvancedChat`.`User` WHERE Username = ?");
                abuse.setObject(1,sign.get(1));
                rs = abuse.executeQuery();
                rs.next();
                idOffending = rs.getInt("IdUser");

                abuse = con.prepareStatement("SELECT * FROM Offense WHERE IdSender = ? AND IdOffending = ?");
                abuse.setObject(1,sign.get(0));
                abuse.setInt(2,idOffending);
                rs = abuse.executeQuery();

                if(!rs.next()){
//aggiungo in offense
                    abuse = con.prepareStatement("INSERT INTO `AdvancedChat`.`Offense` (`IdSender`,`IdOffending`) VALUES (?,?)");
                    abuse.setObject(1, sign.get(0));
                    abuse.setInt(2, idOffending);
                    abuse.execute();
//aggiungo in abuse ma prima mi serve l'idabuse
                    abuse = con.prepareStatement("SELECT IdAbuse FROM Offense WHERE IdSender = ? AND IdOffending=?");
                    abuse.setObject(1, sign.get(0));
                    abuse.setInt(2, idOffending); 
                    rs = abuse.executeQuery();
                    rs.next();
                    idAbuse = rs.getInt("IdAbuse"); 
                    abuse = con.prepareStatement("INSERT INTO `AdvancedChat`.`Abuse` () VALUES (?,?)");
                    abuse.setObject(1, idAbuse);
                    abuse.setObject(2, sign.get(2));
                    abuse.execute();
//procedimento penale
                    abuse = con.prepareStatement("SELECT Warning FROM User WHERE IdUser = ?");
                    abuse.setInt(1,idOffending);
                    rs = abuse.executeQuery();
                    rs.next();
                    warning = rs.getInt("Warning");

                    if(warning == 3){
        
                     //metodo di declassamento livello
                    responder.downLevel(idOffending);
                    
                     }
                      
                    else{
                    //devo aumentare il warning
                    responder.upWarning(idOffending);

                    }
//                        
//                    abuse = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Warning` = ? WHERE `User`.`idUser` = ?");
//                    abuse.setInt(1, (warning+1));
//                    abuse.setInt(2,idOffending);
//                    abuse.execute();
//
//                    abuse = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Level` = ? WHERE `User`.`idUser` = ?");
//                    abuse.setInt(2,(level-1));
//                    abuse.setInt(2,idOffending);
//                    abuse.execute();

                    response = new Packet(666,"Segnalazione avvenuta con successo!");
                    this.out.writeObject(response);

                    }
                else{

                    response = new Packet(666, "Hai già segnalato questo utente.");
                    this.out.writeObject(response);
                    }
                }
                catch(SQLException ex){
                    
                    System.out.println(ex.getMessage());
                    response = new Packet(666, "Problemi tecnici. Riprova più tardi."); //666 è un codice errore che nel ClientFetching
                    this.out.writeObject(response);//corrisponde ad aprire una finestra con l'errore; vale per tutti gli
                                                         //altri errori degli altri metodi;
                }

    }
    
    
    public void getMyMess(String username) throws IOException{
        
            Vector mess;
            
            mess = this.responder.getVector(username);
            while(!mess.isEmpty())
                        
                this.out.writeObject(new Packet(1,mess.remove(mess.size() - 1)));
            
            this.out.flush();     
            
    }
    
         public void updateStatus(Object payload) throws SQLException, InterruptedException, IOException{

            Vector info = (Vector)payload;
            Connection con = Database.getCon();
            PreparedStatement update;

            //il primo elemento della lista deve essere id dell'user che fa la richiesta ; il secondo lo status in cui vuole andare
            update = con.prepareStatement("UPDATE `AdvancedChat`.`Status` SET `IdStatus` = ? WHERE `Status`.`IdUser` = ?");
            update.setObject(1,info.get(1));
            update.setObject(2,info.get(0));
            update.execute();
            String myUsername = getMyUsername((Integer) info.get(0));
            switch((Integer) info.get(1)){
                
                case 0: gv.enqueueEvent("L'utente "+myUsername+" ha effettuato il logout."); 
                        gv.removeLoggedUsers(myUsername); this.clientSocket.close(); break;
                
            }

        }
 
            
     public void registerMe(Object payload) throws SQLException, IOException{

        User new_user = (User) payload;
        Connection con = Database.getCon();
        ResultSet rs;
        PreparedStatement query;
        String response;

        try{
//controllo se la email che vogli registrare è nella blacklist
            query = con.prepareStatement("SELECT Email FROM BlackList WHERE Email = ? ");
            query.setString(1, new_user.getEmail());         
            rs = query.executeQuery();

            if(!rs.next()){
//controllo se la e-mail o l'username ci sono gia in user
                query = con.prepareStatement("SELECT IdUser FROM User WHERE Username = ? OR Email = ? ");
                query.setString(1,new_user.getUsername());
                query.setString(2, new_user.getEmail());
                rs = query.executeQuery();
//inserimento dei dati      
                if(!rs.next()){

                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`User` (`Username`,`Password`,`Email`) VALUES (? , MD5(?) , ?)");
                    query.setString(1,new_user.getUsername());
                    query.setString(2,new_user.getPassword());
                    query.setString(3,new_user.getEmail());
                    query.execute();
                    
                    query = con.prepareStatement("SELECT idUser FROM User WHERE Username = ?" );
                    query.setString(1,new_user.getUsername());
                    rs = query.executeQuery();
                    rs.next();
                    new_user.setIdPerson(rs.getInt("idUser"));
                    
                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Person` (`IdPerson`,`Name`,`Surname`,`Birthday`,`City`,`Nation`,`Sex`,`Job`) VALUES (? , ? , ? , ? , ? , ? , ?, ?)");
                    query.setInt(1,new_user.getIdPerson());
                    query.setString(2,new_user.getName());
                    query.setString(3,new_user.getSurname());
                    query.setString(4,new_user.getBirthday());
                    query.setString(5,new_user.getCity());
                    query.setString(6,new_user.getNation());
                    query.setString(7,new_user.getSex());
                    query.setString(8,new_user.getJob());
                    query.execute();

                    setPersonalInterests(new_user.getInterests(),new_user.getIdPerson());

                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Login` ( `IdUser` , `Ip` ) VALUES ( ? , ? )");
                    query.setInt(1, new_user.getIdPerson());
                    query.setString(2,this.clientSocket.getInetAddress().toString());
                    query.execute();

                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Status` (`IdUser`,`IdStatus`) VALUES ( ? , ? ) ");
                    query.setInt(1,new_user.getIdPerson());
                    query.setInt(2,1);
                    query.execute();

                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Activation` (`IdUser`,`ActivationStatus`) VALUES ( ? , 1)");
                    query.setInt(1, new_user.getIdPerson());
                    query.execute();

                    query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Level` (`IdUser`,`Level`) VALUES ( ? , 1)");
                    query.setInt(1, new_user.getIdPerson());
                    query.execute();

                    
                    this.out.writeObject(new_user);
                    this.responder.addMe(new Vector(),new_user.getUsername());
                    gv.enqueueEvent("L'utente "+new_user.getUsername()+" <"+new_user.getEmail()+"> si è registrato con successo. - IP: "+new_user.getIp());
                    gv.addLoggedUsers(new_user.getUsername());
               }
               else{

                    response = "Username e/o email già utilizzati da un altro utente.";
                    this.out.writeObject(response);

                }
                      
            }
            
            else{

                response = "La e-mail da te inserita è presente nella nostra blacklist.";
                this.out.writeObject(response);
             }

           
        }
        catch(Exception ex){
            
                this.out.writeChars("Abbiamo dei problemi tecnici. Riprova più tardi.");
        }


    }
 
    
    private void setPersonalInterests(String[] personalInterests,int id) throws SQLException{

            int index = 0;
            Connection connection = Database.getCon();
            PreparedStatement query;

            query = connection.prepareStatement("INSERT INTO `AdvancedChat`.`Interest`() VALUES (?,?)");
            query.setInt(1,id);

            while(index < personalInterests.length){

                if(personalInterests[index] != null){

                    query.setString(2,personalInterests[index]);
                    query.execute();

                }

                index++;
            }

    }
    
    
    public void setPersonalImage(Object payload) throws FileNotFoundException, IOException, InterruptedException, SQLException{
        
            Vector imageInfo;
            Integer idUser;
            File image;
            InputStream reader;
            
            imageInfo = (Vector) payload;
            idUser = (Integer) imageInfo.get(0);
            image = (File) imageInfo.get(1);
            reader = new FileInputStream(image);
            
            if(fileOperation.exist("Utenti/"+idUser+"/Immagini"))
                
                fileOperation.writeFile(idUser, reader);
            
            else{
                
                fileOperation.createDirectory("Utenti/"+idUser+"/Immagini");
                fileOperation.writeFile(idUser, reader);
                
            }
            
            this.out.writeObject(new Packet(666, "Le modifiche saranno visibili al prossimo accesso."));
            gv.enqueueEvent("L'utente "+getMyUsername(idUser)+" ha cambiato l'immagine personale in :"+"'"+image.getName()+"'");
    }
    
    private String getMyUsername(int id) throws SQLException{
        
        PreparedStatement query;
        Connection con = Database.getCon();
        ResultSet rs;
        
        query = con.prepareStatement("SELECT Username FROM `AdvancedChat`.`User` WHERE IdUser = ?");
        query.setInt(1, id);
        rs = query.executeQuery();
        rs.next();
        
        return rs.getString("Username");
        
    }
        
//     ULTIMO METODO REVISIONATO :)
//    il primo elemento del vector deve essere l'id del user che fa la richiesta il secondo la email oppure l'username dell utente che vuole aggiungere;
     public void doFriendship(Object payload) throws SQLException, IOException, InterruptedException{

                Vector info = (Vector) payload;
                Connection con = Database.getCon();
                ResultSet rs;
                PreparedStatement query;
                Integer idUser;
                int IdFriend = 0;
                Packet response;
                idUser = (Integer) info.get(0);

                try{
                    
                query = con.prepareStatement("SELECT IdUser FROM User WHERE Username = ? OR Email = ?");
                query.setObject(1,info.get(1));
                query.setObject(2,info.get(1));
                rs = query.executeQuery();
                if(rs.next()){

                    IdFriend = rs.getInt(1);

                    query = con.prepareStatement("SELECT IdUser FROM Friend WHERE IdUser = ? AND IdFriend= ?");
                    query.setInt(1,idUser);
                    query.setObject(2,IdFriend);
                    rs = query.executeQuery();
                    
                   
                    if(!rs.next()){
                        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Friend` (`IdUser`,`IdFriend`) VALUES (? , ?)");
                        query.setInt(1,idUser);
                        query.setInt(2,IdFriend);
                        query.execute();
                        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Friend` (`IdUser`,`IdFriend`) VALUES (? , ?)");
                        query.setInt(1,IdFriend);
                        query.setInt(2,idUser);
                        query.execute();
                        response = new Packet(666,"L'aggiunta dell'utente da te selezionato è avvenuta con successo!");
                        this.out.writeObject(response);

                        }
                    else
                        {

                        response = new Packet(666, "L'utente è già tuo amico!");
                        this.out.writeObject(response);
                        
                        gv.enqueueEvent("L'utente "+getMyUsername(idUser) +"ha fatto amicizia con "+info.get(1).toString());

                        }
                    }
                else{

                    response = new Packet(666,"L'username da te inserito non esiste.");
                    this.out.writeObject(response);
                }
                }
                catch(IOException ex){

                    response = new Packet(666,"Servizio temporaneamente non disponibile.\n\nErrore:\n"+ex.getMessage());
                    this.out.writeObject(response);
                }
                catch(SQLException ex){

                    response = new Packet(666,"Servizio temporaneamente non disponibile.\n\nErrore:\n"+ex.getMessage());
                    this.out.writeObject(response);
                }
    }
    
   
    private ImageIcon getImage(int idUser) throws IOException{
        
        final String path;
        ImageIcon icon = null;
        File image;
        
        path = "Utenti/"+idUser+"/Immagini/"+idUser;
        
        if(fileOperation.exist(path)){
            
            image = new File(path);
            icon = fileOperation.loadImage(image);

        }
        
        return icon;
    }
    
    public void logMe(Object payload) throws SQLException, IOException{

        User user;
        Vector v = (Vector) payload;
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;
        ImageIcon personalImage;
        String response;
        String[] interests = new String[6];
        int index = 0;
        int flag = 0;
  
        query = con.prepareStatement("SELECT * FROM `User` WHERE Username = ? AND Password = ?");
        query.setObject(1, v.get(0));
        query.setObject(2, v.get(1));

        try{

            rs = query.executeQuery();

            if(rs.next()){

                user = new User();
                user.setIdPerson(rs.getInt("IdUser"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setWarning(rs.getInt("Warning"));

                query = con.prepareStatement("SELECT * FROM `BlackList` WHERE Email = ?");
                query.setString(1, user.getEmail());
                rs = query.executeQuery();

                    if(!rs.next()){
                        
                        query = con.prepareStatement("SELECT * FROM `Activation` WHERE idUser = ? AND ActivationStatus = 1");
                        query.setInt(1, user.getIdPerson());
                        rs = query.executeQuery();
               
                        if(rs.next()){
                            
                            query = con.prepareStatement("SELECT * FROM `Person` WHERE IdPerson = ?");
                            query.setInt(1, user.getIdPerson());
                            rs = query.executeQuery();
                  
                        while(rs.next()){
                            
                            user.setName(rs.getString("Name"));
                            user.setSurname(rs.getString("Surname"));
                            user.setBirthday(rs.getObject("Birthday").toString());
                            user.setCity(rs.getString("City"));
                            user.setNation(rs.getString("Nation"));
                            user.setSex(rs.getString("Sex"));
                            user.setJob(rs.getString("Job"));
                        
                        }
 
                        query = con.prepareStatement("SELECT * FROM `Interest` WHERE IdUser = ?");
                        query.setInt(1, user.getIdPerson());
                        rs = query.executeQuery();
 
                        while(rs.next()){
                                flag = 1;
                                interests[index] = rs.getString("Interests");                         
                                index++;
                             }

                        if(flag == 1)

                            user.setInterests(interests);
                        else
                            user.setInterests("Nessuno");
                

                        query = con.prepareStatement("UPDATE `AdvancedChat`.`Status` SET `IdStatus` = 1 WHERE `Status`.`IdUser` = ?");
                        query.setInt(1,user.getIdPerson());
                        query.execute();

                        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Login`(`IdUser`,`Ip`) VALUE (?,?)");
                        query.setInt(1,user.getIdPerson());
                        query.setString(2,this.clientSocket.getInetAddress().toString());
                        query.execute();

                        }
                        else{
                        
                            response = "Non sei più parte della comunity.";
                            this.out.writeObject(response);
                                                                                
                        }

                }
                else{
                 
                    response = "Non puoi più accedere alla comunity.";
                    this.out.writeObject(response);
                        
                }

                user.setIp(this.clientSocket.getInetAddress().toString());
                personalImage = getImage(user.getIdPerson());
                if(!(personalImage == null))//da modificare
                    user.setPersonalImage(personalImage);
                this.out.writeObject(user);                
                gv.enqueueEvent("L'utente "+user.getUsername()+" <"+user.getEmail()+"> ha effettuato l'accesso. - IP: "+user.getIp());
                gv.addLoggedUsers(user.getUsername());
                this.responder.addMe(new Vector(),user.getUsername());
        }

        else{
                
                response = "Informazioni di Login errate.";
                this.out.writeObject(response);
                
        }
        }

        catch(Exception ex){
        
            response = ex.toString();
            this.out.writeObject(response);
      
        }
        
    }
    

    public void searchFriend(String username) throws SQLException, IOException, InterruptedException{
            
        Connection con;
        PreparedStatement query;
        ResultSet rs;
        Packet packet;
        User user = new User();
        ImageIcon icon = null;
        int idUser;
        
        con = Database.getCon();
        
        try{
            query = con.prepareStatement("SELECT User.IdUser,Username,Name,Surname,Email,Level,City FROM `Person`,`User`,`Level` WHERE User.Username = ? AND User.IdUser = Person.IdPerson AND Level.IdUser = User.IdUser");
            query.setString(1, username);
            rs = query.executeQuery();
            
            rs.next();
                          
            user.setUsername(rs.getString("Username"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            user.setEmail(rs.getString("Email"));
            user.setLevel(rs.getInt("Level"));
            user.setCity(rs.getString("City"));
            idUser=rs.getInt("IdUser");

            icon=getImage(idUser);
            user.setPersonalImage(icon);

            packet=new Packet(8,user);

            this.out.writeObject(packet);
        }
        
        catch(IOException ex){

            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            this.out.writeObject(packet);
           }
        catch(SQLException ex){

            packet = new Packet(666,"\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            this.out.writeObject(packet);
        }

        
    }
    
    //mi faccio restituire solo la lista degli user amici 
    public void getFriendList(Object payload) throws SQLException, IOException{

        Integer id;
        Vector list;
        int i = 0;
        Connection con;
        PreparedStatement query;
        ResultSet rs;
        Packet packet;

        try{
            id = (Integer) payload;
            list = new Vector();
            con = Database.getCon();
            
//la query mi restituisce gli username degli amici di un dato id 
            query = con.prepareStatement("SELECT Username FROM User,Friend,Status WHERE Friend.IdUser = ? AND User.IdUser = Friend.IdFriend AND Friend.IdFriend = Status.IdUser AND Status.IdStatus > 0 ORDER BY Username ASC");
            query.setInt(1, id);
            rs = query.executeQuery();

            while(rs.next()){

                list.add(i,rs.getString("Username"));
                i++;
            }

            
            packet = new Packet(6,list);
            this.out.writeObject(packet);
            }

        catch(IOException ex){

            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            this.out.writeObject(packet);
           }
        catch(SQLException ex){

            packet = new Packet(666,"\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
            this.out.writeObject(packet);
        }
    }
    
    public void statistic(int idUser) throws SQLException, IOException{
        Statistics stat = new Statistics();
        Vector statistics;
        int i=0;
        Packet packet;  
    
      
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
        
    }

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket clientSocket;
    private generalView gv;
    private serverExecutor responder;
    
}
