package cn.hairui.blog.util;

import java.io.File;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/15 23:41
 */
public class FileUtil {
    /**
     * 删除单个文件
     *
     * @param path 文件全路径
     */
    public static void deleteSingleFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
    public static void main(String[] args){
        deleteSingleFile("D:/upload/video/ckin.mp4");
    }
}
