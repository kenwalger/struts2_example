<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="css/normalize.css">
      <link rel="stylesheet" href="css/foundation.min.css">
      <script src="js/vendor/modernizr.js"></script>
      <title>Test - Home</title>
  </head>
  <body>
    <%@include file="includes/header.html"%>
    <div class="row">
        <div class="columns large-12">
            <div class="columns large-8 large-offset-2">
                <br>
                <p>This is my implementation of a Struts 2 application to store OS, OS Version, and Notes data.</p>
                <ul class="vcard large-centered">
                    <li class="fn">Ken W. Alger</li>
                    <li class="street-address">778 Chehalis PL N</li>
                    <li class="locality">Keizer</li>
                    <li><span class="state">OR</span>, <span class="zip">97303</span></li>
                    <li class="email"><a href="#">kenalger@comcast.net</a></li>
                </ul>
            </div>
            <div class="columns large-8 pull-2">
                <s:a href="entry.jsp" class="small round button">Enter Data</s:a>
            </div>
        </div>
    </div>
    <%@include file="includes/footer.html"%>
  </body>
</html>
