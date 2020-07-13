package com.hg.reading.springstart.controller;


import com.hg.reading.springstart.pojo.Comment;
import com.hg.reading.springstart.pojo.Essay;
import com.hg.reading.springstart.pojo.HgUsers;
import com.hg.reading.springstart.service.comment.ICommentService;
import com.hg.reading.springstart.service.essay.IEssayService;
import com.hg.reading.springstart.service.user.IHgUsersService;
import com.hg.reading.springstart.utils.fileup.FileUp;
import com.hg.reading.springstart.utils.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("hg")
public class HgUserController {

    @Autowired
    private IHgUsersService hgUsersService;
    @Autowired
    private IEssayService iEssayService;
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("/login.do")
    public String login(HttpSession session, String userid, Model model) {
        if (!"".equals(userid) && userid != null && !"null".equals(userid)) {
            HgUsers user = (HgUsers) session.getAttribute("user");
            if (user!= null) {
                //Session中的新建user对象只有id，name，password属性
                    user = hgUsersService.getLoginUserByid(user.getUserid());
                List<Essay> allEssay = iEssayService.getAllEssay(Integer.parseInt(userid), new Page());
                int essayCount = iEssayService.getTotal(Integer.parseInt(userid));
                for (Essay essay:allEssay) {
                    List<Comment> comments = iCommentService.getComments(essay.getEssayid());
                    essay.setComments(comments);
                }
                model.addAttribute("allEssay", allEssay);
                model.addAttribute("essayCount", essayCount);
                if (user.getUserid() == Integer.parseInt(userid)) {
                    model.addAttribute("user",user);
                    model.addAttribute("status",true);
                } else {
                    HgUsers users = hgUsersService.getLoginUserByid(Integer.parseInt(userid));
                    model.addAttribute("user",users);
                    model.addAttribute("status",false);
                }
                return "self";
            } else {
                return "redirect:login.do";
            }
        }
        model.addAttribute("isDirect", false);
        return "login";
    }

    @RequestMapping("/username.do")
    @ResponseBody
    public Map<String, Object> nameLogin(String username) {
        HgUsers user = hgUsersService.getLoginUser(username);

        Map<String, Object> result = new HashMap<>();
        if (user == null) {//用户不存在
            result.put("flag", false);
            result.put("msg", "用户名不存在");
            return result;
        }
        result.put("flag", true);
        result.put("msg", "");
        return result;
    }

    @PostMapping("/log")
    public String userLogin(HttpSession session, String username, String password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("isDirect", true);
        //调用根据用户名和密码查询用户的方法
        HgUsers user = hgUsersService.getLoginUser(username);
        if (user == null) {//用户不存在
            /*model.addAttribute("err_msg", "用户名错误");*/
            return "login";
        } else if (!password.equals(user.getPassword())) {//该用户存在
            model.addAttribute("err_msg", "密码错误");
            return "login";
        } else {
            List<Essay> allEssay = iEssayService.getAllEssay(user.getUserid(), new Page());
            int essayCount = iEssayService.getTotal(user.getUserid());
            for (Essay essay:allEssay) {
                List<Comment> comments = iCommentService.getComments(essay.getEssayid());
                essay.setComments(comments);
            }

            session.setAttribute("user", user);
            model.addAttribute("status",true);
            model.addAttribute("user",user);
            model.addAttribute("allEssay", allEssay);
            model.addAttribute("essayCount", essayCount);
            return "self";
        }
    }

    @RequestMapping("logon.do")
    public String insertUser(String regname, String regpass,String reregpass,Model model) {
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        model.addAttribute("isDirect", false);
        if (regpass.equals(reregpass)){
            HgUsers hgUser = new HgUsers();
            hgUser.setUsername(regname);
            hgUser.setPassword(reregpass);
            hgUsersService.insertUser(hgUser);
            model.addAttribute("err_msg","请使用注册账号登录");
            return "login";
        }
        model.addAttribute("err_msg","密码不一致，请重新注册");
        return "login";
    }

    @RequestMapping("edit.do")
    public String editUserById(String userid,Model model){
        if (!"".equals(userid) && userid != null && !"null".equals(userid)) {
            HgUsers user = hgUsersService.getLoginUserByid(Integer.parseInt(userid));
            model.addAttribute("user",user);
            return "edit";
        }
        return null;
    }

    @RequestMapping("submit.do")
    public String updateUser(HgUsers user,@RequestParam("file") MultipartFile file,@RequestParam("bfile") MultipartFile bfile,Model model){
        System.out.println(user);
        user.setImg(FileUp.fileUp(file));
        user.setBimg(FileUp.fileUp(bfile));
        int status = hgUsersService.updateUser(user);
        if (status!=0){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");
        }
        model.addAttribute("user",user);
        return "edit";
    }

    @RequestMapping("/test")
    public String userTest() {
        return "test";
    }

}
