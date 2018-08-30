package com.mofei.sports.web.controller;

import com.mofei.sports.crawler.Crawler;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.entity.Book;
import com.mofei.sports.web.entity.BookCategory;
import com.mofei.sports.web.entity.SubBook;
import com.mofei.sports.web.service.BasketBallService;
import com.mofei.sports.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BasketBallService basketBallService;

    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping("/basketball/team")
    public List<BasketballTeam> getBasketballTeam(){
        return basketBallService.findAll();
    }

    @ResponseBody
    @GetMapping("/index")
    public List<BasketballTeam> index(){
        try {
            Crawler crawler = new Crawler();
            crawler.init("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072222");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @GetMapping("/index1")
    public BookCategory index1(){
        BookCategory bookCategory = new BookCategory();
        bookCategory.setName("sss");
        bookCategory.setCate(111);
        Book book1 = new SubBook();
        book1.setTitle("X1");

        Book book2 = new SubBook();
        book2.setTitle("X2");

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        bookCategory.setList(books);

        BookCategory bookCategory1 = bookService.save(bookCategory);
        return bookCategory1;
    }

    @ResponseBody
    @GetMapping("/test/book")
    public BookCategory testGetBook(){

        return bookService.findByName("sss");
    }
}
