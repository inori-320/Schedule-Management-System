package pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author lty
 */
public class SysUser implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;

    public SysUser() {}

    public SysUser(Integer sid, Integer uid, String title, Integer completed) {
        this.sid = sid;
        this.uid = uid;
        this.title = title;
        this.completed = completed;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(sid, sysUser.sid) && Objects.equals(uid, sysUser.uid) && Objects.equals(title, sysUser.title) && Objects.equals(completed, sysUser.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, uid, title, completed);
    }
}
