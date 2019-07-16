package cn.hairui.blog.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/20 23:29
 */
public class CommUtil {

    /**
     * 将对象装换为map
     */
    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new org.apache.commons.beanutils.BeanMap(obj);
    }

    /**
     * 创建标签随机颜色
     *
     * @return
     */
    public static String createRandomColor() {
        List list = new ArrayList<>();
        list.add("#E8F8F5");
        list.add("#D5F5E3");
        list.add("#FEF9E7");
        list.add("#F8F9F9");
        list.add("#82E0AA");
        list.add("#D7BDE2");
        list.add("#A3E4D7");
        list.add("#85C1E9");
        list.add("#F8C471");
        list.add("#F9E79F");
        list.add("#A3E4D7");
        list.add("#82E0AA");
        list.add("#F9E79F");
        list.add("#85C1E9");
        list.add("#BDE9DD");
        list.add("#E9DFBD");
        list.add("#E9D0DE");
        list.add("#CED7E9");
        list.add("#D4C9E9");
        list.add("#E3F7DD");
        list.add("#B8E3E9");
        int i = new Random().nextInt(19);//0-19随机图片
        return (String) list.get(i);
    }
}
