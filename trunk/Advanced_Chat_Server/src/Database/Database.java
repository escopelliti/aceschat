package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*Classe di gestione Database*/
public abstract class Database {

    //Metodo che ci permette di connetterci al DB;
    protected Connection connectDb() throws ClassNotFoundException, SQLException{
     
        Class.forName("com.mysql.jdbc.Driver");
        try{
            con = DriverManager.getConnection(credentials);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Errore di connessione al DB:"+ ex.getMessage() , "ACES", JOptionPane.ERROR_MESSAGE);
        }       
        return con;
    }

    protected Connection con;
    private static final String credentials = "jdbc:mysql://localhost:3306/AdvancedChat?user=admin&password=rLuwtnZ7DwGrLa4M";
}
