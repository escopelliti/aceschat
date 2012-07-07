package Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import General.DateTime;

/*Classe che calcola delle statistiche sull'utente che ne fa richiesta*/
public class statisticQueries {

    
    public statisticQueries(Connection con){
        
       this.con = con;
    }
    
    /*Calcoliamo da quanto tempo l'utente è registrato all'applicazione*/
    public Integer timeInAces (int idUser) throws SQLException, IOException{
       
        int dateDif;

        query = con.prepareStatement("SELECT DATEDIFF(?, (SELECT RegistrationTime FROM Activation WHERE idUser =?)) AS date_dif");
        query.setString(1,DateTime.getDateTime());
        query.setInt(2,idUser );
        rs=query.executeQuery();
        rs.next();
        
        dateDif = rs.getInt("date_dif")+1;
        return dateDif;    
        }

    /*Questo metodo ritorna il numero di login effettuati fin dalla registrazione*/
    public Integer countLogin(int IdUser) throws SQLException, IOException{

        query = con.prepareStatement("SELECT COUNT(IdUser) as NumeroLogin FROM Login WHERE idUser = ? ");
        query.setInt(1,IdUser);
        rs = query.executeQuery();
        rs.next();
       
        return rs.getInt("NumeroLogin");
    }

    /*Effettua il calcolo del numero di login in una determinata data*/
    public Integer dataCountLogin(int IdUser, String dateTime) throws SQLException, IOException{

        query = con.prepareStatement("SELECT COUNT(IdUser) AS NumeroLogin FROM Login WHERE idUser = ? AND Datetime LIKE ?");
        query.setInt(1,IdUser);
        query.setObject(2,dateTime+"%");
        rs = query.executeQuery();
        rs.next();
        
        return rs.getInt("NumeroLogin");    
        }

    /*Ritorna il numero di messaggi inviati dall'utente che ne fa richiesta.*/
    public Integer countMessage(int IdUser) throws SQLException, IOException{

        query = con.prepareStatement("SELECT COUNT(*) AS nMess FROM Chat WHERE IdSorg = ?");
        query.setInt(1,IdUser);
        rs = query.executeQuery();
        rs.next();
            
        return rs.getInt("nMess");       
    }
    
    /*Calcola il numero di amici che l'utente ha sottoscritto*/
    public Integer countFriends(int IdUser) throws SQLException, IOException{
                                
        query = con.prepareStatement("SELECT COUNT(*) AS nFriends FROM Friend WHERE IdUser = ?");
        query.setInt(1,IdUser);
        rs = query.executeQuery();
        rs.next();               
        return rs.getInt("nFriends");                         
    }
      
    /*Statistica implementata per il server; in paritolcare ritorna il numero di utente per livello(passato come argomento*/
    public int countUserByLevel(int level) throws SQLException{
        
        query = con.prepareStatement("SELECT COUNT(*) AS nUser FROM User WHERE level = ?");
        query.setInt(1, level);
        rs = query.executeQuery();
        return rs.getInt("nUser");           
    }

    private PreparedStatement query;
    private ResultSet rs;
    private Connection con;
}