package cn.hairui.blog.model;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/4 21:03
 */
public class ArticalCategories {
    private Integer id;//编号
    private String categoryName;//分类名称
    private String isShow;//是否展示
    private Integer showOrder;//展示顺序
    private Integer articalCount;//文章数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getArticalCount() {
        return articalCount;
    }

    public void setArticalCount(Integer articalCount) {
        this.articalCount = articalCount;
    }
}
