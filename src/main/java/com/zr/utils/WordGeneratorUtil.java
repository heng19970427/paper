package com.zr.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGeneratorUtil {
    private static Configuration configuration = null;
    private static Map<String,Template> allTemplate = null;
    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        //模板路径
        configuration.setClassForTemplateLoading(WordGeneratorUtil.class, "/com/zr/ftl");
        allTemplate =new HashMap<String, Template>();
        try {
            allTemplate.put("paper1",configuration.getTemplate("paper1.ftl","UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private WordGeneratorUtil() {
        throw new AssertionError();
    }

    public static File createDoc(Map<?, ?> dataMap, String tempName,String paperName) {
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File f=new File(paperName);
        try {
            Template t =allTemplate.get("paper1");
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

}