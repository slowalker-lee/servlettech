package slowalker.filter;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter{
    private PrintWriter logger;
    private String prefix;

    public void init(FilterConfig filterConfig) throws ServletException{
        prefix = filterConfig.getInitParameter("prefix");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        String logFileName = filterConfig.getInitParameter("logFileName");
        System.out.println("logFileName:" + logFileName);
        try{
            logger = new PrintWriter(new File(appPath, logFileName));
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    public void destroy(){
        System.out.println("destroy filter");
        if(logger != null) logger.close();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException{
        System.out.println("LoggingFilter.doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        logger.println(new Date() + " " + prefix + httpServletRequest.getRequestURI());
        logger.flush();
        chain.doFilter(request, response);
    }
}