package gb.model.actions;

import java.util.Date;

import guestbook.model.beans.GuestbookEntry;
import guestbook.model.db.DatabaseException;
import guestbook.model.db.GuestbookDB;

import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Struts-Action zum Erstellen eines Gaestebuch-Eintrags
 */
public class CreateAction extends ActionSupport {

	private String author, text, email;
	private Date date;

	@Override
	public String execute() {
		
		GuestbookDB instance = GuestbookDB.getInstance();
		GuestbookEntry entry = new GuestbookEntry(getDate(), getAuthor(), 
				getText(), getEmail());

		try {
			//entry hinzufügen
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
