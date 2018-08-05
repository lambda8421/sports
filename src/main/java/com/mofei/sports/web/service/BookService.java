package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.Book;
import com.mofei.sports.web.entity.BookCategory;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    BookCategory save(BookCategory bookCategory);
}
