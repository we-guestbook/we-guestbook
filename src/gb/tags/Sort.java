package gb.tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class Sort extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("this is my unaimious testtag");
		} catch (Exception ex) {
			throw new JspTagException("TestTag: " + ex.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}
}
