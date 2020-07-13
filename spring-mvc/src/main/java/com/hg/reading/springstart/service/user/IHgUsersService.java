package com.hg.reading.springstart.service.user;

import com.hg.reading.springstart.pojo.HgUsers;

public interface IHgUsersService {

    public HgUsers getLoginUser(String username);

    //注册用户
    int insertUser(HgUsers hgUser);

    //通过用户id查询用户
    HgUsers getLoginUserByid(Integer userid);

    //通过用户id修改用户资料
    int updateUser(HgUsers user);

}
