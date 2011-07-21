package gb.model.db;

public abstract class DataFile {

	protected abstract String getFile();

	protected static final String SEPERATOR = "\\t";
	protected static final String DATE_FORMAT = "dd.MM.yyyy-HH:mm:ss";
	protected static final String ENCODING = "UTF-8";
	protected static final int POS_DATE = 0;
	protected static final int POS_AUTHOR = 1;
	protected static final int POS_TEXT = 2;
	protected static final int POS_EMAIL = 3;

	protected String filename = null;
}
