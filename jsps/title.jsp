<%
    if (session.getAttribute("userType") == null)
        session.setAttribute("userType",new Integer(5));
%>


<%
if(((Integer)session.getAttribute("userType")).equals(new Integer(1))){
%>
<img src='../image/error.jpg'/>
<%
session.setAttribute("userType", new Integer(5));
}else{
%>
<img src='../image/right.jpg'/>
<%
session.setAttribute("userType", new Integer(1));
}
%>
