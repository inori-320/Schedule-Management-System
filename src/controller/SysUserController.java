package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.SysUser;
import service.SysUserService;
import utils.MD5Util;

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
        String loginPwd = service.findPwdByUsername(username);
        if(loginPwd == null){
            resp.sendRedirect("/loginUsernameError.html");
        } else if(!MD5Util.encrypt(userPwd).equals(loginPwd)) {
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            resp.sendRedirect("/showSchedule.html");
        }
    }
}