package Database;

import User.User;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/*Si occupa della maggior parte delle query al Database*/
public class databaseQueries extends Database{

    public databaseQueries() throws ClassNotFoundException, SQLException{
        
        this.con = connectDb();
    }

    public Connection getCon() {
        return con;
    }

    /*Torna un oggetto Vector contenente gli amici dell'id passato come argomento*/
    public Vector selectFriends(int id) throws SQLException{
        
        Vector friends;
        int i = 0;
       
        friends = new Vector();
        //la query mi restituisce gli username degli amici di un dato id 
        query = con.prepareStatement("SELECT Username FROM User,Friend,Status WHERE Friend.IdUser = ? AND User.IdUser = Friend.IdFriend AND Friend.IdFriend = Status.IdUser AND Status.IdStatus > 0 ORDER BY Username ASC");
        query.setInt(1, id);
        rs = query.executeQuery();
        while(rs.next()){
            friends.add(i,rs.getString("Username"));
            i++;
        }
        return friends;
    }
    
    /*Controlla se due utenti sono già amici; In caso lo sono il metodo avrà come valore
     * di ritorno TRUE;
     */
    public boolean checkFriendship(int idUser,int idFriend) throws SQLException{
        
        query = con.prepareStatement("SELECT IdUser FROM Friend WHERE IdUser = ? AND IdFriend= ?");
        query.setInt(1,idUser);
        query.setObject(2,idFriend);
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Permette a due utenti di "fare amicizia"; Un utente comparirà nella lista amici dell'altro utente
     * e viceversa;
     */
    public void insertFriend(int idUser,int idFriend) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Friend` (`IdUser`,`IdFriend`) VALUES (? , ?)");
        query.setInt(1,idUser);
        query.setInt(2,idFriend);
        query.execute();
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Friend` (`IdUser`,`IdFriend`) VALUES (? , ?)");
        query.setInt(1,idFriend);
        query.setInt(2,idUser);
        query.execute();
    }
    
    /*Ottengo l'id, avendo Username o email dell'utente (UNIQUE)
     se l'utente non esiste torna -1*/
    public int selectId(String username,String email) throws SQLException{
                         
        query = con.prepareStatement("SELECT IdUser FROM User WHERE Username = ? OR Email = ?");
        query.setString(1,username);
        query.setString(2,email);
        rs=query.executeQuery();
        if(rs.next())
            return rs.getInt("IdUser");
        else return (-1);
    }
    
    /*Inserisci un abuso nelle tabelle predisposte*/
    public void insertAbuse(int idSender,int idOffending,String offense) throws SQLException{
        int idAbuse;
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Offense` (`IdSender`,`IdOffending`) VALUES (?,?)");
        query.setInt(1, idSender);
        query.setInt(2, idOffending);
        query.execute();
        
        query = con.prepareStatement("SELECT IdAbuse FROM Offense WHERE IdSender = ? AND IdOffending=?");
        query.setInt(1, idSender);
        query.setInt(2, idOffending); 
        rs = query.executeQuery();
        rs.next();
        idAbuse = rs.getInt("IdAbuse");
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Abuse` () VALUES (?,?)");
        query.setObject(1, idAbuse);
        query.setString(2, offense);
        query.execute();
    }
    
    /*Ottengo i "Warning" di un utente grazie al suo id*/
    public int selectWarning(int id) throws SQLException{
        
        query = con.prepareStatement("SELECT Warning FROM User WHERE IdUser = ?");
        query.setInt(1,id);
        rs = query.executeQuery();
        rs.next();
        return rs.getInt("Warning");
    }
    
