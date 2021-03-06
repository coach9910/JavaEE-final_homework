package org.example.spring.servlet;
import org.example.spring.jdbc.StudentHomeworkJdbc;
import org.example.spring.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/List")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        List<StudentHomework> list = StudentHomeworkJdbc.selectALL();
        req.setAttribute("list", list);
        req.getRequestDispatcher("teacher.jsp").forward(req, resp);
    }
}