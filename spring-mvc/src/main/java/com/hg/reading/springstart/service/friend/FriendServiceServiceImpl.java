package com.hg.reading.springstart.service.friend;

import com.hg.reading.springstart.mapper.friend.FriendMapper;
import com.hg.reading.springstart.pojo.Friend;
import com.hg.reading.springstart.pojo.HgUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceServiceImpl implements IFriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<HgUsers> getFriendList(int userid) {
        List<HgUsers> usersList = friendMapper.getFriendList(userid);
        List<HgUsers> list = new ArrayList<>();
        for (HgUsers users: usersList) {
            if (users.getStatus()==2){
                list.add(users);
            }
        }
        return list;
    }

    @Override
    public int insertFriend(Friend friend) {

        return friendMapper.insertFriend(friend);
    }

    @Override
    public List<HgUsers> getApplyList(int userid) {
        List<HgUsers> usersList = friendMapper.getApplyList(userid);
        List<HgUsers> list = new ArrayList<>();
        for (HgUsers users: usersList) {
            if (users.getStatus()==0){
                list.add(users);
            }
        }
        return list;
    }

    @Override
    public int deleteFriend(Friend friend) {
        return friendMapper.deleteFriend(friend);
    }

    @Override
    public int updateFriend(Friend friend) {
        return friendMapper.updateFriend(friend);
    }
}
