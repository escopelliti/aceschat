/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package General;

import java.io.Serializable;

/**
 *
 * @author enrico
 */
public class Packet implements Serializable{

    private int header;
    private Object payload;


    public Packet(int header,Object payload){

        this.header = header;
        this.payload = payload;

    }

    public int getHeader() {
        return header;
    }

    public Object getPayload() {
        return payload;
    }


}
