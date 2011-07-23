<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <h2>Login</h2>
            <p>
               You can login on this page. It's required to be registered before.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form>
                <!-- "Name" field -->
                <div class="formField">
                    <label for="tfLoginname">Login-name</label>
                    <input type="text" name="tfLoginname" id="tfLoginname"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label for="tfPassword">Password</label>
                    <input type="password" name="tfPassword" id="tfPassword"/>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>