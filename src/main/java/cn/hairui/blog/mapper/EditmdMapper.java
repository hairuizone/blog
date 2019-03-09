package cn.hairui.blog.mapper;

import cn.hairui.blog.model.Editmd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/3/8 20:27
 */
@Mapper
public interface EditmdMapper {

    @Select("select * from editmd where id=#{id}")
    public Editmd queryEditmdById(Integer id);

    @Update("update editmd set content=#{content} where id=#{id}")
    public void updateEditmd(Editmd editmd);
}
