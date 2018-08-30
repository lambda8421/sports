package com.mofei.sports.web.service.impl;

import com.mofei.sports.web.entity.BookCategory;
import com.mofei.sports.web.repository.BookRespository;
import com.mofei.sports.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRespository bookRespository;

    @Override
    public BookCategory save(BookCategory bookCategory) {
        return bookRespository.save(bookCategory);
    }

    @Override
    public BookCategory findByName(String x1) {
        return bookRespository.findByName(x1);
    }
}
