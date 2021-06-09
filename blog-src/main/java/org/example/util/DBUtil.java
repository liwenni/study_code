package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    //类初始化的时候，创建连接池对象及设置属性（使用同一个连接池复用连接对象）
    //之后可用多线程调整为双重校验锁的单例模式 TODO
    private static MysqlDataSource ds = new MysqlDataSource();
    static {
        ds.setURL("jdbc:mysql://localhost:3306/servlet_blog");
        ds.setCharacterEncoding("UTF-8");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setUseSSL(false);
    }
    public static Connection getConnection() throws SQLException {
        Connection c = ds.getConnection();
        System.out.println(c);
        return c;
    }
    public static void close(Connection c, PreparedStatement ps, ResultSet rs) throws SQLException {
        //5.释放资源
        if(rs != null)
            rs.close();
        if(ps != null)
            ps.close();
        if(c != null)
            c.close();
    }

    public static void close(Connection c, PreparedStatement ps) throws SQLException {
        close(c,ps,null);
    }
}

