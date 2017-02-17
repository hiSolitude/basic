package Utils;

import java.sql.*;

/**
 * Created by solitude on 2017/2/9.
 *
 *
 * 数据库连接帮助类
 */
public class DBManager {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    private static final String USERNAME = "scott";
    private static final String PASSWORD = "admin";

    static {
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(ResultSet rs, Statement st,Connection conn){
        if (rs !=null ){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
                rs = null;
            }
        }
        if (st != null){
            try {
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
                st = null;
            }
        }
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
                conn = null;
            }
        }
    }
}
