package cn.hairui.blog.mapper;

import cn.hairui.blog.model.NavIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author laoganbu
 * @date: 2019/3/4 14:57
 */
@Mapper
public interface NavIndexMapper {
    @Select("select * from nav_index where id=#{id}")
    public NavIndex findNavIndexById(Integer id);

    @Select("select * from nav_index")
    public List<NavIndex> queryNavIndexList();
}
