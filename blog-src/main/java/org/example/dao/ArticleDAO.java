package org.example.dao;

import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> query(int userId) throws SQLException {
        //jdbc查询用户关联的文章列表
        //1.创建连接Connection对象
        Connection c = DBUtil.getConnection();

        //2.创建操作命令对象Statement
        String sql = "select id,title from article where user_id=?";
        PreparedStatement ps = c.prepareStatement(sql);
        //替换占位符的值：第一个参数表示占位符的索引（从1开始），第二个参数是要替换的值
        ps.setInt(1,userId);

        //3.执行SQL
        ResultSet rs = ps.executeQuery();

        List<Article> query = new ArrayList<>();
        //4.如果是查询操作，处理结果集
        while(rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            Article a = new Article();
            a.setId(id);
            a.setTitle(title);
            query.add(a);
        }
        //5.释放资源 TODO 若之前的代码出现异常，就无法释放资源了
        DBUtil.close(c, ps, rs);

        return query;
    }




    public static void main(String[] args) throws SQLException {
        List<Article> a =  query(1);
        System.out.println(a);
    }

    public static int insert(Article a,Integer userId) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            c = DBUtil.getConnection();
            //2.根据Connection + sql 创建操作命令对象
            String sql = "insert into article(title,content,user_id) values(?,?,?)";
            ps = c.prepareStatement(sql);

            //3.先替换占位符的值，再执行sql
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,userId);
            //插入、修改、删除都是调用executeUpdate的方法，返回值都是int
            return ps.executeUpdate();

//        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            DBUtil.close(c,ps);
        }
    }

    public static Article queryById(int id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article a = null;
        try {
            //1.获取连接
            c = DBUtil.getConnection();
            //2.创建操作命令对象
            String sql = "select * from article where id=?";
            ps = c.prepareStatement(sql);
            //3.替换占位符
            ps.setInt(1,id);
            rs = ps.executeQuery();
            //4.处理结果集
            while(rs.next()){
                a = new Article();
                a.setId(id);
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
            }
            return a;
        } finally {
            DBUtil.close(c,ps,rs);
        }

    }

    public static int update(Article a) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            //1
            c = DBUtil.getConnection();
            //2
            String sql = "update article set title=?,content=? where id=? ";
            ps = c.prepareStatement(sql);
            //先替代占位符 再执行sql
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getId());
            //修改
            return ps.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int delete(String[] ids) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in(");
            //拼接带占位符的sql
            for(int i = 0;i < ids.length;i++){
                if(i != 0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");
            ps = c.prepareStatement(sql.toString());
            //替换占位符的值
            for(int i = 0;i < ids.length;i++){
                //数组索引从0开始，占位符替换从1开始
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }

            return ps.executeUpdate();

//        }catch (Exception e){
//            e.printStackTrace();
        }finally {
            DBUtil.close(c,ps);
        }
    }
}
