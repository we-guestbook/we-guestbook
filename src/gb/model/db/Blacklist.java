package gb.model.db;

import gb.model.beans.BlacklistEntry;

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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Blacklist extends DataFile {
	// Private Instanz-Variable fuer das Singleton-Pattern
	private static Blacklist instance = null;

	/**
	 * Gibt die Instanz der G�stebuchDB zur�ck
	 * 
	 * @return G�stebuch-Instanz
	 */
	public static synchronized Blacklist getInstance() {
		//Überprüfung, ob bereits Instanz vorhanden
		if (instance == null) {
			//neue Instanz holen
			instance = new Blacklist();
		}
		return instance;
	}

	/**
	 * Gibt alle Einträge des Gästebuchs zurück.
	 * 
	 * @return alle Gästebucheinträge
	 */
	public List<BlacklistEntry> getAllEntries() throws DatabaseException {

		List<BlacklistEntry> result = new ArrayList<BlacklistEntry>();

		try {
			Reader in = new InputStreamReader(new FileInputStream(filename),
					ENCODING);
			BufferedReader reader = new BufferedReader(in);

			//Daten einlesen
			while (reader.ready()) {
				final String line = reader.readLine();				
				if (line.length() > 0) {
					BlacklistEntry entry = new BlacklistEntry(line);
					result.add(entry);
				}
			}
		} catch (FileNotFoundException e) {
			throw new DatabaseException("The database file " + filename
					+ " could not be found.");
		} catch (IOException e) {
			throw new DatabaseException(
					"Error while reading guestbook database:\n"
							+ e.getMessage(), e);
		} catch (ParseException e) {
			throw new DatabaseException(
					"Guestbook database is in wrong format:\n" + e.getMessage(),
					e);
		}

		return result;
	}

	/**
	 * Fügt einen neuen Gästebuch-Eintrag der Datenbank hinzu
	 * 
	 * @param entry
	 *            Der Gästebuch-Eintrag
	 * @throws DatabaseException
	 *             Wenn ein Fehler beim Zugriff auf die Datenbank auftritt.
	 */
	public void addEntry(BlacklistEntry entry) throws DatabaseException {

		try {
			OutputStream out = new FileOutputStream(filename, true);
			Writer writer = new OutputStreamWriter(out, ENCODING);
			writer.write(entry.getBadWord() + "\n");
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
	private Blacklist() {
	}

	public void init(String pathToWebInf) {
		Blacklist db = Blacklist.getInstance();
		if (db.filename == null) {
			db.filename = pathToWebInf + "/" + getFile();
		}
	}

	@Override
	public String getFile() {
		return "blacklist.dat";
	}	

}
