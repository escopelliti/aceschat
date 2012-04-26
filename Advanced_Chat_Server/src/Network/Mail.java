/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author enrico
 */
public class Mail extends Thread{

    final String link = "http://www.projectnotesmore.blogspot.com/";
    final String admin = "teamprojectinfo@gmail.com";
    private String sender;//username
    private String receiver;//indirizzo
    private String mex;
    private String subject;
    final String std_subj = "vuole invitarti ad usare Advanced Chat Easy Service.";
    final String smtp = "stmp.tiscali.it";
    final String std_mex = "vuole invitarti ad usare Advanced Chat Easy Service.\nACES ti permette di restare sempre "
            + "in contatto con i tuoi amici e conoscenti in modo semplice e divertente.\nComincia ad usare ACES,"
            + "scaricalo a questo link: "+link;


    public Mail(String sender,String receiver,String subject,String mex){

        this.sender = sender;
        this.receiver = receiver;
        this.mex = sender.concat(" "+mex);
        this.subject = subject;
    }

    public Mail(String sender,String receiver){

        this.sender = sender;
        this.receiver = receiver;
        this.mex = sender.concat(" "+std_mex);
        this.subject = sender.concat(" "+std_subj);
    }

    public String getMex() {
        return mex;
    }

    public String getSmtp() {
        return smtp;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }


  
    @Override
    public void run(){
        try {
            sendMail();
        } catch (Exception ex) {
            System.out.println("Error: "+ex);;
        

    }
    }


    private void sendMail() throws UnknownHostException, IOException, MessagingException{

            //settiamo le proprietà del sistema ospitante per poter permettere l'invio della mail: smtp,porta
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");//protocollo
            props.setProperty("mail.host", "smtp.gmail.com");//host
            props.put("mail.smtp.auth", "true");//autenticazione
            props.put("mail.smtp.port", "465");//porta
            props.put("mail.smtp.socketFactory.port", "465");//porta
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.quitwait", "false");

            //autenticazione sul host;
            Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("teamprojectinfo@gmail.com","ramadaletitbe");
            }
            });

            //creiamo il messaggio da inviare
            MimeMessage message = new MimeMessage(session);
            message.setSubject(getSubject());
            message.setText(getMex());

            //settiamo mittente e destinatario
            InternetAddress fromAddress = new InternetAddress(admin);
            InternetAddress toAddress = new InternetAddress(getReceiver());
            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // inviamo la mail
            Transport.send(message);



    }



    public static boolean checkMail(String email){

        Pattern x = Pattern.compile("^\\S+@\\S+$");
        Matcher matcher = x.matcher(email);

        if(matcher.find()){
            //qui ci va il metodo del network che se va a buon fine(cioè la mail è unica e non è nella black list)
            //allora ritorniamo vero cioè possiamo completare la registrazione
            return true;
        }

        return false;



    }









}
