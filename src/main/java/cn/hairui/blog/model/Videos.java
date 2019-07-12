package cn.hairui.blog.model;

/**
 * <p>
 * <h2>请添加说明
 * </h2>
 * <ol>请添加详细说明
 * </ol>
 *
 * <h2>修改历史
 * </h2>
 * <ol>如有修改，请添加修改历史
 * </ol>
 *
 * </p>
 *
 * @author laoganbu
 * @version V1.0
 * @date 2019/7/12 11:29
 */
public class Videos {
    private Integer id;
    private String name;
    private String vtype;
    private Integer publishYear;
    private String introduction;
    private String coverPath;
    private String filePath;
    private String showFlag;
    private String creator;
    private String createTime;

    @Override
    public String toString() {
        return "Videos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vtype='" + vtype + '\'' +
                ", publishYear=" + publishYear +
                ", introduction='" + introduction + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", filePath='" + filePath + '\'' +
                ", showFlag='" + showFlag + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

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

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
