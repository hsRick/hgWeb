package com.hg.reading.springstart.mapper.essay;

import com.hg.reading.springstart.pojo.Book;
import com.hg.reading.springstart.pojo.Essay;
import com.hg.reading.springstart.utils.page.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EssayMapper {

    //按倒叙获得所有帖
    List<Essay> getAllEssay(Integer friendid, Integer pageAge, Integer pageSize);

    //得到用户帖总量
    int getTotal(Integer userid);

    //用户插入帖
    int insertEssay(Essay essay);

    //根据帖id删除帖
    int deleteEssayById(Integer essayid);

    //得到推荐书
    List<Book> getBooks();
}
