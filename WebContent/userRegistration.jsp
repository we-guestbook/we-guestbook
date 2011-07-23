<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <h2>Registration</h2>
            <p>
               You can register on this page. After that you can login.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form action="SearchServlet">
                <!-- "Name" field -->
                <div class="formField">
                    <label for="tfloginname">Login-name</label>
                    <input type="text" name="tfloginname" id="tfloginname"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfPassword">Password</label>
                    <input type="password" name="tfpassword" id="tfpassword"/>
                </div>
                
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfEmail">E-Mail</label>
                    <input type="text" name="tfEmail" id="tfEmail"/>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>