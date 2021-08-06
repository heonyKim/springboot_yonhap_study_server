package com.example.yonhapnews.service;

import com.example.yonhapnews.model.HeonyNews;
import com.example.yonhapnews.repository.HeonyNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HeonyNewsService {

    @Autowired
    private HeonyNewsRepository heonyNewsRepository;

//    @Transactional
//    public int saveAllIgnore(List<HeonyNews> heonyNewsList){
//        try{
//            for (HeonyNews news : heonyNewsList) {
//                heonyNewsRepository.saveIgnore(
//                        news.getId(),
//                        news.getTitle(),
//                        news.getLink(),
//                        news.getComments(),
//                        news.getPub_date(),
//                        news.getCategory(),
//                        news.getDescription(),
//                        news.getContent(),
//                        news.getReg_date(),
//                        news.getSaveDate()
//                );
//            }
//        }catch (Exception e){
//            return 0;
//        }
//        return 1;
//    }

}
