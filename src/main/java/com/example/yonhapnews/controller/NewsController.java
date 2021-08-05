package com.example.yonhapnews.controller;

import com.example.yonhapnews.GlobalVariables;
import com.example.yonhapnews.model.News;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class NewsController {

    private final Gson gson = new Gson();
    private final String DEFAULT_SAVE_FILE_PATH="C:\\Users\\dq\\Desktop";

    @PostMapping("/collect")
    public String collectNewsListPost(@RequestBody News news){
        System.out.println(gson.toJson(news));
        for (News newsElement : GlobalVariables.savedNewsList) {
            if(newsElement.getTitle().equals(news.getTitle())){
                System.out.println("[현재 적재된 뉴스] "+GlobalVariables.savedNewsList.size());
                System.out.println("[heony_dev] 동일한 뉴스가 존재하므로 적재하지 않습니다.");
                return "";
            }
        }
        GlobalVariables.savedNewsList.add(news);
        System.out.println("[현재 적재된 뉴스] "+GlobalVariables.savedNewsList.size());
        return gson.toJson(GlobalVariables.savedNewsList);
    }

    @GetMapping("/save")
    public String saveNewsListGet(){

        if(GlobalVariables.savedNewsList.size()==0){
            System.out.println("[heony_dev] 적재된 뉴스가 없으므로 파일을 생성하지 않습니다.");
            return "";
        }
        System.out.println("[heony_dev] SAVE Start..");
        String toBeSavedJson = gson.toJson(GlobalVariables.savedNewsList);

        Date date =new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentTimeFormatStr = sdf.format(date);
        System.currentTimeMillis();
        File file = new File(DEFAULT_SAVE_FILE_PATH+"\\"+"data_"+currentTimeFormatStr+".txt");
        FileWriter writer = null;

        try {
            writer = new FileWriter(file,false);
            writer.write(toBeSavedJson);
            System.out.println("[heony_dev] FILE : " + file.getName() + " is saved!");
            GlobalVariables.savedNewsList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null){
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    @PostMapping("/save")
    public String saveNewsListPost(@RequestBody String filePath){

        File filePathForExists = new File(filePath);
        if(!!!filePathForExists.exists()){
            System.out.println("[heony_dev] 파일 경로가 존재하지 않습니다.");
            System.out.println("[heony_dev] 바탕화면에 저장합니다.");
            filePath = DEFAULT_SAVE_FILE_PATH;
        }
        System.out.println("[heony_dev] SAVE Start..");
        String toBeSavedJson = gson.toJson(GlobalVariables.savedNewsList);

        Date date =new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentTimeFormatStr = sdf.format(date);
        System.currentTimeMillis();

        File file = new File(filePath+"\\"+"data_"+currentTimeFormatStr+".txt");
        FileWriter writer = null;

        try {
            writer = new FileWriter(file,false);
            writer.write(toBeSavedJson);
            System.out.println("[heony_dev] FILE save directory : "+ filePath);
            System.out.println("[heony_dev] FILE : " + file.getName() + " is saved!");
            GlobalVariables.savedNewsList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null){
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    @DeleteMapping("/clear")
    public void clearNewsList(){
        GlobalVariables.savedNewsList.clear();
        System.out.println("[heony_dev] 리스트 클리어");
    }

}
