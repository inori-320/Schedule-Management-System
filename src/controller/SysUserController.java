package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Result;
import common.ResultCodeEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.SysUser;
import service.SysUserService;
import utils.MD5Util;
import utils.WebUtil;

import java.io.IOException;

/**
 * @author lty
 */
@WebServlet("/user/*")
public class SysUserController extends BasicController {
    private final SysUserService service = new SysUserService();
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = service.register(sysUser);
        if(rows > 0){
            resp.sendRedirect("/registerSuccess.html");
        } else {
            resp.sendRedirect("/registerFail.html");
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = service.findInfoByUsername(username);
        if(sysUser == null){
            resp.sendRedirect("/loginUsernameError.html");
        } else if(!MD5Util.encrypt(userPwd).equals(sysUser.getUserPwd())) {
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", sysUser);
            resp.sendRedirect("/showSchedule.html");
        }
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