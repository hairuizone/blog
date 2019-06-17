package cn.hairui.blog.mapper;

import cn.hairui.blog.model.OnlineTools;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/5 11:52
 */
@Mapper
public interface OnlineToolsMapper {

    @Select("select * from online_tools")
    public List<OnlineTools> queryOnlineToolsList();

    @Select("select count(1) from online_tools where tool_name=#{toolName}")
    public int queryOnlineToolsByName(String toolName);

    @Insert("insert into online_tools(tool_name,url,introduce,add_date) value (#{toolName},#{url},#{introduce},#{addDate})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int addOnlineTools(OnlineTools onlineTools);

    @Select("select * from online_tools where id=#{id}")
    public OnlineTools queryOnlineToolsById(int id);

    @Update("update online_tools set tool_name=#{toolName},url=#{url},introduce=#{introduce},add_date=#{addDate} where id=#{id}")
    public int updateOnlineTools(OnlineTools onlineTools);

    @Delete("delete from online_tools where id=#{id}")
    public int deleteOnlineToolsById(String id);

    @Select("select * from online_tools order by id desc  limit 0,#{maxSize}")
    public List<OnlineTools> queryOnlineToolsListLimited(int maxSize);
}
