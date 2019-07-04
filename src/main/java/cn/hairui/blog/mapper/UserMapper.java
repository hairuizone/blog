package cn.hairui.blog.mapper;

import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:20
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE USERNAME=#{username} AND PASSWORD=#{password}")
    public User queryUserByNameAndPwd(String username, String password);

}
