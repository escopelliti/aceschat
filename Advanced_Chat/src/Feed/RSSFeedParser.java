
package Feed;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {

	static final String TITLE = "title";
	static final String ITEM = "item";
        final URL url;


	public RSSFeedParser(String feedUrl) {
            
		try {
			this.url = new URL(feedUrl);
                        
		} catch (MalformedURLException e) {
                    
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("null")
	public Feed readFeed() {
		Feed feed = null;
		try {

			boolean isFeedHeader = true;
			String title = "";
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = read();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// Read the XML document
			while (eventReader.hasNext()) {

				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					if (event.asStartElement().getName().getLocalPart() == (ITEM)) {
                                            
						if (isFeedHeader) {
							isFeedHeader = false;
							feed = new Feed(title);
						}
						event = eventReader.nextEvent();
						continue;
					}

					if (event.asStartElement().getName().getLocalPart() == (TITLE)) {
                                            
						event = eventReader.nextEvent();
						title = event.asCharacters().getData();
						continue;
					}
                                        
				} else if (event.isEndElement()) {
                                    
					if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                                            
						FeedMessage message = new FeedMessage();
						message.setTitle(title);
						feed.getMessages().add(message);
						event = eventReader.nextEvent();
						continue;
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feed;

	}

	private InputStream read() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
