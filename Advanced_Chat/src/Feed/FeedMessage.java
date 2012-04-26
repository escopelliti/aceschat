/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enrico
 *
*/
package Feed;


public class FeedMessage {

	String title;
	String link;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ","+" link=" + link
				+ "]";
	}

}

