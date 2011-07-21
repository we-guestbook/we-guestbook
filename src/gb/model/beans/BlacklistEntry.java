package gb.model.beans;

public class BlacklistEntry {
	private String badWord;

	public BlacklistEntry() {
		badWord = null;
	}

	public BlacklistEntry(String newBadWord) {
		badWord = newBadWord;
	}

	public String getBadWord() {
		return badWord;
	}

	public void setWord(String newBadWord) {
		badWord = newBadWord;
	}
}
