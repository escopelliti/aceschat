package Database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dumpQueries{
    
    public dumpQueries(Connection con){
        
        this.con = con;
    }
  
    public ArrayList dumpUserTable() throws SQLException{
        
        ArrayList userTable;
        int index;
        
        index = 0;
        userTable = new ArrayList(10000);
        query = con.prepareStatement("SELECT * FROM User");
        rs = query.executeQuery();
        
        while(rs.next()){
            index = 0;
            while(index < 5){
                userTable.add(rs.getObject(index+1));
                index++;
            }
        }        
        return userTable;
    }
    
    private ResultSet rs;
    private PreparedStatement query;
    private Connection con;
}
