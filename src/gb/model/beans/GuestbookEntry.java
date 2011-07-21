package gb.model.beans;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

/**
 * Klasse, die einen Gästebucheintrag abbildet
 */
public class GuestbookEntry extends ValidatorForm implements
		Comparable<GuestbookEntry> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String author;
	private String text;
	private String email;

	public GuestbookEntry() {
		this.date = null;
		this.author = null;
		this.text = null;
		this.email = null;
		this.date = new Date();
	}

	public GuestbookEntry(Date date, String author, String text, String email) {
		this.date = date;
		this.author = author;
		this.text = text;
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author == null) {
			this.author = null;
		} else {
			try {
				this.author = new String(author.getBytes("UTF-8"), "UTF-8");
			} catch (UnsupportedEncodingException ex) {
			}
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(GuestbookEntry o) {
		Date otherDate = (o == null ? null : o.getDate());
		return this.date.compareTo(otherDate);
	}

}
