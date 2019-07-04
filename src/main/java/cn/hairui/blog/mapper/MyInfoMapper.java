package cn.hairui.blog.mapper;

import cn.hairui.blog.model.MusicList;
import cn.hairui.blog.model.MyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author laoganbu
 * @date: 2019/3/4 11:28
 */
@Mapper
public interface MyInfoMapper {

    @Select("select * from my_info where id=#{id}")
    public MyInfo findMyInfoById(Integer id);

    @Update("update my_info set " +
            "NICKNAME=#{nickname}," +
            "name=#{name}," +
            "webname=#{webname}," +
            "occupation=#{occupation}," +
            "address=#{address}," +
            "email=#{email}," +
            "website=#{website}," +
            "qq=#{qq}," +
            "wechat=#{wechat}," +
            "webroot=#{webroot}," +
            "webicon=#{webicon}," +
            "motto=#{motto}," +
            "prophoto=#{prophoto}," +
            "github=#{github}," +
            "weibo=#{weibo}," +
            "brandimg=#{brandimg} where id=#{id}")
    public int updateMyInfo(MyInfo myInfo);



    @Select("SELECT * FROM MUSIC_LIST WHERE ID=#{id}")
    public MusicList queryMusicListById(Integer id);

    @Update("UPDATE MUSIC_LIST SET " +
            "LIST_NAME_ONE=#{listNameOne}," +
            "LIST_NO_ONE=#{listNoOne}," +
            "LIST_NAME_TWO=#{listNameTwo}," +
            "LIST_NO_TWO=#{listNoTwo}," +
            "LIST_NAME_THREE=#{listNameThree}," +
            "LIST_NO_THREE=#{listNoThree}," +
            "LIST_NAME_FOUR=#{listNameFour}," +
            "LIST_NO_FOUR=#{listNoFour}," +
            "LIST_NAME_FIVE=#{listNameFive}," +
            "LIST_NO_FIVE=#{listNoFive}," +
            "DEFAULT_LIST=#{defaultList} WHERE ID=#{id}")
    public int updateMusicListInfo(MusicList music);
}
