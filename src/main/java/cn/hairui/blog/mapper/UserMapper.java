package cn.hairui.blog.mapper;

import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lihairui
 * @version V1.0
 * @date: 2019/6/29 21:20
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE USERNAME=#{username} AND PASSWORD=#{password} LIMIT 1")
    public User queryUserByNameAndPwd(String username, String password);

    @Select("SELECT * FROM USER WHERE USERNAME != 'admin'")
    public List<User> queryUserList();

    @Select("SELECT * FROM USER WHERE ADMIN_FLAG='N'")
    public List<User> queryNormalUserList();

    @Update("UPDATE USER SET PASSWORD=#{newPwd} WHERE ID=#{id}")
    public int updateUserPwd(Integer id, String newPwd);

    @Update("UPDATE USER SET LOCKFLAG=#{lock} WHERE ID=#{id}")
    public int updateUserLockSts(Integer id, String lock);
}
