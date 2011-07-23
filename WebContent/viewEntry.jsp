<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
                      "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%-- Direktiven fuer Page-Optionen und verwendete Tag-Libs --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="html" uri="/struts-tags"%>


<div class="searchResults">
	<h2>Results</h2>
	<%-- Ergebnisliste als Bean einbinden --%>
	<jsp:useBean id="result" class="java.util.ArrayList" scope="request" />

	<%-- If-Else Abrage ob Fehler-Objekt im Request ist --%>
	<c:choose>

		<c:when test="${not empty requestScope.error}">
			<%-- Fehlerobjekt ist im Request vorhanden, wir
                            zeigen Fehlermeldung an. --%>
			<span class="error">${requestScope.error}</span>
			<br />
			<br />
		</c:when>
		<c:otherwise>
			<%-- Kein Fehler aufgetreten, wie zeigen Suchergebnis
                             an. --%>
			<%-- Wenn Liste leer ist, dann gib Hinweis aus --%>
			<c:if test="${empty result}">
				<span> Ihre Suche hat leider keinen Treffer ergeben.
					Versuchen Sie andere Suchbegriffe.<br /> <br /> </span>
			</c:if>

			<%-- Gib alle Suchtreffer aus.
                             Die For-Schleife wird nur ausgefuehrt, wenn result
                             nicht leer ist, deshalb ist kein Else-Zweig fuer 
                             die Abfrage oben noetig. --%>
			<c:forEach var="entry" items="${result}">

				<div class="searchHit">
					<div class="searchHit_author">
						<c:choose>
							<c:when test="${entry.email != null}">
								<a href="mailto:${entry.email}"> ${entry.author} </a>
							</c:when>
							<c:otherwise>
                                           ${entry.author}
                                        </c:otherwise>
						</c:choose>
					</div>
					<div class="searchHit_date">
						<%--Formatiere Datum zur besseren Anzeige --%>
						<fmt:formatDate value="${entry.date}" pattern="dd.MM.yyyy HH:mm" />
					</div>
					<div class="searchHit_text">${entry.text}</div>
				</div>

			</c:forEach>

		</c:otherwise>
	</c:choose>

</div>
