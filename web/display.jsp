<%@ page import="java.sql.*" %>
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
          <h3>Data Entered</h3>
            <div>
              <table border="1" cellspacing="0" cellpadding="3">
                <tbody>
                  <tr>
                    <th class="text-center">Operating System (OS)</th>
                    <th class="text-center">OS Version</th>
                    <th class="text-center">Notes</th>
                  </tr>
                  <s:iterator value="entryList" var="entry">
                    <tr>
                      <td><s:property value="OS"/></td>
                      <td><s:property value="osVersion"/></td>
                      <td><s:property value="notes"/></td>
                    </tr>
                  </s:iterator>

                <%-- Try to force the data w/o Struts --%>
                      <%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url= "jdbc:mysql://localhost:3306/jive_ssei_test";
String username="root";
String password="root";
String query="select * from entries";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
                  <tr>
                      <td><%= rs.getString("OS") %></td>
                      <td><%= rs.getString("osVersion") %></td>
                      <td><%= rs.getString("Notes") %></td>
                  </tr>
                      <%

}
%>
                  </tbody>
              </table>
                <%
                        rs.close();
                        stmt.close();
                        conn.close();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }




                %>
                <%--</tbody>--%>
              <%--</table>--%>
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
