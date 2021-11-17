package top.ycshang.basedao.serializable;

import java.io.Serializable;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-17 23:58
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private transient String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}