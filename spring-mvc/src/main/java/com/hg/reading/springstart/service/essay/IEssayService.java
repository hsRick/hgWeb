package com.hg.reading.springstart.service.essay;

import com.hg.reading.springstart.pojo.Book;
import com.hg.reading.springstart.pojo.Essay;
import com.hg.reading.springstart.utils.page.Page;

import java.util.List;

public interface IEssayService {
    //按倒叙获得所有帖
    List<Essay> getAllEssay(Integer friendid, Page page);

    //得到用户帖总量
    int getTotal(Integer userid);

    //用户插入帖
    int insertEssay(Essay essay);

    //根据帖id删除帖
    int deleteEssayById(Integer essayid);

    //得到推荐书
    List<Book> getBooks();
}
