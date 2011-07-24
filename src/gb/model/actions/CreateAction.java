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
    private Date date = new Date();

    public String execute() {
        Guestbook database = Guestbook.getInstance();
        GuestbookEntry entry = new GuestbookEntry(getDate(), getAuthor(),
                        getText(), getEmail());

        try {
            database.addEntry(entry);
        } catch (DatabaseException e) {
            return Action.ERROR;
        }

        return Action.SUCCESS;

    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

}