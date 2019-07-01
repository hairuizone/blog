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
    private String introduction;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

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

    @Override
    public String toString() {
        return "ArticalCategories{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", isShow='" + isShow + '\'' +
                ", showOrder=" + showOrder +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
