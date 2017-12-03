<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
//errorPage="login.jsp"
    request.setCharacterEncoding("UTF-8");

    String username = "";
    int visitTime = 0;
    Cookie[] cookies = request.getCookies();
    System.out.println("4");
    for(int i = 0; (cookies!=null)&& (i < cookies.length); i++){
        Cookie cookie = cookies[i];
        System.out.println("4");
        if("username".equals(cookie.getName())){
            username = cookie.getValue();
        }else if("visitTime".equals(cookie.getName())){
            //visitTime = Integer.parseInt(cookie.getValue());
            String a = cookie.getValue();
            System.out.println(a);
            visitTime = Integer.parseInt(a);
        }
    }
    System.out.println("45");
    if(username == null || username.trim().equals("")){
        throw new Exception();
    }
    //System.out.println("3");
    Cookie visitTimeCookie = new Cookie("visitTime", Integer.toString(++visitTime));
    response.addCookie(visitTimeCookie);
%>
<!DOCTYPE html>
<html>
  <body>
    <div align='center'>
      <fieldset>
        <legend>登录信息</legend>
        <form action='login.jsp' method='post'>
          <table>
            <tr><td>账号</td><td><%=username %></td></tr>
            <tr><td>登录次数</td><td><%=visitTime%></td></tr>
            <tr><td></td><td>
            <input type='button' value='refresh' onclick="location='<%=request.getRequestURI()%>?ts=' + new Date().getTime();">
            
            </td></tr>
          </table>
      </fieldset>
    </div>
  </body>
</html>