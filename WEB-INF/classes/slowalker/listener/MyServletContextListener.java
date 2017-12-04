package slowalker.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.io.*;

public class MyServletContextListener 
        implements ServletContextAttributeListener,ServletContextListener{
    private ServletContext servletContext = null;

    //实现servletContextListener接口
    public void ContextDestroyed(ServletContextEvent sce){
        logout("ContextDestroyed(ServletContextEvent sce) ServletContext被销毁");
        this.servletContext = null;
    }

    public void contextInitialized(ServletContextEvent sce){
        this.servletContext = sce.getServletContext();
        System.out.println("contextinitialized(ServletContextEvent sce) ServletContext被初始化");
        logout("contextinitialized(ServletContextEvent sce) ServletContext被初始化");
    }


    //实现ServletContextAttribute接口
    public void attributeAdded(ServletContextAttributeEvent scae){
        logout("增加了一个ServletContext属性 " + scae.getName() + "->" + scae.getValue() );
    }

    public void attributeRemoved(ServletContextAttributeEvent scae){
        logout("删除了一个ServletContext属性 " + scae.getName() + "->" + scae.getValue() );
    }

    public void attributeReplaced(ServletContextAttributeEvent scae){
        logout("更改了一个ServletContext属性 " + scae.getName() + "->" + scae.getValue() );
    }

    

    private void logout(String message){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileOutputStream("/usr/local/apache-tomcat-9.0.1/webapps/servlettech/ccc.txt",true));
            pw.println(new java.util.Date().toString() + "::From Context Listener" + message);
            pw.close();
        }catch(Exception e){
            pw.close();
            e.printStackTrace();
        }
    }




}