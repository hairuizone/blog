package cn.hairui.blog.model;

/**
 * @author laoganbu
 * @date: 2019/3/4 16:38
 */
public class Artical {

    private Integer id;//自增主键编号
    private Integer articalId;//文章编号
    private String author;//作者
    private String originAuthor;//原文作者
    private String originUrl;//原文URL
    private String tittle;//标题
    private String imgpath;//背景图片路径
    private String content;//内容
    private String tags;//标签
    private Integer navId;//导航编号 用于在导航栏中显示
    private String topicId;//专题编号
    private Integer categories;//分类
    private String type;//类型（原创、转载）
    private String createDate;//创建日期
    private String updateDate;//更新日期
    private String articalUrl;//本文URL
    private String summary;//摘要
    private Integer lastArticalId;//上一篇
    private Integer nextArticalId;//下一篇
    private Integer likeNums;//喜欢
    private Integer dissNums;//不喜欢
    private String intop;//是否置顶

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticalId() {
        return articalId;
    }

    public void setArticalId(Integer articalId) {
        this.articalId = articalId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginAuthor() {
        return originAuthor;
    }

    public void setOriginAuthor(String originAuthor) {
        this.originAuthor = originAuthor;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getCategories() {
        return categories;
    }

    public void setCategories(Integer categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getArticalUrl() {
        return articalUrl;
    }

    public void setArticalUrl(String articalUrl) {
        this.articalUrl = articalUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getLastArticalId() {
        return lastArticalId;
    }

    public void setLastArticalId(Integer lastArticalId) {
        this.lastArticalId = lastArticalId;
    }

    public Integer getNextArticalId() {
        return nextArticalId;
    }

    public void setNextArticalId(Integer nextArticalId) {
        this.nextArticalId = nextArticalId;
    }

    public Integer getLikeNums() {
        return likeNums;
    }

    public void setLikeNums(Integer likeNums) {
        this.likeNums = likeNums;
    }

    public Integer getDissNums() {
        return dissNums;
    }

    public void setDissNums(Integer dissNums) {
        this.dissNums = dissNums;
    }

    public String getIntop() {
        return intop;
    }

    public void setIntop(String intop) {
        this.intop = intop;
    }
}
