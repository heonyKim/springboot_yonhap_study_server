package com.example.yonhapnews.service;

import com.example.yonhapnews.model.HeonyNews;
import com.example.yonhapnews.repository.HeonyNewsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Log4j2
public class HeonyNewsService {

    @Autowired
    private HeonyNewsRepository heonyNewsRepository;

    @Transactional
    public int saveAllIgnore(List<HeonyNews> heonyNewsList){
        heonyNewsList.forEach(heonyNews -> {
            try{
                heonyNewsRepository.save(heonyNews);
            }catch (Exception e){
                log.debug("error :" + e.getMessage());
                log.debug("INSERT IGNORE");
            }
        });
        return 1;
    }

}
