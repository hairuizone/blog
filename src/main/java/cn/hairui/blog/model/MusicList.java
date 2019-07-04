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
 * @date 2019/7/4 15:32
 */
public class MusicList {
    private Integer id;//编号

    private String listNameOne;//歌单1
    private String listNoOne;

    private String listNameTwo;
    private String listNoTwo;

    private String listNameThree;
    private String listNoThree;

    private String listNameFour;
    private String listNoFour;

    private String listNameFive;
    private String listNoFive;

    private String defaultList;//默认歌单

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListNameOne() {
        return listNameOne;
    }

    public void setListNameOne(String listNameOne) {
        this.listNameOne = listNameOne;
    }

    public String getListNoOne() {
        return listNoOne;
    }

    public void setListNoOne(String listNoOne) {
        this.listNoOne = listNoOne;
    }

    public String getListNameTwo() {
        return listNameTwo;
    }

    public void setListNameTwo(String listNameTwo) {
        this.listNameTwo = listNameTwo;
    }

    public String getListNoTwo() {
        return listNoTwo;
    }

    public void setListNoTwo(String listNoTwo) {
        this.listNoTwo = listNoTwo;
    }

    public String getListNameThree() {
        return listNameThree;
    }

    public void setListNameThree(String listNameThree) {
        this.listNameThree = listNameThree;
    }

    public String getListNoThree() {
        return listNoThree;
    }

    public void setListNoThree(String listNoThree) {
        this.listNoThree = listNoThree;
    }

    public String getListNameFour() {
        return listNameFour;
    }

    public void setListNameFour(String listNameFour) {
        this.listNameFour = listNameFour;
    }

    public String getListNoFour() {
        return listNoFour;
    }

    public void setListNoFour(String listNoFour) {
        this.listNoFour = listNoFour;
    }

    public String getListNameFive() {
        return listNameFive;
    }

    public void setListNameFive(String listNameFive) {
        this.listNameFive = listNameFive;
    }

    public String getListNoFive() {
        return listNoFive;
    }

    public void setListNoFive(String listNoFive) {
        this.listNoFive = listNoFive;
    }

    public String getDefaultList() {
        return defaultList;
    }

    public void setDefaultList(String defaultList) {
        this.defaultList = defaultList;
    }

    @Override
    public String toString() {
        return "MusicList{" +
                "id=" + id +
                ", listNameOne='" + listNameOne + '\'' +
                ", listNoOne='" + listNoOne + '\'' +
                ", listNameTwo='" + listNameTwo + '\'' +
                ", listNoTwo='" + listNoTwo + '\'' +
                ", listNameThree='" + listNameThree + '\'' +
                ", listNoThree='" + listNoThree + '\'' +
                ", listNameFour='" + listNameFour + '\'' +
                ", listNoFour='" + listNoFour + '\'' +
                ", listNameFive='" + listNameFive + '\'' +
                ", listNoFive='" + listNoFive + '\'' +
                ", defaultList='" + defaultList + '\'' +
                '}';
    }
}
