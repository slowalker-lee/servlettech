package slowalker.javabean;

import java.sql.*;

import slowalker.javabean.UserInfo;

import java.sql.*;

public class UserRegist{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/javaweb";
    public static final String DBUSER = "java";
    public static final String PASSWD = "19950922";

    private UserInfo userInfo;
    private Connection conn;

    //构造方法，获得数据库连接
    public UserRegist(){
        try{
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, PASSWD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public void regist() throws Exception{
        try{
            //生成一个预处理语句
            String reg = "insert into user_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(reg);
            pstmt.setString(1,userInfo.getUserId());
            pstmt.setString(2,userInfo.getName());
            pstmt.setString(3,userInfo.getPhone());
            pstmt.setString(4,userInfo.getStreet());
            pstmt.setString(5,userInfo.getState());
            pstmt.setString(6,userInfo.getZipCode());
            pstmt.setString(7,userInfo.getCity());
            pstmt.setString(8,userInfo.getEmail());
            pstmt.setString(9,userInfo.getCardNumber());

            pstmt.setInt(10,userInfo.getCardType());
            pstmt.setInt(11,0);
            pstmt.setDate(12,new java.sql.Date(new java.util.Date().getTime()));
            pstmt.setInt(13,1);   
            pstmt.setInt(14,0); 

            pstmt.setString(15,userInfo.getFanvcategory());
            pstmt.setString(16,userInfo.getPassword());

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}