package com.hg.reading.springstart.mapper.user;

import com.hg.reading.springstart.pojo.HgUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface HgUsersMapper {

    //通过用户名查询用户
    HgUsers getLoginUser(String username);

    //通过用户id查询用户
    HgUsers getLoginUserById(Integer userid);

    //通过用户id修改用户资料
    int updateUser(HgUsers user);

    //注册用户
    int insertUser(HgUsers user);

}
