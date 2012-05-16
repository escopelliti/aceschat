/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;


import General.generalView;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Vector;


/**
 *
 * @author enrico
 */
public class Server extends Thread{

   
    public Server(generalView gv) throws IOException{
        
        this.gv = gv;
        this.server_socket = new ServerSocket(8240);        
        responder = new serverExecutor(gv);
    }


    
    
    private void acceptClient() throws IOException{

        while(true){
            Socket clientSocket = server_socket.accept();                       
            ServerFetching fetch = new ServerFetching(clientSocket,this.responder,this.gv);
            fetch.start();
        }

    }

    @Override
    public void run(){
        try{

            acceptClient();
        }
        catch(Exception ex){

            System.out.println(ex.toString());
        }
    }

 
    
    
    private ServerSocket server_socket;
    private serverExecutor responder;
    private generalView gv;
    }