    /*Controlla se un utente ha segnalato già un altro utente; in tal caso tornerà TRUE;*/
    public boolean checkAbuse(int idSender,int idOffending) throws SQLException{
        
        query = con.prepareStatement("SELECT * FROM Offense WHERE IdSender = ? AND IdOffending = ?");
        query.setInt(1,idSender);
        query.setInt(2,idOffending);
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Controllo se c'è gia un utente diverso da id che utilizza username e email -- per la Modifica info personali*/
    public boolean checkUserTable(int id,String email,String username) throws SQLException{
        
        query = con.prepareStatement("SELECT User.IdUser FROM User WHERE User.IdUser != ? AND (User.Email = ? OR User.Username = ?)");
        query.setInt(1, id);
        query.setString(2, email);
        query.setString(3,username);
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Aggiorna il profilo personale di un utente*/
    public void updateProfileUser(User new_user_info) throws SQLException{
        
        query = con.prepareStatement("UPDATE `AdvancedChat`.`User`,`AdvancedChat`.`Person` SET `User`.`Username`=?,"
                                            + "`User`.`Email`=?,`Name`=?, `Surname`=?,`Birthday`=?, "
                                            + "`City`=?, `Nation`=?, `Sex`=?, `Job`=? WHERE `User`.`IdUser` = ? AND"
                                            + " `Person`.`IdPerson`=?");
        query.setString(1, new_user_info.getUsername());
        query.setString(2, new_user_info.getEmail());
        query.setString(3, new_user_info.getName());
        query.setString(4, new_user_info.getSurname());
        query.setString(5, new_user_info.getBirthday());
        query.setString(6, new_user_info.getCity());
        query.setString(7, new_user_info.getNation());
        query.setString(8, new_user_info.getSex());
        query.setString(9, new_user_info.getJob());
        query.setInt(10, new_user_info.getIdPerson());
        query.setInt(11, new_user_info.getIdPerson());
        query.execute();               
    }
    
    /*Torna tutte le informazioni nella tabella User avendo username e psw*/
    public User selectUser(String username,String psw) throws SQLException{
        
        User user = null;
        
        query = con.prepareStatement("SELECT * FROM `User` WHERE Username = ? AND Password = ?");
        query.setObject(1,username);
        query.setObject(2,psw);
        rs = query.executeQuery();      
        if(rs.next()){

            user = new User();
            user.setIdPerson(rs.getInt("IdUser"));
            user.setUsername(rs.getString("Username"));
            user.setEmail(rs.getString("Email"));
            user.setWarning(rs.getInt("Warning"));
        }
        return user;
    }
    
    /*Torna tutte le informazioni personali contenuti in Person grazie all'idPerson*/
    public User selectPerson(User user) throws SQLException{

        query = con.prepareStatement("SELECT * FROM `Person` WHERE IdPerson = ?");
        query.setInt(1, user.getIdPerson());
        rs = query.executeQuery();          
        if(rs.next()){
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            user.setBirthday(rs.getObject("Birthday").toString());
            user.setCity(rs.getString("City"));
            user.setNation(rs.getString("Nation"));
            user.setSex(rs.getString("Sex"));
            user.setJob(rs.getString("Job"));                        
        }
        return user;
    }
    
    /*Inserisce nell'oggetto User gli interessi dell'utente*/
    public User selectInterests(User user) throws SQLException{
       
        String[] interests = new String[6];
        int index = 0;
        int flag = 0;
        
        query = con.prepareStatement("SELECT * FROM `Interest` WHERE id = ?");
        query.setInt(1, user.getIdPerson());
        rs = query.executeQuery();
        while(rs.next()){
            flag = 1;
            interests[index] = rs.getString("description");                         
            index++;
        }
        if(flag == 1)
           user.setInterests(interests);
        else
           user.setInterests("Nessuno");
        
        return user;
    }
    
    /*Controlla se l'utente è "attivo", ovvero se è correttamente registrato il suo account;
     * ActivationStatus ci permette di codificare la possibilità dell'utente di cancellarsi dall'applicazione;
     */
    public boolean checkActivation(int id) throws SQLException{
        
        query = con.prepareStatement("SELECT * FROM `Activation` WHERE IdUser = ? AND ActivationStatus = 1");
        query.setInt(1, id);
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Torna le informazioni personali di un utente dato l'username -- Per la funzionalità
     * "Ricerca una persona all'interno di ACES"
     */
    public User selectUser(String username) throws SQLException{
        
        User user = new User();
        
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
        user.setIdPerson(rs.getInt("IdUser"));
        return user;
    }

    /*Aggiunge i messaggi scambiati da più utenti nel Database*/
    public void addMessToDb(int idSender, String text, Vector participants, int idFile) throws SQLException{
        
        int idMess,i;
        Integer idDest;
 
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Chat` (IdSorg,Text,IdFile) VALUES (?,?,?)",1);
        query.setInt(1,idSender);
        query.setString(2,text);
        query.setInt(3,idFile);
        query.execute();
        rs=query.getGeneratedKeys();
        rs.next();
        idMess=rs.getInt(1);
                
        for(i = 0; i < participants.size(); i++){
           
            idDest = selectId(participants.get(i).toString(),"");
           
            if(idDest != idSender){
                query=con.prepareStatement("INSERT INTO `AdvancedChat`.`Conversation` () VALUES (?,?,?)");
                query.setInt(1, idSender);
                query.setInt(2, idDest);
                query.setInt(3, idMess);
                query.execute();       
            }
        }
    }
    
    /*Traccia lo scambio file tra più utenti nel Databaase*/
    public void addFileToDb(int idSender,File fileExchange, Vector participants) throws SQLException{
        
        
        PreparedStatement query;
        ResultSet rs;        
        int idFile;
        String fileMess="File Exchange";
                
        String description = fileExchange.getName() ;
            
        query=con.prepareStatement("INSERT INTO `AdvancedChat`.`File`(`Description`) VALUE (?)");
        query.setString(1,"NAME : "+ description);
        query.execute();
        rs=query.getGeneratedKeys();
        rs.next();
        idFile=rs.getInt(1);
        
        addMessToDb(idSender,fileMess, participants, idFile);       
    }
    
    /*Aumenta il numero di Warning di un utente*/
    public void upWarning(int IdUser) throws SQLException{
        
        query = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Warning` = Warning + 1 WHERE `User`.`IdUser` = ?");
        query.setInt(1,IdUser);
        query.execute();
    }
    
    /*"Declassa" di livello un utente - per esempio a seguito di un offesa fatta ad un altro utente*/
    public void downLevel(int IdUser) throws SQLException{

        int level;
        
        try{
            query = con.prepareStatement("SELECT Level FROM `Level` WHERE IdUser= ? ");
            query.setInt(1,IdUser);
            rs = query.executeQuery();    
            rs.next();
            level = rs.getInt("Level");
        
            if(level == 1)
                addToBlackList(IdUser);
            else{        
                query = con.prepareStatement("UPDATE `AdvancedChat`.`Level` SET `Level` = Level - 1 WHERE `Level`.`IdUser` = ? ");
                query.setInt(1,IdUser);
                query.execute();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Errore SQL nel downLevel - Check it:\n"+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    /*Aggiunge un utente alla BlackList dell'applicazione - una lista di persone non più desiderate
     * nella community;
     */
    public void addToBlackList(int IdUser) throws SQLException{

        String Email;
        query = con.prepareStatement("SELECT Email FROM `User` WHERE IdUser=?");
        query.setInt(1,IdUser);
        rs=query.executeQuery();
    
        rs.next();
        Email = rs.getString("Email");
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`BlackList` (Email) VALUES (?)");
        query.setString(1, Email);
        query.execute();
        disableMe(IdUser);   
    }
    
    //Imposta l'ActivationStatus = 0; vedi addToBlackList
    private void disableMe(int IdUser) throws SQLException{
        
        query=con.prepareStatement("UPDATE `AdvancedChat`.`Activation` SET `ActivationStatus` = 0 WHERE `IdUser` = ? ");
        query.setInt(1,IdUser);
        query.execute();  
    }
    
    /*Controlla se un utente che vuole accedere all'applicazione non sia nella "Lista nera" di utenti
     * non desiderati;
     */
    public boolean checkBlackList(String email) throws SQLException{
        
        query = con.prepareStatement("SELECT Email FROM BlackList WHERE Email = ? ");
        query.setString(1, email);         
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Controlla l'esistenza di un utente dati in ingresso l'username o l'email*/
    public boolean checkUserTable(String username,String email) throws SQLException{
        
        query = con.prepareStatement("SELECT IdUser FROM User WHERE Username = ? OR Email = ? ");
        query.setString(1,username);
        query.setString(2,email);
        rs = query.executeQuery();
        return rs.next();
    }
    
    /*Inserisc un nuovo user nella tabella User*/
    public void insertUser(String username,String psw,String email) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`User` (`Username`,`Password`,`Email`) VALUES (? , MD5(?) , ?)");
        query.setString(1,username);
        query.setString(2,psw);
        query.setString(3,email);
        query.execute();
    }
    
    /*Alla registrazione si inserisce una entry nella tabella Status che definisce il suo stato(online - offline)*/
    public void insertStatus(int id,int status) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Status` (`IdUser`,`IdStatus`) VALUES ( ? , ? ) ");
        query.setInt(1,id);
        query.setInt(2,status);
        query.execute();
    }
    
    /*Permette di aggiornare lo stato di un utente*/
    public void updateStatus(int id,int status) throws SQLException{
        
        query = con.prepareStatement("UPDATE `AdvancedChat`.`Status` SET `IdStatus` = ? WHERE `Status`.`IdUser` = ?");
        query.setInt(2,id);
        query.setInt(1,status);
        query.execute();
    }
    
    /*Inserisce una entry nella tabella Activation alla registrazione di un nuovo utente;
     * saprò così quando si è registrato;
     */
    public void insertActivation(int id) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Activation` (`IdUser`,`ActivationStatus`) VALUES ( ? , 1)");
        query.setInt(1, id);
        query.execute();             
    }
    
    /*Inserisce una entry nella tabella Level che codifica a quale livello appartiene l'utente alla registrazione*/
    public void insertLevel(int id) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Level` (`IdUser`,`Level`) VALUES ( ? , 1)");
        query.setInt(1, id);
        query.execute();
    }
    
    /*Inserisce gli interessi dell'utente decisi al momento della registrazione*/
    public void insertInterests(int id,String[] personalInterests) throws SQLException{
        
        int index = 0;
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Interest`() VALUES (?,?)");
        query.setInt(1,id);
        while(index < personalInterests.length){
            if(personalInterests[index] != null){
                query.setString(2,personalInterests[index]);
                query.execute();
            }

            index++;
        }
    }
    
    /*Restituisce l'username dato l'id dell'utente*/
    public String selectUsername(int id) throws SQLException{
        
        query = con.prepareStatement("SELECT Username FROM `AdvancedChat`.`User` WHERE IdUser = ?");
        query.setInt(1, id);
        rs = query.executeQuery();
        rs.next();
        return rs.getString("Username");
    }
    
    /*Inserisce un nuovo evento Login con id e IP di chi ha lo ha effettuato*/
    public void insertLogin(int id,String ip) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Login` ( `IdUser` , `Ip` ) VALUES ( ? , ? )");
        query.setInt(1,id);
        query.setString(2,ip);
        query.execute();
    }
    
    /*Inserisce informazioni personali relativi ad un utente nella tabella Person*/
    public void insertPerson(User new_user) throws SQLException{
        
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
    }
    
    private PreparedStatement query;
    private ResultSet rs;
}
