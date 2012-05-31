/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;


import General.Packet;
import General.generalView;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 *
 * @author enrico
 */
public class ServerFetching extends Thread{

    private Client accepted;
    private Socket socket;
    private serverExecutor responder;



    public ServerFetching(Socket clientSocket,serverExecutor responder,generalView gv) throws IOException{

            this.socket = clientSocket;           
            this.accepted = new Client(socket,responder,gv);
            this.responder = responder;
    }



    private void fetch() throws IOException, ClassNotFoundException, SQLException, InterruptedException{

            Packet request;

            while(true){

                request = (Packet) accepted.getIn().readObject();

                switch(request.getHeader()){

                  case 0: this.accepted.registerMe(request.getPayload()); break;
                  case 1: this.accepted.doFriendship(request.getPayload()); break;
                  case 2: this.accepted.updateStatus(request.getPayload()); break;
                  case 3: this.accepted.sendMail(request.getPayload()); break;
                  case 4: this.accepted.logMe(request.getPayload());  break;
                  case 5: this.accepted.signAbuse(request.getPayload()); break;
                  case 6: this.accepted.getFriendList(request.getPayload()); break;
                  case 7: this.accepted.modifyPersonalInfo(request.getPayload()); break;
                  case 8: responder.sendMess(request.getPayload()); break;
                  case 9: this.accepted.getMyMess((String) request.getPayload()); break;
                  case 10: this.accepted.setPersonalImage(request.getPayload()); break;
/*da controllare*/case 13: this.accepted.searchFriend((String)(request.getPayload()));break;
                 // case 12: ClientToServer.createTeam(request.getPayload(),out); break;
                  case 15: this.accepted.statistic((Integer)request.getPayload());break;

            }

        }

    }
    


    @Override
     public void run(){

            try 
            {

                fetch();
            } 
            
            catch (Exception ex) 
            {

                System.out.println("Error: "+ex);
            }

     }





    }





