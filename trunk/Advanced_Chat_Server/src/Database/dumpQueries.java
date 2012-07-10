package Database;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dumpQueries{
    
    public dumpQueries(Connection con){
        
        this.con = con;
    }
  
    public ArrayList dumpTable(String nameTable) throws SQLException{
        
        ArrayList Table;
        int index=0;
        Table = new ArrayList();
        String sql="SELECT * FROM "+ nameTable;
        
        
        query = con.prepareStatement(sql);
        rs = query.executeQuery();
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int column= rsmd.getColumnCount();
        
        while(rs.next()){
            index = 0;
            while(index < column){
                Table.add(rs.getObject(index+1));
                index++;
            }
        }        
        return Table;
    }
    
    public ArrayList dumpTable(int i) throws SQLException {
        ArrayList Table;
        int index=0;
        Table = new ArrayList();
        
         switch(i){  
             case 0 : query = con.prepareStatement("SELECT * FROM `Friend`ORDER BY `Friend`.`IdUser` ASC");break;
             case 1 : query = con.prepareStatement("SELECT * FROM `Interest`ORDER BY `Interest`.`id` ASC");break;
             case 2 : query = con.prepareStatement("SELECT * FROM `LevelDescription`ORDER BY `LevelDescription`.`id` ASC");break;    
             case 3 : query = con.prepareStatement("SELECT * FROM `StatusDescription`ORDER BY `StatusDescription`.`id` ASC");break;    

         }   
        
        rs = query.executeQuery();
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int column= rsmd.getColumnCount();
        
        while(rs.next()){
            index = 0;
            while(index < column){
                Table.add(rs.getObject(index+1));
                index++;
            }
        }    
         return Table;
    }
    
    private ResultSet rs;
    private PreparedStatement query;
    private Connection con;

    
}
