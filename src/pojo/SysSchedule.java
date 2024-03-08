package pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author lty
 */
public class SysSchedule implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;

    public SysSchedule() {}

    public SysSchedule(Integer uid, String username, String userPwd) {
        this.uid = uid;
        this.username = username;
        this.userPwd = userPwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysSchedule that = (SysSchedule) o;
        return Objects.equals(uid, that.uid) && Objects.equals(username, that.username) && Objects.equals(userPwd, that.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd);
    }
}
