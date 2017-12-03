package slowalker.listener;
//测试ServletContextListener，view 是 /jsps/countries.jsp
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;  //对servlet context生命周期事件做出响应的监听器。

public class AppListener implements ServletContextListener{
    @Override
    public void contextDestroyed(ServletContextEvent sce){}

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext servletContext = sce.getServletContext();
        Map<String, String> countries = new HashMap<>();
        countries.put("ca", "Canada");
        countries.put("cn", "China");

        servletContext.setAttribute("countries", countries);
    }

}