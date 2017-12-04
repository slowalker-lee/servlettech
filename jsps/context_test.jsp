<%@ page import="java.util.*"%>
<%
    out.println("add attribute");
    this.getServletContext().setAttribute("name1","hx");
    out.println("replace attribute");
    this.getServletContext().setAttribute("name1","lhx");
    out.println("remove attribute");
    this.getServletContext().removeAttribute("name1");

    System.out.println("============================");
    Enumeration<String> enu = this.getServletContext().getAttributeNames();
    while(enu.hasMoreElements()){
       System.out.println(enu.nextElement());
    }

%>