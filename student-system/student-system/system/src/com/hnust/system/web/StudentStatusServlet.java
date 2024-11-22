package com.hnust.system.web;

import com.hnust.system.common.Result;
import com.hnust.system.pojo.vo.ChangeVo;
import com.hnust.system.service.ChangeService;
import com.hnust.system.service.StudentService;
import com.hnust.system.service.impl.ChangeServiceImpl;
import com.hnust.system.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/studentStatus/*")
public class StudentStatusServlet extends BaseServlet{

    private final ChangeService changeService = new ChangeServiceImpl();

    /**
     * 根据表中的记录号删除一条学籍修改记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteStatusById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        int rows = changeService.deleteById(id);

        if(rows > 0){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }

    /**
     * 根据表单信息插入学籍变化数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateStudentStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String change = req.getParameter("change");
        String description = req.getParameter("description");
        int rows = 0;
        if(!studentId.isEmpty() && !change.isEmpty()){
            ChangeVo changeVo = new ChangeVo(null,studentId,Integer.parseInt(change),null,description);
            rows = changeService.updateStudentStatus(changeVo);
        }
        if(rows > 0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }

    /**
     * 查询所有的学籍变更信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findStudentStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object> changes = changeService.findChange();

        Map data = new HashMap();
        changes.forEach(change -> {
            ChangeVo changeVo = (ChangeVo)change;
            data.put(changeVo.getId(),changeVo);
        });

        Result<Map> ok = Result.ok(data);
        WebUtil.writeJson(resp,ok);
    }
}
