<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="html" uri="/struts-tags" %>


            <h2>Create Entry</h2>
            <p>
               You can create an entry on this page.
            </p>
            
            <!--  Form for signing guestbook  -->
            <form action="CreateSubmit" method="post">
                <!-- "Name" field -->
                <div class="formField">
                    <label>Name</label>
                    <input type="text" name="name" id="name"/>
                </div>
                <!-- "Title" field -->
                <div class="formField">
                    <label>Mail</label>
                    <input type="text" name="email" id="email"/>
                </div>
                <!-- "" field -->
                <div class="formField">
                    <label>Your Message</label>
                    <textarea rows="10" cols="20" name="text" id="text"></textarea>
                </div>
                <!-- Submit-Button -->
                <div class="formField">
                    <button type="submit">Go for it!</button>
                </div>
            </form>