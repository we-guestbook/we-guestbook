package gb.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gb.model.beans.GuestbookEntry;
import gb.model.db.DatabaseException;
import gb.model.db.Guestbook;

/**
 * Servlet für Suche im Gästebuch
 */
public class InitServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{

	/**
	 * Gästebuchdatenbank initialisieren
	 */
	public void init() throws ServletException {
		Guestbook instance = Guestbook.getInstance();
		instance.init(getServletContext().getRealPath("/WEB-INF"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	/**
	 * Anfrage bearbeiten
	 */
	protected void handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//Parameter aus Request auslesen
		String searchText = getParameterAsString("tfSearchtext", "", request);
		String author = getParameterAsString("tfAuthor", "", request);
		
		// umwandeln in Kleinbuchstaben, für Case-Insensitive Suche
		searchText = searchText.toLowerCase();
		author = author.toLowerCase();
		
		// mind. ein Parameter wurde gesetzt; führen Suche durch
		Guestbook instance = Guestbook.getInstance();
		
		try {
			// Liste für die Suchergebnisse
			ArrayList<GuestbookEntry> result = new ArrayList<GuestbookEntry>();
			// Gästebucheinträge holen
			List<GuestbookEntry> allEntries = instance.getAllEntries();
			// Einträge durchgehen und passende raussuchen
			for (GuestbookEntry entry : allEntries) {
				if (entry.getText().toLowerCase().contains(searchText)
						&& entry.getAuthor().toLowerCase().contains(author)) {
					result.add(entry);
				}
			}
			// result an request anhängen
			request.setAttribute("result", result);
			
		} catch (DatabaseException e) {
			request.setAttribute("error", "ERROR: " + e.getMessage());
		}

		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}
	
	/**
	 * Hilfsmethode für Auslesen von String-Parametern aus Request
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
	
}
