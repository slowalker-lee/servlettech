<%@ page language="java"%>
<%@ page import="slowalker.listener.*,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!--会话管理程序-->
<html>
  <head>
    <title>Lomboz JSP</title>
  </head>
  <body>
    <table>
      <tr>
        <td>会话ID</td>
        <td>用户名</td>
        <td>事件</td>
        <td>创建时间</td>
        <td>操作</td>
      </tr>
      <%
        Iterator iterator = MySessionListener.getSet();
        while(iterator.hasNext()){
            try{
                HttpSession hs = (HttpSession)iterator.next();
                out.println("<tr>");
                out.println("<td>" + hs.getId() + "</td>");
                out.println("<td>" + hs.getAttribute("name") + "</td>");
                out.println("<td>" + hs.getAttribute("thing") + "</td>");
      %>
                <td><a href='end.jsp?sessionid=<%=session.getId()%>'>销毁</a></td>
                <%
                out.println("</tr>");
            }catch(Exception e){
                e.printStackTrace();
                //throw new Exception();
            }
        }
       // out.println("while outter");
      %>
    </table>
  </body>
</html>