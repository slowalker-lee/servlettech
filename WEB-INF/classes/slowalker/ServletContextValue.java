package slowalker;
//查看ServletContext的属性组成，有一堆尚不知为何物的玩意，待考证
import java.util.Enumeration;
import java.io.*;

import javax.servlet.http.*;
import javax.servlet.ServletContext;

public class ServletContextValue extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
        ServletContext sc = this.getServletConfig().getServletContext();
        sc.setAttribute("name1", "lhx");
        Enumeration eu = sc.getAttributeNames();
        while(eu.hasMoreElements()){
            pw.println(eu.nextElement());
        }
    }
}


/**
 * output：
 * javax.servlet.context.tempdir
 *org.apache.catalina.resources
 *org.apache.tomcat.InstanceManager
 *org.apache.catalina.jsp_classpath
 *javax.websocket.server.ServerContainer
 *name1  该属性为自己添加的
 *org.apache.jasper.compiler.TldCache
 *org.apache.tomcat.JarScanner
 */