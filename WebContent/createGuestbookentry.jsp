<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="/struts-tags" %>


            <!-- Subheader and explanation text for this page -->
            <h2>Create your Guestbook Entry</h2>
            <p>
                Create your Guestbook entry.
            </p>
            
           <span class="error">
           <html:fielderror/>
           </span>

            <html:form action="CreateSubmit" method="post">

                <div class="formField">
                    <html:textfield name="author" label="Your Name"/>
                </div>

                <div class="formField">
                    <html:textfield name="email" label="Your Mail"/>
                </div>
               
                <div class="formField">
                    <html:textarea name="text" label="Your Message"/>
                </div>

                <!-- Submit-Button -->
                <div class="formButton">
                    <html:submit value="Erstellen"/>
                </div>
                </html:form>