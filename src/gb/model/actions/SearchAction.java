package gb.model.actions;

import java.util.ArrayList;
import java.util.List;

import gb.model.beans.GuestbookEntry;
import gb.model.db.DatabaseException;
import gb.model.db.Guestbook;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements ServletRequestAware {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String searchText;
	private String author;
	
	@Override
	public String execute() throws Exception {
		
		String searchText;
		String author;
		
		// Umwandlung in Kleinbuchstaben; für Case-Insensitive Suche
		if(getSearchText() != null) {
			searchText = getSearchText().toLowerCase();
		} else {
			searchText = "";
		}
		
		if(getAuthor() != null) {
			author = getAuthor().toLowerCase();
		} else {
			author = "";
		}

		// mind. ein Parameter wurde gesetzt; fÃ¼hren Suche durch
		Guestbook instance = Guestbook.getInstance();
		try {
			ArrayList<GuestbookEntry> searchResult = new ArrayList<GuestbookEntry>();
			List<GuestbookEntry> allEntries = instance.getAllEntries();
			
			// Einträge durchschauen und zur Suchanfrage passende herausfinden
			for (GuestbookEntry entry : allEntries) {
				if (entry.getText().toLowerCase().contains(searchText)
						&& entry.getAuthor().toLowerCase().contains(author)) {
					searchResult.add(entry);
				}
			}
			request.setAttribute("result", searchResult);
			return Action.SUCCESS;
			
		} catch (DatabaseException e) {
			return Action.ERROR;
		}
		
		
	}

	/**
	 * Hilfsmethode zum Auslesen von String-Parametern aus dem Request
	 */
	protected String getParameterAsString(String name, String defaultValue,
			HttpServletRequest request) {
		String value = request.getParameter(name);
		if (value == null) {
			value = defaultValue;
		}
		value = value.trim();
		return value;
	}

	@Override
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
