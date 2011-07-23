package gb.tags;

import gb.model.beans.GuestbookEntry;
import gb.model.db.Guestbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class Sort extends TagSupport {

	public class ComparatorText implements Comparator<GuestbookEntry> {
		public int compare(GuestbookEntry a, GuestbookEntry b) {
			return a.getText().compareTo(b.getText());
		}
	}

	public class ComparatorEmail implements Comparator<GuestbookEntry> {
		public int compare(GuestbookEntry a, GuestbookEntry b) {
			return a.getEmail().compareTo(b.getEmail());
		}
	}

	public class ComparatorAuthor implements Comparator<GuestbookEntry> {
		public int compare(GuestbookEntry a, GuestbookEntry b) {
			return a.getAuthor().compareTo(b.getAuthor());
		}
	}

	public class ComparatorDate implements Comparator<GuestbookEntry> {
		public int compare(GuestbookEntry a, GuestbookEntry b) {
			return a.getDate().compareTo(b.getDate());
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String order = "asc";
	private String attribute = "date";
	private ArrayList<GuestbookEntry> list = null;

	public int doStartTag() throws JspException {
		if (list == null) {
			return SKIP_BODY;
		}
		try {
			if (list.size() > 0) {
				final Comparator<GuestbookEntry> c;
				if (attribute.equals("date")) {
					c = new ComparatorDate();
				} else if (attribute.equals("author")) {
					c = new ComparatorAuthor();
				} else if (attribute.equals("email")) {
					c = new ComparatorEmail();
				} else {
					c = new ComparatorText();
				}
				Collections.sort(list, c);
				if (order.equals("desc")) {
					Collections.reverse(list);
				}
				StringBuilder entries = new StringBuilder();
				entries.append("<div class=\"searchResults\">");
				for (GuestbookEntry ge : list) {
					entries.append("<div class=\"searchHit\">");
					entries.append("<div class=\"searchHit_date\">");
					entries.append(ge.getDate());
					entries.append("</div><div class=\"searchHit_author\"><a href=\"mailto:\"");
					entries.append(ge.getEmail());
					entries.append("\">");
					entries.append(ge.getAuthor());
					entries.append("</a></div><div class=\"searchHit_text\">");
					entries.append(ge.getText());
					entries.append("</div></div>");
				}
				entries.append("</div>");
				pageContext.getOut().print(entries);
			}
		} catch (Exception e) {
			throw new JspTagException("gb:sort Tag: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}

	public void setOrder(String newOrder) {
		if (newOrder.toLowerCase().equals("desc")) {
			order = "desc";
		} else {
			order = "asc";
		}
	}

	public void setAttribute(String newAttribute) {
		if (newAttribute.equals("author")) {
			attribute = "author";
		} else if (newAttribute.equals("text")) {
			attribute = "text";
		} else if (newAttribute.equals("email")) {
			attribute = "email";
		} else {
			attribute = "date";
		}
	}

	public void setList(ArrayList<GuestbookEntry> newList) {
		list = newList;
	}

	public static ArrayList<GuestbookEntry> getEntries() {
		try {
			Guestbook db = Guestbook.getInstance();
			if (db != null) {
				return db.getAllEntries();
			}
		} catch (Exception ignore) {
		}
		return new ArrayList<GuestbookEntry>();
	}
}
