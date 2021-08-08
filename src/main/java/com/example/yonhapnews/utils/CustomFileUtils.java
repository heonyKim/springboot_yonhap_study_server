package com.example.yonhapnews.utils;

import com.example.yonhapnews.GlobalVariables;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
@Component
public class CustomFileUtils {

    public boolean fileSaverToText(String path, String content){
        File file = new File(path);
        FileWriter writer = null;
        boolean returnValue = false;
        try {
            writer = new FileWriter(file,false);
            writer.write(content);
            System.out.println("[heony_dev] FILE : " + file.getName() + " is saved!");
            GlobalVariables.savedNewsList.clear();
            returnValue = true;
        } catch (IOException e) {
            log.error(e.getMessage());
            returnValue = false;
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
        return returnValue;
    }

}
