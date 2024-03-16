package service;

import DAO.SysScheduleDAO;
import pojo.SysSchedule;

import java.util.List;

/**
 * @author lty
 */
public class SysScheduleService {
    private final SysScheduleDAO dao = new SysScheduleDAO();

    public List<SysSchedule> showInfo(int uid){
        return dao.findAll(uid);
    }

    public int addNewSchedule(int uid){
        return dao.addSchedule(uid);
    }

    public int updateSchedule(SysSchedule sysSchedule){
        return dao.updateSchedule(sysSchedule);
    }

    public int dropSchedule(int sid){
        return dao.dropSchedule(sid);
    }
}
