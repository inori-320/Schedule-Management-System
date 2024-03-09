import DAO.SysScheduleDAO;
import DAO.SysUserDAO;
import pojo.SysSchedule;
import pojo.SysUser;

import java.util.List;

/**
 * @author lty
 */
public class Main {
    public static void main(String[] args) {
        SysSchedule sysSchedule = new SysSchedule(null, 2, "学习MySQL", 0);
        SysScheduleDAO sysScheduleDAO = new SysScheduleDAO();
        int i = sysScheduleDAO.addSchedule(sysSchedule);
        System.out.println(i);
    }
}
