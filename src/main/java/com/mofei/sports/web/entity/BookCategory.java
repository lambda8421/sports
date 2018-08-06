package com.mofei.sports.web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BookCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cate")
    private Integer cate;

    private String name;

    @OneToMany(mappedBy = "bookCategory",cascade = CascadeType.ALL)
    private List<Book> list;

    public BookCategory() {
    }

    public Integer getCate() {
        return cate;
    }

    public void setCate(Integer cate) {
        this.cate = cate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
