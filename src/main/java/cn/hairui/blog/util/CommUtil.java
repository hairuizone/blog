package cn.hairui.blog.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.Map;

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
}
