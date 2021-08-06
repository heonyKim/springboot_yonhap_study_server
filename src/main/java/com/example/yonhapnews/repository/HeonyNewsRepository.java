package com.example.yonhapnews.repository;

import com.example.yonhapnews.model.HeonyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HeonyNewsRepository extends JpaRepository<HeonyNews,Integer> {

//
//    @Modifying
//    @Query(value = "INSERT IGNORE INTO heony_dev_yonhap_tbl VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
//    Boolean saveIgnore(long id, String title, String link, String comments, Timestamp pub_date, String category, String description, String content, Timestamp reg_date, Timestamp save_date);

}
