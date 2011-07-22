package gb.model.actions;

import java.util.Date;

import gb.model.beans.GuestbookEntry;
import gb.model.db.DatabaseException;
import gb.model.db.Guestbook;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts-Action zum Erstellen eines Gästebuch-Eintrags
 */
public class CreateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String author, text, email;
	private Date date;

	@Override
	public String execute() {
		
		Guestbook instance = Guestbook.getInstance();
		GuestbookEntry entry = new GuestbookEntry(getDate(), getAuthor(), 
				getText(), getEmail());

		try {
			//entry hinzuf�gen
			instance.addEntry(entry);
		} catch (DatabaseException e) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	private String getEmail() {
		return email;
	}

	private void setText(String text) {
		this.text = text;
	}
	
	private String getText() {
		return text;
	}

	private void setAuthor(String author) {
		this.author = author;
	}
	
	private String getAuthor() {
		return author;
	}

	private void setDate(Date date) {
		this.date = date;
	}
	
	private Date getDate() {
		return date;
	}

}
