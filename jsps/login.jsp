<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    
    if("POST".equals(request.getMethod())){
        Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
        Cookie visitTimeCookie = new Cookie("visitTime", "000");
        username.setMaxAge(7*24*3600);
        visitTimeCookie.setMaxAge(7*24*3600);
        response.addCookie(usernameCookie);
        response.addCookie(visitTimeCookie);
        response.sendRedirect("cookie.jsp");
        return;
    }
%>

<DOCTYPE html>
<html>
  <head>
    <title>请先登录</title>
  </head>
  <body>
    <div align='center'>
      <fieldset>
        <legend>登录</legend>
          <form action='login.jsp' method='POST'>
            <table>
              <tr><td>账号：</td><td><input type='text' name='username'></td></tr>
              <tr><td>密码：</td><td><input type='password' name='passwd'></td></tr>
              <tr><td></td><td><input type='submit' value='登录'></td></tr>
            </table>
      </fieldset>
    </div>
  </body>
</html>