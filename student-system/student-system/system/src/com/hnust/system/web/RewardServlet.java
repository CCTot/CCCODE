package com.hnust.system.web;

import com.hnust.system.common.Result;
import com.hnust.system.pojo.vo.RewardVo;
import com.hnust.system.service.RewardService;
import com.hnust.system.service.impl.RewardServiceImpl;
import com.hnust.system.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/reward/*")
public class RewardServlet extends BaseServlet{

    private final RewardService rewardService = new RewardServiceImpl();


    protected void deleteRewardById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        //调用service层实现业务
        int rows = rewardService.deleteById(id);

        if(rows > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    /**
     *  根据输入的信息，插入一条学生奖励记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void insertReward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RewardVo rewardVo = new RewardVo();
        rewardVo.setId(null);
        rewardVo.setStudentId(req.getParameter("studentId"));
        rewardVo.setLevels(Integer.parseInt(req.getParameter("levels")));
        //修改时间默认设置为当前时间
        rewardVo.setDescription(req.getParameter("description"));

        System.out.println(rewardVo);

        int rows = rewardService.insertReward(rewardVo);

        if(rows > 0){
            System.out.println("奖励记录插入成功");
        } else {
            System.out.println("奖励记录插入失败");
        }
    }

    /**
     * 查询所有的学生奖励记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllRewards(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("前端发送请求有用");
        List<Object> rewards = rewardService.findAllRewards();

        Map data = new HashMap();
        rewards.forEach(reward -> {
            RewardVo rewardVo = (RewardVo)reward;
            if(rewardVo.getStudentId() != null){
                data.put(rewardVo.getId(),rewardVo);
            }
        });

        WebUtil.writeJson(resp, Result.ok(data));
    }
}
