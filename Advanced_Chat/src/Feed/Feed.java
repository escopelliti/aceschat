package Feed;

import java.util.ArrayList;
import java.util.List;

/*Classe che definisce i Feed*/
public class Feed {

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

    final String title;
    final List<FeedMessage> entries = new ArrayList<FeedMessage>();
}
