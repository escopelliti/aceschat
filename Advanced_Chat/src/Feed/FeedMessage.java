package Feed;

/*Classe che definisce un messaggio Feed*/
public class FeedMessage {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }  

	@Override
    public String toString(){
	
        return "FeedMessage [title=" + title + ","+" link=" + link + "]";				
    }
        
    String title;
    String link;
}

