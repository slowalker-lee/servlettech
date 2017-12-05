package slowalker.messageboradMV;

import java.sql.*;
import javax.sql.*;
import java.util.*;

public class OperateDB{
    private Connection con;
    Message msg;

    public OperateDB() throws SQLException, ClassNotFoundException{
        final String DBDRIVER = "org.gjt.mm.mysql.Driver";
        final String DBURL = "jdbc:mysql://localhost:3306/javaweb";
        final String DBUSER = "java";
        final String DBPASSWD = "19950922";

        try{
            Class.forName(DBDRIVER);
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException  e){
            System.out.println("============================");
            System.out.println("slowalker.messageboradMV.OperateDB");
            
            e.printStackTrace();
        }
    }

    public void setMessage(Message msg){
        this.msg = msg;
    }

    public void addMesage() throws Exception{
        PreparedStatement stm = con.prepareStatement("insert into messagebroad values(?,?,?,?,?)");
        stm.setString(1,msg.getTitle());
        stm.setString(2,msg.getName());
        if(msg.getEmail().length() > 0) stm.setString(3,msg.getEmail());
        else stm.setString(3,null);
        stm.setDate(4,msg.getDate());
        stm.setString(5,msg.getContent());

        try{
            stm.executeUpdate();
        }catch (Exception e){
            System.out.println("============================");
            System.out.println("slowalker.messageboradMV.addMesage()");
            e.printStackTrace();

        }finally{
            con.close();
        }
    }

    public ArrayList<Message> getMessage(){
        ArrayList<Message> al = new ArrayList<>();
        try{
            Statement stm = con.createStatement();
            int messageCount = 0;
            ResultSet rs = stm.executeQuery("select count(*) from messagebroad");
            if(rs.next()) {
                messageCount = rs.getInt(1);
                rs.close();
            }
            if(messageCount > 0){
                rs = stm.executeQuery("select * from messagebroad");
                while(rs.next()){
                    String title = rs.getString(1);
                    String name = rs.getString(2);
                    String email = rs.getString(3);
                    java.sql.Date date = rs.getDate(4);
                    String content = rs.getString(5);

                    Message m = new Message();
                    m.setName(name);
                    m.setTitle(title);
                    m.setEmail(email);
                    m.setDate(date);
                    m.setContent(content);

                    al.add(m);
                }
                rs.close();
                stm.close();
            }
        }catch (Exception e){
            System.out.println("============================");
            System.out.println("slowalker.messageboradMV.getMessage()");
            e.printStackTrace();
        }
        return al;
    }

}