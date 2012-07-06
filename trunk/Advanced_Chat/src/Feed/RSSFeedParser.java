package Feed;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/*Classe che fa da Parser per i FeedRSS*/
public class RSSFeedParser {

    //Nel costruttore definiamo l'URL da cui attingeremo per i Feed;
    public RSSFeedParser(String feedUrl) {
         
        url = null;
        try{
            this.url = new URL(feedUrl);
        }catch (MalformedURLException e){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*"Parsa" i Feed eseguenza le lettura tramite XML tornando un oggetto Feed*/
    @SuppressWarnings("null")
    public Feed readFeed() {
            
        Feed feed = null;
	try{
            boolean isFeedHeader = true;
	    String title = "";
            //Creiamo un XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Imposta un eventReader
            InputStream in = read();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // Legge il documento XML grazie all'eventReader
            while (eventReader.hasNext()){

                XMLEvent event = eventReader.nextEvent();
		if (event.isStartElement()) {
                    if (event.asStartElement().getName().getLocalPart() == (ITEM)){
                                            
                        if (isFeedHeader){
                            isFeedHeader = false;
                            feed = new Feed(title);
			}
			event = eventReader.nextEvent();
			continue;
                    }

                    if (event.asStartElement().getName().getLocalPart() == (TITLE)){
                                            
                        event = eventReader.nextEvent();
			title = event.asCharacters().getData();
			continue;
                    }
                                        
		}else if (event.isEndElement()){
                                    
                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                                           
                        FeedMessage message = new FeedMessage();
			message.setTitle(title);
			feed.getMessages().add(message);
			event = eventReader.nextEvent();
        		continue;
                    }
            	}
            }
        }catch (XMLStreamException e) {
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
	}
                
        return feed;
    }

    /*Otteniamo un oggetto per poter leggere dallo stream di connessione all'URL selezionato*/
    private InputStream read(){
        try{           
            return url.openStream();
	}catch (IOException e){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
             
    private static final String TITLE = "title";
    private static final String ITEM = "item";
    private URL url;
}
