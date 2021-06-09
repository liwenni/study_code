package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.JSONResponse;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        JSONResponse json = new JSONResponse();
        try{
            //1.解析请求数据
            Article a = JSONUtil.deserialize(req.getInputStream(),Article.class);
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            //2.业务处理
            int n = ArticleDAO.insert(a,user.getId());

            json.setSuccess(true);
            //处理成功，可以设置业务数据（业务数据一般是数据库查询出来的）
        }catch (Exception e) {
            //将异常堆栈信息打印出来，否则会吃异常
            e.printStackTrace();
            json.setCode("ERROR");
            json.setMessage("后端程序出错，请联系管理员");
        }
        //3.返回响应数据
        String s = JSONUtil.serialize(json);
        resp.getWriter().println(s);

    }
}
