<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
                      "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
 
<%-- Direktiven fuer Page-Optionen und verwendete Tag-Libs --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="gb.model.db.Guestbook,gb.model.beans.GuestbookEntry,java.util.ArrayList"%>
<%@ taglib prefix="gb" uri="/WEB-INF/guestbook.tld"%>

<h2>Display all Entries</h2>
<p>
<gb:sort order="asc" attribute="email" list="${gb:getEntries()}" />
</p>