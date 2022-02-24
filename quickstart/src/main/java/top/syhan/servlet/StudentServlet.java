package top.syhan.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.syhan.entity.Student;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName Student
 * @Description 拦截"/students"请求，创建一组学生记录，通过服务器转发带到目标页面
 * @Date 2019/9/21
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student[] students = {
                new Student(1, "张无忌", "男", 21),
                new Student(2, "张碧晨", "女", 22),
                new Student(3, "张韶涵", "女", 23),
                new Student(4, "张杰", "男", 24)
        };
        List<Student> studentList = Arrays.asList(students);
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/student.jsp").forward(req, resp);
    }
}
