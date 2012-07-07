package General;

import java.io.Serializable;

/*
 * Classe per la gestione dei pacchetti = header + payload
 */
public class Packet implements Serializable{

    private int header;
    private Object payload;


    public Packet(int header,Object payload){

        this.header = header;
        this.payload = payload;

    }
    //metodo per l'accesso a header
    public int getHeader() {
        return header;
    }

    //metodo per l'accesso al payload
    public Object getPayload() {
        return payload;
    }


}
