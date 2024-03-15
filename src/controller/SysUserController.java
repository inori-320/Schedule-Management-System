package controller;

import common.Result;
import common.ResultCodeEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.SysUser;
import service.SysUserService;
import utils.MD5Util;
import utils.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lty
 */
@WebServlet("/user/*")
public class SysUserController extends BasicController {
    private final SysUserService service = new SysUserService();
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        int rows = service.register(sysUser);
        Result<Object> result;
        if(rows == 0){
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        } else {
            result = Result.build(null, ResultCodeEnum.SUCCESS);
        }
        WebUtil.writeJson(resp, result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser loginUser = WebUtil.readJson(req, SysUser.class);
        SysUser sysUser = service.findInfoByUsername(loginUser.getUsername());
        Result<Object> result;
        if(sysUser == null){
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        } else if(!MD5Util.encrypt(loginUser.getUserPwd()).equals(sysUser.getUserPwd())) {
            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        } else {
            Map<String, SysUser> data = new HashMap<>();
            loginUser.setUserPwd("");
            data.put("loginUser", loginUser);
            result = Result.ok(data);
        }
        WebUtil.writeJson(resp, result);
    }

    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        SysUser sysUser = service.findInfoByUsername(username);
        Result result = Result.ok(null);
        if(sysUser != null){
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }
}