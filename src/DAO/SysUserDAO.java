package DAO;

import lombok.NoArgsConstructor;
import pojo.SysUser;

import java.sql.SQLException;

/**
 * @author lty
 */
@NoArgsConstructor
public class SysUserDAO extends BasicDAO<SysUser> {
    private String sql;

    public int addSysUser(SysUser sysUser){
        sql = "insert into sys_user values(NULL, ?, ?)";
        try {
            return dml(sql, sysUser.getUsername(), sysUser.getUserPwd());
        } catch (Exception e){
            return 0;
        }
    }

    public SysUser findUserInfo(String username){
        sql = "select uid, username, user_pwd as userPwd from sys_user where username = ?";
        try {
            return querySingle(sql, SysUser.class, username);
        } catch (Exception e){
            return null;
        }
    }
}
