package General.Operations;

import Database.Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import General.DateTime;
import General.Packet;


public class Statistics {


//    Questo metodo effettua la differenza tra la data di registrazione e quella attuale
    public Integer timeInAces (int idUser) throws SQLException, IOException{

        Connection con = Database.getCon();
        ResultSet rs;
        Packet packet;
        int dateDif;
     
        PreparedStatement count = con.prepareStatement("SELECT DATEDIFF(?, (SELECT RegistrationTime FROM Activation WHERE idUser =?)) AS date_dif");
        count.setString(1,DateTime.getDateTime());
        count.setInt(2,idUser );
        rs=count.executeQuery();
        return dateDif= rs.getInt("date_dif");
    
        }


        //Questo metodo calcola quanti login ha fatto l'utente
//Vuole passato come parametro l'id dell'utente di cui si deve fare il calcolo
    public Integer countLogin(int IdUser) throws SQLException, IOException{

        Connection con = Database.getCon();
        ResultSet rs;
        Packet packet;
        int nLogin;
   
    
        PreparedStatement count = con.prepareStatement("SELECT COUNT(IdUser) as NumeroLogin FROM Login WHERE idUser = ? ");
        count.setInt(1,IdUser);
        rs = count.executeQuery();
        rs.next();
       
        return nLogin=rs.getInt("NumeroLogin");
     
    
}

//Questo metodo calcola quanti login ha fatto l'utente in un determinata data
//Vuole passato un vettore in cui il primo elemento è l'id del tizio, e il secondo invece è la data da controllare
    public Integer dataCountLogin(int IdUser, String dateTime) throws SQLException, IOException{

        Connection con = Database.getCon();
        ResultSet rs;
        Packet packet;
        PreparedStatement count;
        int nLogin;
   
        count = con.prepareStatement("SELECT COUNT(IdUser) AS NumeroLogin FROM Login WHERE idUser = ? AND Datetime LIKE ?");
        count.setInt(1,IdUser);
        count.setObject(2,dateTime+"%");
        rs = count.executeQuery();
        rs.next();
        
        return nLogin=rs.getInt("NumeroLogin");
     
        }


      public Integer countMessage(int IdUser) throws SQLException, IOException{

        Connection con = Database.getCon();
        ResultSet rs;
        Packet packet;
        int nMess;

        PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nMess FROM Chat WHERE IdSorg = ?");
        count.setInt(1,IdUser);
        rs=count.executeQuery();
        rs.next();
            
        return nMess=rs.getInt("nMess");
        
    }
    
       public Integer countFriends(int IdUser) throws SQLException, IOException{
           
           Connection con = Database.getCon();  
           ResultSet rs;
           Packet packet;
           int nFriends;
           
                PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nFriends FROM Friend WHERE IdUser = ?");
                count.setInt(1,IdUser);
                rs=count.executeQuery();
                rs.next();
         
                return nFriends=rs.getInt("nFriends");
                   
       }
      
      
      
//Statistiche calcolate per il server
    public static int countUserByLevel(int level) throws SQLException{
            Connection con = Database.getCon();
            ResultSet rs;

            PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nUser FROM User WHERE level = ?");
            count.setInt(1, level);
            rs=count.executeQuery();
            int nUser= (rs.getInt("nUser"));
            return nUser;
        }

}