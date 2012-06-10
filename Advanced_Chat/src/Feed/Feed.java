/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enrico
 */
package Feed;


import java.util.ArrayList;
import java.util.List;


public class Feed {

	final String title;
	final List<FeedMessage> entries = new ArrayList<FeedMessage>();

	public Feed(String title) {
            
            this.title = title;		
	}

	public List<FeedMessage> getMessages() {
            
            return entries;
	}

	public String getTitle() {
            
            return title;
	}

	@Override
	public String toString() {
		return "Feed [title=" + title + "]";
	}

}
