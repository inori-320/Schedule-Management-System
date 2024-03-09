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
    public int addSchedule(SysSchedule sysSchedule){
        sql = "insert into sys_schedule values(null, ?, ?, ?)";
        return dml(sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
    }

    public List<SysSchedule> findAll(){
        sql = "select * from sys_schedule";
        return queryMulti(sql, SysSchedule.class);
    }
}
