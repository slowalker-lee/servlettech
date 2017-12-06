package slowalker.mvcexample;
//用于保存留言
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class AddMessageServlet extends HttpServlet{
    private Connection con;
    PreparedStatement ps;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String[] st = {title,email,name,content};
        for (int i = 0; i < st.length; i++){
            if (st[i] == null)
                st[i] = "";
        }
        try{
            ps = con.prepareStatement("INSERT INTO messagebroad values(?,?,?,?,?)");
            ps.setString(1,title);
            ps.setString(2,name);
            ps.setString(3,email);
            ps.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(5,content);
            try{
                ps.executeUpdate();
            }catch(Exception e){
                System.out.println("================================");
                System.out.println("slowalker.mvcexample.AddMessageServlet doGet2");
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("================================");
            System.out.println("slowalker.mvcexample.AddMessageServlet doGet1");
            e.printStackTrace();
        }finally{
            try{
                ps.close();
                //con.close();
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.println("<a href='/servlettech/viewmessageservlet'>view message</a>");
            }catch (Exception e){
                System.out.println("================================");
                System.out.println("slowalker.mvcexample.AddMessageServlet doGet3");
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);

    }

    public AddMessageServlet() throws Exception{
        final String DBDRIVER = "org.gjt.mm.mysql.Driver";
        final String DBURL = "jdbc:mysql://localhost:3306/javaweb";
        final String DBUSER = "java";
        final String DBPASSWD = "19950922";
        try{
            Class.forName(DBDRIVER);
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);
        }catch (Exception e){
            System.out.println("================================");
            System.out.println("slowalker.mvcexample.AddMessageServlet Constructor");
            e.printStackTrace();
        }

    }
}