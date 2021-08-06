package com.example.yonhapnews.controller;

import com.example.yonhapnews.GlobalVariables;
import com.example.yonhapnews.model.HeonyNews;
import com.example.yonhapnews.model.News;
import com.example.yonhapnews.repository.HeonyNewsRepository;
import com.example.yonhapnews.service.HeonyNewsService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/heony")
public class HeonyNewsController {

    @Autowired
    private HeonyNewsRepository heonyNewsRepository;

    @Autowired
    private HeonyNewsService heonyNewsService;

    private final Gson gson = new Gson();
    private final String DEFAULT_SAVE_FILE_PATH="C:\\Users\\dq\\Desktop";

    @GetMapping
    public String test(){
        HeonyNews news1 = new HeonyNews();
        news1.setTitle("1111");
        news1.setContent("1111");
        HeonyNews news2 = new HeonyNews();
        news2.setTitle("2222");
        news2.setContent("2222");
        HeonyNews news3 = new HeonyNews();
        news3.setTitle("3333");
        news3.setContent("3333");
        List<HeonyNews> allasdf = new ArrayList<>();
        allasdf.add(news1);
        allasdf.add(news2);
        allasdf.add(news3);
        try {
            allasdf.forEach(heonyNews -> heonyNewsRepository.save(heonyNews));
//            heonyNewsRepository.saveAll(allasdf);
        }catch (Exception e){
            log.debug(e.getMessage());
        }
        log.debug(1111111111);
        return "1234";
    }

    @PostMapping
    public String test2(){
        HeonyNews news1 = new HeonyNews();
        news1.setTitle("4444");
        news1.setContent("4444");
        HeonyNews news2 = new HeonyNews();
        news2.setTitle("2222");
        news2.setContent("2222");
        HeonyNews news3 = new HeonyNews();
        news3.setTitle("5555");
        news3.setContent("5555");
        List<HeonyNews> allasdf = new ArrayList<>();
        allasdf.add(news1);
        allasdf.add(news2);
        allasdf.add(news3);
        try {
            allasdf.forEach(heonyNews -> heonyNewsRepository.save(heonyNews));
        }catch (Exception e){
            log.debug(e.getMessage());
        }
        log.debug(1111111111);
        return "1234";
    }

}
