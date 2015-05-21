<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/foundation.min.css">
    <script src="js/vendor/modernizr.js"></script>
    <title>Ken W. Alger | Jive Software Interview Test</title>
  </head>
  <body>
    <%@include file="includes/header.html"%>
    <div class="row">
      <div class="columns large-12">
        <div class="columns large-8 large-offset-2">
          <br>
          <h3>Data Entered</h3>
            <div>
              <table border="1" cellspacing="0" cellpadding="3">
                <tbody>
                  <tr>
                    <th class="text-center">Operating System (OS)</th>
                    <th class="text-center">OS Version</th>
                    <th class="text-center">Notes</th>
                  </tr>
                  <s:iterator value="allEntries" var="entry">
                    <tr>
                      <td><s:property value="os"/></td>
                      <td><s:property value="osVersion"/></td>
                      <td><s:property value="notes"/></td>
                    </tr>
                  </s:iterator>
                </tbody>
              </table>
              <div class="columns large-8 push-4">
                <s:a href="entry.jsp" class="small round button">Enter Additional Data</s:a>
              </div>
            </div>
          </div>
        </div>
      </div>
    <footer class="row">
      <div class="columns large-12 text-center">
        <p>&COPY; Ken W. Alger - <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></p>
      </div>
    </footer>
  </body>
</html>
