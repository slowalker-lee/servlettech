<%@ page language="java"%>
<%@ page import="slowalker.listener.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Lomboz.jsp</title>
  </head>
  <body>
    <%
        try{
            String strSid = request.getParameter("sessionid");
            HttpSession hs = MySessionListener.getSession(strSid);
            if(hs != null){
                hs.invalidate();
            }
        }catch(Exception e){
                e.printStackTrace();
        }finally{
            response.sendRedirect("./index.jsp");
        }
    %>
  </body>
</html>