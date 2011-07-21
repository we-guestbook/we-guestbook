package gb;

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
 * Servlet f�r Suche im G�stebuch
 */
public class InitServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * G�stebuchdatenbank initialisieren
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
		
		// umwandeln in Kleinbuchstaben, f�r Case-Insensitive Suche
		searchText = searchText.toLowerCase();
		author = author.toLowerCase();
		
		// mind. ein Parameter wurde gesetzt; f�hren Suche durch
		Guestbook instance = Guestbook.getInstance();
		
		try {
			// Liste f�r die Suchergebnisse
			ArrayList<GuestbookEntry> result = new ArrayList<GuestbookEntry>();
			// G�stebucheintr�ge holen
			List<GuestbookEntry> allEntries = instance.getAllEntries();
			// Eintr�ge durchgehen und passende raussuchen
			for (GuestbookEntry entry : allEntries) {
				if (entry.getText().toLowerCase().contains(searchText)
						&& entry.getAuthor().toLowerCase().contains(author)) {
					result.add(entry);
				}
			}
			// result an request anh�ngen
			request.setAttribute("result", result);
			
		} catch (DatabaseException e) {
			request.setAttribute("error", "ERROR: " + e.getMessage());
		}

		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}
	
	/**
	 * Hilfsmethode f�r Auslesen von String-Parametern aus Request
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
