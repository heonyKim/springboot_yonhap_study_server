package com.example.yonhapnews;

import com.example.yonhapnews.model.News;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class GlobalVariables {
    public static List<News> savedNewsList = new LinkedList<>();
    public static final String DEFAULT_SAVE_FILE_PATH="C:\\Users\\dq\\Desktop";
}
