package com.hnust.system.web;

import com.hnust.system.common.Result;
import com.hnust.system.pojo.vo.PunishmentVo;
import com.hnust.system.service.PunishmentService;
import com.hnust.system.service.impl.PunishmentServiceImpl;
import com.hnust.system.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/punishment/*")
public class StudentPunishmentServlet extends BaseServlet{

    private final PunishmentService punishmentService = new PunishmentServiceImpl();

    /**
     * 根据Id记录号删除处罚的记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));


        //System.out.println(id);
        //调用service层处理业务逻辑
        int rows = punishmentService.deleteById(id);

        if(rows > 0){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 根据输入的表单数据添加一条记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insertPunishment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PunishmentVo punishmentVo = new PunishmentVo();
        punishmentVo.setId(null);
        punishmentVo.setStudentId(req.getParameter("studentId"));
        punishmentVo.setLevels(Integer.parseInt(req.getParameter("levels")));
        //时间默认为当前时间，所以在这里不需要赋值。
        punishmentVo.setEnable(req.getParameter("enable"));
        punishmentVo.setDescription(req.getParameter("description"));

        System.out.println(punishmentVo);

        int rows = punishmentService.insertPunishment(punishmentVo);

        if(rows > 0){
            System.out.println("插入处罚记录成功");
        } else {
            System.out.println("插入处罚记录失败");
        }

    }

    /**
     * 实现查询所有处罚记录的的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllPunishments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object> punishments = punishmentService.finAllPunishments();

        System.out.println("findAllPunishments方法执行了");
        Map data = new HashMap();
        punishments.forEach(punishment -> {
            PunishmentVo punishmentVo = (PunishmentVo)punishment;
            System.out.println(punishmentVo);
            data.put(punishmentVo.getId(),punishmentVo);
        });

        WebUtil.writeJson(resp, Result.ok(data));
    }
}
