<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Create an entry</h2>
            <s:form action="CreateSubmit" method="post">

                <div class="formField">
                    <s:textfield name="author" label="Your name"/>
                </div>

                <div class="formField">
                    <s:textfield name="email" label="Your Mail"/>
                </div>
               
                <div class="formField">
                    <s:textarea name="text" label="Your Text" rows="10" cols="30"/>
                </div>

                <!-- Submit-Button -->
                <div class="formButton">
                    <s:submit value="Erstellen"/>
                </div>

            </s:form>