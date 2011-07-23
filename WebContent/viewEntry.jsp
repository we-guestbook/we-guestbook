<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="gb.model.db.Guestbook,gb.model.beans.GuestbookEntry,java.util.ArrayList"%>
<%@ taglib uri="/WEB-INF/guestbook.tld" prefix="gb"%>
<p>
	Entry is
	<gb:sort order="asc" attribute="email" list="${gb:getEntries()}" />
	here.
</p>