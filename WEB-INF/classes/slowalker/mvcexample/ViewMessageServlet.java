package slowalker.mvcexample;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class ViewMessageServlet extends HttpServlet{
    private Connection con;
    private Statement stm;
    public ViewMessageServlet() throws Exception{
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ArrayList<Message> al = new ArrayList<>();
        int messageCount = 0;
        try{
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM messagebroad");
            if(rs.next()) messageCount = rs.getInt(1);
            rs.close();
            if(messageCount > 0){
                 rs = stm.executeQuery("SELECT * FROM messagebroad");
                while(rs.next()){
                    Message ms = new Message();
                    ms.setTitle(rs.getString(1));
                    ms.setName(rs.getString(2));
                    ms.setEmail(rs.getString(3));
                    ms.setDate(rs.getDate(4));
                    ms.setContent(rs.getString(5));
                    al.add(ms);

                }
                rs.close();
                stm.close();
            }
            request.setAttribute("messageList",al);
            RequestDispatcher rd = request.getRequestDispatcher("./jsps/mvcexample/viewMessages.jsp");
            rd.forward(request, response);

        }catch (Exception e){
            System.out.println("================================");
            System.out.println("slowalker.mvcexample.ViewMessageServlet doGet");
            e.printStackTrace();
        }

    }
}