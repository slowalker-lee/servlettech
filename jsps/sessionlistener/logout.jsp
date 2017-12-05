<%@ page language="java"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!--注销会话-->
<html>
  <head>
    <title>logout</title>
  <head>
  <body>
    <%
        if(session.isNew()) session.invalidate();
        response.sendRedirect("index.jsp");
    %>
  </body>
</html>