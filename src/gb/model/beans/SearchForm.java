package gb.model.beans;

import org.apache.struts.validator.ValidatorForm;

/**
 * Klasse, die das Suchformular für Gästebucheintr�ge abbildet 
 */
public class SearchForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchText;
	private String author;
	
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
		System.out.println("Set searchText to '" + searchText + "'");
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		System.out.println("Set author to '" + author + "'");
	}	
}
