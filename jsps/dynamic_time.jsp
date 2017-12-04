<%@ page language="java"%>
<% 
    java.util.Date now = new java.util.Date();
    int month = now.getMonth();
    System.out.println(month);
    String bgcolor = "";
    switch(month){
        case 1:bgcolor = "blue";break;
        case 2:bgcolor = "blue";break;
        case 3:bgcolor = "blue";break;
        case 4:bgcolor = "green";break;
        case 5:bgcolor = "green";break;
        case 6:bgcolor = "green";break;
        case 7:bgcolor = "yellow";break;
        case 8:bgcolor = "yellow";break;
        case 9:bgcolor = "yellow";break;
        case 10:bgcolor = "yellow";break;
        case 11:bgcolor = "yellow";break;
        case 12:bgcolor = "yellow";break;
    }
%>
<html>
<head>
  <title></title>
</head>
<body bgcolor=<%=bgcolor%>>
  <hr>welcome current time is <%=now.toString()%>
</body>
</html>