package com.mofei.sports.web.repository;

import com.mofei.sports.web.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends JpaRepository<BookCategory, Integer> {

    @Override
    <S extends BookCategory> S save(S s);
}
