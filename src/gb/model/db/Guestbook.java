package gb.model.db;

import gb.model.beans.GuestbookEntry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Klasse die als Zugriff auf die Gaestebuch-Datenbank dient.
 * 
 */
public class Guestbook extends DataFile {

	// Private Instanz-Variable fuer das Singleton-Pattern
	private static Guestbook instance = null;

	private static final String SEPERATOR = "\\t";
	private static final String DATE_FORMAT = "dd.MM.yyyy-HH:mm:ss";
	private static final String ENCODING = "UTF-8";
	private static final int POS_DATE = 0;
	private static final int POS_AUTHOR = 1;
	private static final int POS_TEXT = 2;
	private static final int POS_EMAIL = 3;

	private String filename = null;
	private DateFormat dateFormat = null;

	/**
	 * Gibt die Instanz der G�stebuch zur�ck
	 * 
	 * @return G�stebuch-Instanz
	 */
	public static synchronized Guestbook getInstance() {
		//�berpr�fung, ob bereits Instanz vorhanden
		if (instance == null) {
			//neue Instanz holen
			instance = new Guestbook();
		}
		return instance;
	}

	/**
	 * Gibt alle Eintr�ge des G�stebuchs zur�ck.
	 * 
	 * @return alle G�stebucheintr�ge
	 */
	public ArrayList<GuestbookEntry> getAllEntries() throws DatabaseException {
		
		ArrayList<GuestbookEntry> result = new ArrayList<GuestbookEntry>();
		System.out.println("Before Read in");
		try {
			Reader in = new InputStreamReader(new FileInputStream(filename),
					ENCODING);
			BufferedReader reader = new BufferedReader(in);
			System.out.println("After Read in");
			//Daten einlesen
			while (reader.ready()) {
				String line = reader.readLine();
				
				if (line.length() > 0) {
					String[] items = line.split(SEPERATOR);
					
					if (items.length != 4) {
					    System.out.println("ITEMS ZUVIEL!");
						throw new ParseException("Wrong number of values", 0);
					}

					Date date = dateFormat.parse(items[POS_DATE]);
					String author = items[POS_AUTHOR];
					String text = items[POS_TEXT];
					String email = items[POS_EMAIL];
					
					if (email.equals("null")) {
						email = null;
					}
					GuestbookEntry entry = new GuestbookEntry(date, author,
							text, email);
					result.add(entry);
				}
			}
		} catch (FileNotFoundException e) {
		    System.out.println("File not found!");
			throw new DatabaseException("The database file " + filename
					+ " could not be found.");
		} catch (IOException e) {
		    System.out.println("IOException .... !");
			throw new DatabaseException(
					"Error while reading guestbook database:\n"
							+ e.getMessage(), e);
		} catch (ParseException e) {
		    System.out.println("ParseException ....");
			throw new DatabaseException(
					"Guestbook database is in wrong format:\n" + e.getMessage(),
					e);
		}

		// Sortiere die Eintraege noch
		Comparator<GuestbookEntry> reverseOrder = Collections.reverseOrder();
		Collections.sort(result, reverseOrder);

		return result;
	}

	/**
	 * F�gt einen neuen G�stebuch-Eintrag der Datenbank hinzu
	 * 
	 * @param entry
	 *            Der G�stebuch-Eintrag
	 * @throws DatabaseException
	 *             Wenn ein Fehler beim Zugriff auf die Datenbank auftritt.
	 */
	public void addEntry(GuestbookEntry entry) throws DatabaseException {

	    System.out.println(entry.getEmail());
	    System.out.println(entry.getText());
	    
	    
		try {
			OutputStream out = new FileOutputStream(filename, true);
			Writer writer = new OutputStreamWriter(out, ENCODING);

			String dataLine = "";
			int numValues = 4;
			for (int i = 0; i < numValues; i++) {
				switch (i) {
				case POS_AUTHOR:
					dataLine += entry.getAuthor();
					break;
				case POS_DATE:
				    System.out.println("entryDate" + entry.getDate());
				    
					dataLine += dateFormat.format(entry.getDate());
					break;
				case POS_TEXT:
					dataLine += entry.getText();
					break;
				case POS_EMAIL:
					String email = entry.getEmail();
					if (email != null && email.length() == 0) {
						email = "null";
					}
					dataLine += email;
					break;
				}
				if (i < (numValues - 1)) {
					dataLine += "\t";
				}
			}

			writer.write(dataLine + "\n");
			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {
			throw new DatabaseException("The database file " + filename
					+ " could not be found.");
		} catch (IOException e) {
			throw new DatabaseException(
					"Error while reading guestbook database:\n"
							+ e.getMessage(), e);
		}

	}

	/**
	 * Private Konstruktor wegen Singleton-Pattern
	 */
	private Guestbook() {
		dateFormat = new SimpleDateFormat(DATE_FORMAT);

	}

	public void init(String pathToWebInf) {
		Guestbook db = Guestbook.getInstance();
		if (db.filename == null) {
			db.filename = pathToWebInf + "/" + getFile();
		}
	}

	@Override
	public String getFile() {
		return "guestbook.dat";
	}

}
