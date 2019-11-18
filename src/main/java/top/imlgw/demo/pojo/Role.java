package top.imlgw.demo.pojo;

import org.apache.catalina.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author imlgw.top
 * @date 2019/11/18 19:01
 */
public class Role {
    private  Integer rid;

    private  String rname;

    private Set<Permission> permissions=new HashSet<>();

    private Set<User> users=new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
