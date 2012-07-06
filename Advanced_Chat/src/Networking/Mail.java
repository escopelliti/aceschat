package Networking;

/*Classe che rappresenta le Mails*/
public class Mail {
    
    //Controlliamo se la mail è ben formata
    public static boolean checkMail(String email){

        return email.matches("^[_.0-9a-z-]+@([0-9a-z][0-9a-z-]+.)+[a-z]{2,3}$");
    }
}
