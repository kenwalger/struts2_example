<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 5/13/2015
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/foundation.min.css">
    <script src="js/vendor/modernizr.js"></script>
    <title>Ken W. Alger | Jive Software Interview Test</title>
  </head>
  <body>
    <header class="row">
      <div class="columns large-12 text-center">
        <h1>Ken W. Alger</h1>
        <h2>Software Support Engineer Interview Test</h2>
        <nav class="breadcrumbs">
          <s:a href="index.jsp">Home</s:a>
          <s:a href="entry.jsp">Entry</s:a>
          <s:a href="display.jsp">Display</s:a>
        </nav>
      </div>
    </header>
    <div class="row">
      <div class="columns large-12">
        <div class="columns large-8 large-offset-2">
          <br>
          <h3>Enter Data</h3>
            <div>
              <table>
                <tbody>
                  <tr>
                    <th>Operating System (OS)</th>
                    <th>OS Version</th>
                    <th>Notes</th>
                  </tr>
                  <s:iterator value="add" var="entry">
                    <tr>
                      <td><s:property value="OS"></s:property></td>
                      <td><s:property value="osVersion"></s:property></td>
                      <td><s:property value="notes"></s:property></td>
                    </tr>
                  </s:iterator>
                </tbody>
              </table>
              <a href="entry.jsp">Enter more information.</a>
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