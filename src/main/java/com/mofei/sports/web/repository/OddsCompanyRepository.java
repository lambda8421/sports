package com.mofei.sports.web.repository;

import com.mofei.sports.web.entity.OddsCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OddsCompanyRepository extends JpaRepository<OddsCompany,Long> {

    @Override
    Optional<OddsCompany> findById(Long aLong);
}
