package com.zr.utils;

public class Convert {
    public static String whichTable(String id){
        if(id.equals("1")){
            return "selectques-s_id";
        }
        if(id.equals("2")){
            return "fillblankques-f_id";
        }
        if(id.equals("3")){
            return "judgeques-j_id";
        }
        if(id.equals("4")){
            return "bigques-b_id";
        }
        return "bigques-b_id";
    }
}
