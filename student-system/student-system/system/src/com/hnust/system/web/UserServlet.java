package com.hnust.system.web;

import com.hnust.system.common.Result;
import com.hnust.system.common.ResultCodeEnum;
import com.hnust.system.pojo.Student;
import com.hnust.system.pojo.User;
import com.hnust.system.service.StudentService;
import com.hnust.system.service.UserService;
import com.hnust.system.service.impl.StudentServiceImpl;
import com.hnust.system.service.impl.UserServiceImpl;

import com.hnust.system.utils.WebUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.findByUsername(username);

        Result result = null;
        if (loginUser == null) {
            result = result.build(null, ResultCodeEnum.USERNAME_ERROR);
            resp.sendRedirect("/loginUsernameError.html");
        } else if (loginUser.getPassword().equals(password)) {
            //密码相同
            result = Result.ok(null);
            if (loginUser.getIdentity().equals("teacher")) {
                resp.sendRedirect("/teacher.html");
            } else {
                // 获取session对象
                HttpSession session = req.getSession();
                // 获取Session的ID
                String jSessionId = session.getId();
                System.out.println(jSessionId);
                // 判断session是不是新创建的session
                boolean isNew = session.isNew();
                System.out.println(isNew);
                // 向session对象中存入数据
                session.setAttribute("username", username);

               /* Student student = studentService.selectByName(username);
                WebUtil.writeJson(resp, Result.ok(student));*/
                resp.sendRedirect("/student.html");
            }

        } else {
            //密码不相同
            result = result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            resp.sendRedirect("/loginUserPwdError.html");
        }

    }
}
