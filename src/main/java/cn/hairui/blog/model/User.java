package cn.hairui.blog.model;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:13
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String prophoto;
    private String email;
    private String mobile;
    private String lockflag;
    private String adminflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProphoto() {
        return prophoto;
    }

    public void setProphoto(String prophoto) {
        this.prophoto = prophoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLockflag() {
        return lockflag;
    }

    public void setLockflag(String lockflag) {
        this.lockflag = lockflag;
    }

    public String getAdminflag() {
        return adminflag;
    }

    public void setAdminflag(String adminflag) {
        this.adminflag = adminflag;
    }
}
