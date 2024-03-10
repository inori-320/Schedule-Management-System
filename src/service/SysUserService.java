package service;

import DAO.SysUserDAO;
import pojo.SysUser;
import utils.MD5Util;

/**
 * @author lty
 */
public class SysUserService {
    private SysUserDAO dao = new SysUserDAO();
    public int register(SysUser sysUser){
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return dao.addSysUser(sysUser);
    }

    public SysUser findInfoByUsername(String username){
        return dao.findUserInfo(username);
    }
}
