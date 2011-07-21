<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <h2>Login</h2>
            <p>
               You can login on this page. It's required to be registered before.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form action="SearchServlet">
                <!-- "Name" field -->
                <div class="formField">
                    <label for="tfSearchtext">Login-name</label>
                    <input type="text" name="tfloginname" id="tfloginname"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfAuthor">Password</label>
                    <input type="password" name="tfpassword" id="tfpassword"/>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>