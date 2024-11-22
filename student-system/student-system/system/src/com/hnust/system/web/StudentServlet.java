package com.hnust.system.web;

import com.hnust.system.common.Result;
import com.hnust.system.common.ResultCodeEnum;
import com.hnust.system.pojo.Student;
import com.hnust.system.service.StudentService;
import com.hnust.system.service.impl.StudentServiceImpl;
import com.hnust.system.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.spi.ResolveResult;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.*;

@WebServlet("/student/*")
public class StudentServlet extends BaseServlet{

    private final StudentService studentService = new StudentServiceImpl();

    /**
     * 根据学生名字查询学生信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void selectByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();
         // 获取Session的ID
        String jSessionId = session.getId();
        System.out.println(jSessionId);
        // 判断session是不是新创建的session
        boolean isNew = session.isNew();
        System.out.println(isNew);
        // 从session中取出数据
        String name = (String)session.getAttribute("username");
        System.out.println(name);

/*
        String name = req.getParameter("username");*/
        Student student = studentService.selectByName(name);
        Result result = null;
        Map data = new HashMap();
        if(student != null){
            data.put("studentId", student.getStudentId());
            data.put("name", student.getName());
            data.put("sex", student.getSex());
            data.put("clazz", student.getClazz());
            data.put("department",student.getDepartment());
            data.put("birthday", student.getBirthday());
            data.put("nativePlace", student.getNativePlace());
            result = Result.ok(data);
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        WebUtil.writeJson(resp, result);
    }

    protected void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("studentId"));

        //调用service层实现业务
        int rows = studentService.deleteStudent(id);

        if(rows > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    protected void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("可以访问！username为：" + username);
    }

    /**
     * 根据学生Id查询学生信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        //没有输入数据时，studentId是空串。
        System.out.println(studentId.isEmpty());
        //调用service层方法
        List<Object> students = studentService.findById(studentId);

        Map<String,Student> data = new HashMap<>();
        students.forEach(student -> {
            Student student1 = (Student) student;
            data.put(student1.getStudentId(),student1);
        });

        Result<Map> ok = Result.ok(data);
        WebUtil.writeJson(resp,ok);
    }

    /**
     * 实现对学生对象信息更新的业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体中的参数
        Set<Map.Entry<String, String[]>> entries = req.getParameterMap().entrySet();
        //先创建一个student类，后面用来传参
        Student newStudent = new Student();
        //先规定时间类的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //利用反射给对象属性赋值
        for (Map.Entry<String, String[]> entry : entries) {
            Class<Student> studentClass = Student.class;
            try {
                // 获取student类中的每个属性
                Field declaredField = studentClass.getDeclaredField(entry.getKey());
                // 确保可以访问私有属性
                declaredField.setAccessible(true);
                // 获取属性的类型
                Class<?> fieldType = declaredField.getType();
                //这里获取的会是一个数组，直接赋值会报错，并且数组类型是字符串数组，student类中有些属性类型不是String
                String value = entry.getValue()[0];

                Object convertedValue = null;
                //如果属性不为空就进行类型判断,先假设输入的不能为空,为空直接跳转页面
                if (!value.isEmpty()) {
                    // 根据属性类型进行转换
                    if (fieldType == int.class || fieldType == Integer.class) {
                        convertedValue = Integer.parseInt(value.isEmpty() ? "1" : value);
                    } else if (fieldType == Date.class) {
                        // 假设日期格式为"yyyy-MM-dd"
                        try {
                            convertedValue = dateFormat.parse(value);
                        } catch (ParseException e) {
                            throw new RuntimeException("Date format error", e);
                        }
                    } else {
                        convertedValue = value; // 默认为String类型
                    }
                }
                //给对象中的属性赋值
                declaredField.set(newStudent, convertedValue);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(newStudent);

        //调用service层方法进行数据更新
        int rows = studentService.updateStudent(newStudent);

        if(rows > 0){
            //添加成功
            resp.sendRedirect("/success.html");
        } else {
            //添加失败
            resp.sendRedirect("/queryAndUpdate.html");
        }
    }

    /**
     * 根据发来的数据进行学生信息的添加。
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体中的参数
        Set<Map.Entry<String, String[]>> entries = req.getParameterMap().entrySet();
        //先创建一个student类，后面用来传参
        Student newStudent = new Student();
        //先规定时间类的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //利用反射给对象属性赋值
        for (Map.Entry<String, String[]> entry : entries) {
            Class<Student> studentClass = Student.class;
            try {
                // 获取student类中的每个属性
                Field declaredField = studentClass.getDeclaredField(entry.getKey());
                // 确保可以访问私有属性
                declaredField.setAccessible(true);
                // 获取属性的类型
                Class<?> fieldType = declaredField.getType();
                //这里获取的会是一个数组，直接赋值会报错，并且数组类型是字符串数组，student类中有些属性类型不是String
                String value = entry.getValue()[0];

                Object convertedValue = null;
                //如果属性不为空就进行类型判断,先假设输入的不能为空,为空直接跳转页面
                if (!value.isEmpty()) {
                    // 根据属性类型进行转换
                    if (fieldType == int.class || fieldType == Integer.class) {
                        convertedValue = Integer.parseInt(value.isEmpty() ? "1" : value);
                    } else if (fieldType == Date.class) {
                        // 假设日期格式为"yyyy-MM-dd"
                        try {
                            convertedValue = dateFormat.parse(value);
                        } catch (ParseException e) {
                            throw new RuntimeException("Date format error", e);
                        }
                    } else {
                        convertedValue = value; // 默认为String类型
                    }
                }
                //给对象中的属性赋值
                declaredField.set(newStudent, convertedValue);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //调用service层进行业务处理
        int rows = studentService.insertStudent(newStudent);

        System.out.println("rows:"+rows);
        if(rows > 0){
            //添加成功
            resp.sendRedirect("/success.html");
        } else {
            //添加失败
            resp.sendRedirect("/fail.html");
        }
    }
}