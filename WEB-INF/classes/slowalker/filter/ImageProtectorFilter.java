package slowalker.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(filterName = "ImageProtectorFilter",urlPatterns={"/image/*"})

public class ImageProtectorFilter implements Filter{
    @Override
    public void init(FilterConfig config){}

    @Override
    public void destroy(){}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws ServletException, IOException{
        System.out.println("ImageProtectedFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String referrer = httpServletRequest.getHeader("referer");
        if(referrer != null){
            filterChain.doFilter(request, response);

        }else{
            throw new ServletException("Image Not Found");
        }
    }

}
