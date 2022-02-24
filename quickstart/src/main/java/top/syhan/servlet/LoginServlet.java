package top.syhan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author mq_xu
 * @ClassName Test
 * @Description 拦截/home请求，获取所有图书数据，并通过服务器端转发跳转到主页
 * @Date 2019/9/23
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求乱码
        req.setCharacterEncoding("UTF-8");
        //通过req请求参数获取前台表单的用户名参数
        String username = req.getParameter("username");
        //取得密码参数
        String password = req.getParameter("password");
        //账号密码正确
        if ("admin".equals(username) && "111".equals(password)) {
            //通过request对象获取session会话对象
            HttpSession session = req.getSession();
            //把用户名存入session对象
            session.setAttribute("username", username);
            //进行重定向跳转（客户端跳转）
            resp.sendRedirect("/index.jsp");
        } else {
            //账号或密码错误，跳转到登陆页面
            resp.sendRedirect("/");
        }
    }
}
