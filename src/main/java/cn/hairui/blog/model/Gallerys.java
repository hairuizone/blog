package cn.hairui.blog.model;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/7/5 22:04
 */
public class Gallerys {
    private Integer id;
    private String name;
    private String showImg;
    private String showFlag;
    private String introduction;
    private String createTime;
    private String creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Gallerys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", showImg='" + showImg + '\'' +
                ", showFlag='" + showFlag + '\'' +
                ", introduction='" + introduction + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
