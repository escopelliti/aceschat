/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author enrico
 */
//SERVER:
//classe per la connessione al DB o per la creazione di un pool di connessione a esso --> DA DISCUTERE E COMPLETARE
public class Database {

    private static Connection con = null;
    private static final String credentials = "jdbc:mysql://localhost:3306/AdvancedChat?user=admin&password=rLuwtnZ7DwGrLa4M";

    //ci connettiamo al DB e torniamo un oggetto Connessione per poter creare statement e altro;
    public static void connectDb() throws ClassNotFoundException, SQLException{

        
        Class.forName("com.mysql.jdbc.Driver");
        try{
            con = DriverManager.getConnection(credentials);
        }
        catch(SQLException ex){
            System.out.println("Errore di connessione al DB: "+ex);
        }       
        
    }

    public static Connection getCon() {
        return con;
    }


    


}
