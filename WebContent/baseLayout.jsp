<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HTML head -->
	<head>
		<title>Guestbook</title>
		<!-- Embed cascading stylesheet file -->
		<link rel="stylesheet" type="text/css" href="guestbook.css"/>
	</head>
    <body>

                    <tiles:insertAttribute name="header" />
              
                    <tiles:insertAttribute name="menu" />

        <div class="guestbook_body">
                    <tiles:insertAttribute name="body" />
		</div>
                    <tiles:insertAttribute name="footer" />
    </body>
</html>
