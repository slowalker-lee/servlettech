<%@ page language="java"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!--会话显示-->
<!DOCTYPE html>
<html>
  <head>
    <title>会话显示</title>
  </head>
  <body>
    <%
        if (session.isNew() == true) response.sendRedirect("./index.jsp");
        out.println("name : " + session.getAttribute("name") + " <br/>");
        out.println("thing : " + session.getAttribute("thing") + "<br />");
        out.println("ID : " + "session.getId()" + "<br />");
        out.println("create time " + session.getCreationTime() + "<br />");
    %>
    <table>
      <tr>
        <td><a href="./session.jsp">管理</a></td>&nbsp;&nbsp;&nbsp;&nbsp;
        <td><a href="./logout.jsp">注销</a></td>
      </tr>
    </table>
  </body>
</html>