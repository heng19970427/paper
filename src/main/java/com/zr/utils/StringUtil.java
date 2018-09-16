package com.zr.utils;

import java.util.List;

public class StringUtil {
    public static void StringToInteger(String[] data, List<Integer> target){
        for(int i=0;i<data.length;i++){
            target.add(Integer.valueOf(data[i]));
        }
    }
}
