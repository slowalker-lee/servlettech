<%@ page language="java" import="java.util.*,java.sql.*,slowalker.messageboradMV.*"%>
<jsp:useBean id="messageE" class="slowalker.messageboradMV.Message" scope="page">
    <jsp:setProperty name="messageE" property="*"/>
</jsp:useBean>
<jsp:useBean id="messageMd" class="slowalker.messageboradMV.OperateDB" scope="page"/>

<html>
  <head>
    <title>add message</title>
  </head>
  <body>
    <%
        try{
            messageMd.setMessage(messageE);
            messageMd.addMesage();
            out.println(messageE.getTitle());
        }catch(Exception e){
          System.out.println("wtfffffffffffffffffffffffffffffffff");
        }
    %>
    <jsp:forward page="viewMessages.jsp"/>
   
    
  </body>
</html>