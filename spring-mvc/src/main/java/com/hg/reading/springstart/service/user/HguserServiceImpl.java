package com.hg.reading.springstart.service.user;

import com.hg.reading.springstart.mapper.user.HgUsersMapper;
import com.hg.reading.springstart.pojo.HgUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HguserServiceImpl implements IHgUsersService{
    @Autowired
    private HgUsersMapper hgUsersMapper;

    @Override
    public HgUsers getLoginUser(String username) {
        return hgUsersMapper.getLoginUser(username);
    }

    @Override
    public int insertUser(HgUsers hgUser) {
        return hgUsersMapper.insertUser(hgUser);
    }

    @Override
    public HgUsers getLoginUserByid(Integer userid) {
        return hgUsersMapper.getLoginUserById(userid);
    }

    @Override
    public int updateUser(HgUsers user) {
        return hgUsersMapper.updateUser(user);
    }
}
