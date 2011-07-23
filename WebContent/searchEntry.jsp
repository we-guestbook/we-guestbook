<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="html" uri="/struts-tags" %>

<!-- Subheader and explanation text for this page -->
            <h2>Search</h2>
            <p>
               You can search within the guestbook on this page.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form action="SearchSubmit" method="post">
                <!-- "Name" field -->
                <div class="formField">
                    <label for="tfSearchtext">Search Text</label>
                    <input type="text" name="text" id="text"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfAuthor">Author</label>
                    <input type="text" name="author" id="author"/>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>