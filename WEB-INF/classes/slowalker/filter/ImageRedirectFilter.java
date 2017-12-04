package slowalker.filter;
//仅在本站内的网页引用本站资源时，图片才会正常使用

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ImageRedirectFilter implements Filter{
    public void init(FilterConfig config) throws ServletException{}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String refer = req.getHeader("referer");

        if(refer == null || !refer.contains(request.getServerName())){
            request.getRequestDispatcher("/error.jpg").forward(req,rep); 
        }else{
            chain.doFilter(req,rep);
        }
    }

    public void destroy(){}
}
