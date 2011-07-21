<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Guestbook body with contains the actual page content -->

            
            <!-- Subheader and explanation text for this page -->
            <h2>Search within Guestbook</h2>
            <p>
               You can search on this page for special entries.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form action="SearchServlet">
                <!-- "Name" field -->
                <div class="formField">
                    <label for="tfSearchtext">Searchtext</label>
                    <input type="text" name="tfSearchtext" id="tfSearchtext"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfAuthor">Author</label>
                    <input type="text" name="tfAuthor" id="tfAuthor"/>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>
            
