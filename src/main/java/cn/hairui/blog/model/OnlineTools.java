package cn.hairui.blog.model;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:50
 */
public class OnlineTools {
    private Integer id;//序号
    private String toolName;//工具名称
    private String url;//网址
    private String introduce;//介绍
    private String addDate;//添加日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
