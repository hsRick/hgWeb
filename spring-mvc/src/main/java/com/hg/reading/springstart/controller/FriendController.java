package com.hg.reading.springstart.controller;

import com.hg.reading.springstart.pojo.Friend;
import com.hg.reading.springstart.pojo.HgUsers;
import com.hg.reading.springstart.service.friend.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class FriendController {
    @Autowired
    private IFriendService iFriendService;

    /*@RequestMapping("/friend.do")
    @ResponseBody
    public Map<String, Object> getFriendListByid(Integer id){
        Map<String, Object> result = new HashMap<>();
        if (id!=null){
            List<HgUsers> friendList = iFriendService.getFriendList(id);
            result.put("result",friendList);
            System.out.println(result);
        }else {
            result.put("result",null);
        }
        return result;
    }*/

    @RequestMapping("/friend.do")
    @ResponseBody
    public List<HgUsers> getFriendListByid(Integer userid){
        if (userid!=null){
            List<HgUsers> friendList = iFriendService.getFriendList(userid);
            System.out.println(friendList);
            return friendList;
        }
        return null;
    }

    @RequestMapping("/insertFriend.do")
    @ResponseBody
    public String insertFriend(Friend friend) {
        int i = iFriendService.insertFriend(friend);
        return "{\"message\":\"请求已发送\"}";
    }

    @RequestMapping("getApplyList.do")
    public String getApplyList(int selfid, Model model){
        List<HgUsers> applyList = iFriendService.getApplyList(selfid);
        model.addAttribute("selfid",selfid);
        model.addAttribute("applyList",applyList);
        return "apply";
    }

    @RequestMapping("/hfFriend.do")
    @ResponseBody
    public String hfFriend(Friend friend) {
        Friend f = new Friend();
        f.setSelfid(friend.getFriendid());
        f.setFriendid(friend.getSelfid());
        f.setStatus(friend.getStatus());
        if (friend.getStatus()!=2){
            int a = iFriendService.deleteFriend(f);
            return "{'message':'已拒绝'}";
        }
        int b = iFriendService.insertFriend(friend);
        int c = iFriendService.updateFriend(f);
        return "{\"message\":\"已同意\"}";
    }
}
