package cn.hairui.blog.mapper;

import cn.hairui.blog.model.OnlineTools;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:52
 */
@Mapper
public interface OnlineToolsMapper {

    @Select("select * from online_tools")
    public List<OnlineTools> queryOnlineToolsList();
}
