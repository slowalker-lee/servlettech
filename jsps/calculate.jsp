<%@ page language="java" contentType="text/html" %>
<jsp:useBean id="calculater" scope="request" class="slowalker.javabean.SimpleCalculate">
   <jsp:setProperty name="calculater" property="*"/>
</jsp:useBean>
<html>
  <head>
    <title>calculate</title>
  </head>
  <body>
    resute:
    <%
        try{
            calculater.getResult();
            out.println(calculater.getFirst() + " " + calculater.getOperate() + " " 
                      + calculater.getLast() + " " + "= " + calculater.getResult());
        }catch (Exception e){
            out.println("operate error");
        }
    %>
    <form action='calculate.jsp' method='post'>
      <table>
        <tr><td>first</td><td><input name='first'></td></tr>
        <tr><td>operate</td><td><input name='operate'></td></tr>
        <tr><td>last</td><td><input name='last'></td></tr>
        <tr><td><input type='submit' value='submit'/></td></tr>
      </table>
    </form>
  </body>
</html>
