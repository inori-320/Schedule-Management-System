package DAO;

import lombok.NoArgsConstructor;
import pojo.SysSchedule;

import java.util.List;

/**
 * @author lty
 */
@NoArgsConstructor
public class SysScheduleDAO extends BasicDAO<SysSchedule> {
    private String sql;
    public int addSchedule(int uid){
        sql = "insert into sys_schedule values(null, ?, null, null)";
        return dml(sql, uid);
    }

    public List<SysSchedule> findAll(int uid){
        sql = "select * from sys_schedule where uid = ?";
        return queryMulti(sql, SysSchedule.class, uid);
    }

    public int updateSchedule(SysSchedule sysSchedule){
        int sid = sysSchedule.getSid(), completed = sysSchedule.getCompleted();
        String title = sysSchedule.getTitle();
        sql = "update sys_schedule set title = ?, completed = ? where sid = ?";
        return dml(sql, title, completed, sid);
    }

    public int dropSchedule(int sid){
        sql = "delete from sys_schedule where sid = ?";
        return dml(sql, sid);
    }
}
