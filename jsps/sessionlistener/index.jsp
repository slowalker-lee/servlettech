<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!--会话登录-->
<%
    String strName = null;
    String strThing = null;
    try{
        strName = request.getParameter("name");
        strThing = request.getParameter("thing");
        if((strName == null) || (strName.length() == 0)) throw new Exception("null name");
        if((strThing == null) || (strThing.length() == 0)) throw new Exception("null thing");
        session.setAttribute("name",strName);
        session.setAttribute("thing",strThing);
        response.sendRedirect("./display.jsp");
    }catch (Exception e){}
    
%>

<html>
  <head>
    <title>会话管理</title>
  </head>
  <body>
    <form action="" method="post">
      <table align='center'>
        <tr><td>姓名</td><td><input type='text' name='name'></td></tr>
        <tr><td>事件</td><td><input type='text' name='thing'></td></tr>
        <tr><td align='right'></td><td align='right'><input type='submit'></td></tr>
      </table>
    </form>
  </body>
</html>