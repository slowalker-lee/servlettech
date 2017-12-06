<%@ page import="java.sql.*,slowalker.mvcexample.*,java.util.*"%>
<html>
  <head>
    <title>message list</title>
  </head>
  <body>
    <table>
    <tr><td>item</td><td>content</td><tr>
    <%
        ArrayList<Message> al = (ArrayList<Message>)request.getAttribute("messageList");
        Iterator<Message> it = al.iterator();
        while(it.hasNext()){
            Message mmm = (Message)it.next();
            out.println("<tr><td>title</td><td>" + mmm.getTitle() + "</td></tr>");
            out.println("<tr><td>name</td><td>" + mmm.getName() + "</td></tr>");
            out.println("<tr><td>email</td><td>" + mmm.getEmail() + "</td></tr>");
            out.println("<tr><td>date</td><td>" + mmm.getDate() + "</td></tr>");
            out.println("<tr><td>content</td><td>" + mmm.getContent() + "</td></tr>");
            out.println("<tr><td></td><td></td></tr>");
        }

    %>
    </table>
  </body>
</html>
