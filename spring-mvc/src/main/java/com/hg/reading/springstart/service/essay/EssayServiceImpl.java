package com.hg.reading.springstart.service.essay;

import com.hg.reading.springstart.mapper.essay.EssayMapper;
import com.hg.reading.springstart.pojo.Book;
import com.hg.reading.springstart.pojo.Essay;
import com.hg.reading.springstart.utils.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImpl implements IEssayService {
    @Autowired
    private EssayMapper essayMapper;

    @Override
    public List<Essay> getAllEssay(Integer friendid, Page page) {
        return essayMapper.getAllEssay(friendid, page.getPageAge(), page.getPageSize());
    }

    @Override
    public int getTotal(Integer userid) {
        return essayMapper.getTotal(userid);
    }

    @Override
    public int insertEssay(Essay essay) {
        return essayMapper.insertEssay(essay);
    }

    @Override
    public int deleteEssayById(Integer essayid) {
        return essayMapper.deleteEssayById(essayid);
    }

    @Override
    public List<Book> getBooks() {
        return essayMapper.getBooks();
    }


}
