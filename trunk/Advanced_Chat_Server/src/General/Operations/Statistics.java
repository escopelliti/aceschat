package General.Operations;

import Database.Database;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import General.DateTime;

/*Classe che calcola delle statistiche sull'utente che ne fa richiesta*/
public class Statistics {

    
    public Statistics(){
        
        this.con = Database.getCon();
    }
    /*Calcoliamo da quanto tempo l'utente è registrato all'applicazione*/
    public Integer timeInAces (int idUser) throws SQLException, IOException{
       
        ResultSet rs;
        int dateDif;
        PreparedStatement count;
     
        count = con.prepareStatement("SELECT DATEDIFF(?, (SELECT RegistrationTime FROM Activation WHERE idUser =?)) AS date_dif");
        count.setString(1,DateTime.getDateTime());
        count.setInt(2,idUser );
        rs=count.executeQuery();
        rs.next();       
        dateDif = rs.getInt("date_dif")+1;
        return dateDif;    
        }

    /*Questo metodo ritorna il numero di login effettuati fin dalla registrazione*/
    public Integer countLogin(int IdUser) throws SQLException, IOException{

        ResultSet rs;
        PreparedStatement count;
   
        count = con.prepareStatement("SELECT COUNT(IdUser) as NumeroLogin FROM Login WHERE idUser = ? ");
        count.setInt(1,IdUser);
        rs = count.executeQuery();
        rs.next();
       
        return rs.getInt("NumeroLogin");
    }

    /*Effettua il calcolo del numero di login in una determinata data*/
    public Integer dataCountLogin(int IdUser, String dateTime) throws SQLException, IOException{

        ResultSet rs;
        PreparedStatement count;
   
        count = con.prepareStatement("SELECT COUNT(IdUser) AS NumeroLogin FROM Login WHERE idUser = ? AND Datetime LIKE ?");
        count.setInt(1,IdUser);
        count.setObject(2,dateTime+"%");
        rs = count.executeQuery();
        rs.next();
        
        return rs.getInt("NumeroLogin");    
        }

    /*Ritorna il numero di messaggi inviati dall'utente che ne fa richiesta.*/
    public Integer countMessage(int IdUser) throws SQLException, IOException{

        ResultSet rs;

        PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nMess FROM Chat WHERE IdSorg = ?");
        count.setInt(1,IdUser);
        rs=count.executeQuery();
        rs.next();
            
        return rs.getInt("nMess");       
    }
    
    /*Calcola il numero di amici che l'utente ha sottoscritto*/
    public Integer countFriends(int IdUser) throws SQLException, IOException{
                      
           ResultSet rs;
           int nFriends;
           PreparedStatement count;
                    
           count = con.prepareStatement("SELECT COUNT(*) AS nFriends FROM Friend WHERE IdUser = ?");
           count.setInt(1,IdUser);
           rs=count.executeQuery();
           rs.next();               
           nFriends=rs.getInt("nFriends");  
           return nFriends;                   
       }
      
    /*Statistica implementato per il server; in paritolcare ritorna il numero di utente per livello(passato come argomento*/
    public int countUserByLevel(int level) throws SQLException{
        
            ResultSet rs;

            PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nUser FROM User WHERE level = ?");
            count.setInt(1, level);
            rs=count.executeQuery();
            int nUser= (rs.getInt("nUser"));
            return nUser;
        }

    private Connection con;
}