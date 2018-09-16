package com.zr.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zr.pojo.Option;
import com.zr.utils.JsonUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    @Test
    public void testJson() throws IOException {
        List<Option> optionList=new ArrayList<>();
        optionList.add(new Option("sdfgfsg"));
        String jsonString = JsonUtil.toJsonString(optionList);
        List<Option> o = JsonUtil.toListObject(jsonString, ArrayList.class, Option.class);
        System.out.println(o);
    }
}
