package controller;

import common.Result;
import common.ResultCodeEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.SysSchedule;
import service.SysScheduleService;
import utils.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lty
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BasicController {
    private final SysScheduleService service = new SysScheduleService();
    protected void showInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> schedules = service.showInfo(uid);
        Map<String, List<SysSchedule>> map = new HashMap<>();
        map.put("schedules", schedules);
        Result<Map<String, List<SysSchedule>>> result = Result.ok(map);
        WebUtil.writeJson(resp, result);
    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int i = service.addNewSchedule(uid);
        Result<Object> result;
        if(i > 0){
            result = Result.ok(null);
        } else {
            result = Result.build(null, ResultCodeEnum.ADD_SCHEDULE_ERROR);
        }
        WebUtil.writeJson(resp, result);
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        int i = service.updateSchedule(sysSchedule);
        Result<Object> result;
        if(i > 0){
            result = Result.ok(null);
        } else {
            result = Result.build(null, ResultCodeEnum.UPDATE_SCHEDULE_ERROR);
        }
        WebUtil.writeJson(resp, result);
    }

    protected void dropSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        int i = service.dropSchedule(sid);
        Result<Object> result;
        if(i > 0){
            result = Result.ok(null);
        } else {
            result = Result.build(null, ResultCodeEnum.DROP_SCHEDULE_ERROR);
        }
        WebUtil.writeJson(resp, result);
    }
}
