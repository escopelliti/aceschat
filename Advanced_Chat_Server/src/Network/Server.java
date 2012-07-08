package Network;

import Database.databaseQueries;
import General.generalView;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/*Classe server che apre una serverSocket sulla porta 8240 e accetta nuove connessione dai client*/
public class Server extends Thread{

    /*nel costruttore instanziamo un oggetto serverExecutor per le interazioni tra le socket
     * "accettate" e quindi tra i client
     */
    public Server(generalView gv,databaseQueries query) throws IOException{
        
        this.gv = gv;
        this.server_socket = new ServerSocket(8240);
        this.query = query;
        responder = new serverExecutor(gv,query);
    }

    
    /*Si crea un thread per utente che è pronto in qualsiasi in momento(in ascolto sull'input stream della socket)
     * a soddisfare le richieste (fetching)
     */
    private void acceptClient() throws IOException{

        while(true){
            Socket clientSocket = server_socket.accept();                       
            ServerFetching fetch = new ServerFetching(clientSocket,this.gv,this.query,this.responder);
            fetch.start();
        }
    }

    @Override
    public void run(){
        try{
            acceptClient();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Errore di connessione: "+ ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ServerSocket server_socket;
    protected serverExecutor responder;
    protected generalView gv;
    protected databaseQueries query; 
    }






