package com.hg.reading.springstart.controller;

import com.hg.reading.springstart.pojo.Book;
import com.hg.reading.springstart.pojo.Comment;
import com.hg.reading.springstart.pojo.Essay;
import com.hg.reading.springstart.pojo.HgUsers;
import com.hg.reading.springstart.service.comment.ICommentService;
import com.hg.reading.springstart.service.essay.IEssayService;
import com.hg.reading.springstart.utils.fileup.FileUp;
import com.hg.reading.springstart.utils.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class EssayController {
    @Autowired
    private IEssayService iEssayService;
    @Autowired
    private ICommentService iCommentService;

    @RequestMapping("index.do")
    public String getAllEssay(HttpSession session, Model model){
        //if (!"".equals(userid)&&userid!=null&&!"null".equals(userid)){}
        HgUsers user = (HgUsers) session.getAttribute("user");
        System.out.println(user);
        model.addAttribute("user",user);
        return "index";
    }

    @ResponseBody
    @RequestMapping("getEssay.do")
    public Map<String,Object> getEssay(Integer currentPage, Integer pageSize){
        Page page = new Page();
        //得到帖总量
        page.setTotal(iEssayService.getTotal(null));
        if (currentPage!=null){
            page.setCurrentPage(currentPage);
        }
        if (pageSize!=null){
            page.setPageSize(pageSize);
        }
        page.setPageAge();
        page.setPageCount();

        List<Essay> allEssay = iEssayService.getAllEssay(null,page);
        Map<String,Object> data = new HashMap<>();
        data.put("allEssay",allEssay);
        data.put("page",page);
        return data;
    }

    @RequestMapping("posting.do")
    public String toPosting(String userid,Model model){
        if (userid!=null&&userid!=""&&userid!="null"){
            model.addAttribute("userid",Integer.parseInt(userid));
            model.addAttribute("msg","");
        }
        return "posting";
    }

    @RequestMapping("insertEssay.do")
    public String insertEssay(Essay essay, @RequestParam("file") MultipartFile file, Model model){
        essay.setEtime(new Date());
        essay.setPicture(FileUp.fileUp(file));
        int i = iEssayService.insertEssay(essay);
        model.addAttribute("msg","发布成功");
        model.addAttribute("userid",essay.getUserid());
        return "posting";
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public String deleteEssay(Integer essayid){
        int i = iEssayService.deleteEssayById(essayid);
        System.out.println(i+"hahaha"+essayid);
        if (i==0){
           return "删除失败！" ;
        }
        return "删除成功！";
    }

    @RequestMapping("insertComment.do")
    public String insertComment(Comment comment,Integer uid){
        int i = iCommentService.insertComment(comment);
        return "redirect:/hg/login.do?userid="+uid;
    }

    //得到推荐书
    @RequestMapping("getBooks.do")
    @ResponseBody
    public List<Book> getBooks(){
        List<Book> bookList = iEssayService.getBooks();
        return bookList;
    }

    //显示评论
    @RequestMapping("getCom.do")
    @ResponseBody
    public List<Comment> getCom(Integer essayid){
        List<Comment> commentList = iCommentService.getComments(essayid);
        return commentList;
    }


}
