<%@ page import="java.sql.*,slowalker.messageboradMV.*,java.util.*"%>
<jsp:useBean id="viewMessage" class="slowalker.messageboradMV.OperateDB" scope="page"/>

<html>
  <head>
    <title>view message</title>
  </head>
  <body>
    <%
      int messageCount = 0;
      ArrayList<Message> al = viewMessage.getMessage();
      Iterator it = al.iterator();
      while(it.hasNext()){
          Message m = (Message)it.next();
          String name = m.getName();
          String content = m.getContent();
          String email = m.getEmail();
          //String date = m.getDate().toString();
          String title = m.getTitle();

          out.println("title:" + title);
          out.println("name:" + name);
          if (email != null)
            out.println("email:" + email);
         // out.println("日期:" + date);
          out.println("content:" + content + "<hr/>");
        }
    %>
    <a href="form.html">i want to do</a>
  </body>
</html>