package cn.hairui.blog.mapper;

import cn.hairui.blog.model.MyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author laoganbu
 * @date: 2019/3/4 11:28
 */
@Mapper
public interface MyInfoMapper {

    @Select("select * from my_info where id=#{id}")
    public MyInfo findMyInfoById(Integer id);

}
