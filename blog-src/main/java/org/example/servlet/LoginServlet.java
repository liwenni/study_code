package org.example.servlet;

import org.example.dao.UserDAO;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        JSONResponse json = new JSONResponse();
        try {
            //获取请求数据
            User user = JSONUtil.deserialize(req.getInputStream(),User.class);
            //处理业务：根据输入的账号密码，查询是否有数据
            User query = UserDAO.query(user);
            if(query == null){
                json.setCode("LOG001");
                json.setMessage("用户名或密码错误");
            }else{//校验用户名密码成功
                json.setSuccess(true);
                //创建一个人session对象
                HttpSession session = req.getSession();
                session.setAttribute("user",query);
            }
        }catch (Exception e){
            e.printStackTrace();
            //业务处理失败：返回false+错误码+错误信息
            //TODO
            json.setCode("ERR");
            json.setMessage("系统出错了，请联系管理员。");
        }

        String s = JSONUtil.serialize(json);
        resp.getWriter().println(s);
    }
}
