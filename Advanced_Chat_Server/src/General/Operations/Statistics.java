package General.Operations;

import Database.Database;
import User.User;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import General.DateTime;
import java.util.Vector;


public class Statistics {


    //Questo metodo effettua la differenza tra la data di registrazione e quella attuale e promuove direttamente l'utente al suo livello
    public static void Promotion (Object Payload,ObjectOutputStream out) throws SQLException{

        Integer id = (Integer) Payload;
        Connection con = Database.getCon();
        ResultSet rs;
        PreparedStatement count = con.prepareStatement("SELECT DATEDIFF( ? , (SELECT RegistrationTime FROM Activations WHERE idUser =?)) AS Level");
        count.setString(1,DateTime.getDate());
        count.setInt(2,id );
        rs=count.executeQuery();
        int dlevel= (rs.getInt("Level"));

        if(dlevel>30)
        {
            if (dlevel<70){
                PreparedStatement up = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Level` = 2 WHERE `Status`.`idUser` = ?");
                up.setInt(1, id);
                up.execute();
            }

            else{
                PreparedStatement up = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Level` = 3 WHERE `Status`.`idUser` = ?");
                up.setInt(1, id);
                up.execute();


            }
        }
    }


        //Questo metodo calcola quanti login ha fatto l'utente
//Vuole passato come parametro l'id dell'utente di cui si deve fare il calcolo
    public static void countLogin(Object payload, ObjectOutputStream out ) throws SQLException, IOException{

        Connection con = Database.getCon();
        Integer id = (Integer) payload;
        ResultSet rs;
        PreparedStatement count;

        count = con.prepareStatement("SELECT count(idUser) as NumeroLogin FROM Login WHERE idUser = ? ");
        count.setInt(1,id );
        rs = count.executeQuery();
        rs.next();
        out.writeInt(rs.getInt(1));

}

//Questo metodo calcola quanti login ha fatto l'utente in un determinata data
//Vuole passato un vettore in cui il primo elemento è l'id del tizio, e il secondo invece è la data da controllare
    public static void dataCountLogin(Object payload,ObjectOutputStream out) throws SQLException, IOException{

        Vector list = (Vector)payload;
        Connection con = Database.getCon();
        ResultSet rs;
        PreparedStatement count;

        count = con.prepareStatement("SELECT count( idUser ) AS NumeroLogin FROM Login WHERE idUser = ? AND Datetime LIKE ?");
        count.setObject(1,list.get(0));
        count.setObject(2,list.get(1)+"%");
        rs = count.executeQuery();
        rs.next();
        out.writeInt(rs.getInt(1));

}



//non lo faccio via socket perchè queste sono operazioni che faccio sul server e i dati delle query li analizzo solo sul server
    public static int countUserByLevel(int level) throws SQLException{
            Connection con = Database.getCon();
            ResultSet rs;

            PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nUser FROM User WHERE level = ?");
            count.setInt(1, level);
            rs=count.executeQuery();
            int nUser= (rs.getInt("nUser"));
            return nUser;
        }

    
    public static void countMessage(Object Payload,ObjectOutputStream out) throws SQLException, IOException{
            Integer id = (Integer) Payload;
            Connection con = Database.getCon();
            ResultSet rs;
            PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nMess FROM ChatMultichat WHERE IdWriter = ?");
            count.setInt(1,id);
            rs=count.executeQuery();
            rs.next();
            out.write(rs.getInt(1));

            
    }

//metodo che restituisce un user ricercato via username
    public static void findUser(Object payload,ObjectOutputStream out ) throws SQLException, IOException{
        User user =null;
        String  username= (String)payload;
        Connection con = Database.getCon();

        PreparedStatement query = con.prepareStatement("SELECT idUser,Username,Email,Warning,Level,Name,Surname,Birthday,City,Nation,Sex,Job FROM User,Person WHERE Username = ? AND idUser=idPerson");
        query.setObject(1, username);
        ResultSet rs = query.executeQuery();

         if(rs.next()){

                user.setIdPerson(rs.getInt("idUser"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setWarning(rs.getInt("Warning"));
                user.setLevel(rs.getInt("Level"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setBirthday(rs.getString("Birthday"));
                user.setCity(rs.getString("City"));
                user.setNation(rs.getString("Nation"));
                user.setSex(rs.getString("Sex"));
                user.setJob(rs.getString("Job"));

                query = con.prepareStatement("SELECT * FROM `Interests` WHERE idUser = ?");
                query.setInt(1, user.getIdPerson());
                rs = query.executeQuery();

                if(rs.next()){

                    while(rs.next()){

                        user.setInterests(rs.getString("Interests"));

                    }

                }

                else{

                    user.setInterests("Nessuno");

                }

          out.writeObject(user);

         }

        
        else{
               out.writeChars("L'username inserito non esiste.");
        }
    }


    public static void countTeamCreated(Object payload,ObjectOutputStream out) throws SQLException, IOException{

        Integer id = (Integer) payload;
        Connection con = Database.getCon();
        ResultSet rs;
        PreparedStatement count = con.prepareStatement("SELECT COUNT(*) AS nTeam FROM `AdvancedChat`.`Team` WHERE IdFounder = ?");
        count.setInt(1,id);
        rs=count.executeQuery();
        rs.next();
        out.writeInt(rs.getInt(1));

    }

}