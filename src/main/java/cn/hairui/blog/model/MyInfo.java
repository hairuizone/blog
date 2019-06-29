package cn.hairui.blog.model;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/3 21:42
 */
public class MyInfo {
    public int id;
    public String nickname;
    public String name;
    public String webname;
    public String occupation;
    public String address;
    public String email;
    public String website;
    public String qq;
    public String wechat;
    public String webroot;
    public String webicon;
    public String motto;
    public String prophoto;
    public String github;
    public String weibo;
    public String brandimg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBrandimg() {
        return brandimg;
    }

    public void setBrandimg(String brandimg) {
        this.brandimg = brandimg;
    }

    public String getWebicon() {
        return webicon;
    }

    public void setWebicon(String webicon) {
        this.webicon = webicon;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getProphoto() {
        return prophoto;
    }

    public void setProphoto(String prophoto) {
        this.prophoto = prophoto;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getWebroot() {
        return webroot;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "MyInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", webname='" + webname + '\'' +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", webroot='" + webroot + '\'' +
                ", webicon='" + webicon + '\'' +
                ", motto='" + motto + '\'' +
                ", prophoto='" + prophoto + '\'' +
                ", github='" + github + '\'' +
                ", weibo='" + weibo + '\'' +
                ", brandimg='" + brandimg + '\'' +
                '}';
    }
}
