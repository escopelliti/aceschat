package Database;

import User.User;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;


public class databaseQueries extends Database{

    public databaseQueries() throws ClassNotFoundException, SQLException{
        
        this.con = connectDb();
    }
    
    public int selectId(String username) throws SQLException{
                
        int id;        
        query=con.prepareStatement("SELECT IdUser FROM User WHERE username = ?");
        query.setString(1,username);
        rs=query.executeQuery();
        rs.next();
        id=rs.getInt("IdUser");
        return id;
    }
    

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
           
            idDest = selectId(participants.get(i).toString());
           
            if(idDest != idSender){
                query=con.prepareStatement("INSERT INTO `AdvancedChat`.`Conversation` () VALUES (?,?,?)");
                query.setInt(1, idSender);
                query.setInt(2, idDest);
                query.setInt(3, idMess);
                query.execute();       
            }
        }
    }
        
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
    
    public void upWarning(int IdUser) throws SQLException{
        
        query = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Warning` = Warning + 1 WHERE `User`.`IdUser` = ?");
        query.setInt(1,IdUser);
        query.execute();
    }
    
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
    
    private void disableMe(int IdUser) throws SQLException{
        
        query=con.prepareStatement("UPDATE `AdvancedChat`.`Activation` SET `ActivationStatus` = 0 WHERE `IdUser` = ? ");
        query.setInt(1,IdUser);
        query.execute();  
    }
    
    public boolean checkBlackList(String email) throws SQLException{
        
        query = con.prepareStatement("SELECT Email FROM BlackList WHERE Email = ? ");
        query.setString(1, email);         
        rs = query.executeQuery();
        return rs.next();
    }
    
    public boolean checkUserTable(String username,String email) throws SQLException{
        
        query = con.prepareStatement("SELECT IdUser FROM User WHERE Username = ? OR Email = ? ");
        query.setString(1,username);
        query.setString(2,email);
        rs = query.executeQuery();
        return rs.next();
    }
    
    public void insertUser(String username,String psw,String email) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`User` (`Username`,`Password`,`Email`) VALUES (? , MD5(?) , ?)");
        query.setString(1,username);
        query.setString(2,psw);
        query.setString(3,email);
        query.execute();
    }
    
    public void insertStatus(int id) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Status` (`IdUser`,`IdStatus`) VALUES ( ? , ? ) ");
        query.setInt(1,id);
        query.setInt(2,1);
        query.execute();
    }
    
    public void insertActivation(int id) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Activation` (`IdUser`,`ActivationStatus`) VALUES ( ? , 1)");
        query.setInt(1, id);
        query.execute();             
    }
    
    public void insertLevel(int id) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Level` (`IdUser`,`Level`) VALUES ( ? , 1)");
        query.setInt(1, id);
        query.execute();
    }
    
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
    
    public String selectUsername(int id) throws SQLException{
        
        query = con.prepareStatement("SELECT Username FROM `AdvancedChat`.`User` WHERE IdUser = ?");
        query.setInt(1, id);
        rs = query.executeQuery();
        rs.next();
        return rs.getString("Username");
    }
    
    
    public void insertLogin(int id,String ip) throws SQLException{
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Login` ( `IdUser` , `Ip` ) VALUES ( ? , ? )");
        query.setInt(1,id);
        query.setString(2,ip);
        query.execute();
    }
    
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
