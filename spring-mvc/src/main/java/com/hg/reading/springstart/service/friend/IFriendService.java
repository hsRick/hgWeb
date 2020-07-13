package com.hg.reading.springstart.service.friend;

import com.hg.reading.springstart.pojo.Friend;
import com.hg.reading.springstart.pojo.HgUsers;

import java.util.List;

public interface IFriendService {

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
