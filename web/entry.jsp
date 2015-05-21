<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/foundation.min.css">
        <script src="js/vendor/modernizr.js"></script>
        <title>Test - Entry</title>
    </head>
    <body>
        <%@include file="includes/header.html"%>
        <div class="row">
            <div class="columns large-12">
                <div class="columns large-8 large-offset-2">
                        <br>
                    <h3>Enter Data</h3>
                        <s:form action="add" method="POST">
                           <s:textfield name="OS" label="Operating System (OS)" size="30"/>
                           <s:textfield name="osVersion" label="OS Version" size="30"/>
                           <s:textfield name="notes" label="Notes" size="150"/>
                           <s:submit value="Save" class="small round button" align="center"/>
                        </s:form>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.html"%>
    </body>
</html>