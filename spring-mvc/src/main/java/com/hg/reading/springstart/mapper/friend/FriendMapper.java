package com.hg.reading.springstart.mapper.friend;

import com.hg.reading.springstart.pojo.Friend;
import com.hg.reading.springstart.pojo.HgUsers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendMapper {

    //通过用户id查询好友集合
    List<HgUsers> getFriendList(int userid);

    //通过用户对象添加好友
    int insertFriend(Friend friend);

    //通过用户id查询申请列表
    List<HgUsers> getApplyList(int userid);

    //删除好友
    int deleteFriend(Friend friend);

    //更改状态
    int updateFriend(Friend friend);

}
