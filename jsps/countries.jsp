<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>countries list</title>
  </head>
  <body>
   <h1>countries list</h1>
   <ul>
   <c:forEach items="${countries}" var="country">
     <li>${country.value}</li>
   </c:forEach>
   </ul>
  </body>
</html>